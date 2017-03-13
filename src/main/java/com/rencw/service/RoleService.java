package com.rencw.service;

import java.util.List;

import com.rencw.bean.Role;
import com.rencw.bean.RolePermission;

public interface RoleService {
	public Role createRole(Role role);

	public void deleteRole(Long roleId);

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(List<RolePermission> rolePermissionList);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(List<RolePermission> rolePermissionList);

}
