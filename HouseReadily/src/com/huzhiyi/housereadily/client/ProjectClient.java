package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class ProjectClient extends BaseClient {

	public void testProjectResource_get() {
		try {
			Form queryForm = new Form();
			queryForm.add("pageNo", "1");
			queryForm.add("limit", "100");
			queryForm.add("name", "云");
			queryForm.add("publish", "1");
			queryForm.add("city", "sz");
			String url_ = getBaseUrl("project", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
