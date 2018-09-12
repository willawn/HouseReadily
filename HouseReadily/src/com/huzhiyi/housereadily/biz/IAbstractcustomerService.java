package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Customer DAO Interface
 */
public abstract interface IAbstractcustomerService {
	/**
	 *查询所有
	 */
	List<Customer> findAll();

	/**
	 *根据实例查询
	 */
	QueryResult<Customer> findByExample(Customer example);

	/**
	 *根据属性名查询
	 */
	QueryResult<Customer> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	Customer findById(Integer id);

	/**
	 *新增操作
	 */
	void add(Customer example);

	/**
	 *更新操作
	 */
	void update(Customer example);

	/**
	 *删除操作
	 */
	void delete(Customer example);
}