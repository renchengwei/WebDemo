package com.rencw.dao.mapper;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.rencw.dto.query.PermissionQuery;
import com.rencw.pojo.Permission;

/**  
 * @ClassName: PermissionMapper  
 * @Description: 权限DAO，定义权限相关的数据库层操作
 * @author renchengwei  
 * @date 2017年6月17日  
 *    
 */
@Repository
public interface PermissionMapper {
	/**  
	 * @Title: addPermission  
	 * @Description: 新增权限
	 * @param @param permission    参数  
	 * @return void    返回类型  
	 * @throws  
	 */
	public void addPermission(Permission permission);
    /**  
     * @Title: deletePermission  
     * @Description: 删除权限 
     * @param @param permissionId    参数  
     * @return void    返回类型  
     * @throws  
     */
    public void deletePermission(Long permissionId);
    
    /**  
     * @Title: selectPermissionsByUserName  
     * @Description: 根据用户名查询权限，返回权限标识
     * @param @param userName
     * @param @return    参数  
     * @return Set<String>    返回类型  
     * @throws  
     */
    public Set<String> selectPermissionsByUserName(String userName);
    
    /**  
     * @Title: findPermissionsByUserName  
     * @Description: 根据用户名查询权限，返回权限对象 
     * @param @param userName
     * @param @return    参数  
     * @return List<Permission>    返回类型  
     * @throws  
     */
    public List<Permission> queryPermissionsByUserName(String userName);
    
    /**  
     * @Title: queryPermissionsByPage  
     * @Description: 分页查询权限 
     * @param @param query
     * @param @return    参数  
     * @return List<Permission>    返回类型  
     * @throws  
     */
    public List<Permission> queryPermissions(PermissionQuery query);
    
    /**  
     * @Title: queryPermissionsCount  
     * @Description: 查询权限总记录数
     * @param @param query
     * @param @return    参数  
     * @return Long    返回类型  
     * @throws  
     */
    public Long queryPermissionsCount(PermissionQuery query);
	public Permission getPermissionById(Long id);
	public void editPermission(Permission permission);
}
