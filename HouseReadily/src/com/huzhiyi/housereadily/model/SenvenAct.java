package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;

public class SenvenAct extends TastyEntity {
	private int id;
	private Integer userId;
	private String moblie;
	private String wiboNo;
	private String invitationCode;
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMoblie() {
		return moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public String getWiboNo() {
		return wiboNo;
	}

	public void setWiboNo(String wiboNo) {
		this.wiboNo = wiboNo;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
