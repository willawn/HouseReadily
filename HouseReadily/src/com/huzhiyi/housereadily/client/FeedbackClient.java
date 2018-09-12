package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class FeedbackClient extends BaseClient {

	public void testFeedbackResource_add() {
		try {
			Form queryForm = new Form();
			queryForm.add("userName", "测试用户1");
			queryForm.add("email", "test@qq.com");
			queryForm.add("description", "意见反馈，发现bug");
			String url_ = getBaseUrl("feedback/0", "add");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFeedbackResource_list() {
		try {
			Form queryForm = new Form();
			String url_ = getBaseUrl("feedback/0", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
