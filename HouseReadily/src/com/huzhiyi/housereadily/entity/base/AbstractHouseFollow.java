package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractHouseFollow entity provides the base persistence definition of the
 * HouseFollow entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHouseFollow extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer houseReadilyId;
	private Integer customerId;
	private Integer mode;
	private String description;
	private Integer creater;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractHouseFollow() {
	}

	/** full constructor */
	public AbstractHouseFollow(Integer houseReadilyId, Integer customerId, Integer mode, String description, Integer creater,
			Timestamp createTime) {
		this.houseReadilyId = houseReadilyId;
		this.customerId = customerId;
		this.mode = mode;
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

	public Integer getHouseReadilyId() {
		return this.houseReadilyId;
	}

	public void setHouseReadilyId(Integer houseReadilyId) {
		this.houseReadilyId = houseReadilyId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getMode() {
		return this.mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
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