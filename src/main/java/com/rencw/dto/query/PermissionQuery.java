package com.rencw.dto.query;

public class PermissionQuery extends PageQuery {

	private String name; //权限名称
	private String type; //权限类型
	private String code;
	private String parentId;//父节点
	private String available; // 是否可用,如果不可用将不会添加给用户
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
