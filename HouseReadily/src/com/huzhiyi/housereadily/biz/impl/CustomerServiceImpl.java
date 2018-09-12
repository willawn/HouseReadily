package com.huzhiyi.housereadily.biz.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.huzhiyi.housereadily.biz.ICustomerService;
import com.huzhiyi.housereadily.biz.IHouseFollowService;
import com.huzhiyi.housereadily.biz.IHouseOwnerService;
import com.huzhiyi.housereadily.biz.IHouseReadilyService;
import com.huzhiyi.housereadily.biz.IOperateLogService;
import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.IUserExtService;
import com.huzhiyi.housereadily.biz.IUserService;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.housereadily.entity.HouseOwner;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.request.CustomerCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ContextHelper;

public class CustomerServiceImpl extends AbstractCustomerServiceImpl implements ICustomerService {

	@Override
	public Customer add(ICommand command) throws Exception {
		CustomerCommand customerCommand = (CustomerCommand) command;
		Integer userId = customerCommand.getUserId();
		Integer ctype = customerCommand.getCtype();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Timestamp createTime = null != customerCommand.getCreateTime() ? new Timestamp(customerCommand.getCreateTime().getTime())
				: currentTime;

		Customer customer = new Customer();
		customer.setCtype(ctype);
		customer.setName(customerCommand.getName());
		customer.setGender(customerCommand.getGender());
		customer.setPhone(customerCommand.getPhone());
		customer.setMobile(customerCommand.getMobile());
		customer.setDescription(customerCommand.getDescription());
		customer.setLastFollowDate(createTime);
		customer.setUpdateTime(createTime);
		customer.setSyncTime(currentTime);
		customer.setVersion(StringUtils.isNotEmpty(customerCommand.getVersion()) ? customerCommand.getVersion()
				: Configuration.DEFAULT_VERSION);
		customer.setIsEnable(1);
		customer.setIsDelete(1);
		customer.setState(8);
		customer.setCreater(userId);
		customer.setCreateTime(createTime);

		if (ctype == 2 || ctype == 3) { // 求租，求购
			customer.setBuildType(customerCommand.getBuildType());
			Integer bigAreaCode = customerCommand.getBigAreaCode();
			if (null != bigAreaCode && bigAreaCode > 0) {
				customer.setCityCode(ContextHelper.allareasToCityCodesMap.get(bigAreaCode));
			} else {
				customer.setCityCode(null);
			}
			customer.setBigAreaCode(bigAreaCode);
			customer.setSmallAreaCode(customerCommand.getSmallAreaCode());
			customer.setRoomNum(customerCommand.getRoomNum());
			customer.setHallNum(customerCommand.getHallNum());
			customer.setToiletNum(customerCommand.getToiletNum());
			customer.setBeginFirstPayment(customerCommand.getBeginFirstPayment());
			customer.setEndFirstPayment(customerCommand.getEndFirstPayment());
			customer.setBeginArea(customerCommand.getBeginArea());
			customer.setEndArea(customerCommand.getEndArea());
			customer.setBeginUnitPrice(customerCommand.getBeginUnitPrice());
			customer.setEndUnitPrice(customerCommand.getEndUnitPrice());
			customer.setBeginTotalPrice(customerCommand.getBeginTotalPrice());
			customer.setEndTotalPrice(customerCommand.getEndTotalPrice());
			customer.setYear(customerCommand.getYear());
			customer.setMonth(customerCommand.getMonth());
		}

		super.add(customer);
		
		if (ctype == 1) { // 业主
			String houseReadilyIds = customerCommand.getHouseReadilyIds();
			if (!StringUtils.isEmpty(houseReadilyIds)) {
				String[] houseReadilyIdArray = houseReadilyIds.split(",");
				for (int i = 0, len = houseReadilyIdArray.length; i < len; i++) {
					Integer houseReadilyId = Integer.parseInt(houseReadilyIdArray[i]);
					HouseOwner houseOwner = new HouseOwner();
					houseOwner.setIsMain(houseOwnerService.exists(houseReadilyId, null) ? 0 : 1);
					houseOwner.setHouseReadilyId(houseReadilyId);
					houseOwner.setCustomerId(customer.getId());
					houseOwner.setCreater(userId);
					houseOwner.setCreateTime(new Timestamp(System.currentTimeMillis()));
					houseOwnerService.add(houseOwner);
				}
			}
		}

		// 新增跟进记录
		addHouseFollows(customerCommand.getHouseFollows(), customer);

		// 新增操作日志
		operateLogService.add(userId, customerCommand.getIp(), customerCommand.getOperate(), 4, MessageFormat.format(
				Configuration.CUSTOMER_ADD_LOG, customer.getId().toString()), currentTime);
		
		// 更新用户客源数量
		userExtService.updateCustomerCount(customer.getCreater());
		
		// 新增积分日志
		customer.setGrowing(taskLogService.add(userId, Integer.parseInt(Configuration.TASK_CUSTOMER_ID), null));

		// 关联数据查询
		initCustomerForeignValue(customer);

		return customer;
	}

