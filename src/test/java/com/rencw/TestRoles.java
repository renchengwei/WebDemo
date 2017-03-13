package com.rencw;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.rencw.bean.Role;
import com.rencw.bean.RolePermission;
import com.rencw.service.RoleService;

public class TestRoles extends TestSpringBase {

	@Resource
	private RoleService roleService;
	
	@Test
	public void testCreateRole() {
		Role role = new Role("user", "user", Boolean.TRUE);
		roleService.createRole(role);
	}
	
	@Test
	public void testDeleteRole() {
		roleService.deleteRole(1L);
	}
		
	@Test
	public void correlationPermissions() {
		List<RolePermission> list = new ArrayList<>();
		RolePermission rp1 = new RolePermission();
		rp1.setRoleId(2L);
		rp1.setPermissionId(1L);
		list.add(rp1);
		roleService.correlationPermissions(list);
	}
	
	@Test
	public void uncorrelationPermissions() {
		List<RolePermission> list = new ArrayList<>();
		RolePermission rp1 = new RolePermission();
		rp1.setRoleId(2L);
		rp1.setPermissionId(1L);
		list.add(rp1);
		roleService.uncorrelationPermissions(list);
	}
}
