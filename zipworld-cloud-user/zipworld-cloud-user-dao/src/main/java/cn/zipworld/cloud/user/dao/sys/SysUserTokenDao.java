package cn.zipworld.cloud.user.dao.sys;

import cn.zipworld.cloud.user.dao.MyBatisBaseDao;
import cn.zipworld.cloud.user.entity.sys.SysUserToken;
import cn.zipworld.cloud.user.entity.sys.SysUserTokenSelectReq;

import java.util.List;

/**
 * SysUserTokenDao继承基类
 */
public interface SysUserTokenDao extends MyBatisBaseDao<SysUserToken, Long> {
    List<SysUserToken> select(SysUserTokenSelectReq req);
}