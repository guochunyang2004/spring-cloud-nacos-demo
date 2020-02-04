package cn.zipworld.cloud.user.business.sys;

import cn.zipworld.cloud.user.business.BusinessAbstract;
import cn.zipworld.cloud.user.dao.sys.SysUserTokenDao;
import cn.zipworld.cloud.user.entity.sys.SysUserToken;
import cn.zipworld.cloud.user.entity.sys.SysUserTokenSelectReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SysUserTokenBusiness extends BusinessAbstract<SysUserToken,Long,SysUserTokenDao> {
    public List<SysUserToken> select(SysUserTokenSelectReq req){
        return mapper.select(req);
    }

    public PageInfo<SysUserToken> selectPage(SysUserTokenSelectReq req){
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<SysUserToken>  list = mapper.select(req);
        PageInfo<SysUserToken> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 事务保存例子
     * @param record
     * @return
     */
    @Transactional(readOnly = false)
    public SysUserToken save(SysUserToken record){
        SysUserTokenSelectReq sysUserTokenSelectReq = new SysUserTokenSelectReq();
        sysUserTokenSelectReq.setUserId(record.getUserId());
        sysUserTokenSelectReq.setAppId(record.getAppId());
        List<SysUserToken> sysUserTokenList =  select(sysUserTokenSelectReq);
        if (sysUserTokenList!=null && sysUserTokenList.size()>0){
            record.setId(sysUserTokenList.get(0).getId());
            record.setUpdateTime(LocalDateTime.now());
            mapper.updateByPrimaryKeySelective(record);
        }
        else {
            record.setCreateTime(LocalDateTime.now());
            record.setUpdateTime(LocalDateTime.now());
            mapper.insertSelective(record);
        }
        return record;
    }
}
