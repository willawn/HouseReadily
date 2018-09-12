package com.huzhiyi.housereadily.model;

import java.util.Date;

import com.tastysoft.swct.db.model.TastyEntity;

public class CProject extends TastyEntity{
	
	private Integer id;
	private Integer robotId;
	private Integer robotRunId;
	private String refindKey;
	private Date firstExtractionDate;
	private Date latestExtractionDate;
	private String extractedInLatestRun;
	private String city;
	private String projectId;
	private String name;
	private String area;
	private String subArea;
	private Integer areaId;
	private Integer subAreaId;
	private String nameFullEn;
	private String nameSimpleEn;
	private String address;
	private Float price;
	private Float manageFee;
	private String description;
	private String arround;
	private String traffic;
	private Float lat;
	private Float lng;
	private Integer page;
	private Integer buildType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRobotId() {
		return robotId;
	}
	public void setRobotId(Integer robotId) {
		this.robotId = robotId;
	}
	public Integer getRobotRunId() {
		return robotRunId;
	}
	public void setRobotRunId(Integer robotRunId) {
		this.robotRunId = robotRunId;
	}
	public String getRefindKey() {
		return refindKey;
	}
	public void setRefindKey(String refindKey) {
		this.refindKey = refindKey;
	}
	public Date getFirstExtractionDate() {
		return firstExtractionDate;
	}
	public void setFirstExtractionDate(Date firstExtractionDate) {
		this.firstExtractionDate = firstExtractionDate;
	}
	public Date getLatestExtractionDate() {
		return latestExtractionDate;
	}
	public void setLatestExtractionDate(Date latestExtractionDate) {
		this.latestExtractionDate = latestExtractionDate;
	}
	public String getExtractedInLatestRun() {
		return extractedInLatestRun;
	}
	public void setExtractedInLatestRun(String extractedInLatestRun) {
		this.extractedInLatestRun = extractedInLatestRun;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSubArea() {
		return subArea;
	}
	public void setSubArea(String subArea) {
		this.subArea = subArea;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getSubAreaId() {
		return subAreaId;
	}
	public void setSubAreaId(Integer subAreaId) {
		this.subAreaId = subAreaId;
	}
	public String getNameFullEn() {
		return nameFullEn;
	}
	public void setNameFullEn(String nameFullEn) {
		this.nameFullEn = nameFullEn;
	}
	public String getNameSimpleEn() {
		return nameSimpleEn;
	}
	public void setNameSimpleEn(String nameSimpleEn) {
		this.nameSimpleEn = nameSimpleEn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getManageFee() {
		return manageFee;
	}
	public void setManageFee(Float manageFee) {
		this.manageFee = manageFee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArround() {
		return arround;
	}
	public void setArround(String arround) {
		this.arround = arround;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getLng() {
		return lng;
	}
	public void setLng(Float lng) {
		this.lng = lng;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getBuildType() {
		return buildType;
	}
	public void setBuildType(Integer buildType) {
		this.buildType = buildType;
	}
}
