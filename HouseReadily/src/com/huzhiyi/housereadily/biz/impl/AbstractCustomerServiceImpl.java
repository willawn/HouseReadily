package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractcustomerService;
import com.huzhiyi.housereadily.dao.ICustomerDAO;
import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Customer Biz Implement Class
 */
public abstract class AbstractCustomerServiceImpl implements IAbstractcustomerService {
	/**
	 *DAO对象注入
	 */
	private ICustomerDAO customerDAO;

	public ICustomerDAO getCustomerDAO() {
		return this.customerDAO;
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	/**
	 *查询所有
	 */
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Customer> findByExample(Customer example) {
		return customerDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Customer> findByProperty(String propertyName, Object value) {
		return customerDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Customer findById(Integer id) {
		return customerDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Customer example) {
		customerDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(Customer example) {
		customerDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Customer example) {
		customerDAO.delete(example);
	}
}