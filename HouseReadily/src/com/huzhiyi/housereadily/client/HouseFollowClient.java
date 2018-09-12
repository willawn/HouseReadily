package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class HouseFollowClient extends BaseClient {

	public void testHouseFollowResource_add() {
		try {
			Form queryForm = new Form();
			//queryForm.add("houseReadilyId", "7");
			queryForm.add("customerId", "8");
			queryForm.add("mode", "1");
			queryForm.add("description", "跟客户沟通后，约在明日看房233333333");
			String url_ = getBaseUrl("houseFollow/10461", "add");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testHouseFollowResource_list() {
		try {
			Form queryForm = new Form();
			queryForm.add("houseReadilyId", "7");
			//queryForm.add("customerId", "1");
			queryForm.add("ctype", "1");
			queryForm.add("pageNo", "2");
			queryForm.add("pageSize", "10");
			String url_ = getBaseUrl("houseFollow/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testHouseFollowResource_find() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "1");
			String url_ = getBaseUrl("houseFollow/10461", "find", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testHouseFollowResource_delete() {
		try {
			Form queryForm = new Form();
			queryForm.add("ids", "5");
			String url_ = getBaseUrl("houseFollow/10461", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.delete();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
