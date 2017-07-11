package com.rencw.service;

import java.util.List;

import com.rencw.dto.query.PermissionQuery;
import com.rencw.dto.result.DatatablesViewPage;
import com.rencw.pojo.Permission;

public interface PermissionService {
	public Permission addPermission(Permission permission);
    public void deletePermission(Long permissionId);
    public DatatablesViewPage<Permission> queryPermissionsByPage(PermissionQuery query);
    public Long queryPermissionsCount(PermissionQuery query);
    public List<Permission> queryPermissions(PermissionQuery query);
    public Permission getPermissionById(Long id);
	public void editPermission(Permission permission);
}
