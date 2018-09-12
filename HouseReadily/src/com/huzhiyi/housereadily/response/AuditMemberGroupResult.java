package com.huzhiyi.housereadily.response;

import java.sql.Timestamp;

public class AuditMemberGroupResult extends StatusResult {

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
	private String auditerName;
	private String auditerRealName;
	private Timestamp auditTime;
	private Timestamp createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseGroupId() {
		return baseGroupId;
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
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsPass() {
		return isPass;
	}

	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Integer getAuditer() {
		return auditer;
	}

	public void setAuditer(Integer auditer) {
		this.auditer = auditer;
	}

	public String getAuditerName() {
		return auditerName;
	}

	public void setAuditerName(String auditerName) {
		this.auditerName = auditerName;
	}

	public String getAuditerRealName() {
		return auditerRealName;
	}

	public void setAuditerRealName(String auditerRealName) {
		this.auditerRealName = auditerRealName;
	}

	public Timestamp getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Timestamp auditTime) {
		this.auditTime = auditTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
