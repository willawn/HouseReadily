package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class HouseReadilyListResult extends Result {

	private JSONObject houseReadilys;

	public JSONObject getHouseReadilys() {
		return houseReadilys;
	}

	public void setHouseReadilys(JSONObject houseReadilys) {
		this.houseReadilys = houseReadilys;
	}
}
