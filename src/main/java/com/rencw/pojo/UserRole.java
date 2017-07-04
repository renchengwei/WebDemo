package com.rencw.pojo;

import org.apache.ibatis.type.Alias;

@Alias("userRole")
public class UserRole extends BaseBean {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
