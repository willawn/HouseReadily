package com.huzhiyi.housereadily.request;

public class ProjectCommand extends ListCommand{
	
	public ProjectCommand() {
		super();
	}
	
	private String lngs; 
	private String lats; 
	private String buildType; 
	private String areaId ; 
	private String subAreaId;
	private String city; 
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLngs() {
		return lngs;
	}
	public void setLngs(String lngs) {
		this.lngs = lngs;
	}
	public String getLats() {
		return lats;
	}
	public void setLats(String lats) {
		this.lats = lats;
	}
	public String getBuildType() {
		return buildType;
	}
	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getSubAreaId() {
		return subAreaId;
	}
	public void setSubAreaId(String subAreaId) {
		this.subAreaId = subAreaId;
	}
	
	
	
	
}
