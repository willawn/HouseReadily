package com.huzhiyi.housereadily.dao.impl;

import com.huzhiyi.housereadily.entity.Customer;
import com.huzhiyi.housereadily.entity.HouseReadily;
import com.huzhiyi.comm.dao.HibernateBaseDAO;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.housereadily.dao.IAbstractcustomerDAO;

/**
 *RDE(快速开发环境)自动生成代码 Customer DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractCustomerDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractcustomerDAO {
	/**
	 *查询所有
	 */
	public List<Customer> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<Customer> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Customer> findByExample(Customer example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Customer> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Customer findById(Integer id) {
		return (Customer) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Customer example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(Customer example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Customer example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return Customer.class;
	}
}