package com.huzhiyi.housereadily.request;

public class BaseGroupCommand extends BaseCommand {

	private Integer id;
	private String groupNum;
	private String groupName;
	private String acement;
	private String description;
	private Integer cityCode;
	private Integer bigAreaCode;
	private Integer smallAreaCode;
	private Integer pageNo;
	private Integer pageSize;
	private String userName;
	private String password;
	private String version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAcement() {
		return acement;
	}

	public void setAcement(String acement) {
		this.acement = acement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getBigAreaCode() {
		return bigAreaCode;
	}

	public void setBigAreaCode(Integer bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}

	public Integer getSmallAreaCode() {
		return smallAreaCode;
	}

	public void setSmallAreaCode(Integer smallAreaCode) {
		this.smallAreaCode = smallAreaCode;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
