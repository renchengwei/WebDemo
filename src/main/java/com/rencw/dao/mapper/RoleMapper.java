package com.rencw.dao.mapper;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.rencw.pojo.Role;
import com.rencw.pojo.RolePermission;

/**  
 * @ClassName: RoleMapper  
 * @Description: 定义角色相关的数据库层操作
 * @author renchengwei  
 * @date 2017年6月17日  
 *    
 */
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

	/**
     * 根据用户名查找其角色
     * @param userName
     * @return
     */
    public List<Role> findRolesByUserName(String userName);

    /**
     * 根据用户名查找其角色
     * @param userName
     * @return
     */
    public Set<String> selectRolesByUserName(String userName);
}
