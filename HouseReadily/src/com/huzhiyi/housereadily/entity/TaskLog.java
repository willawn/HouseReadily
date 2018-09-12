package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractTaskLog;

/**
 * TaskLog entity. @author MyEclipse Persistence Tools
 */
public class TaskLog extends AbstractTaskLog implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TaskLog() {
	}

	/** full constructor */
	public TaskLog(Integer userId, Integer taskId, Integer shareType, Integer growing, Integer integration, Integer creater, Timestamp createTime) {
		super(userId, taskId, shareType, growing, integration, creater, createTime);
	}

	private String userName;
	private Integer type;
	private String taskName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
}
