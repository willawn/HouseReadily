package com.huzhiyi.housereadily.entity;

import com.huzhiyi.housereadily.entity.base.AbstractBroker;

/**
 * Broker entity. @author MyEclipse Persistence Tools
 */
public class Broker extends AbstractBroker implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Broker() {
	}

	/** full constructor */
	public Broker(String name, String company, String mobile, String subareas) {
		super(name, company, mobile, subareas);
	}

}