	@Override
	public Customer update(ICommand command) throws Exception {
		CustomerCommand customerCommand = (CustomerCommand) command;
		Integer id = customerCommand.getId();
		Integer userId = customerCommand.getUserId();
		String properties = customerCommand.getProperties();
		Integer ctype = customerCommand.getCtype();
		Customer customer = findById(id);
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Timestamp updateTime = null != customerCommand.getUpdateTime() ? new Timestamp(customerCommand.getUpdateTime().getTime())
				: currentTime;

		customer.setCtype(ctype);
		customer.setName(customerCommand.getName());
		customer.setGender(customerCommand.getGender());
		customer.setPhone(customerCommand.getPhone());
		customer.setMobile(customerCommand.getMobile());
		customer.setDescription(customerCommand.getDescription());
		// if (null != customerCommand.getLastFollowDate()) {
		// customer.setLastFollowDate(new
		// Timestamp(customerCommand.getLastFollowDate().getTime()));
		// }
		customer.setUpdateTime(updateTime);
		customer.setSyncTime(currentTime);
		customer.setVersion(StringUtils.isNotEmpty(customerCommand.getVersion()) ? customerCommand.getVersion() : new BigDecimal(customer
				.getVersion()).add(new BigDecimal("0.1")).toString());

		if (ctype == 2 || ctype == 3) { // 求租，求购
			customer.setBuildType(customerCommand.getBuildType());
			Integer bigAreaCode = customerCommand.getBigAreaCode();
			if (null != bigAreaCode && bigAreaCode > 0) {
				customer.setCityCode(ContextHelper.allareasToCityCodesMap.get(bigAreaCode));
			} else {
				customer.setCityCode(null);
			}
			customer.setBigAreaCode(bigAreaCode);
			customer.setSmallAreaCode(customerCommand.getSmallAreaCode());
			customer.setRoomNum(customerCommand.getRoomNum());
			customer.setHallNum(customerCommand.getHallNum());
			customer.setToiletNum(customerCommand.getToiletNum());
			customer.setBeginFirstPayment(customerCommand.getBeginFirstPayment());
			customer.setEndFirstPayment(customerCommand.getEndFirstPayment());
			customer.setBeginArea(customerCommand.getBeginArea());
			customer.setEndArea(customerCommand.getEndArea());
			customer.setBeginUnitPrice(customerCommand.getBeginUnitPrice());
			customer.setEndUnitPrice(customerCommand.getEndUnitPrice());
			customer.setBeginTotalPrice(customerCommand.getBeginTotalPrice());
			customer.setEndTotalPrice(customerCommand.getEndTotalPrice());
			customer.setYear(customerCommand.getYear());
			customer.setMonth(customerCommand.getMonth());
		}

		super.update(customer);

		if (ctype == 1) { // 业主
			String houseReadilyIds = customerCommand.getHouseReadilyIds();
			List<HouseOwner> houseOwners = houseOwnerService.findHouseOwnerByCustomerId(id);
			if (!StringUtils.isEmpty(houseReadilyIds)) {
				String[] houseReadilyIdArray = houseReadilyIds.split(",");

				// 新增关联房源
				for (int i = 0, len = houseReadilyIdArray.length; i < len; i++) {
					Integer houseReadilyId = Integer.parseInt(houseReadilyIdArray[i]);
					if (!isExists(houseOwners, houseReadilyId)) {
						HouseOwner houseOwner = new HouseOwner();
						houseOwner.setIsMain(houseOwnerService.exists(houseReadilyId, null) ? 0 : 1);
						houseOwner.setHouseReadilyId(houseReadilyId);
						houseOwner.setCustomerId(customer.getId());
						houseOwner.setCreater(userId);
						houseOwner.setCreateTime(new Timestamp(System.currentTimeMillis()));
						houseOwnerService.add(houseOwner);
					}
				}

				// 删除关联房源
				for (HouseOwner houseOwner : houseOwners) {
					if (!isExists(houseReadilyIds, houseOwner.getHouseReadilyId())) {
						houseOwnerService.delete(houseOwner);
					}
				}
			} else {
				// 删除关联房源
				for (HouseOwner houseOwner : houseOwners) {
					houseOwnerService.delete(houseOwner);
				}
			}
		}

		if (properties.indexOf("houseFollows") > -1) {
			// 删除跟进记录
			String delHouseFollows = customerCommand.getDelHouseFollows();
			if (StringUtils.isNotEmpty(delHouseFollows)) {
				houseFollowService.delete(delHouseFollows);
			}

			// 新增跟进记录
			addHouseFollows(customerCommand.getHouseFollows(), customer);
		}

		// 新增操作日志
		operateLogService.add(userId, customerCommand.getIp(), customerCommand.getOperate(), 5, MessageFormat.format(
				Configuration.CUSTOMER_UPDATE_LOG, customer.getId().toString()), currentTime);

		// 关联数据查询
		initCustomerForeignValue(customer);

		return customer;
	}

