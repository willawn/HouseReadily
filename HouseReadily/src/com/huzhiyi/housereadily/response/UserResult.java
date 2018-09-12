package com.huzhiyi.housereadily.response;


public class UserResult extends StatusResult {

	private Integer userId;
	private String userName;
	private String email;
	private String mobile;
	private String realName;
	private int cityCode;
	private int groupId;
	private String groupName;
	private String vipExpireTime;
	private int smsCount;
	private int live;
	private Integer houseReadilyCount;
	private Integer customerCount;
	private Integer growing;
	private Integer growed;
	private String avatar;
	private Integer isComplete;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public Integer getHouseReadilyCount() {
		return houseReadilyCount;
	}

	public void setHouseReadilyCount(Integer houseReadilyCount) {
		this.houseReadilyCount = houseReadilyCount;
	}

	public Integer getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}

	public Integer getGrowing() {
		return growing;
	}

	public void setGrowing(Integer growing) {
		this.growing = growing;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getGrowed() {
		return growed;
	}

	public void setGrowed(Integer growed) {
		this.growed = growed;
	}

	public Integer getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

}
