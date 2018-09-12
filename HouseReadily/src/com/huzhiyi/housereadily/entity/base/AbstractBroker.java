package com.huzhiyi.housereadily.entity.base;

/**
 * AbstractBroker entity provides the base persistence definition of the Broker
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBroker implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String company;
	private String mobile;
	private String subareas;

	// Constructors

	/** default constructor */
	public AbstractBroker() {
	}

	/** full constructor */
	public AbstractBroker(String name, String company, String mobile, String subareas) {
		this.name = name;
		this.company = company;
		this.mobile = mobile;
		this.subareas = subareas;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSubareas() {
		return this.subareas;
	}

	public void setSubareas(String subareas) {
		this.subareas = subareas;
	}

}