	private void addHouseFollows(String houseFollows, Customer customer) throws JSONException, ParseException {
		if (StringUtils.isNotEmpty(houseFollows)) {
			// 复制旧跟进记录
			List<HouseFollow> oldHouseFollows = new ArrayList<HouseFollow>(customer.getHouseFollows());
			Timestamp bigCreateTime = null;
			
			// 解析跟进记录请求
			JSONArray houseFollowArray = new JSONArray(houseFollows);
			JSONObject houseFollowObject = null;
			HouseFollow houseFollow = null;
			for (int i = 0, len = houseFollowArray.length(); i < len; i++) {
				houseFollowObject = (JSONObject) houseFollowArray.get(i);
				String description = houseFollowObject.getString("description");
				Timestamp createTime = new Timestamp(DateUtils.parse(houseFollowObject.getString("createTime"), Constants.DATEFORMAT)
						.getTime());

				// 新增跟进记录
				houseFollow = new HouseFollow();
				houseFollow.setCustomerId(customer.getId());
				houseFollow.setDescription(description);
				houseFollow.setCreater(customer.getCreater());
				houseFollow.setCreateTime(createTime);
				houseFollowService.add(houseFollow);

				// 获取请求最后跟进时间
				if (null == bigCreateTime || createTime.compareTo(bigCreateTime) > 0) {
					bigCreateTime = createTime;
				}
			}
			
			// 获取最后跟进时间
			for (int j = 0, size = oldHouseFollows.size(); j < size; j++) {
				if (oldHouseFollows.get(j).getCreateTime().compareTo(bigCreateTime) > 0) {
					bigCreateTime = oldHouseFollows.get(j).getCreateTime();
				}
			}
			
			// 更新客源最后跟进时间
			if (bigCreateTime.compareTo(customer.getLastFollowDate()) > 0) {
				customer.setLastFollowDate(bigCreateTime);
			}
		}
	}

	private boolean isExists(String houseReadilyIds, Integer houseReadilyId) {
		String[] idArray = houseReadilyIds.split(",");
		for (int i = 0, len = idArray.length; i < len; i++) {
			if (idArray[i].equals(houseReadilyId.toString())) {
				return true;
			}
		}
		return false;
	}

