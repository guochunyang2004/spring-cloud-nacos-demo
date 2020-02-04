package cn.zipworld.cloud.user.entity.sys;

import java.io.Serializable;

/**
 * sys_role_menu
 * @author 
 */
public class SysRoleMenu implements Serializable {
    /**
     * 角色编号
     */
    private Long roleId;

    /**
     * 菜单编号
     */
    private Long menuId;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}