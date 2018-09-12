package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class CityAreaClient extends BaseClient {

	public void testCityAreaResource_citylist() {
		try {
			String url_ = getBaseUrl("cityArea/10461", "citylist");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCityAreaResource_arealist() {
		try {
			Form queryForm = new Form();
			queryForm.add("cityCode", "900003");
			String url_ = getBaseUrl("cityArea/10461", "arealist", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
