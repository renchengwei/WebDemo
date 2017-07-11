package com.rencw.pojo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**  
 * @ClassName: Permission  
 * @Description: 系统权限，包括一级菜单，二级菜单，操作
 * @author renchengwei  
 * @date 2017年7月4日  
 *    
 */
@Alias("permission")
public class Permission extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name; //权限名称
	private String type; //权限类型
	private Long parentId = -1L; // 父菜单
	private String menuURL; // 菜单URL
	private Integer orderNo; // 权限排序号
	private String code; // 权限标识 程序中判断使用,如"user:create"
	private String icon; // 权限描述,UI界面显示使用
	private String available = "1"; // 是否可用,如果不可用将不会添加给用户 0:禁用	1:启用
	private Boolean isDeleted = Boolean.FALSE; //是否删除
	private Date gmtCreate;
    private Date gmtModify;
    private Integer childrenCount;//子权限数量
	public Permission() {
	}

	public Permission(String code, String name, String available) {
		this.code = code;
		this.name = name;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(Integer childrenCount) {
		this.childrenCount = childrenCount;
	}
}
