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

import com.huzhiyi.housereadily.biz.IHouseAttachmentService;
import com.huzhiyi.housereadily.biz.IHouseFollowService;
import com.huzhiyi.housereadily.biz.IHouseOwnerService;
import com.huzhiyi.housereadily.biz.IHouseReadilyService;
import com.huzhiyi.housereadily.biz.IOperateLogService;
import com.huzhiyi.housereadily.biz.IProjectService;
import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.IUserExtService;
import com.huzhiyi.housereadily.dao.ICustomerDAO;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.housereadily.entity.HouseOwner;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.model.CProject;
import com.huzhiyi.housereadily.request.HouseReadilyCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.ContextHelper;

public class HouseReadilyServiceImpl extends AbstractHouseReadilyServiceImpl implements IHouseReadilyService {

	@Override
	public HouseReadily add(ICommand command) throws Exception {
		HouseReadilyCommand readilyCommand = (HouseReadilyCommand) command;
		String btAttachments = readilyCommand.getBtAttachments();
		String snAttachments = readilyCommand.getSnAttachments();
		String fxAttachments = readilyCommand.getFxAttachments();
		String xqAttachments = readilyCommand.getXqAttachments();
		Integer userId = readilyCommand.getUserId();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Timestamp createTime = null != readilyCommand.getCreateTime() ? new Timestamp(readilyCommand.getCreateTime().getTime())
				: currentTime;

		HouseReadily houseReadily = new HouseReadily();
		houseReadily.setStype(readilyCommand.getStype());
		houseReadily.setProjectId(readilyCommand.getProjectId());
		houseReadily.setProjectName(readilyCommand.getProjectName());
		
		// 关联已有的楼盘记录
		if (null != readilyCommand.getProjectId() && readilyCommand.getProjectId() > 0) {
			CProject project = projectService.findById(readilyCommand.getProjectId());
			houseReadily.setCityCode(ContextHelper.enCityCodes.get(project.getCity()));
			houseReadily.setBigAreaCode(project.getAreaId());
			houseReadily.setSmallAreaCode(project.getSubAreaId());
			houseReadily.setLon(new BigDecimal(null != project.getLng() ? project.getLng() : 0.0f));
			houseReadily.setLat(new BigDecimal(null != project.getLat() ? project.getLat() : 0.0f));
			houseReadily.setAddress(project.getAddress());
		} else {
			Integer bigAreaCode = readilyCommand.getBigAreaCode();
			if (null != bigAreaCode && bigAreaCode > 0) {
				houseReadily.setCityCode(ContextHelper.allareasToCityCodesMap.get(bigAreaCode));
			} else {
				houseReadily.setCityCode(null);
			}
			houseReadily.setBigAreaCode(bigAreaCode);
			houseReadily.setSmallAreaCode(readilyCommand.getSmallAreaCode());
		}

		houseReadily.setBuildType(readilyCommand.getBuildType());
		houseReadily.setTitle(readilyCommand.getTitle());
		houseReadily.setBuilding(readilyCommand.getBuilding());
		houseReadily.setHouseNum(readilyCommand.getHouseNum());
		houseReadily.setRoomNum(readilyCommand.getRoomNum());
		houseReadily.setHallNum(readilyCommand.getHallNum());
		houseReadily.setToiletNum(readilyCommand.getToiletNum());
		houseReadily.setArea(readilyCommand.getArea());
		if (null != readilyCommand.getUnitPrice() && readilyCommand.getUnitPrice().compareTo(BigDecimal.ZERO) > 0) {
			houseReadily.setUnitPrice(readilyCommand.getUnitPrice());
			houseReadily.setTotalPrice(readilyCommand.getArea().multiply(readilyCommand.getUnitPrice()));
		} else if (null != readilyCommand.getTotalPrice() && readilyCommand.getTotalPrice().compareTo(BigDecimal.ZERO) > 0) {
			houseReadily.setTotalPrice(readilyCommand.getTotalPrice());
			if(readilyCommand.getArea().compareTo(BigDecimal.ZERO) == 0){
				houseReadily.setUnitPrice(readilyCommand.getTotalPrice());
			}else{
				houseReadily.setUnitPrice(readilyCommand.getTotalPrice().divide(readilyCommand.getArea(), 2, BigDecimal.ROUND_HALF_EVEN));
			}
		}

		// 修改时间：2013-06-27，修改人：willter，修改描述：加入房源详细信息字段
		houseReadily.setTowards(readilyCommand.getTowards());
		houseReadily.setFitment(readilyCommand.getFitment());
		houseReadily.setHouseRight(readilyCommand.getHouseRight());
		houseReadily.setFurn(readilyCommand.getFurn());
		houseReadily.setKeyer(readilyCommand.getKeyer());
		/*****************************************************************/
		
		houseReadily.setHasRedBook(readilyCommand.getHasRedBook());
		houseReadily.setDescription(readilyCommand.getDescription());
		houseReadily.setLastFollowDate(createTime);
		houseReadily.setUpdateTime(createTime);
		houseReadily.setSyncTime(currentTime);
		houseReadily.setVersion(StringUtils.isNotEmpty(readilyCommand.getVersion()) ? readilyCommand.getVersion()
				: Configuration.DEFAULT_VERSION);
		houseReadily.setIsEnable(1);
		houseReadily.setIsDelete(1);
		houseReadily.setState(8);
		houseReadily.setCreater(userId);
		houseReadily.setCreateTime(createTime);

		super.add(houseReadily);
		
		Integer houseReadilyId = houseReadily.getId();

		// 新增业主信息
		addHouseOwners(readilyCommand.getHouseOwners(), houseReadilyId, userId);

		// 新增附件
		addAttachments(houseReadilyId, btAttachments, snAttachments, fxAttachments, xqAttachments);

		// 新增跟进记录
		addHouseFollows(readilyCommand.getHouseFollows(), houseReadily);

		// 新增操作日志
		operateLogService.add(userId, readilyCommand.getIp(), readilyCommand.getOperate(), 1, MessageFormat.format(
				Configuration.HOUSEREADILY_ADD_LOG, houseReadilyId.toString()), currentTime);
		
		// 更新用户房源数量
		userExtService.updateHouseReadilyCount(houseReadily.getCreater());
		
		// 新增积分日志
		houseReadily.setGrowing(taskLogService.add(userId, Integer.parseInt(Configuration.TASK_HOUSEREADILY_ID), null));

		// 关联数据查询
		initHouseReadilyForeignValue(houseReadily);

		return houseReadily;
	}