	private boolean isExists(List<HouseOwner> houseOwners, Integer houseReadilyId) {
		for (HouseOwner houseOwner : houseOwners) {
			if (houseOwner.getHouseReadilyId().equals(houseReadilyId)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public List<Customer> findByIds(String ids) {
		List<Customer> customers = getCustomerDAO().findByProperty("id", StringUtils.toInteger(ids.split(","))).getList();
		for (Customer customer : customers) {
			initCustomerForeignValue(customer);
		}
		return customers;
	}

	@Override
	public Customer findById(Integer id) {
		Customer customer = super.findById(id);
		initCustomerForeignValue(customer);

		return customer;
	}

	@Override
	public List<Customer> findPaging(ICommand command, PagingBean pagingBean) {
		List<Customer> customers = getCustomerDAO().findPaging(command, pagingBean);
		for (Customer customer : customers) {
			initCustomerForeignValue(customer);
		}
		return customers;
	}

	@Override
	public List<Customer> findPaging(Integer id, Integer ctype, Integer buildType, String name, Integer gender, String mobile,
			Integer beginRoomNum, Integer endRoomNum, BigDecimal beginArea, BigDecimal endArea, String userName, Date beginDate,
			Date endDate, Integer isDelete, String sort, String dir, PagingBean pagingBean) {
		List<Customer> customers = getCustomerDAO().findPaging(id, ctype, buildType, name, gender, mobile, beginRoomNum, endRoomNum,
				beginArea, endArea, userName, beginDate, endDate, isDelete, sort, dir, pagingBean);
		for (Customer customer : customers) {
			initCustomerForeignValue(customer);
		}
		return customers;
	}

	@Override
	public List<Customer> findIdAndVersion(Integer userId) {
		return getCustomerDAO().findIdAndVersion(userId);
	}

	private void initCustomerForeignValue(Customer customer) {
		if (null != customer) {
			Integer customerId = customer.getId();

			List<HouseOwner> houseOwners = houseOwnerService.findHouseOwnerByCustomerId(customerId);
			List<HouseReadily> houseReadilys = new ArrayList<HouseReadily>();
			HouseReadily houseReadily = null;
			for (HouseOwner houseOwner : houseOwners) {
				houseReadily = houseReadilyService.findById(houseOwner.getHouseReadilyId());
				houseReadilys.add(houseReadily);

				// houseOwner.setCustomerName(customer.getName());
				// houseOwner.setGender(customer.getGender());
				// houseOwner.setPhone(customer.getPhone());
				// houseOwner.setMobile(customer.getMobile());
				houseOwner.setHouseReadilyName(houseReadily.getProjectName());
			}
			customer.setHouseReadilys(houseReadilys);
			customer.setHouseOwners(houseOwners);

			customer.setHouseFollows(houseFollowService.findByProperty("customerId", customerId, "createTime", "desc").getList());

			customer.setUserName(userService.findById(customer.getCreater()).getName());
		}
	}

	@Override
	public Customer updateStatus(ICommand command) {
		CustomerCommand customerCommand = (CustomerCommand) command;
		Integer userId = customerCommand.getUserId();
		Integer id = customerCommand.getId();
		Integer state = customerCommand.getState();
		Customer customer = findById(id);
		
		// 判断是否创建人修改状态
		if (!customer.getCreater().equals(userId)) {
			return null;
		}
		
		// 执行修改操作
		customer.setState(state);
//		Integer result = getCustomerDAO().updateStatus(id, state);
//		if (result <= 0) {
//			return null;
//		}
		
		// 修改版本号
		customer.setVersion(StringUtils.isEmpty(customer.getVersion()) ? Configuration.DEFAULT_VERSION : new BigDecimal(
				customer.getVersion()).add(new BigDecimal("0.1")).toString());
		
		return customer;
	}
	
	@Override
	public void delete(Customer customer) {
		customer.setIsDelete(0);
		userExtService.updateCustomerCount(customer.getCreater());
		Integer customerId = customer.getId();

		// 删除关联房源
		if (customer.getCtype() == 1) { // 业主
			List<HouseOwner> houseOwners = houseOwnerService.findByProperty("customerId", customerId).getList();
			for (HouseOwner houseOwner : houseOwners) {
				houseOwnerService.delete(houseOwner);
			}
		}

		// 删除跟进记录
		List<HouseFollow> houseFollows = houseFollowService.findByProperty("customerId", customerId).getList();
		for (HouseFollow houseFollow : houseFollows) {
			houseFollowService.delete(houseFollow);
		}

//		// 求租，求购，业主
//		super.delete(customer);
	}

	@Override
	public void delete(ICommand command) {
		CustomerCommand customerCommand = (CustomerCommand) command;
		String ids = customerCommand.getIds();
		Integer userId = customerCommand.getUserId();
		String ip = customerCommand.getIp();
		String operate = customerCommand.getOperate();

		String[] idArray = ids.split(",");
		Customer customer = null;
		for (int i = 0; i < idArray.length; i++) {
			if (!StringUtils.isEmpty(idArray[i])) {
				customer = findById(Integer.parseInt(idArray[i]));
				if (null != customer) {
					delete(customer);

					// 新增操作日志
					operateLogService.add(userId, ip, operate, 6,
							MessageFormat.format(Configuration.CUSTOMER_DELETE_LOG, customer.getId().toString()), null);
				}
			}
		}
	}

	@Override
	public Customer existsCustomer(Integer userId, Integer ctype, String name, String mobile) {
		return getCustomerDAO().existsCustomer(userId, ctype, name, mobile);
	}

	private IHouseOwnerService houseOwnerService;
	private IHouseReadilyService houseReadilyService;
	private IHouseFollowService houseFollowService;
	private IOperateLogService operateLogService;
	private IUserService userService;
	private IUserExtService userExtService;
	private ITaskLogService taskLogService;

	public IHouseOwnerService getHouseOwnerService() {
		return houseOwnerService;
	}

	public void setHouseOwnerService(IHouseOwnerService houseOwnerService) {
		this.houseOwnerService = houseOwnerService;
	}

	public IHouseReadilyService getHouseReadilyService() {
		return houseReadilyService;
	}

	public void setHouseReadilyService(IHouseReadilyService houseReadilyService) {
		this.houseReadilyService = houseReadilyService;
	}

	public IHouseFollowService getHouseFollowService() {
		return houseFollowService;
	}

	public void setHouseFollowService(IHouseFollowService houseFollowService) {
		this.houseFollowService = houseFollowService;
	}

	public IOperateLogService getOperateLogService() {
		return operateLogService;
	}

	public void setOperateLogService(IOperateLogService operateLogService) {
		this.operateLogService = operateLogService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IUserExtService getUserExtService() {
		return userExtService;
	}

	public void setUserExtService(IUserExtService userExtService) {
		this.userExtService = userExtService;
	}

	public ITaskLogService getTaskLogService() {
		return taskLogService;
	}

	public void setTaskLogService(ITaskLogService taskLogService) {
		this.taskLogService = taskLogService;
	}
}