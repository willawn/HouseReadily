package com.huzhiyi.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;

import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.housereadily.response.Result;

public class JsonHelper {
	public static JsonRepresentation getJson(Result result) {

		String str = null;
		try {
			str = JSONUtil.toJSONString(result);
		} catch (JSONException e) {

		}
		JSONObject jsonOjb = new JSONObject();
		try {
			jsonOjb.put("housereadily", str);
		} catch (JSONException e) {
		}

		return new JsonRepresentation(jsonOjb);
	}
	
	/**
	 * sana
	 * @param result1
	 * @param command
	 * @return
	 */
	public static JsonRepresentation getJson(Object result1,ICommand command) {

		String str1 = null;
		String str2 = null;
		try {
			str1 = JSONUtil.toJSONString(result1);
			str2 = JSONUtil.toJSONString(command);
		} catch (JSONException e) {

		}
		JSONObject jsonOjb = new JSONObject();
		try {
			jsonOjb.put("housereadily", str1);
			jsonOjb.put("command", str2);
		} catch (JSONException e) {
		}

		return new JsonRepresentation(jsonOjb);
	}
	
	public static JsonRepresentation getJsonStr(Object result) {

		String str = null;
		try {
			str = JSONUtil.toJSONString(result);
		} catch (JSONException e) {

		}
		JSONObject jsonOjb = new JSONObject();
		try {
			jsonOjb.put("housereadily", str);
		} catch (JSONException e) {
		}

		return new JsonRepresentation(jsonOjb);
	}
	
	/**
	 * 获取json格式【api中 更新房源操作接口用处】
	 * @param jsonStr
	 * @return
	 */
	public static Map<Integer,List<Integer>> getObjectByJson(String jsonStr){
		Map<Integer,List<Integer>> maps = new HashMap<Integer,List<Integer>>();
		try {
			String jsonString = jsonStr.substring(jsonStr.indexOf("{\"list\":"),jsonStr.indexOf("}\"}"));
			JSONObject jsonObject = new JSONObject(jsonString);
			
			if(jsonObject.has("list")){
				JSONArray jArray = jsonObject.getJSONArray("list");
				for (int i = 0; i < jArray.length(); i++) {
						JSONObject jObj = (JSONObject) jArray.get(i);
						String houseId = jObj.getString("houseId");
						Integer id = Integer.valueOf(houseId==null?"0":houseId);
						System.err.println(jObj.getString("houseId"));
						
						JSONArray array = jObj.getJSONArray("webList");
						List<Integer> listwebId = new ArrayList<Integer>();
							for (int j = 0; j < array.length(); j++) {
								listwebId.add(Integer.valueOf(array.get(j).toString()==null?"0":array.get(j).toString()));
							}
					    maps.put(id, listwebId);
					}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//(TableSet)JSONObject.toBean(JSONObject.fromObject(jsonString), TableSet.class);
		//JSONObject.toBean(jsonObj, MyBean.class); 
		return maps;
	}
}
