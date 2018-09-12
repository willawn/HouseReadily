package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IUserExtService;
import com.huzhiyi.housereadily.dao.ICustomerDAO;
import com.huzhiyi.housereadily.dao.IHouseReadilyDAO;
import com.huzhiyi.housereadily.entity.UserExt;

public class UserExtServiceImpl extends AbstractUserExtServiceImpl implements IUserExtService {

	@Override
	public UserExt findByUserId(Integer userId) {
		if (!userExtExist(userId)) {
			add(userId, 0);
		}
		return findByProperty("userId", userId).getUniqueResult();
	}
	
	@Override
	public void add(Integer userId, Integer isUpdate) {
		UserExt userExt = new UserExt();
		userExt.setUserId(userId);
		userExt.setHouseReadilyCount(houseReadilyDAO.findCount(userId));
		userExt.setCustomerCount(customerDAO.findCount(userId));
		userExt.setLevel(0);
		userExt.setGrowing(0);
		userExt.setIntegration(0);
		userExt.setIsUpdate(isUpdate);

		super.add(userExt);
	}

	@Override
	public boolean userExtExist(Integer userId) {
		List<UserExt> userExtList = getUserExtDAO().findByProperty("userId", userId).getList();
		return !userExtList.isEmpty();
	}

	@Override
	public void updateHouseReadilyCount(Integer userId) {
		if (!userExtExist(userId)) {
			add(userId, 0);
		}
		UserExt userExt = findByUserId(userId);
		userExt.setHouseReadilyCount(houseReadilyDAO.findCount(userId));
	}
	
	@Override
	public void updateCustomerCount(Integer userId) {
		if (!userExtExist(userId)) {
			add(userId, 0);
		}
		UserExt userExt = findByUserId(userId);
		userExt.setCustomerCount(customerDAO.findCount(userId));
	}
	
	@Override
	public void updateIsUpdate(Integer userId, Integer isUpdate) {
		UserExt userExt = findByUserId(userId);
		userExt.setIsUpdate(isUpdate);
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