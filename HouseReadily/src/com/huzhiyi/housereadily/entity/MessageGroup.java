package com.huzhiyi.housereadily.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.huzhiyi.housereadily.entity.base.AbstractMessageGroup;

/**
 * MessageGroup entity. @author MyEclipse Persistence Tools
 */
public class MessageGroup extends AbstractMessageGroup implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MessageGroup() {
	}

	/** minimal constructor */
	public MessageGroup(Integer baseGroupId, String description, Integer mtype, Timestamp syncTime, String version,
			Integer isDelete, Integer creater, Timestamp createTime) {
		super(baseGroupId, description, mtype, syncTime, version, isDelete, creater, createTime);
	}

	/** full constructor */
	public MessageGroup(Integer baseGroupId, String title, String description, Integer mtype, Integer source, Integer sctype, Double ownerRate,
			Double otherRate, Timestamp syncTime, String version, Integer isDelete, Integer creater, Timestamp createTime,
			Double brokerage, String remarks, String share) {
		super(baseGroupId, title, description, mtype, source, sctype, ownerRate, otherRate, syncTime, version, isDelete, creater, createTime,
				brokerage, remarks, share);
	}

	private String createrName;
	private String createrRealName;
	private String mobile;
	private String baseGroupName;
	private String avatar;
	private List houseReadilys = new ArrayList(0);
	private List customers = new ArrayList(0);
	private List btAttachments = new ArrayList(0);
	private List snAttachments = new ArrayList(0);
	private List fxAttachments = new ArrayList(0);
	private List xqAttachments = new ArrayList(0);
	private Integer growing;

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public List getBtAttachments() {
		return btAttachments;
	}

	public void setBtAttachments(List btAttachments) {
		this.btAttachments = btAttachments;
	}

	public List getSnAttachments() {
		return snAttachments;
	}

	public void setSnAttachments(List snAttachments) {
		this.snAttachments = snAttachments;
	}

	public List getFxAttachments() {
		return fxAttachments;
	}

	public void setFxAttachments(List fxAttachments) {
		this.fxAttachments = fxAttachments;
	}

	public List getXqAttachments() {
		return xqAttachments;
	}

	public void setXqAttachments(List xqAttachments) {
		this.xqAttachments = xqAttachments;
	}

	public List getHouseReadilys() {
		return houseReadilys;
	}

	public void setHouseReadilys(List houseReadilys) {
		this.houseReadilys = houseReadilys;
	}

	public List getCustomers() {
		return customers;
	}

	public void setCustomers(List customers) {
		this.customers = customers;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBaseGroupName() {
		return baseGroupName;
	}

	public void setBaseGroupName(String baseGroupName) {
		this.baseGroupName = baseGroupName;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getCreaterRealName() {
		return createrRealName;
	}

	public void setCreaterRealName(String createrRealName) {
		this.createrRealName = createrRealName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
