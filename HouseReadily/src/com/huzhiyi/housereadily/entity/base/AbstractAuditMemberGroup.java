package com.huzhiyi.housereadily.entity.base;

import java.sql.Timestamp;

/**
 * AbstractAuditMemberGroup entity provides the base persistence definition of
 * the AuditMemberGroup entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAuditMemberGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer baseGroupId;
	private String groupNum;
	private String groupName;
	private Integer userId;
	private String userName;
	private String realName;
	private String description;
	private Integer isPass;
	private Integer isRead;
	private Integer auditer;
	private Timestamp auditTime;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractAuditMemberGroup() {
	}

	/** minimal constructor */
	public AbstractAuditMemberGroup(Integer baseGroupId, String groupNum, String groupName, Integer userId, Integer isPass, Integer isRead,
			Timestamp createTime) {
		this.baseGroupId = baseGroupId;
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.userId = userId;
		this.isPass = isPass;
		this.isRead = isRead;
		this.createTime = createTime;
	}

	/** full constructor */
	public AbstractAuditMemberGroup(Integer baseGroupId, String groupNum, String groupName, Integer userId, String userName,
			String realName, String description, Integer isPass, Integer isRead, Integer auditer, Timestamp auditTime, Timestamp createTime) {
		this.baseGroupId = baseGroupId;
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.description = description;
		this.isPass = isPass;
		this.isRead = isRead;
		this.auditer = auditer;
		this.auditTime = auditTime;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseGroupId() {
		return this.baseGroupId;
	}

	public void setBaseGroupId(Integer baseGroupId) {
		this.baseGroupId = baseGroupId;
	}

	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsPass() {
		return this.isPass;
	}

	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	public Integer getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Integer getAuditer() {
		return this.auditer;
	}

	public void setAuditer(Integer auditer) {
		this.auditer = auditer;
	}

	public Timestamp getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Timestamp auditTime) {
		this.auditTime = auditTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}