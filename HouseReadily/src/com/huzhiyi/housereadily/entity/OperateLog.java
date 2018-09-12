package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractOperateLog;

/**
 * SystemLog entity. @author MyEclipse Persistence Tools
 */
public class OperateLog extends AbstractOperateLog implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OperateLog() {
	}

	/** full constructor */
	public OperateLog(Integer userId, String ip, String terminal, Integer type, String description, Integer creater, Timestamp createTime) {
		super(userId, ip, terminal, type, description, creater, createTime);
	}

	private String ipAddress;
	private String userName;
	private Integer regSource;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRegSource() {
		return regSource;
	}

	public void setRegSource(Integer regSource) {
		this.regSource = regSource;
	}
}
