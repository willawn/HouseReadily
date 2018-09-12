package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;


/**
 * AbstractCode entity provides the base persistence definition of the Code entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCode  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer userId;
     private String userName;
     private String mobile;
     private String code;
     private String description;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public AbstractCode() {
    }

    
    /** full constructor */
    public AbstractCode(Integer userId, String userName, String mobile, String code, String description, Timestamp createTime) {
        this.userId = userId;
        this.userName = userName;
        this.mobile = mobile;
        this.code = code;
        this.description = description;
        this.createTime = createTime;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}