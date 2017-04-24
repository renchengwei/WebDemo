package com.rencw.dao.mapper;

import org.springframework.stereotype.Repository;

import com.rencw.bean.Role;
import com.rencw.bean.RolePermission;

@Repository
public interface RoleMapper {

	public void createRole(Role role);

	public void deleteRole(Long roleId);

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(RolePermission rolePermission);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(RolePermission rolePermission);

}
