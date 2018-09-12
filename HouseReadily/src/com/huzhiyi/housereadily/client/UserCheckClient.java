/**   
 * @Title: UserCheckClient.java
 * @Package com.huzhiyi.housereadily.client
 * @Description: TODO(描述文件)
 * 		<p>
 * @author willter
 * @date 2012-10-29
 */
package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * @ClassName: UserCheckClient
 * @Description: 描述类
 *               <p>
 * @author willter
 * @date 2012-10-29
 */
public class UserCheckClient extends BaseClient {

	public void testUserCheckResource_sendcode() {
		try {
			Form queryForm = new Form();
			queryForm.add("userName", "test331");
			queryForm.add("mobile", "13713825474");
			String url_ = getBaseUrl("usercheck", "sendcode", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUserCheckResource_retakepassword() {
		try {
			Form queryForm = new Form();
			queryForm.add("userName", "T00001");
			queryForm.add("mobile", "13713825474");
			queryForm.add("password", "123456ab");
			queryForm.add("code", "308926");
			String url_ = getBaseUrl("usercheck", "retakepassword", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUserCheckResource_login() {
		try {
			Form queryForm = new Form();
			queryForm.add("action", "login");
			queryForm.add("userName", "T00001");
//			queryForm.add("userName", "boliangchen123");
//			queryForm.add("password", "huzhiyi@kuai365.com");
//			queryForm.add("userName", "allen");
			queryForm.add("password", "123456ab");
			queryForm.add("operate", "android");
			queryForm.add("version","2013060916");
			String url_ = getBaseUrl("usercheck", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUserCheckResource_register() {
		try {
			Form queryForm = new Form();
			queryForm.add("userName", "test23456223");
			queryForm.add("password", "123456ab");
			queryForm.add("mobile","13713825474");
			String url_ = getBaseUrl("usercheck", "register");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testUserCheckResource_adduserext() {
		try {
			Form queryForm = new Form();
			String url_ = getBaseUrl("usercheck", "adduserext", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
