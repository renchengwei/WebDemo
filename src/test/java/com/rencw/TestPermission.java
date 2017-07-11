package com.rencw;

import javax.annotation.Resource;

import org.junit.Test;

import com.rencw.pojo.Permission;
import com.rencw.service.PermissionService;

public class TestPermission extends TestSpringBase {

	@Resource
	private PermissionService permissionService;
	
	@Test
	public void testCreatePermission() {
		Permission permission = new Permission("user_create", "user_create", "1");
		permissionService.addPermission(permission);
	}
	@Test
	public void testDeletePermission() {
		permissionService.deletePermission(2L);
	}
}
