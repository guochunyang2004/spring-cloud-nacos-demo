package cn.zipworld.cloud.user.dao.sys;

import cn.zipworld.cloud.user.dao.MyBatisBaseDao;
import cn.zipworld.cloud.user.entity.sys.SysUser;
import cn.zipworld.cloud.user.entity.sys.SysUserSelectReq;

import java.util.List;

/**
 * SysUserDao继承基类
 */
public interface SysUserDao extends MyBatisBaseDao<SysUser, Long> {
    List<SysUser> select(SysUserSelectReq req);
}