	@Override
	public List<HouseReadily> findByIds(String ids) {
		List<HouseReadily> houseReadilys = getHouseReadilyDAO().findByProperty("id", StringUtils.toInteger(ids.split(","))).getList();
		for (HouseReadily houseReadily : houseReadilys) {
			initHouseReadilyForeignValue(houseReadily);
		}
		return houseReadilys;
	}

	@Override
	public HouseReadily findById(Integer id) {
		HouseReadily houseReadily = super.findById(id);
		initHouseReadilyForeignValue(houseReadily);

		return houseReadily;
	}

	@Override
	public List<HouseReadily> findPaging(ICommand command, PagingBean pagingBean) {
		List<HouseReadily> houseReadilys = getHouseReadilyDAO().findPaging(command, pagingBean);
		for (HouseReadily houseReadily : houseReadilys) {
			initHouseReadilyForeignValue(houseReadily);
		}
		return houseReadilys;
	}

	@Override
	public List<HouseReadily> findPaging(Integer id, Integer stype, Integer buildType, String projectName, String title, Integer cityCode,
			Integer bigAreaCode, Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir,
			PagingBean pagingBean) {
		List<HouseReadily> houseReadilys = getHouseReadilyDAO().findPaging(id, stype, buildType, projectName, title, cityCode, bigAreaCode,
				smallAreaCode, userName, beginDate, endDate, isDelete, sort, dir, pagingBean);
		for (HouseReadily houseReadily : houseReadilys) {
			initHouseReadilyForeignValue(houseReadily);
		}
		return houseReadilys;
	}

	@Override
	public List<HouseReadily> findIdAndVersion(Integer userId) {
		return getHouseReadilyDAO().findIdAndVersion(userId);
	}

