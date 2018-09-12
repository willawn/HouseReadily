package com.huzhiyi.housereadily.response;

import org.json.JSONObject;

public class FeedbackListResult extends Result {

	private JSONObject feedbacks;

	public JSONObject getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(JSONObject feedbacks) {
		this.feedbacks = feedbacks;
	}
}
