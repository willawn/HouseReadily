package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractSystemLog;

/**
 * SystemLog entity. @author MyEclipse Persistence Tools
 */
public class SystemLog extends AbstractSystemLog implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public SystemLog() {
	}

	/** full constructor */
	public SystemLog(Integer userId, String ip, Integer regSource, String terminal, Integer type, String description, Integer creater,
			Timestamp createTime) {
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
