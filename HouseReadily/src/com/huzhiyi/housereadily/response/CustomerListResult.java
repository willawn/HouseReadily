package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class CustomerListResult extends Result {

	private JSONObject customers;

	public JSONObject getCustomers() {
		return customers;
	}

	public void setCustomers(JSONObject customers) {
		this.customers = customers;
	}
}
