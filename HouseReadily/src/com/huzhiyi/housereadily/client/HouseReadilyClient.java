package com.huzhiyi.housereadily.client;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class HouseReadilyClient extends BaseClient {

	public void testHouseReadilyResource_add() {
		try {
			Form queryForm = new Form();
			queryForm.add("stype", "1");
			queryForm.add("projectId", "3322");
			queryForm.add("projectName", "泰然公寓");
			queryForm.add("buildType", "1");
			queryForm.add("title", "泰然公寓");
			queryForm.add("building", "A/12");
			queryForm.add("houseNum", "803");
			queryForm.add("roomNum", "3");
			queryForm.add("hallNum", "2");
			queryForm.add("toiletNum", "2");
			queryForm.add("firstPayment", "300000");
			queryForm.add("area", "120");
			queryForm.add("totalPrice", "1500000");
//			queryForm.add("towards", "1");
//			queryForm.add("fitment", "2");
//			queryForm.add("houseRight", "3");
//			queryForm.add("furn", "2");
//			queryForm.add("keyer", "张三");
//			queryForm.add("hasRedBook", "1");
			queryForm.add("description", "位于车公庙商圈，地铁物业，交通便利，升值空间大");
//			queryForm.add("createTime", "2013-03-18 13:00:00");
//			queryForm.add("lastFollowDate", "2013-03-18 12:50:00");
//			queryForm.add("version", "1.0");
//			queryForm.add("houseOwners", "[{\"customerId\":1,\"isMain\":1},{\"customerId\":2,\"isMain\":0}]");
//			queryForm.add("btAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445");
//			queryForm.add("snAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445;4d5a0def716ec2426d000026.jpg,/upload/credit_pics/201212/06/0612001354788720814.jpg,/upload/credit_pics/201212/06/0612001354788720814_s.jpg,53335");
//			queryForm.add("fxAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445;4d5a0def716ec2426d000026.jpg,/upload/credit_pics/201212/06/0612001354788720814.jpg,/upload/credit_pics/201212/06/0612001354788720814_s.jpg,53335");
//			queryForm.add("xqAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445;4d5a0def716ec2426d000026.jpg,/upload/credit_pics/201212/06/0612001354788720814.jpg,/upload/credit_pics/201212/06/0612001354788720814_s.jpg,53335");
			//queryForm.add("houseFollows", "[{\"customerId\":1,\"mode\":1,\"description\":\"22222222222\",\"createTime\":\"2013-03-18 12:30:15\"},{\"customerId\":2,\"mode\":2,\"description\":\"33333333\",\"createTime\":\"2013-03-18 12:50:00\"}]");
			String url_ = getBaseUrl("houseReadily/10461", "add");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testHouseReadilyResource_update() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "11");
			queryForm.add("stype", "1");
			queryForm.add("projectId", "378");
			queryForm.add("projectName", "香港丽园");
			queryForm.add("buildType", "2");
			queryForm.add("title", "香港丽园");
			queryForm.add("building", "A/13");
			queryForm.add("houseNum", "1003");
			queryForm.add("roomNum", "4");
			queryForm.add("hallNum", "3");
			queryForm.add("toiletNum", "3");
			queryForm.add("firstPayment", "400000");
			queryForm.add("area", "200");
			queryForm.add("totalPrice", "2000000");
			queryForm.add("hasRedBook", "1");
			queryForm.add("description", "香港丽园香港丽园香港丽园香港丽园香港丽园");
			queryForm.add("updateTime", "2013-03-18 18:00:00");
			queryForm.add("lastFollowDate", "2013-03-18 14:30:33");
//			queryForm.add("version", "1.1");
//			queryForm.add("properties", "houseReadily,houseOwners,attachments");
//			queryForm.add("properties", "houseReadily,houseFollows");
//			queryForm.add("properties", "houseOwners");
//			queryForm.add("delHouseOwners", "19");
//			queryForm.add("updateHouseOwners", "[{\"id\":34,\"customerId\":7,\"isMain\":1}]");
//			queryForm.add("houseOwners", "[{\"customerId\":165,\"isMain\":0}]");
//			queryForm.add("delAttachments", "24,26,28");
//			queryForm.add("houseOwners", "[{\"customerId\":1,\"isMain\":1},{\"customerId\":2,\"isMain\":0}]");
//			queryForm.add("btAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445");
//			queryForm.add("snAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445;4d5a0def716ec2426d000026.jpg,/upload/credit_pics/201212/06/0612001354788720814.jpg,/upload/credit_pics/201212/06/0612001354788720814_s.jpg,53335");
//			queryForm.add("fxAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445;4d5a0def716ec2426d000026.jpg,/upload/credit_pics/201212/06/0612001354788720814.jpg,/upload/credit_pics/201212/06/0612001354788720814_s.jpg,53335");
//			queryForm.add("xqAttachments", "4d5a0d10716ec2426b00000c.jpg,/upload/credit_pics/201212/06/0610481354788648477.jpg,/upload/credit_pics/201212/06/0610481354788648477_s.jpg,86445;4d5a0def716ec2426d000026.jpg,/upload/credit_pics/201212/06/0612001354788720814.jpg,/upload/credit_pics/201212/06/0612001354788720814_s.jpg,53335");
			queryForm.add("houseFollows", "[{\"customerId\":1,\"mode\":1,\"description\":\"5555555555\",\"createTime\":\"2013-03-18 14:30:33\"}]");
			queryForm.add("delHouseFollows", "7");
			String url_ = getBaseUrl("houseReadily/10461", "update");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testHouseReadilyResource_updatestate() {
		try {
			Form queryForm = new Form();
			queryForm.add("id", "1419");
			queryForm.add("state", "5");
			String url_ = getBaseUrl("houseReadily/10461", "updatestate");
			ClientResource client = new ClientResource(url_);
			Representation representation = client.post(queryForm.getWebRepresentation());
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testHouseReadilyResource_list() {
		try {
			Form queryForm = new Form();
			queryForm.add("stype", "1");
			//queryForm.add("order", "1");
			String url_ = getBaseUrl("houseReadily/10461", "list", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testHouseReadilyResource_idsversion() {
		try {
			Form queryForm = new Form();
			String url_ = getBaseUrl("houseReadily/10461", "idsversion", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testHouseReadilyResource_myreadily() {
		try {
			Form queryForm = new Form();
			//queryForm.add("stype", "2");
			queryForm.add("pageNo", "1");
			queryForm.add("pageSize", "15");
			String url_ = getBaseUrl("houseReadily/10461", "myreadily", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testHouseReadilyResource_find() {
		try {
			Form queryForm = new Form();
			queryForm.add("ids", "15");
			String url_ = getBaseUrl("houseReadily/10461", "find", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testHouseReadilyResource_delete() {
		try {
			Form queryForm = new Form();
			queryForm.add("ids", "83");
			String url_ = getBaseUrl("houseReadily/10461", "delete", queryForm);
			ClientResource client = new ClientResource(url_);
			Representation representation = client.get();
			System.out.println(representation.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
