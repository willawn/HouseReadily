package com.huzhiyi.housereadily.entity;

import com.huzhiyi.housereadily.entity.base.AbstractUserExt;

/**
 * userExt entity. @author MyEclipse Persistence Tools
 */
public class UserExt extends AbstractUserExt implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserExt() {
	}

	/** full constructor */
	public UserExt(Integer userId, Integer houseReadilyCount, Integer customerCount, Integer level, Integer growing, Integer integration,
			Integer isUpdate, String avatar) {
		super(userId, houseReadilyCount, customerCount, level, growing, integration, isUpdate, avatar);
	}

}
