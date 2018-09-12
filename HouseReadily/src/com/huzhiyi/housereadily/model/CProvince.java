package com.huzhiyi.housereadily.model;

import com.tastysoft.swct.db.model.TastyEntity;


public class CProvince extends TastyEntity{
	
	private int id;
	private String provinceName;
	private String provinceEnName;
	private int provinceCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	public int getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceEnName() {
		return provinceEnName;
	}
	public void setProvinceEnName(String provinceEnName) {
		this.provinceEnName = provinceEnName;
	}
	
	
}
