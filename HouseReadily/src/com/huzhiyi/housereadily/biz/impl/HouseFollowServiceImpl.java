package com.huzhiyi.housereadily.biz.impl;

import java.sql.Timestamp;
import java.util.List;

import com.huzhiyi.housereadily.biz.IHouseFollowService;
import com.huzhiyi.housereadily.dao.ICustomerDAO;
import com.huzhiyi.housereadily.dao.IHouseReadilyDAO;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.request.HouseFollowCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.util.StringUtils;

public class HouseFollowServiceImpl extends AbstractHouseFollowServiceImpl implements IHouseFollowService {

	@Override
	public HouseFollow add(ICommand command) {
		HouseFollowCommand houseFollowCommand = (HouseFollowCommand) command;
		Integer userId = houseFollowCommand.getUserId();
		Timestamp createTime = new Timestamp(System.currentTimeMillis());

		HouseFollow houseFollow = new HouseFollow();
		houseFollow.setHouseReadilyId(houseFollowCommand.getHouseReadilyId());
		houseFollow.setCustomerId(houseFollowCommand.getCustomerId());
		houseFollow.setMode(houseFollowCommand.getMode());
		houseFollow.setDescription(houseFollowCommand.getDescription());
		houseFollow.setCreater(userId);
		houseFollow.setCreateTime(createTime);

		super.add(houseFollow);

		// 关联数据查询
		initHouseFollowForeignValue(houseFollow);
		
		if (null != houseFollow.getHouseReadilyId() && houseFollow.getHouseReadilyId() > 0) {
			// 更新房源最后跟进时间
			HouseReadily houseReadily = houseReadilyDAO.findById(houseFollow.getHouseReadilyId());
			houseReadily.setLastFollowDate(createTime);
		} else if (null != houseFollow.getCustomerId() && houseFollow.getCustomerId() > 0) {
			// 更新客源最后跟进时间
			Customer customer = customerDAO.findById(houseFollow.getCustomerId());
			customer.setLastFollowDate(createTime);
		}

		return houseFollow;
	}

	@Override
	public List<HouseFollow> findPaging(Integer houseReadilyId, Integer customerId, Integer ctype, PagingBean pagingBean) {
		List<HouseFollow> houseFollows = getHouseFollowDAO().findPaging(houseReadilyId, customerId, ctype, pagingBean);
		for (HouseFollow houseFollow : houseFollows) {
			initHouseFollowForeignValue(houseFollow);
		}
		return houseFollows;
	}
	
	@Override
	public List<HouseFollow> findByCustomerId(Integer customerId) {
		List<HouseFollow> houseFollows = getHouseFollowDAO().findByCustomerId(customerId);
		for (HouseFollow houseFollow : houseFollows) {
			initHouseFollowForeignValue(houseFollow);
		}
		return houseFollows;
	}
	
	@Override
	public QueryResult<HouseFollow> findByProperty(String propertyName, Object value) {
		QueryResult<HouseFollow> houseFollowResult = super.findByProperty(propertyName, value);
		for (HouseFollow houseFollow : houseFollowResult.getList()) {
			initHouseFollowForeignValue(houseFollow);
		}
		return houseFollowResult;
	}
	
	@Override
	public QueryResult<HouseFollow> findByProperty(String propertyName, Object value, String order, String dir) {
		QueryResult<HouseFollow> houseFollowResult = getHouseFollowDAO().findByProperty(propertyName, value, order, dir);
		for (HouseFollow houseFollow : houseFollowResult.getList()) {
			initHouseFollowForeignValue(houseFollow);
		}
		return houseFollowResult;
	}

	private void initHouseFollowForeignValue(HouseFollow houseFollow) {
		if (null != houseFollow.getHouseReadilyId() && houseFollow.getHouseReadilyId() > 0) {
			HouseReadily houseReadily = houseReadilyDAO.findById(houseFollow.getHouseReadilyId());
			
			houseFollow.setProjectId(houseReadily.getProjectId());
			houseFollow.setProjectName(houseReadily.getProjectName());
			houseFollow.setTitle(houseReadily.getTitle());
			houseFollow.setBuilding(houseReadily.getBuilding());
			houseFollow.setHouseNum(houseReadily.getHouseNum());
		}
		if (null != houseFollow.getCustomerId() && houseFollow.getCustomerId() > 0) {
			Customer customer = customerDAO.findById(houseFollow.getCustomerId());
			
			houseFollow.setCtype(customer.getCtype());
			houseFollow.setCustomerName(customer.getName());
			houseFollow.setGender(customer.getGender());
			houseFollow.setPhone(customer.getPhone());
			houseFollow.setMobile(customer.getMobile());
		}
	}

	@Override
	public void delete(String ids) {
		String[] idArray = ids.split(",");
		HouseFollow houseFollow = null;
		for (int i = 0; i < idArray.length; i++) {
			if (!StringUtils.isEmpty(idArray[i])) {
				houseFollow = findById(Integer.parseInt(idArray[i]));
				if (null != houseFollow) {
					delete(houseFollow);
				}
			}
		}
	}

	private IHouseReadilyDAO houseReadilyDAO;
	private ICustomerDAO customerDAO;

	public IHouseReadilyDAO getHouseReadilyDAO() {
		return houseReadilyDAO;
	}

	public void setHouseReadilyDAO(IHouseReadilyDAO houseReadilyDAO) {
		this.houseReadilyDAO = houseReadilyDAO;
	}

	public ICustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
}