package com.rencw.service;

import java.util.List;

import com.rencw.dto.query.RoleQuery;
import com.rencw.dto.result.DatatablesViewPage;
import com.rencw.pojo.Role;
import com.rencw.pojo.RolePermission;

public interface RoleService {
	
	public Role addRole(Role role);
	
	public void updateRole(Role role);

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

	public DatatablesViewPage<Role> queryRolesByPage(RoleQuery query);

	public Role getRoleById(Long id);
	
}
