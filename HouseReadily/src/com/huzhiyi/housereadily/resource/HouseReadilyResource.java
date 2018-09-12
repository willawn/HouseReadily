package com.huzhiyi.housereadily.resource;

import static com.huzhiyi.model.PagingBean.cpn;
import static com.huzhiyi.model.PagingBean.cps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.IHouseReadilyService;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.request.HouseReadilyCommand;
import com.huzhiyi.housereadily.response.HouseReadilyListResult;
import com.huzhiyi.housereadily.response.HouseReadilyResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class HouseReadilyResource extends BaseResource {

	private static final String ADD = "add";
	private static final String LIST = "list";
	private static final String MYREADILY = "myreadily";
	private static final String FIND = "find";
	private static final String IDSVERSION = "idsversion";
	private static final String UPDATE = "update";
	private static final String UPDATESTATE = "updatestate";
	private static final String DELETE = "delete";
	private static final String UPDATESTYPE = "updatestype";

	@Override
	protected void doInit() throws ResourceException {
		command = new HouseReadilyCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
		getCommand().setStype(RequestUtils.requestPropertyIntValue(form, "stype"));
		getCommand().setProjectId(RequestUtils.requestPropertyIntValue(form, "projectId"));
		getCommand().setProjectName(RequestUtils.requestPropertyValue(form, "projectName", ""));
		// getCommand().setCityCode(RequestUtils.requestPropertyIntValue(form, "cityCode"));
		getCommand().setBigAreaCode(RequestUtils.requestPropertyIntValue(form, "bigAreaCode"));
		getCommand().setSmallAreaCode(RequestUtils.requestPropertyIntValue(form, "smallAreaCode"));
		// getCommand().setLon(RequestUtils.requestPropertyBigDecimalValue(form, "lon", BigDecimal.ZERO));
		// getCommand().setLat(RequestUtils.requestPropertyBigDecimalValue(form, "lat", BigDecimal.ZERO));
		getCommand().setBuildType(RequestUtils.requestPropertyIntValue(form, "buildType"));
		getCommand().setTitle(RequestUtils.requestPropertyValue(form, "title", ""));
		getCommand().setBuilding(RequestUtils.requestPropertyValue(form, "building", ""));
		getCommand().setHouseNum(RequestUtils.requestPropertyValue(form, "houseNum", ""));
		getCommand().setRoomNum(RequestUtils.requestPropertyIntValue(form, "roomNum"));
		getCommand().setHallNum(RequestUtils.requestPropertyIntValue(form, "hallNum"));
		getCommand().setToiletNum(RequestUtils.requestPropertyIntValue(form, "toiletNum"));
		getCommand().setArea(RequestUtils.requestPropertyBigDecimalValue(form, "area", BigDecimal.ZERO));
		getCommand().setUnitPrice(RequestUtils.requestPropertyBigDecimalValue(form, "unitPrice", BigDecimal.ZERO));
		getCommand().setTotalPrice(RequestUtils.requestPropertyBigDecimalValue(form, "totalPrice", BigDecimal.ZERO));
		getCommand().setTowards(RequestUtils.requestPropertyIntValue(form, "towards"));
		getCommand().setFitment(RequestUtils.requestPropertyIntValue(form, "fitment"));
		getCommand().setHouseRight(RequestUtils.requestPropertyIntValue(form, "houseRight"));
		getCommand().setFurn(RequestUtils.requestPropertyIntValue(form, "furn"));
		getCommand().setKeyer(RequestUtils.requestPropertyValue(form, "keyer", ""));
		getCommand().setHasRedBook(RequestUtils.requestPropertyIntValue(form, "hasRedBook"));
		getCommand().setDescription(RequestUtils.requestPropertyValue(form, "description", ""));
		getCommand().setCreateTime(RequestUtils.requestPropertyDateValue(form, "createTime"));
		getCommand().setUpdateTime(RequestUtils.requestPropertyDateValue(form, "updateTime"));
		// getCommand().setLastFollowDate(RequestUtils.requestPropertyDateValue(form, "lastFollowDate"));
		getCommand().setSyncTime(RequestUtils.requestPropertyDateValue(form, "syncTime"));
		getCommand().setVersion(RequestUtils.requestPropertyValue(form, "version", ""));
		getCommand().setState(RequestUtils.requestPropertyIntValue(form, "state"));
		getCommand().setHouseOwners(RequestUtils.requestPropertyValue(form, "houseOwners", ""));
		getCommand().setBtAttachments(RequestUtils.requestPropertyValue(form, "btAttachments", ""));
		getCommand().setSnAttachments(RequestUtils.requestPropertyValue(form, "snAttachments", ""));
		getCommand().setFxAttachments(RequestUtils.requestPropertyValue(form, "fxAttachments", ""));
		getCommand().setXqAttachments(RequestUtils.requestPropertyValue(form, "xqAttachments", ""));
		getCommand().setDelHouseOwners(RequestUtils.requestPropertyValue(form, "delHouseOwners", ""));
		getCommand().setUpdateHouseOwners(RequestUtils.requestPropertyValue(form, "updateHouseOwners", ""));
		getCommand().setDelAttachments(RequestUtils.requestPropertyValue(form, "delAttachments", ""));
		getCommand().setHouseFollows(RequestUtils.requestPropertyValue(form, "houseFollows", ""));
		getCommand().setDelHouseFollows(RequestUtils.requestPropertyValue(form, "delHouseFollows", ""));
		getCommand().setProperties(RequestUtils.requestPropertyValue(form, "properties", ""));
		getCommand().setIds(RequestUtils.requestPropertyValue(form, "ids", ""));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
		getCommand().setBigAreaCode(RequestUtils.requestPropertyIntValue(form, "bigAreaCode"));
		getCommand().setSmallAreaCode(RequestUtils.requestPropertyIntValue(form, "smallAreaCode"));
		getCommand().setBeginArea(RequestUtils.requestPropertyBigDecimalValue(form, "beginArea", BigDecimal.ZERO));
		getCommand().setEndArea(RequestUtils.requestPropertyBigDecimalValue(form, "endArea", BigDecimal.ZERO));
		getCommand().setBeginUnitPrice(RequestUtils.requestPropertyBigDecimalValue(form, "beginUnitPrice", BigDecimal.ZERO));
		getCommand().setEndUnitPrice(RequestUtils.requestPropertyBigDecimalValue(form, "endUnitPrice", BigDecimal.ZERO));
		getCommand().setBeginTotalPrice(RequestUtils.requestPropertyBigDecimalValue(form, "beginTotalPrice", BigDecimal.ZERO));
		getCommand().setEndTotalPrice(RequestUtils.requestPropertyBigDecimalValue(form, "endTotalPrice", BigDecimal.ZERO));
		getCommand().setBeginRoomNum(RequestUtils.requestPropertyIntValue(form, "beginRoomNum"));
		getCommand().setEndRoomNum(RequestUtils.requestPropertyIntValue(form, "endRoomNum"));
		getCommand().setOrder(RequestUtils.requestPropertyIntValue(form, "order"));
	}

	public HouseReadilyCommand getCommand() {
		return (HouseReadilyCommand) command;
	}

	/**
	 * @Title: add
	 * @Description: 发布房源
	 *               <p>
	 * @author willter
	 * @date 2012-12-5
	 *       <p>
	 * @return
	 */
	private Representation add() {
		HouseReadilyResult readilyResult = new HouseReadilyResult();
		HouseReadily houseReadily = null;
		try {
			houseReadily = houseReadilyService.add(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SUBMIT_FAILURE));
		}

		readilyResult.setStatus(1);
		readilyResult.setMsg(Configuration.SUBMIT_SUCCESS);

		initData(houseReadily, readilyResult);

		return JsonHelper.getJson(readilyResult);
	}

	private void initData(HouseReadily houseReadily, HouseReadilyResult readilyResult) {
		readilyResult.setCommand(command);
		readilyResult.setId(houseReadily.getId());
		readilyResult.setStype(houseReadily.getStype());
		readilyResult.setProjectId(houseReadily.getProjectId());
		readilyResult.setProjectName(houseReadily.getProjectName());
		readilyResult.setCityCode(houseReadily.getCityCode());
		readilyResult.setCityEn(houseReadily.getCityEn());
		readilyResult.setCityName(houseReadily.getCityName());
		readilyResult.setBigAreaCode(houseReadily.getBigAreaCode());
		readilyResult.setBigAreaName(houseReadily.getBigAreaName());
		readilyResult.setSmallAreaCode(houseReadily.getSmallAreaCode());
		readilyResult.setSmallAreaName(houseReadily.getSmallAreaName());
		readilyResult.setLon(houseReadily.getLon());
		readilyResult.setLat(houseReadily.getLat());
		readilyResult.setBuildType(houseReadily.getBuildType());
		readilyResult.setBuildTypeName(houseReadily.getBuildTypeName());
		readilyResult.setTitle(houseReadily.getTitle());
		readilyResult.setBuilding(houseReadily.getBuilding());
		readilyResult.setHouseNum(houseReadily.getHouseNum());
		readilyResult.setRoomNum(houseReadily.getRoomNum());
		readilyResult.setHallNum(houseReadily.getHallNum());
		readilyResult.setToiletNum(houseReadily.getToiletNum());
		readilyResult.setArea(houseReadily.getArea());
		readilyResult.setUnitPrice(houseReadily.getUnitPrice());
		readilyResult.setTotalPrice(houseReadily.getTotalPrice());
		readilyResult.setTowards(houseReadily.getTowards());
		readilyResult.setFitment(houseReadily.getFitment());
		readilyResult.setHouseRight(houseReadily.getHouseRight());
		readilyResult.setFurn(houseReadily.getFurn());
		readilyResult.setKeyer(houseReadily.getKeyer());
		readilyResult.setHasRedBook(houseReadily.getHasRedBook());
		readilyResult.setDescription(houseReadily.getDescription());
		readilyResult.setAddress(houseReadily.getAddress());
		readilyResult.setLastFollowDate(houseReadily.getLastFollowDate());
		readilyResult.setSyncTime(houseReadily.getSyncTime());
		readilyResult.setVersion(houseReadily.getVersion());
		readilyResult.setUpdateTime(houseReadily.getUpdateTime());
		readilyResult.setState(houseReadily.getState());
		readilyResult.setCreater(houseReadily.getCreater());
		readilyResult.setCreateTime(houseReadily.getCreateTime());
		readilyResult.setGrowing(houseReadily.getGrowing());

		Map parseDataKey = new HashMap();
		String[] field = new String[] { "id", "isMain", "houseReadilyId", "houseReadilyName", "customerId", "customerName", "gender",
				"phone", "mobile" };
		JSONObject houseOwners = ResponseUtils.getJSONByModel("list", houseReadily.getHouseOwners(), parseDataKey, field);
		readilyResult.setHouseOwners(houseOwners);

		parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "path", "spath", "mpath" });
		field = new String[] { "id", "type", "houseReadilyId", "name", "description", "path", "spath", "mpath", "size", "isPicture",
				"createTime" };
		JSONObject btAttachments = ResponseUtils.getJSONByModel("list", houseReadily.getBtAttachments(), parseDataKey, field);
		readilyResult.setBtAttachments(btAttachments);
		JSONObject snAttachments = ResponseUtils.getJSONByModel("list", houseReadily.getSnAttachments(), parseDataKey, field);
		readilyResult.setSnAttachments(snAttachments);
		JSONObject fxAttachments = ResponseUtils.getJSONByModel("list", houseReadily.getFxAttachments(), parseDataKey, field);
		readilyResult.setFxAttachments(fxAttachments);
		JSONObject xqAttachments = ResponseUtils.getJSONByModel("list", houseReadily.getXqAttachments(), parseDataKey, field);
		readilyResult.setXqAttachments(xqAttachments);

		parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		field = new String[] { "id", "houseReadilyId", "projectId", "projectName", "title", "building", "houseNum", "customerId", "ctype",
				"customerName", "gender", "phone", "mobile", "mode", "description", "creater", "createTime" };
		JSONObject houseFollows = ResponseUtils.getJSONByModel("list", houseReadily.getHouseFollows(), parseDataKey, field);
		readilyResult.setHouseFollows(houseFollows);
	}

	private void initData(List houseReadilyList, PagingBean pagingBean, HouseReadilyListResult readilyListResult) {
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
		JSONObject houseReadilys = ResponseUtils.getJSONByPagingBean(pagingBean, houseReadilyList, parseDataKey, "id", "stype",
				"projectId", "projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName", "smallAreaCode",
				"smallAreaName", "lon", "lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum", "hallNum",
				"toiletNum", "area", "unitPrice", "totalPrice", "towards", "fitment", "houseRight", "furn", "keyer", "hasRedBook",
				"description", "address", "lastFollowDate", "syncTime", "version", "updateTime", "state", "creater", "userName",
				"createTime", "houseOwners", "btAttachments", "snAttachments", "fxAttachments", "xqAttachments", "houseFollows");
		
		readilyListResult.setCommand(command);
		readilyListResult.setHouseReadilys(houseReadilys);
	}

	/**
	 * @Title: list
	 * @Description: 房源列表查询
	 *               <p>
	 * @author willter
	 * @date 2012-12-5
	 *       <p>
	 * @param userId
	 * @return
	 */
	private Representation list(Integer userId) {
		HouseReadilyListResult readilyListResult = new HouseReadilyListResult();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();

		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		List houseReadilyList = houseReadilyService.findPaging(command, pagingBean);

		initData(houseReadilyList, pagingBean, readilyListResult);

		return JsonHelper.getJson(readilyListResult);
	}

	/**
	 * @Title: idsversion
	 * @Description: 获取当前用户的房源ID，版本号列表
	 *               <p>
	 * @author willter
	 * @date 2013-3-20
	 *       <p>
	 * @param userId
	 * @return
	 */
	private Representation idsversion(Integer userId) {
		HouseReadilyListResult readilyListResult = new HouseReadilyListResult();

		List houseReadilyList = houseReadilyService.findIdAndVersion(userId);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "syncTime" });
		JSONObject houseReadilys = ResponseUtils.getJSONByPagingBean(null, houseReadilyList, parseDataKey, "id", "version", "syncTime");

		readilyListResult.setCommand(command);
		readilyListResult.setHouseReadilys(houseReadilys);

		return JsonHelper.getJson(readilyListResult);
	}

	/**
	 * @Title: find
	 * @Description: 房源详细信息查看
	 *               <p>
	 * @author willter
	 * @date 2012-12-5
	 *       <p>
	 * @return
	 */
	private Representation find() {
		Integer id = getCommand().getId();
		String ids = getCommand().getIds();
		if (null != id) {
			HouseReadilyResult readilyResult = new HouseReadilyResult();
			HouseReadily houseReadily = houseReadilyService.findById(id);

			initData(houseReadily, readilyResult);

			return JsonHelper.getJson(readilyResult);
		} else if (StringUtils.isNotEmpty(ids)) {
			HouseReadilyListResult readilyListResult = new HouseReadilyListResult();
			List houseReadilyList = houseReadilyService.findByIds(ids);

			initData(houseReadilyList, null, readilyListResult);

			return JsonHelper.getJson(readilyListResult);
		} else {
			return null;
		}
	}

	private Representation update() {
		HouseReadilyResult readilyResult = new HouseReadilyResult();
		HouseReadily houseReadily = null;
		try {
			houseReadily = houseReadilyService.update(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SUBMIT_FAILURE));
		}

		readilyResult.setStatus(1);
		readilyResult.setMsg(Configuration.SUBMIT_SUCCESS);

		initData(houseReadily, readilyResult);

		return JsonHelper.getJson(readilyResult);
	}
	
	private Representation updatestate() {
		HouseReadily houseReadily = null;
		try {
			houseReadily = houseReadilyService.updateStatus(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATE_FAILURE));
		}

		if (null != houseReadily) {
			return JsonHelper.getJson(getStatusResult(1, Configuration.UPDATE_SUCCESS));
		} else {
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATE_FAILURE));
		}
	}

	@Delete
	@Override
	public Representation delete() throws ResourceException {
		houseReadilyService.delete(command);

		return JsonHelper.getJson(getStatusResult(1, Configuration.DELETE_SUCCESS));
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;
		Integer userId = getCommand().getUserId();

		if (LIST.equals(command.getAction())) {
			representation = list(null);
		} else if (MYREADILY.equals(command.getAction())) {
			representation = list(userId);
		} else if (FIND.equals(command.getAction())) {
			representation = find();
		} else if (DELETE.equals(command.getAction())) {
			houseReadilyService.delete(command);
			representation = JsonHelper.getJson(getStatusResult(1, Configuration.DELETE_SUCCESS));
		} else if (IDSVERSION.equals(command.getAction())) {
			representation = idsversion(userId);
		}

		return representation;
	}

	@Post
	@Override
	public Representation post(Representation entity) throws ResourceException {
		Representation representation = null;
		Form form = new Form(entity);
		initData(form);

		if (ADD.equals(command.getAction())) {
			representation = add();
		} else if (UPDATE.equals(command.getAction())) {
			representation = update();
		} else if (UPDATESTATE.equals(command.getAction())) {
			representation = updatestate();
		}

		return representation;
	}

	private IHouseReadilyService houseReadilyService;

	public IHouseReadilyService getHouseReadilyService() {
		return houseReadilyService;
	}

	public void setHouseReadilyService(IHouseReadilyService houseReadilyService) {
		this.houseReadilyService = houseReadilyService;
	}
}
