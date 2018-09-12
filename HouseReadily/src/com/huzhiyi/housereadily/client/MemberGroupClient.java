package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class MemberGroupClient extends BaseClient {

	public void testMemberGroupResource_list() {
		try {
			Form queryForm = new Form();
			queryForm.add("baseGroupId", "8");
			String url_ = getBaseUrl("memberGroup/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testMemberGroupResource_delete() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "10");
			String url_ = getBaseUrl("memberGroup/10461", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.delete();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testMemberGroupResource_quitgroup() {
		try {
			Form queryForm = new Form();
			queryForm.add("baseGroupId", "5");
			String url_ = getBaseUrl("memberGroup/10461", "quitgroup", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
