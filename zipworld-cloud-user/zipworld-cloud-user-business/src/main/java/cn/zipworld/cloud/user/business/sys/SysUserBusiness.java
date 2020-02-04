package cn.zipworld.cloud.user.business.sys;

import cn.zipworld.cloud.user.business.BusinessAbstract;
import cn.zipworld.cloud.user.dao.sys.SysUserDao;
import cn.zipworld.cloud.user.entity.sys.SysUser;
import cn.zipworld.cloud.user.entity.sys.SysUserSelectReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserBusiness extends BusinessAbstract<SysUser,Long,SysUserDao> {
    public List<SysUser> select(SysUserSelectReq req){
        return mapper.select(req);
    }

    public PageInfo<SysUser> selectPage(SysUserSelectReq req){
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<SysUser>  list = mapper.select(req);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 事务保存例子
     * @param record
     * @return
     */
    @Transactional(readOnly = false)
    public SysUser save(SysUser record){
        if (record.getId()!=null && record.getId()>0){
            mapper.updateByPrimaryKeySelective(record);
        }
        else {
            mapper.insertSelective(record);
        }
        return record;
    }
}
