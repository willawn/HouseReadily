package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractTaskLog entity provides the base persistence definition of the
 * TaskLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTaskLog extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer taskId;
	private Integer shareType;
	private Integer growing;
	private Integer integration;
	private Integer creater;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractTaskLog() {
	}

	/** full constructor */
	public AbstractTaskLog(Integer userId, Integer taskId, Integer shareType, Integer growing, Integer integration, Integer creater, Timestamp createTime) {
		this.userId = userId;
		this.taskId = taskId;
		this.shareType = shareType;
		this.growing = growing;
		this.integration = integration;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getShareType() {
		return shareType;
	}

	public void setShareType(Integer shareType) {
		this.shareType = shareType;
	}

	public Integer getGrowing() {
		return this.growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public Integer getIntegration() {
		return this.integration;
	}

	public void setIntegration(Integer integration) {
		this.integration = integration;
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