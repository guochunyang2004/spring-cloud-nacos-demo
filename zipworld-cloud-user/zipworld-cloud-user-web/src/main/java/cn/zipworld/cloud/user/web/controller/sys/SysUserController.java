package cn.zipworld.cloud.user.web.controller.sys;


import cn.zipworld.cloud.common.auth.AuthService;
import cn.zipworld.cloud.common.auth.UserContextService;
import cn.zipworld.cloud.common.entity.auth.UserContext;
import cn.zipworld.cloud.common.util.StringUtils;
import cn.zipworld.cloud.common.vo.base.ResultDataVO;
import cn.zipworld.cloud.user.business.sys.SysUserBusiness;
import cn.zipworld.cloud.user.business.sys.SysUserTokenBusiness;
import cn.zipworld.cloud.user.entity.sys.SysUser;
import cn.zipworld.cloud.user.entity.sys.SysUserSelectReq;
import cn.zipworld.cloud.user.entity.sys.SysUserToken;
import cn.zipworld.cloud.user.entity.sys.SysUserTokenSelectReq;
import cn.zipworld.cloud.user.vo.sys.SysUserReqVO;
import cn.zipworld.cloud.user.vo.sys.SysUserResVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Api(description = "系统用户",tags = "sysuser")
@Slf4j
@RestController()
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private UserContextService userContextService;

    @Autowired
    private SysUserBusiness sysUserBusiness;

    @Autowired
    private SysUserTokenBusiness sysUserTokenBusiness;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public ResultDataVO<SysUserResVO> login(@RequestBody SysUserReqVO req) {
        if(req.getAppId()==null){
            return ResultDataVO.newInstanceIsFailMsg("参数错误！");
        }
        if (!req.getAppId().equals(10001)){
            return ResultDataVO.newInstanceIsFailMsg("appId错误！");
        }
        if (  StringUtils.isBlank(req.getLoginName())
                || StringUtils.isBlank(req.getPassword()) ) {
            return ResultDataVO.newInstanceIsFailMsg("用户名或密码错误！");
        }
        SysUserSelectReq sysUserSelectReq = new SysUserSelectReq();
        sysUserSelectReq.setLoginName(req.getLoginName());
        List<SysUser> sysUserList = sysUserBusiness.select(sysUserSelectReq);
        if (sysUserList==null || sysUserList.size()==0){
            return ResultDataVO.newInstanceIsFailMsg("用户名或密码错误！");
        }

        SysUser sysUser = sysUserList.get(0);
        String oldPassword = sysUser.getPassword();
        if (AuthService.validatePassword(req.getPassword(),oldPassword)){
            /**
             * 1.查询数据库是否有token，
             * --有，则看过期时间，没过期|过期则重新生成，并更新redis，返回现有token
             * 有，则在redis中查找，找到
             * 没有，重新生成，更新redis
             * 2. token请求更新
             *  接口访问带token验证，延长token过期时间，--并更新数据库
             *  redis中token过期，重新生成token
             */
            UserContext userContext =null;
            SysUserTokenSelectReq sysUserTokenSelectReq = new SysUserTokenSelectReq();
            sysUserTokenSelectReq.setUserId(sysUser.getId());
            sysUserTokenSelectReq.setAppId(req.getAppId());
            List<SysUserToken> sysUserTokenList =  sysUserTokenBusiness.select(sysUserTokenSelectReq);
            if (sysUserTokenList!=null && sysUserTokenList.size()>0){
                //读取token
                String token = sysUserTokenList.get(0).getToken();
                userContext =  userContextService.getUserContext(token);
            }
            if(userContext==null) {
                //创建token
                userContext = new UserContext();
                userContext.setLoginName(sysUser.getLoginName());
                userContext.setName(sysUser.getName());
                userContext.setId(sysUser.getId());
                userContext.setAppId(req.getAppId());
                userContextService.tokenStorage(userContext);
                //保存数据库
                SysUserToken record = new SysUserToken();
                record.setUserId(sysUser.getId());;
                record.setToken(userContext.getToken());
                record.setAppId(userContext.getAppId());
                record.setExpireTime(userContext.getExpire());
                sysUserTokenBusiness.save(record);
            }
            SysUserResVO sysUserResVO = new SysUserResVO();
            sysUserResVO.setExpireTime(userContext.getExpire());
            sysUserResVO.setToken(userContext.getToken());
            sysUserResVO.setId(sysUser.getId());
            sysUserResVO.setLoginName(sysUser.getLoginName());
            sysUserResVO.setName(sysUser.getName());
            return ResultDataVO.newInstanceIsOK(sysUserResVO);
        }
        return ResultDataVO.newInstanceIsFailMsg("用户名或密码错误！");
    }
}
