package com.huzhiyi.housereadily.client;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class BrokerClient extends BaseClient {

	public void testBrokerResource_soufun() {
		try {
			String url_ = getBaseUrl("broker/10461", "soufun");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
