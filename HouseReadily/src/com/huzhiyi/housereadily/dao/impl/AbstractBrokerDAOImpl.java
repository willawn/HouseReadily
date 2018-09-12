package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractbrokerDAO;
import com.huzhiyi.housereadily.entity.Broker;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Broker DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractBrokerDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractbrokerDAO {
	/**
	 *查询所有
	 */
	public List<Broker> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<Broker> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Broker> findByExample(Broker example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Broker> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Broker findById(Integer id) {
		return (Broker) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Broker example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(Broker example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Broker example) {
		super.delete(example);
	}
	
	@Override
	protected Class getEntityClass() {
		return Broker.class;
	}
}