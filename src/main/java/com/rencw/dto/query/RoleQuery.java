package com.rencw.dto.query;

public class RoleQuery extends PageQuery {

	private Long id;
	private String name; //角色名称
	private String available; // 是否可用
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
