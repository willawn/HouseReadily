package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class ProjectEntity implements Serializable {

	private String commId;  // 小区名称
	private String commName;  // 楼盘名称
	private Integer bigAreaCode;  // 大区域编码
	private String bigAreaName;   // 
	private Integer smallAreaCode; // 小区域编码
	private String smallAreaName;  // 地址
	private String address;
	private String trafficInfo;    // 交通状况
	private String aroundCondition;  //周边配套
	
	public String getCommId() {
		return commId;
	}
	public void setCommId(String commId) {
		this.commId = commId;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public Integer getBigAreaCode() {
		return bigAreaCode;
	}
	public void setBigAreaCode(Integer bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}
	public String getBigAreaName() {
		return bigAreaName;
	}
	public void setBigAreaName(String bigAreaName) {
		this.bigAreaName = bigAreaName;
	}
	public Integer getSmallAreaCode() {
		return smallAreaCode;
	}
	public void setSmallAreaCode(Integer smallAreaCode) {
		this.smallAreaCode = smallAreaCode;
	}
	public String getSmallAreaName() {
		return smallAreaName;
	}
	public void setSmallAreaName(String smallAreaName) {
		this.smallAreaName = smallAreaName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTrafficInfo() {
		return trafficInfo;
	}
	public void setTrafficInfo(String trafficInfo) {
		this.trafficInfo = trafficInfo;
	}
	public String getAroundCondition() {
		return aroundCondition;
	}
	public void setAroundCondition(String aroundCondition) {
		this.aroundCondition = aroundCondition;
	}
	
	
}
