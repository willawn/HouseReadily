package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractFeedback;

/**
 * Feedback entity. @author MyEclipse Persistence Tools
 */
public class Feedback extends AbstractFeedback implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Feedback() {
	}

	/** full constructor */
	public Feedback(String userName, String email, String description, Integer creater, Timestamp createTime) {
		super(userName, email, description, creater, createTime);
	}

}
