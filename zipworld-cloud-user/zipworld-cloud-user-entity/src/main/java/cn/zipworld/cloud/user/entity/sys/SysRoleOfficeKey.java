package cn.zipworld.cloud.user.entity.sys;

import java.io.Serializable;

/**
 * sys_role_office
 * @author 
 */
public class SysRoleOfficeKey implements Serializable {
    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 机构编号
     */
    private String officeId;

    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }
}