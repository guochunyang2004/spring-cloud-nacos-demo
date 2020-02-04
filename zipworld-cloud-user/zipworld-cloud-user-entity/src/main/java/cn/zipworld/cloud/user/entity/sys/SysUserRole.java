package cn.zipworld.cloud.user.entity.sys;

import java.io.Serializable;

/**
 * sys_user_role
 * @author 
 */
public class SysUserRole implements Serializable {
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 角色编号
     */
    private String roleId;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}