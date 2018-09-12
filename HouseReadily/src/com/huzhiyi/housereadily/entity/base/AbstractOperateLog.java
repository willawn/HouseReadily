package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

import com.tastysoft.swct.db.model.TastyEntity;

/**
 * AbstractSystemLog entity provides the base persistence definition of the
 * SystemLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOperateLog extends TastyEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String ip;
	private String terminal;
	private Integer type;
	private String description;
	private Integer creater;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractOperateLog() {
	}

	/** full constructor */
	public AbstractOperateLog(Integer userId, String ip, String terminal, Integer type, String description, Integer creater,
			Timestamp createTime) {
		this.userId = userId;
		this.ip = ip;
		this.terminal = terminal;
		this.type = type;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
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