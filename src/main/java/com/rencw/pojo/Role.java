package com.rencw.pojo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**  
 * @ClassName: Role  
 * @Description: 系统角色
 * @author renchengwei  
 * @date 2017年7月4日  
 *    
 */
@Alias("role")
public class Role extends BaseBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String name; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户
    private Boolean isDelete = Boolean.FALSE; //是否删除
    private Date gmtCreate;
    private Date gmtModify;
    
    public Role() {
    }

    public Role(String name, String description, Boolean available) {
		super();
		this.name = name;
		this.description = description;
		this.available = available;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
