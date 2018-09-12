package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class MessageGroupClient extends BaseClient {
	
//	public void testMessageGroupResource_add() {
//		try {
//			Form queryForm = new Form();
//			queryForm.add("baseGroupId", "8");
//			queryForm.add("title", "群消息测试");
//			queryForm.add("description", "群消息测试群消息测试群消息测试");
//			queryForm.add("mtype", "3");
////			queryForm.add("source", "213");
////			queryForm.add("brokerage","1000");
////			queryForm.add("ownerRate", "11");
////			queryForm.add("otherRate", "11");
//			String url_ = getBaseUrl("messageGroup/10461", "add");
//			ClientResource client = new ClientResource(url_);
//			Representation representation = client.post(queryForm.getWebRepresentation());
//			System.out.println(representation.getText());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void testMessageGroupResource_delete() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "3");
			String url_ = getBaseUrl("messageGroup/10461", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.delete();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testMessageGroupResource_list() {
		try {
			Form queryForm = new Form();
			queryForm.add("mtype", "1");
			queryForm.add("baseGroupId", "8");
			queryForm.add("creater","10461");
//			queryForm.add("pageNo","2");
//			queryForm.add("pageSize","2");
			String url_ = getBaseUrl("messageGroup/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testMessageGroupResource_messagelist() {
		try {
			Form queryForm = new Form();
//			queryForm.add("mtype", "1");
			queryForm.add("baseGroupId", "8");
			queryForm.add("creater","10461");
//			queryForm.add("pageNo","2");
//			queryForm.add("pageSize","2");
			String url_ = getBaseUrl("messageGroup/10461", "messagelist", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testMessageGroupResource_find() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "1");
			String url_ = getBaseUrl("messageGroup/10461", "find", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
