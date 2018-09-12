package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class TaskClient extends BaseClient {

	public void testTaskResource_list() {
		try {
			Form queryForm = new Form();
			String url_ = getBaseUrl("task/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testTaskResource_share() {
		try {
			Form queryForm = new Form();
			queryForm.add("shareType", "2");
			String url_ = getBaseUrl("task/10461", "share", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
