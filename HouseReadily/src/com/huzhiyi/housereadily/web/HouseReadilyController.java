package com.huzhiyi.housereadily.web;

import java.io.IOException;
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

import com.huzhiyi.housereadily.biz.IHouseReadilyService;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ExtJSONUtil;
import com.huzhiyi.utils.ResponseUtils;

@Controller
@RequestMapping("/houseReadily")
public class HouseReadilyController {

	@Autowired
	private IHouseReadilyService houseReadilyService;

	@RequestMapping("/toHouseReadilyList.do")
	public String toHouseReadilyList(Model model) {
		return "houseReadily/houseReadilyList";
	}

	@RequestMapping("/houseReadilyList.do")
	public void houseReadilyList(@RequestParam("start") int start,
			@RequestParam("limit") int limit,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "stype", required = false) Integer stype,
			@RequestParam(value = "buildType", required = false) Integer buildType,
			@RequestParam(value = "projectName", required = false) String projectName,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "cityCode", required = false) Integer cityCode,
			@RequestParam(value = "bigAreaCode", required = false) Integer bigAreaCode,
			@RequestParam(value = "smallAreaCode", required = false) Integer smallAreaCode,
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
		List<HouseReadily> houseReadilyList = houseReadilyService.findPaging(id, stype, buildType, projectName, title, cityCode,
				bigAreaCode, smallAreaCode, userName, beginDate, endDate, isDelete, sort, dir, pagingBean);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "lastFollowDate", "createTime", "updateTime", "syncTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath" });
		parseDataKey.put(Constants.PARSECOLLKEY, new String[] { "houseOwners", "btAttachments", "snAttachments", "fxAttachments",
				"xqAttachments", "houseFollows" });
		String[] fieldAttachments = { "id", "type", "houseReadilyId", "name", "description", "path", "spath", "mpath", "size", "isPicture",
				"createTime" };
		parseDataKey.put(Constants.PARSECOLLFIELD, new String[][] {
				{ "id", "isMain", "houseReadilyId", "houseReadilyName", "customerId", "customerName", "gender", "phone", "mobile" },
				fieldAttachments,
				fieldAttachments,
				fieldAttachments,
				fieldAttachments,
				{ "id", "houseReadilyId", "projectId", "projectName", "title", "building", "houseNum", "customerId", "ctype",
						"customerName", "gender", "phone", "mobile", "mode", "description", "creater", "createTime" } });
		JSONObject jsonObject = ExtJSONUtil.getJSONByGridPanel(pagingBean, houseReadilyList, parseDataKey, "id", "stype", "projectId",
				"projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName", "smallAreaCode", "smallAreaName", "lon",
				"lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum", "hallNum", "toiletNum", "area",
				"unitPrice", "totalPrice", "hasRedBook", "description", "address", "lastFollowDate", "syncTime", "version", "updateTime",
				"creater", "userName", "createTime", "isDelete", "houseOwners", "btAttachments", "snAttachments", "fxAttachments", 
				"xqAttachments", "houseFollows");
		ExtJSONUtil.retJson(response, jsonObject);
	}

	@RequestMapping("/houseReadilyEdit.do")
	public String houseReadilyEdit(@RequestParam("id") Integer id, Model model) {
		HouseReadily houseReadily = houseReadilyService.findById(id);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "lastFollowDate", "createTime", "updateTime", "syncTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath" });
		parseDataKey.put(Constants.PARSECOLLKEY, new String[] { "houseOwners", "btAttachments", "snAttachments", "fxAttachments",
				"xqAttachments", "houseFollows" });
		String[] fieldAttachments = { "id", "type", "houseReadilyId", "name", "description", "path", "spath", "mpath", "size", "isPicture",
				"createTime" };
		parseDataKey.put(Constants.PARSECOLLFIELD, new String[][] {
				{ "id", "isMain", "houseReadilyId", "houseReadilyName", "customerId", "customerName", "gender", "phone", "mobile" },
				fieldAttachments,
				fieldAttachments,
				fieldAttachments,
				fieldAttachments,
				{ "id", "houseReadilyId", "projectId", "projectName", "title", "building", "houseNum", "customerId", "ctype",
						"customerName", "gender", "phone", "mobile", "mode", "description", "creater", "createTime" } });
		JSONObject jsonObject = ResponseUtils.getJSONByModel("houseReadily", houseReadily, parseDataKey, "id", "stype", "projectId",
				"projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName", "smallAreaCode", "smallAreaName", "lon",
				"lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum", "hallNum", "toiletNum", "area",
				"unitPrice", "totalPrice", "hasRedBook", "description", "address", "lastFollowDate", "syncTime", "version", "updateTime",
				"creater", "userName", "createTime", "isDelete", "houseOwners", "btAttachments", "snAttachments", "fxAttachments", 
				"xqAttachments", "houseFollows");
		model.addAttribute("jsonObject", jsonObject);

		return "houseReadily/houseReadilyEdit";
	}
}
