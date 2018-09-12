package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class AuditMemberGroupClient extends BaseClient {
	
	public void testAuditMemberGroupResource_add() {
		try {
			Form queryForm = new Form();
			queryForm.add("baseGroupId", "1");
			queryForm.add("description", "你好，我是张三");
			String url_ = getBaseUrl("auditMemberGroup/10461", "add");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAuditMemberGroupResource_list() {
		try {
			Form queryForm = new Form();
			String url_ = getBaseUrl("auditMemberGroup/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAuditMemberGroupResource_audit() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "11");
			queryForm.add("isPass", "1");
			String url_ = getBaseUrl("auditMemberGroup/10461", "audit", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
