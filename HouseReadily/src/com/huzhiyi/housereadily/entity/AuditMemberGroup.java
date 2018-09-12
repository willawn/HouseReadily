package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;

import com.huzhiyi.housereadily.entity.base.AbstractAuditMemberGroup;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.ContextHelper;

/**
 * AuditMemberGroup entity. @author MyEclipse Persistence Tools
 */
public class AuditMemberGroup extends AbstractAuditMemberGroup implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public AuditMemberGroup() {
	}

	/** minimal constructor */
	public AuditMemberGroup(Integer baseGroupId, String groupNum, String groupName, Integer userId, Integer isPass, Integer isRead,
			Timestamp createTime) {
		super(baseGroupId, groupNum, groupName, userId, isPass, isRead, createTime);
	}

	/** full constructor */
	public AuditMemberGroup(Integer baseGroupId, String groupNum, String groupName, Integer userId, String userName, String realName,
			String description, Integer isPass, Integer isRead, Integer auditer, Timestamp auditTime, Timestamp createTime) {
		super(baseGroupId, groupNum, groupName, userId, userName, realName, description, isPass, isRead, auditer, auditTime, createTime);
	}

	private Integer cityCode;
	private String cityEn;
	private String cityName;
	private String avatar;
	private String mobile;
	private String email;
	private String auditerName;
	private String auditerRealName;

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityEn() {
		return ContextHelper.cityEnNames.get(getCityCode());
	}

	public void setCityEn(String cityEn) {
		this.cityEn = cityEn;
	}

	public String getCityName() {
		return ContextHelper.allareas.get(getCityCode());
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAvatar() {
		return StringUtils.isNotEmpty(avatar) ? Configuration.WEB_SITE_PATH + avatar : "";
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}
