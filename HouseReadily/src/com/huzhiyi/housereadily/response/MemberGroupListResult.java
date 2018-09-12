package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class MemberGroupListResult extends Result {

	private int status;
	private JSONObject memberGroups;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JSONObject getMemberGroups() {
		return memberGroups;
	}

	public void setMemberGroups(JSONObject memberGroups) {
		this.memberGroups = memberGroups;
	}
}
