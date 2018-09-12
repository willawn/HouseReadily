package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractFeedback entity provides the base persistence definition of the
 * Feedback entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFeedback extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String email;
	private String description;
	private Integer creater;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractFeedback() {
	}

	/** full constructor */
	public AbstractFeedback(String userName, String email, String description, Integer creater, Timestamp createTime) {
		this.userName = userName;
		this.email = email;
		this.description = description;
		this.creater = creater;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCreater() {
		return this.creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}