package com.huzhiyi.housereadily.biz.impl;

import com.huzhiyi.housereadily.model.CUser;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.housereadily.biz.IAbstractuserService;

/**
 *RDE(快速开发环境)自动生成代码 CUser Biz Implement Class
 */
public abstract class AbstractUserServiceImpl implements IAbstractuserService {
	/**
	 *DAO对象注入
	 */
	private IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 *查询所有
	 */
	public List<CUser> findAll() {
		return userDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<CUser> findByExample(CUser example) {
		return userDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<CUser> findByProperty(String propertyName, Object value) {
		return userDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public CUser findById(Integer id) {
		return userDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(CUser example) {
		userDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(CUser example) {
		userDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(CUser example) {
		userDAO.delete(example);
	}
	
	/**
	 *查询指定用户的客源
	 */
	public List<Customer> findCreater(Integer creater){
		return userDAO.findCreater(creater);
	}

	
	/**
	 *查询指定用户的房源
	 */
	public List<HouseReadily> findReadilyCreater(Integer creater){
		return userDAO.findReadilyCreater(creater);
	}
}