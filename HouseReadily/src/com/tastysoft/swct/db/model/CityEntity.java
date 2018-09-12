package com.tastysoft.swct.db.model;

import java.io.Serializable;

public class CityEntity implements Serializable {
	private int provinceId;
	private int cityCode;
	private String cityName;

	public CityEntity() {
	}

	public CityEntity(int provinceId, int cityCode, String cityName) {
		super();
		this.provinceId = provinceId;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