	@Override
	public HouseReadily update(ICommand command) throws Exception {
		HouseReadilyCommand readilyCommand = (HouseReadilyCommand) command;
		Integer userId = readilyCommand.getUserId();
		String properties = readilyCommand.getProperties();
		Integer id = readilyCommand.getId();
		HouseReadily houseReadily = findById(id);
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Timestamp updateTime = null != readilyCommand.getUpdateTime() ? new Timestamp(readilyCommand.getUpdateTime().getTime())
				: currentTime;

		// if (null != readilyCommand.getLastFollowDate()) {
		// houseReadily.setLastFollowDate(newTimestamp(readilyCommand.getLastFollowDate().getTime()));
		// }
		houseReadily.setUpdateTime(updateTime);
		houseReadily.setSyncTime(currentTime);
		houseReadily.setVersion(StringUtils.isNotEmpty(readilyCommand.getVersion()) ? readilyCommand.getVersion() : new BigDecimal(
				houseReadily.getVersion()).add(new BigDecimal("0.1")).toString());

		if (properties.indexOf("houseReadily") > -1) {
			houseReadily.setStype(readilyCommand.getStype());
			houseReadily.setProjectId(readilyCommand.getProjectId());
			houseReadily.setProjectName(readilyCommand.getProjectName());

			// 关联已有的楼盘记录
			if (null != readilyCommand.getProjectId() && readilyCommand.getProjectId() > 0) {
				CProject project = projectService.findById(readilyCommand.getProjectId());
				houseReadily.setCityCode(ContextHelper.enCityCodes.get(project.getCity()));
				houseReadily.setBigAreaCode(project.getAreaId());
				houseReadily.setSmallAreaCode(project.getSubAreaId());
				houseReadily.setLon(new BigDecimal(null != project.getLng() ? project.getLng() : 0.0f));
				houseReadily.setLat(new BigDecimal(null != project.getLat() ? project.getLat() : 0.0f));
				houseReadily.setAddress(project.getAddress());
			} else {
				Integer bigAreaCode = readilyCommand.getBigAreaCode();
				if (null != bigAreaCode && bigAreaCode > 0) {
					houseReadily.setCityCode(ContextHelper.allareasToCityCodesMap.get(bigAreaCode));
				} else {
					houseReadily.setCityCode(null);
				}
				houseReadily.setBigAreaCode(bigAreaCode);
				houseReadily.setSmallAreaCode(readilyCommand.getSmallAreaCode());
			}

			houseReadily.setBuildType(readilyCommand.getBuildType());
			houseReadily.setTitle(readilyCommand.getTitle());
			houseReadily.setBuilding(readilyCommand.getBuilding());
			houseReadily.setHouseNum(readilyCommand.getHouseNum());
			houseReadily.setRoomNum(readilyCommand.getRoomNum());
			houseReadily.setHallNum(readilyCommand.getHallNum());
			houseReadily.setToiletNum(readilyCommand.getToiletNum());
			houseReadily.setArea(readilyCommand.getArea());
			if (null != readilyCommand.getUnitPrice() && readilyCommand.getUnitPrice().compareTo(BigDecimal.ZERO) > 0) {
				houseReadily.setUnitPrice(readilyCommand.getUnitPrice());
				houseReadily.setTotalPrice(readilyCommand.getArea().multiply(readilyCommand.getUnitPrice()));
			} else if (null != readilyCommand.getTotalPrice() && readilyCommand.getTotalPrice().compareTo(BigDecimal.ZERO) > 0) {
				houseReadily.setTotalPrice(readilyCommand.getTotalPrice());
				if(readilyCommand.getArea().compareTo(BigDecimal.ZERO)==0){
					houseReadily.setUnitPrice(readilyCommand.getTotalPrice());
				}else{
					houseReadily.setUnitPrice(readilyCommand.getTotalPrice().divide(readilyCommand.getArea(), 2, BigDecimal.ROUND_HALF_EVEN));
				}
			}

			// 修改时间：2013-06-27，修改人：willter，修改描述：加入房源详细信息字段
			houseReadily.setTowards(readilyCommand.getTowards());
			houseReadily.setFitment(readilyCommand.getFitment());
			houseReadily.setHouseRight(readilyCommand.getHouseRight());
			houseReadily.setFurn(readilyCommand.getFurn());
			houseReadily.setKeyer(readilyCommand.getKeyer());
			/*****************************************************************/
			
			houseReadily.setHasRedBook(readilyCommand.getHasRedBook());
			houseReadily.setDescription(readilyCommand.getDescription());

			super.update(houseReadily);
		}

		if (properties.indexOf("houseOwners") > -1) {
			// 删除业主信息
			String delHouseOwners = readilyCommand.getDelHouseOwners();
			if (!StringUtils.isEmpty(delHouseOwners)) {
				houseOwnerService.delete(delHouseOwners);
			}

			// 修改业主信息
			updateHouseOwners(id, readilyCommand.getUpdateHouseOwners());

			// 新增业主信息
			addHouseOwners(readilyCommand.getHouseOwners(), id, userId);
		}

		if (properties.indexOf("attachments") > -1) {
			// 删除附件
			String delAttachments = readilyCommand.getDelAttachments();
			if (!StringUtils.isEmpty(delAttachments)) {
				houseAttachmentService.delete(delAttachments);
			}

			// 新增附件
			String btAttachments = readilyCommand.getBtAttachments();
			String snAttachments = readilyCommand.getSnAttachments();
			String fxAttachments = readilyCommand.getFxAttachments();
			String xqAttachments = readilyCommand.getXqAttachments();
			addAttachments(id, btAttachments, snAttachments, fxAttachments, xqAttachments);
		}

		if (properties.indexOf("houseFollows") > -1) {
			// 删除跟进记录
			String delHouseFollows = readilyCommand.getDelHouseFollows();
			if (StringUtils.isNotEmpty(delHouseFollows)) {
				houseFollowService.delete(delHouseFollows);
			}

			// 新增跟进记录
			addHouseFollows(readilyCommand.getHouseFollows(), houseReadily);
		}

		// 新增操作日志
		operateLogService.add(userId, readilyCommand.getIp(), readilyCommand.getOperate(), 2, MessageFormat.format(
				Configuration.HOUSEREADILY_UPDATE_LOG, houseReadily.getId().toString()), currentTime);

		// 关联数据查询
		initHouseReadilyForeignValue(houseReadily);

		return houseReadily;
	}

