package com.huzhiyi.housereadily.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huzhiyi.housereadily.biz.ICustomerService;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ExtJSONUtil;
import com.huzhiyi.utils.ResponseUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/toCustomerList.do")
	public String toCustomerList(Model model) {
		return "customer/customerList";
	}

	@RequestMapping("/customerList.do")
	public void customerList(@RequestParam("start") int start, 
			@RequestParam("limit") int limit,
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "ctype", required = false) Integer ctype,
			@RequestParam(value = "buildType", required = false) Integer buildType,
			@RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "gender", required = false) Integer gender,
			@RequestParam(value = "mobile", required = false) String mobile,
			@RequestParam(value = "beginRoomNum", required = false) Integer beginRoomNum,
			@RequestParam(value = "endRoomNum", required = false) Integer endRoomNum,
			@RequestParam(value = "beginArea", required = false) BigDecimal beginArea,
			@RequestParam(value = "endArea", required = false) BigDecimal endArea,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate, 
			@RequestParam(value = "isDelete", required = false) Integer isDelete,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "dir", required = false) String dir, 
			HttpServletResponse response, Model model) throws IOException {
		PagingBean pagingBean = new PagingBean();
		pagingBean.setPageRows(limit);
		pagingBean.setBeginRow(start);
		List<Customer> customerList = customerService.findPaging(id, ctype, buildType, name, gender, mobile, beginRoomNum, endRoomNum,
				beginArea, endArea, userName, beginDate, endDate, isDelete, sort, dir, pagingBean);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "lastFollowDate", "createTime", "updateTime", "syncTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath" });
		parseDataKey.put(Constants.PARSECOLLKEY, new String[] { "houseReadilys", "houseOwners", "houseFollows" });
		String[] field = { "id", "stype", "projectId", "projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName",
				"smallAreaCode", "smallAreaName", "lon", "lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum",
				"hallNum", "toiletNum", "area", "unitPrice", "totalPrice", "hasRedBook", "description", "address", "creater", "createTime" };
		parseDataKey.put(Constants.PARSECOLLFIELD, new String[][] {
				field,
				{ "id", "isMain", "houseReadilyId", "houseReadilyName", "customerId", "customerName", "gender", "phone", "mobile" },
				{ "id", "houseReadilyId", "projectId", "projectName", "title", "building", "houseNum", "customerId", "ctype",
						"customerName", "gender", "phone", "mobile", "mode", "description", "creater", "createTime" } });
		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(pagingBean, customerList, parseDataKey, "id", "buildType",
				"buildTypeName", "ctype", "name", "gender", "phone", "mobile", "cityCode", "cityEn", "cityName", "bigAreaCode",
				"bigAreaName", "smallAreaCode", "smallAreaName", "roomNum", "hallNum", "toiletNum", "beginFirstPayment", "endFirstPayment",
				"beginArea", "endArea", "beginUnitPrice", "endUnitPrice", "beginTotalPrice", "endTotalPrice", "year", "month",
				"description", "lastFollowDate", "syncTime", "version", "updateTime", "creater", "userName", "createTime", "isDelete", 
				"houseReadilys", "houseOwners", "houseFollows");
		ExtJSONUtil.retJson(response, jsonObject);
	}

	@RequestMapping("/customerEdit.do")
	public String houseReadilyEdit(@RequestParam("id") Integer id, Model model) {
		Customer customer = customerService.findById(id);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "lastFollowDate", "createTime", "updateTime", "syncTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath" });
		parseDataKey.put(Constants.PARSECOLLKEY, new String[] { "houseReadilys", "houseOwners", "houseFollows" });
		String[] field = { "id", "stype", "projectId", "projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName",
				"smallAreaCode", "smallAreaName", "lon", "lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum",
				"hallNum", "toiletNum", "area", "unitPrice", "totalPrice", "hasRedBook", "description", "address", "creater", "createTime" };
		parseDataKey.put(Constants.PARSECOLLFIELD, new String[][] {
				field,
				{ "id", "isMain", "houseReadilyId", "houseReadilyName", "customerId", "customerName", "gender", "phone", "mobile" },
				{ "id", "houseReadilyId", "projectId", "projectName", "title", "building", "houseNum", "customerId", "ctype",
						"customerName", "gender", "phone", "mobile", "mode", "description", "creater", "createTime" } });
		JSONObject jsonObject = ResponseUtils.getJSONByModel("customer", customer, parseDataKey, "id", "buildType",
				"buildTypeName", "ctype", "name", "gender", "phone", "mobile", "cityCode", "cityEn", "cityName", "bigAreaCode",
				"bigAreaName", "smallAreaCode", "smallAreaName", "roomNum", "hallNum", "toiletNum", "beginFirstPayment", "endFirstPayment",
				"beginArea", "endArea", "beginUnitPrice", "endUnitPrice", "beginTotalPrice", "endTotalPrice", "year", "month",
				"description", "lastFollowDate", "syncTime", "version", "updateTime", "creater", "userName", "createTime", "isDelete", 
				"houseReadilys", "houseOwners", "houseFollows");
		model.addAttribute("jsonObject", jsonObject);

		return "customer/customerEdit";
	}
}
