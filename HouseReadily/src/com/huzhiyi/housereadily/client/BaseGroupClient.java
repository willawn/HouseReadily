package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class BaseGroupClient extends BaseClient {

	public void testBaseGroupResource_add() {
		try {
			Form queryForm = new Form();
			queryForm.add("groupName", "群名称测试");
			queryForm.add("acement", "群公告测试群公告测试群公告测试");
			queryForm.add("description", "群描述测试群描述测试群描述测试");
			queryForm.add("cityCode", "900003");
			queryForm.add("bigAreaCode", "458");
			queryForm.add("smallAreaCode", "474");
			String url_ = getBaseUrl("baseGroup/10461", "add");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testBaseGroupResource_updateacement() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "7");
			queryForm.add("acement", "群公告修改测试11111111");
			String url_ = getBaseUrl("baseGroup/10461", "updateacement");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testBaseGroupResource_delete() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "7");
			String url_ = getBaseUrl("baseGroup/10461", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.delete();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testBaseGroupResource_list() {
		try {
			Form queryForm = new Form();
			String url_ = getBaseUrl("baseGroup/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testBaseGroupResource_selnum() {
		try {
			Form queryForm = new Form();
			queryForm.add("groupNum", "12345");
			String url_ = getBaseUrl("baseGroup/10461", "selnum", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
