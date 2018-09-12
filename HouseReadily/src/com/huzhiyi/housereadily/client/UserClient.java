package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class UserClient extends BaseClient {

	public void testUserResource_find() {
		try {
			Form queryForm = new Form();
			//queryForm.add("userName", "T00001");
			String url_ = getBaseUrl("user/10461", "find", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUserResource_update() {
		try {
			Form queryForm = new Form();
			//queryForm.add("oldPassword", "123456");
			//queryForm.add("password", "123456ab");
			queryForm.add("email", "123456789@qq.com");
			queryForm.add("mobile", "13713825474");
			queryForm.add("realName", "张大贤");
			queryForm.add("cityCode", "900003");
			queryForm.add("avatar", "27_101230095023_1_lit.jpg,/upload/user/img/1111111111111.jpg,63080");
			queryForm.add("properties", "email,mobile,realName,cityCode");
			String url_ = getBaseUrl("user/10461", "update");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
