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

import com.huzhiyi.housereadily.biz.ICustomerService;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.request.CustomerCommand;
import com.huzhiyi.housereadily.response.CustomerListResult;
import com.huzhiyi.housereadily.response.CustomerResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class CustomerResource extends BaseResource {

	private static final String ADD = "add";
	private static final String LIST = "list";
	private static final String FIND = "find";
	private static final String IDSVERSION = "idsversion";
	private static final String UPDATE = "update";
	private static final String UPDATESTATE = "updatestate";
	private static final String DELETE = "delete";

	@Override
	protected void doInit() throws ResourceException {
		command = new CustomerCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
		getCommand().setCtype(RequestUtils.requestPropertyIntValue(form, "ctype"));
		getCommand().setBuildType(RequestUtils.requestPropertyIntValue(form, "buildType"));
		getCommand().setName(RequestUtils.requestPropertyValue(form, "name", ""));
		getCommand().setGender(RequestUtils.requestPropertyIntValue(form, "gender"));
		getCommand().setPhone(RequestUtils.requestPropertyValue(form, "phone", ""));
		getCommand().setMobile(RequestUtils.requestPropertyValue(form, "mobile", ""));
		getCommand().setBigAreaCode(RequestUtils.requestPropertyIntValue(form, "bigAreaCode"));
		getCommand().setSmallAreaCode(RequestUtils.requestPropertyIntValue(form, "smallAreaCode"));
		getCommand().setRoomNum(RequestUtils.requestPropertyIntValue(form, "roomNum"));
		getCommand().setHallNum(RequestUtils.requestPropertyIntValue(form, "hallNum"));
		getCommand().setToiletNum(RequestUtils.requestPropertyIntValue(form, "toiletNum"));
		// getCommand().setArea(RequestUtils.requestPropertyBigDecimalValue(form, "area", BigDecimal.ZERO));
		// getCommand().setUnitPrice(RequestUtils.requestPropertyBigDecimalValue(form, "unitPrice", BigDecimal.ZERO));
		getCommand().setYear(RequestUtils.requestPropertyIntValue(form, "year"));
		getCommand().setMonth(RequestUtils.requestPropertyIntValue(form, "month"));
		getCommand().setDescription(RequestUtils.requestPropertyValue(form, "description", ""));
		getCommand().setCreateTime(RequestUtils.requestPropertyDateValue(form, "createTime"));
		getCommand().setUpdateTime(RequestUtils.requestPropertyDateValue(form, "updateTime"));
		// getCommand().setLastFollowDate(RequestUtils.requestPropertyDateValue(form, "lastFollowDate"));
		getCommand().setSyncTime(RequestUtils.requestPropertyDateValue(form, "syncTime"));
		getCommand().setVersion(RequestUtils.requestPropertyValue(form, "version", ""));
		getCommand().setState(RequestUtils.requestPropertyIntValue(form, "state"));
		getCommand().setHouseReadilyIds(RequestUtils.requestPropertyValue(form, "houseReadilyIds", ""));
		getCommand().setHouseFollows(RequestUtils.requestPropertyValue(form, "houseFollows", ""));
		getCommand().setDelHouseFollows(RequestUtils.requestPropertyValue(form, "delHouseFollows", ""));
		getCommand().setProperties(RequestUtils.requestPropertyValue(form, "properties", ""));
		getCommand().setIds(RequestUtils.requestPropertyValue(form, "ids", ""));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
		getCommand().setBeginFirstPayment(RequestUtils.requestPropertyBigDecimalValue(form, "beginFirstPayment", BigDecimal.ZERO));
		getCommand().setEndFirstPayment(RequestUtils.requestPropertyBigDecimalValue(form, "endFirstPayment", BigDecimal.ZERO));
		getCommand().setBeginArea(RequestUtils.requestPropertyBigDecimalValue(form, "beginArea", BigDecimal.ZERO));
		getCommand().setEndArea(RequestUtils.requestPropertyBigDecimalValue(form, "endArea", BigDecimal.ZERO));
		getCommand().setBeginUnitPrice(RequestUtils.requestPropertyBigDecimalValue(form, "beginUnitPrice", BigDecimal.ZERO));
		getCommand().setEndUnitPrice(RequestUtils.requestPropertyBigDecimalValue(form, "endUnitPrice", BigDecimal.ZERO));
		getCommand().setBeginTotalPrice(RequestUtils.requestPropertyBigDecimalValue(form, "beginTotalPrice", BigDecimal.ZERO));
		getCommand().setEndTotalPrice(RequestUtils.requestPropertyBigDecimalValue(form, "endTotalPrice", BigDecimal.ZERO));
		getCommand().setBeginRoomNum(RequestUtils.requestPropertyIntValue(form, "beginRoomNum"));
		getCommand().setEndRoomNum(RequestUtils.requestPropertyIntValue(form, "endRoomNum"));
	}

	public CustomerCommand getCommand() {
		return (CustomerCommand) command;
	}

	private Representation add() {
		CustomerResult customerResult = new CustomerResult();
		CustomerCommand customerCommand = (CustomerCommand) command;

		Customer customer = customerService.existsCustomer(customerCommand.getUserId(), customerCommand.getCtype(), customerCommand
				.getName(), customerCommand.getMobile());

		// 如果客户类型，姓名，电话号码都一样，则提示“已经存在”，并将客户信息返回，否则新增客户并返回
		if (null != customer) {
			customerResult.setStatus(2);
			customerResult.setMsg(Configuration.CUSTOMER_EXIST_ADD);
		} else {
			try {
				customer = customerService.add(command);

				customerResult.setStatus(1);
				customerResult.setMsg(Configuration.SUBMIT_SUCCESS);
			} catch (Exception e) {
				customerResult.setStatus(0);
				customerResult.setMsg(Configuration.SUBMIT_FAILURE);
			}
		}

		initData(customer, customerResult);

		return JsonHelper.getJson(customerResult);
	}

	private void initData(Customer customer, CustomerResult customerResult) {
		customerResult.setCommand(command);
		customerResult.setId(customer.getId());
		customerResult.setCtype(customer.getCtype());
		customerResult.setBuildType(customer.getBuildType());
		customerResult.setBuildTypeName(customer.getBuildTypeName());
		customerResult.setName(customer.getName());
		customerResult.setGender(customer.getGender());
		customerResult.setPhone(customer.getPhone());
		customerResult.setMobile(customer.getMobile());
		customerResult.setCityCode(customer.getCityCode());
		customerResult.setCityEn(customer.getCityEn());
		customerResult.setCityName(customer.getCityName());
		customerResult.setBigAreaCode(customer.getBigAreaCode());
		customerResult.setBigAreaName(customer.getBigAreaName());
		customerResult.setSmallAreaCode(customer.getSmallAreaCode());
		customerResult.setSmallAreaName(customer.getSmallAreaName());
		customerResult.setRoomNum(customer.getRoomNum());
		customerResult.setHallNum(customer.getHallNum());
		customerResult.setToiletNum(customer.getToiletNum());
		// customerResult.setFirstPayment(customer.getFirstPayment());
		// customerResult.setArea(customer.getArea());
		// customerResult.setUnitPrice(customer.getUnitPrice());
		// customerResult.setTotalPrice(customer.getTotalPrice());
		customerResult.setBeginFirstPayment(customer.getBeginFirstPayment());
		customerResult.setEndFirstPayment(customer.getEndFirstPayment());
		customerResult.setBeginArea(customer.getBeginArea());
		customerResult.setEndArea(customer.getEndArea());
		customerResult.setBeginUnitPrice(customer.getBeginUnitPrice());
		customerResult.setEndUnitPrice(customer.getEndUnitPrice());
		customerResult.setBeginTotalPrice(customer.getBeginTotalPrice());
		customerResult.setEndTotalPrice(customer.getEndTotalPrice());
		customerResult.setYear(customer.getYear());
		customerResult.setMonth(customer.getMonth());
		customerResult.setDescription(customer.getDescription());
		customerResult.setLastFollowDate(customer.getLastFollowDate());
		customerResult.setSyncTime(customer.getSyncTime());
		customerResult.setVersion(customer.getVersion());
		customerResult.setUpdateTime(customer.getUpdateTime());
		customerResult.setState(customer.getState());
		customerResult.setCreater(customer.getCreater());
		customerResult.setCreateTime(customer.getCreateTime());
		customerResult.setGrowing(customer.getGrowing());

		Map parseDataKey = new HashMap();
		String[] field = { "id", "stype", "projectId", "projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName",
				"smallAreaCode", "smallAreaName", "lon", "lat", "buildType", "buildTypeName", "title", "building", "houseNum", "roomNum",
				"hallNum", "toiletNum", "area", "unitPrice", "totalPrice", "hasRedBook", "description", "address", "updateTime", "creater",
				"createTime" };
		JSONObject houseReadilys = ResponseUtils.getJSONByModel("list", customer.getHouseReadilys(), parseDataKey, field);
		customerResult.setHouseReadilys(houseReadilys);

		parseDataKey = new HashMap();
		field = new String[] { "id", "isMain", "houseReadilyId", "houseReadilyName", "customerId", "customerName", "gender", "phone",
				"mobile" };
		JSONObject houseOwners = ResponseUtils.getJSONByModel("list", customer.getHouseOwners(), parseDataKey, field);
		customerResult.setHouseOwners(houseOwners);

		parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		field = new String[] { "id", "houseReadilyId", "projectId", "projectName", "title", "building", "houseNum", "customerId", "ctype",
				"customerName", "gender", "phone", "mobile", "mode", "description", "creater", "createTime" };
		JSONObject houseFollows = ResponseUtils.getJSONByModel("list", customer.getHouseFollows(), parseDataKey, field);
		customerResult.setHouseFollows(houseFollows);
	}

	private void initData(List customerList, PagingBean pagingBean, CustomerListResult customerListResult) {
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
		JSONObject customers = ResponseUtils.getJSONByPagingBean(pagingBean, customerList, parseDataKey, "id", "buildType",
				"buildTypeName", "ctype", "name", "gender", "phone", "mobile", "cityCode", "cityEn", "cityName", "bigAreaCode",
				"bigAreaName", "smallAreaCode", "smallAreaName", "roomNum", "hallNum", "toiletNum", "beginFirstPayment", "endFirstPayment",
				"beginArea", "endArea", "beginUnitPrice", "endUnitPrice", "beginTotalPrice", "endTotalPrice", "year", "month",
				"description", "lastFollowDate", "syncTime", "version", "updateTime", "state", "creater", "userName", "createTime",
				"houseReadilys", "houseOwners", "houseFollows");

		customerListResult.setCommand(command);
		customerListResult.setCustomers(customers);
	}

	private Representation list() {
		CustomerListResult customerListResult = new CustomerListResult();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();

		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		List customerList = customerService.findPaging(command, pagingBean);

		initData(customerList, pagingBean, customerListResult);

		return JsonHelper.getJson(customerListResult);
	}

	/**
	 * @Title: idsversion
	 * @Description: 获取当前用户的客源ID，版本号列表
	 *               <p>
	 * @author willter
	 * @date 2013-3-20
	 *       <p>
	 * @param userId
	 * @return
	 */
	private Representation idsversion(Integer userId) {
		CustomerListResult customerListResult = new CustomerListResult();

		List customerList = customerService.findIdAndVersion(userId);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "syncTime" });
		JSONObject customers = ResponseUtils.getJSONByPagingBean(null, customerList, parseDataKey, "id", "version", "syncTime");

		customerListResult.setCommand(command);
		customerListResult.setCustomers(customers);

		return JsonHelper.getJson(customerListResult);
	}

	private Representation find() {
		Integer id = getCommand().getId();
		String ids = getCommand().getIds();
		if (null != id) {
			CustomerResult customerResult = new CustomerResult();
			Customer customer = customerService.findById(id);

			initData(customer, customerResult);

			return JsonHelper.getJson(customerResult);
		} else if (StringUtils.isNotEmpty(ids)) {
			CustomerListResult customerListResult = new CustomerListResult();
			List customerList = customerService.findByIds(ids);

			initData(customerList, null, customerListResult);

			return JsonHelper.getJson(customerListResult);
		} else {
			return null;
		}
	}

	private Representation update() {
		CustomerResult customerResult = new CustomerResult();
		Customer customer = null;
		try {
			customer = customerService.update(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SUBMIT_FAILURE));
		}

		customerResult.setStatus(1);
		customerResult.setMsg(Configuration.SUBMIT_SUCCESS);

		initData(customer, customerResult);

		return JsonHelper.getJson(customerResult);
	}
	
	private Representation updatestate() {
		Customer customer = null;
		try {
			customer = customerService.updateStatus(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATE_FAILURE));
		}

		if (null != customer) {
			return JsonHelper.getJson(getStatusResult(1, Configuration.UPDATE_SUCCESS));
		} else {
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATE_FAILURE));
		}
	}

	@Delete
	@Override
	public Representation delete() throws ResourceException {
		customerService.delete(command);

		return JsonHelper.getJson(getStatusResult(1, Configuration.DELETE_SUCCESS));
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;
		Integer userId = getCommand().getUserId();

		if (FIND.equals(command.getAction())) {
			representation = find();
		} else if (LIST.equals(command.getAction())) {
			representation = list();
		} else if (DELETE.equals(command.getAction())) {
			customerService.delete(command);
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

	private ICustomerService customerService;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
}
