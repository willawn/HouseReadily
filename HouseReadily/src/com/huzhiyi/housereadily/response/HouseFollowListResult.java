package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class HouseFollowListResult extends Result {

	private JSONObject houseFollows;

	public JSONObject getHouseFollows() {
		return houseFollows;
	}

	public void setHouseFollows(JSONObject houseFollows) {
		this.houseFollows = houseFollows;
	}
}
