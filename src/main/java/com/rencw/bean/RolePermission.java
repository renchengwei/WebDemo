package com.rencw.bean;

import org.apache.ibatis.type.Alias;

@Alias("rolePermission")
public class RolePermission extends BaseBean {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long roleId;
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

}
