package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class AuditMemberGroupListResult extends Result {

	private int status;
	private JSONObject auditMemberGroups;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JSONObject getAuditMemberGroups() {
		return auditMemberGroups;
	}

	public void setAuditMemberGroups(JSONObject auditMemberGroups) {
		this.auditMemberGroups = auditMemberGroups;
	}
}
