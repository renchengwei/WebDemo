package com.rencw.bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("permission")
public class Permission extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String permission; // 权限标识 程序中判断使用,如"user:create"
	private String description; // 权限描述,UI界面显示使用
	private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
	private Date gmtCreate;
    private Date gmtModify;
	public Permission() {
	}

	public Permission(String permission, String description, Boolean available) {
		this.permission = permission;
		this.description = description;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

}