	/**
	 * @Title: updateHouseOwners
	 * @Description: 更新业主信息，是否主要联系人
	 *               <p>
	 * @author willter
	 * @date 2013-1-18
	 *       <p>
	 * @param updateHouseOwners
	 * @throws JSONException
	 */
	private void updateHouseOwners(Integer houseReadilyId, String updateHouseOwners) throws JSONException {
		if (!StringUtils.isEmpty(updateHouseOwners)) {
			JSONArray customerArray = new JSONArray(updateHouseOwners);
			JSONObject customerObject = null;
			for (int i = 0, len = customerArray.length(); i < len; i++) {
				customerObject = (JSONObject) customerArray.get(i);
				Integer id = customerObject.getInt("id");
				Integer isMain = customerObject.getInt("isMain");
				Integer customerId = customerObject.getInt("customerId");

				// 更新业主信息，是否主要联系人
				HouseOwner houseOwner = houseOwnerService.findById(id);
				houseOwner.setIsMain(isMain);
				if (isMain == 1) {
					List<HouseOwner> houseOwnerList = houseOwnerService.findHouseOwnerByHouseReadilyId(houseReadilyId);
					for (HouseOwner houseOwner$ : houseOwnerList) {
						if (houseOwner.getId() != houseOwner$.getId()) {
							houseOwner$.setIsMain(0);
						}
					}
				}
			}
		}
	}

	/**
	 * @Title: addHouseOwners
	 * @Description: 新增业主信息
	 *               <p>
	 * @author willter
	 * @date 2012-12-26
	 *       <p>
	 * @param houseOwners
	 * @param houseReadilyId
	 * @param userId
	 * @throws JSONException
	 */
	private void addHouseOwners(String houseOwners, Integer houseReadilyId, Integer userId) throws JSONException {
		if (!StringUtils.isEmpty(houseOwners)) {
			JSONArray customerArray = new JSONArray(houseOwners);
			JSONObject customerObject = null;
			for (int i = 0, len = customerArray.length(); i < len; i++) {
				customerObject = (JSONObject) customerArray.get(i);
				Integer isMain = customerObject.getInt("isMain");
				Integer customerId = customerObject.getInt("customerId");

				// 判断房源下是否已经存在主要联系人，如果存在则更新为非主要联系人
				if (isMain == 1) {
					List<HouseOwner> houseOwnerList = houseOwnerService.findHouseOwnerByHouseReadilyId(houseReadilyId);
					for (HouseOwner houseOwner : houseOwnerList) {
						if (houseOwner.getIsMain() == 1) {
							houseOwner.setIsMain(0);
						}
					}
				}

				HouseOwner houseOwner = new HouseOwner();
				houseOwner.setIsMain(isMain);
				houseOwner.setHouseReadilyId(houseReadilyId);
				houseOwner.setCustomerId(customerId);
				houseOwner.setCreater(userId);
				houseOwner.setCreateTime(new Timestamp(System.currentTimeMillis()));
				houseOwnerService.add(houseOwner);
			}
		}
	}

