package com.huzhiyi.housereadily.response;

public class UserCheckResult extends StatusResult {

	private int userId;

	private String userName;

	private String auth;

	private int authOk;

	private String realName;

	private String email;

	private int cityCode;

	private int groupId;

	private String groupName;

	private String vipExpireTime;

	private int smsCount;

	private int live;
	
	private Integer growing;
	
	private String extMsg;
	
	private String mobile;
	
	private String avatar;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
		if (auth != null && auth.length() > 0) {
			setAuthOk(1);
		} else {
			setAuthOk(0);
		}
	}

	public int getAuthOk() {
		return authOk;
	}

	public void setAuthOk(int authOk) {
		this.authOk = authOk;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getVipExpireTime() {
		return vipExpireTime;
	}

	public void setVipExpireTime(String vipExpireTime) {
		this.vipExpireTime = vipExpireTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public String getExtMsg() {
		return extMsg;
	}

	public void setExtMsg(String extMsg) {
		this.extMsg = extMsg;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
