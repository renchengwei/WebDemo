package com.rencw.pojo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**  
 * @ClassName: User  
 * @Description: 系统用户，管理员
 * @author renchengwei  
 * @date 2017年7月4日  
 *    
 */
@Alias("user")
public class User extends BaseBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String userName;
    private String password;
    private String passwordSalt;
    private Boolean locked = Boolean.FALSE;
    private Boolean isDeleted = Boolean.FALSE;
    private Date gmtCreate;
    private Date gmtModify;

	public User() {
    }

    public User(String userName, String password, String passwordSalt, Boolean locked) {
		super();
		this.userName = userName;
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.locked = locked;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getCredentialsSalt() {
        return userName + passwordSalt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
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
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
