package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class CustomerClient extends BaseClient {

	public void testCustomerResource_add() {
		try {
			Form queryForm = new Form();
			queryForm.add("ctype", "2");
			queryForm.add("buildType", "1");
			queryForm.add("name", "test23455");
			queryForm.add("gender", "1");
			queryForm.add("bigAreaCode", "458");
			queryForm.add("smallAreaCode", "474");
			queryForm.add("roomNum", "3");
			queryForm.add("hallNum", "2");
			queryForm.add("toiletNum", "2");
			queryForm.add("beginFirstPayment", "300000");
			queryForm.add("endFirstPayment", "500000");
			queryForm.add("beginArea", "70");
			queryForm.add("endArea", "90");
			queryForm.add("beginUnitPrice", "10000");
			queryForm.add("endUnitPrice", "12000");
			queryForm.add("beginTotalPrice", "900000");
			queryForm.add("endTotalPrice", "1200000");
			queryForm.add("phone", "0755-86521425");
			queryForm.add("mobile", "13652301239");
			queryForm.add("year", "2010");
			queryForm.add("month", "12");
			queryForm.add("description", "111111111111111111111111111111");
			queryForm.add("createTime", "2013-03-18 20:00:00");
			queryForm.add("lastFollowDate", "2013-03-18 21:50:00");
			queryForm.add("version", "1.0");
			queryForm.add("houseReadilyIds", "2,3");
			queryForm.add("houseFollows", "[{\"description\":\"22222222222\",\"createTime\":\"2013-03-18 12:30:15\"},{\"description\":\"33333333\",\"createTime\":\"2013-03-18 12:50:00\"}]");
			String url_ = getBaseUrl("customer/10461", "add");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCustomerResource_update() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "9");
			queryForm.add("ctype", "1");
			queryForm.add("buildType", "2");
			queryForm.add("name", "张三");
			queryForm.add("gender", "0");
			queryForm.add("bigAreaCode", "458");
			queryForm.add("smallAreaCode", "474");
			queryForm.add("roomNum", "3");
			queryForm.add("hallNum", "2");
			queryForm.add("toiletNum", "2");
			queryForm.add("beginFirstPayment", "300000");
			queryForm.add("endFirstPayment", "500000");
			queryForm.add("beginArea", "70");
			queryForm.add("endArea", "90");
			queryForm.add("beginUnitPrice", "10000");
			queryForm.add("endUnitPrice", "12000");
			queryForm.add("beginTotalPrice", "900000");
			queryForm.add("endTotalPrice", "1200000");
			queryForm.add("phone", "0755-86521425");
			queryForm.add("mobile", "13713825474");
			queryForm.add("year", "2010");
			queryForm.add("month", "12");
			queryForm.add("description", "22222222222222222222222");
			queryForm.add("updateTime", "2013-03-19 10:40:00");
			queryForm.add("version", "1.1");
			queryForm.add("houseReadilyIds", "12,5");
			queryForm.add("houseFollows", "[{\"description\":\"44444444444444\",\"createTime\":\"2013-04-22 18:41:00\"}]");
			queryForm.add("delHouseFollows", "13");
			queryForm.add("properties", "houseFollows");
			String url_ = getBaseUrl("customer/10461", "update");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testCustomerResource_updatestatus() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "1764");
			queryForm.add("state", "10");
			String url_ = getBaseUrl("customer/10461", "updatestatus");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCustomerResource_list() {
		try {
			Form queryForm = new Form();
			//queryForm.add("name", "张");
			queryForm.add("ctype", "2");
			queryForm.add("buildType", "1");
			String url_ = getBaseUrl("customer/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCustomerResource_idsversion() {
		try {
			Form queryForm = new Form();
			String url_ = getBaseUrl("customer/10461", "idsversion", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testCustomerResource_find() {
		try {
			Form queryForm = new Form();
			queryForm.add("ids", "9");
			String url_ = getBaseUrl("customer/10461", "find", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCustomerResource_delete() {
		try {
			Form queryForm = new Form();
			queryForm.add("ids", "7");
			String url_ = getBaseUrl("customer/10461", "delete", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
