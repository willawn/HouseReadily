package com.huzhiyi.housereadily.entity.base;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractuserExt entity provides the base persistence definition of the
 * userExt entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserExt extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer houseReadilyCount;
	private Integer customerCount;
	private Integer level;
	private Integer growing;
	private Integer integration;
	private Integer isUpdate;
	private String avatar;

	// Constructors

	/** default constructor */
	public AbstractUserExt() {
	}

	/** full constructor */
	public AbstractUserExt(Integer userId, Integer houseReadilyCount, Integer customerCount, Integer level, Integer growing,
			Integer integration, Integer isUpdate, String avatar) {
		this.userId = userId;
		this.houseReadilyCount = houseReadilyCount;
		this.customerCount = customerCount;
		this.level = level;
		this.growing = growing;
		this.integration = integration;
		this.isUpdate = isUpdate;
		this.avatar = avatar;
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

	public Integer getHouseReadilyCount() {
		return this.houseReadilyCount;
	}

	public void setHouseReadilyCount(Integer houseReadilyCount) {
		this.houseReadilyCount = houseReadilyCount;
	}

	public Integer getCustomerCount() {
		return this.customerCount;
	}

	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public Integer getIntegration() {
		return integration;
	}

	public void setIntegration(Integer integration) {
		this.integration = integration;
	}

	public Integer getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Integer isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}