	/**
	 * @Title: addAttachments
	 * @Description: 新增附件
	 *               <p>
	 * @author willter
	 * @date 2012-12-26
	 *       <p>
	 * @param houseReadilyId
	 * @param btAttachments
	 * @param snAttachments
	 * @param fxAttachments
	 * @param xqAttachments
	 */
	private void addAttachments(Integer houseReadilyId, String btAttachments, String snAttachments, String fxAttachments,
			String xqAttachments) {
		if (!StringUtils.isEmpty(btAttachments)) {
			houseAttachmentService.add(houseReadilyId, Configuration.BT, btAttachments);
		}
		if (!StringUtils.isEmpty(snAttachments)) {
			houseAttachmentService.add(houseReadilyId, Configuration.SN, snAttachments);
		}
		if (!StringUtils.isEmpty(fxAttachments)) {
			houseAttachmentService.add(houseReadilyId, Configuration.FX, fxAttachments);
		}
		if (!StringUtils.isEmpty(xqAttachments)) {
			houseAttachmentService.add(houseReadilyId, Configuration.XQ, xqAttachments);
		}
	}

	/**
	 * @Title: addHouseFollows
	 * @Description: 新增跟进记录
	 *               <p>
	 * @author willter
	 * @date 2013-3-18
	 *       <p>
	 * @param houseFollows
	 * @param houseReadilyId
	 * @param userId
	 * @throws JSONException
	 * @throws ParseException
	 */
	private void addHouseFollows(String houseFollows, HouseReadily houseReadily) throws JSONException, ParseException {
		if (StringUtils.isNotEmpty(houseFollows)) {
			// 复制旧跟进记录
			List<HouseFollow> oldHouseFollows = new ArrayList<HouseFollow>(houseReadily.getHouseFollows());
			Timestamp bigCreateTime = null;
			
			// 解析跟进记录请求
			JSONArray houseFollowArray = new JSONArray(houseFollows);
			JSONObject houseFollowObject = null;
			HouseFollow houseFollow = null;
			for (int i = 0, len = houseFollowArray.length(); i < len; i++) {
				houseFollowObject = (JSONObject) houseFollowArray.get(i);
				Integer customerId = houseFollowObject.getInt("customerId");
				Integer mode = houseFollowObject.getInt("mode");
				String description = houseFollowObject.getString("description");
				Timestamp createTime = StringUtils.isNotEmpty(houseFollowObject.getString("createTime")) ? new Timestamp(DateUtils.parse(
						houseFollowObject.getString("createTime"), Constants.DATEFORMAT).getTime()) : new Timestamp(System
						.currentTimeMillis());

				// 新增跟进记录
				houseFollow = new HouseFollow();
				houseFollow.setHouseReadilyId(houseReadily.getId());
				houseFollow.setCustomerId(customerId);
				houseFollow.setMode(mode);
				houseFollow.setDescription(description);
				houseFollow.setCreater(houseReadily.getCreater());
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
			
			// 更新房源最后跟进时间
			if (bigCreateTime.compareTo(houseReadily.getLastFollowDate()) > 0) {
				houseReadily.setLastFollowDate(bigCreateTime);
			}
		}
	}

	private void initHouseReadilyForeignValue(HouseReadily houseReadily) {
		if (null != houseReadily) {
			Integer houseReadilyId = houseReadily.getId();

			List<HouseOwner> houseOwners = houseOwnerService.findHouseOwnerByHouseReadilyId(houseReadilyId);
			Customer customer = null;
			for (HouseOwner houseOwner : houseOwners) {
				customer = customerDAO.findById(houseOwner.getCustomerId());

				houseOwner.setCustomerName(customer.getName());
				houseOwner.setGender(customer.getGender());
				houseOwner.setPhone(customer.getPhone());
				houseOwner.setMobile(customer.getMobile());
				houseOwner.setHouseReadilyName(houseReadily.getProjectName());
			}
			houseReadily.setHouseOwners(houseOwners);

			houseReadily.setBtAttachments(houseAttachmentService.findAttachment(houseReadilyId, Configuration.BT));
			houseReadily.setSnAttachments(houseAttachmentService.findAttachment(houseReadilyId, Configuration.SN));
			houseReadily.setFxAttachments(houseAttachmentService.findAttachment(houseReadilyId, Configuration.FX));
			houseReadily.setXqAttachments(houseAttachmentService.findAttachment(houseReadilyId, Configuration.XQ));

			houseReadily.setHouseFollows(houseFollowService.findByProperty("houseReadilyId", houseReadilyId, "createTime", "desc").getList());

			houseReadily.setUserName(userDAO.findById(houseReadily.getCreater()).getName());
		}
	}
	
	@Override
	public void updateIosBug(Integer userId) {
		// 修复房源数据
		List<HouseReadily> houseReadilyList = getHouseReadilyDAO().findByProperty("creater", userId).getList();
		BigDecimal tempPrice = null;
		for (HouseReadily houseReadily : houseReadilyList) {
			if (houseReadily.getStype() == 2) { // 正常的数据是：1=出售 2=出租
				houseReadily.setStype(1); // 修改为正确的数据
				if (houseReadily.getUnitPrice() != null && houseReadily.getUnitPrice().compareTo(new BigDecimal("10000")) < 0) { // 判断输入的总价是否小于1万，小于1万说明数据错误，需要转换
					tempPrice = houseReadily.getUnitPrice().multiply(new BigDecimal("10000"));
					houseReadily.setTotalPrice(tempPrice);
					if (houseReadily.getArea() == null || houseReadily.getArea().compareTo(BigDecimal.ZERO) == 0) {
						houseReadily.setUnitPrice(BigDecimal.ZERO);
					} else {
						houseReadily.setUnitPrice(houseReadily.getTotalPrice().divide(houseReadily.getArea(), 2, BigDecimal.ROUND_HALF_EVEN));						
					}
				}
			} else if (houseReadily.getStype() == 1) {
				houseReadily.setStype(2); // 修改为正确的数据
				if (houseReadily.getUnitPrice() != null) {
					tempPrice = houseReadily.getUnitPrice();
					houseReadily.setTotalPrice(tempPrice);
					if (houseReadily.getArea() == null || houseReadily.getArea().compareTo(BigDecimal.ZERO) == 0) {
						houseReadily.setUnitPrice(BigDecimal.ZERO);
					} else {
						houseReadily.setUnitPrice(houseReadily.getTotalPrice().divide(houseReadily.getArea(), 2, BigDecimal.ROUND_HALF_EVEN));
					}
				}
			}
			houseReadily.setVersion(new BigDecimal(houseReadily.getVersion()).add(new BigDecimal("0.1")).toString());
		}
		
		// 修复客源数据
		List<Customer> customerList = getCustomerDAO().findByProperty("creater", userId).getList();
		for (Customer customer : customerList) {
			if (customer.getCtype() == 3) { // 客户类型没有错误：1：业主，2：求租，3：求购
				// 单价，总价
				if (customer.getBeginUnitPrice() != null || customer.getBeginUnitPrice().compareTo(new BigDecimal("10000")) < 0) { // 判断输入的总价是否小于1万，小于1万说明数据错误，需要转换
					tempPrice = customer.getBeginUnitPrice().multiply(new BigDecimal("10000"));
					customer.setBeginTotalPrice(tempPrice);
					customer.setBeginUnitPrice(BigDecimal.ZERO);
				}
				if (customer.getEndUnitPrice() != null || customer.getEndUnitPrice().compareTo(new BigDecimal("10000")) < 0) { // 判断输入的总价是否小于1万，小于1万说明数据错误，需要转换
					tempPrice = customer.getEndUnitPrice().multiply(new BigDecimal("10000"));
					customer.setEndTotalPrice(tempPrice);
					customer.setEndUnitPrice(BigDecimal.ZERO);
				}
				
				// 首付
				customer.setBeginFirstPayment(customer.getBeginFirstPayment().multiply(new BigDecimal("10000")));
				customer.setEndFirstPayment(customer.getEndFirstPayment().multiply(new BigDecimal("10000")));
			} else if (customer.getCtype() == 2) {
				// 单价，总价
				tempPrice = customer.getBeginUnitPrice();
				customer.setBeginTotalPrice(tempPrice);
				customer.setBeginUnitPrice(BigDecimal.ZERO);
				
				tempPrice = customer.getEndUnitPrice();
				customer.setEndTotalPrice(tempPrice);
				customer.setEndUnitPrice(BigDecimal.ZERO);
			}
			customer.setVersion(new BigDecimal(customer.getVersion()).add(new BigDecimal("0.1")).toString());
		}
	}
	
	@Override
	public HouseReadily updateStatus(ICommand command) {
		HouseReadilyCommand readilyCommand = (HouseReadilyCommand) command;
		Integer userId = readilyCommand.getUserId();
		Integer id = readilyCommand.getId();
		Integer state = readilyCommand.getState();
		HouseReadily houseReadily = findById(id);
		
		// 判断是否创建人修改状态
		if (!houseReadily.getCreater().equals(userId)) {
			return null;
		}
		
		// 执行修改操作
		houseReadily.setState(state);
//		Integer result = getHouseReadilyDAO().updateStatus(id, state);
//		if (result <= 0) {
//			return null;
//		}
		
		// 修改版本号
		houseReadily.setVersion(StringUtils.isEmpty(houseReadily.getVersion()) ? Configuration.DEFAULT_VERSION : new BigDecimal(
				houseReadily.getVersion()).add(new BigDecimal("0.1")).toString());
		
		return houseReadily;
	}
	
	@Override
	public void delete(HouseReadily houseReadily) {
		houseReadily.setIsDelete(0);
		userExtService.updateHouseReadilyCount(houseReadily.getCreater());
		Integer houseReadilyId = houseReadily.getId();

		// 删除业主
		List<HouseOwner> houseOwners = houseOwnerService.findHouseOwnerByHouseReadilyId(houseReadilyId);
		for (HouseOwner houseOwner : houseOwners) {
			houseOwnerService.delete(houseOwner);
		}

		// 删除附件
//		List<HouseAttachment> houseAttachments = houseAttachmentService.findByProperty("houseReadilyId", houseReadilyId).getList();
//		for (HouseAttachment houseAttachment : houseAttachments) {
//			houseAttachmentService.delete(houseAttachment);
//		}

		// 删除跟进记录
		List<HouseFollow> houseFollows = houseFollowService.findByProperty("houseReadilyId", houseReadilyId).getList();
		for (HouseFollow houseFollow : houseFollows) {
			houseFollowService.delete(houseFollow);
		}

//		// 删除房源
//		super.delete(houseReadily);
	}

	@Override
	public void delete(ICommand command) {
		HouseReadilyCommand readilyCommand = (HouseReadilyCommand) command;
		String ids = readilyCommand.getIds();
		Integer userId = readilyCommand.getUserId();
		String ip = readilyCommand.getIp();
		String operate = readilyCommand.getOperate();

		String[] idArray = ids.split(",");
		HouseReadily houseReadily = null;
		for (int i = 0; i < idArray.length; i++) {
			if (!StringUtils.isEmpty(idArray[i])) {
				houseReadily = findById(Integer.parseInt(idArray[i]));
				if (null != houseReadily) {
					delete(houseReadily);

					// 新增操作日志
					operateLogService.add(userId, ip, operate, 3, MessageFormat.format(Configuration.HOUSEREADILY_DELETE_LOG, houseReadily
							.getId().toString()), null);
				}
			}
		}
	}

	private IHouseAttachmentService houseAttachmentService;
	private IProjectService projectService;
	private IHouseOwnerService houseOwnerService;
	private IHouseFollowService houseFollowService;
	private IOperateLogService operateLogService;
	private IUserDAO userDAO;
	private IUserExtService userExtService;
	private ICustomerDAO customerDAO;
	private ITaskLogService taskLogService;

	public IProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public IHouseAttachmentService getHouseAttachmentService() {
		return houseAttachmentService;
	}

	public void setHouseAttachmentService(IHouseAttachmentService houseAttachmentService) {
		this.houseAttachmentService = houseAttachmentService;
	}

	public IHouseOwnerService getHouseOwnerService() {
		return houseOwnerService;
	}

	public void setHouseOwnerService(IHouseOwnerService houseOwnerService) {
		this.houseOwnerService = houseOwnerService;
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

	public ICustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public IUserExtService getUserExtService() {
		return userExtService;
	}

	public void setUserExtService(IUserExtService userExtService) {
		this.userExtService = userExtService;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ITaskLogService getTaskLogService() {
		return taskLogService;
	}

	public void setTaskLogService(ITaskLogService taskLogService) {
		this.taskLogService = taskLogService;
	}
}