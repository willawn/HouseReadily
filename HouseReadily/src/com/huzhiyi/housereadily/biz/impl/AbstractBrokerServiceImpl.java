package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractbrokerService;
import com.huzhiyi.housereadily.dao.IBrokerDAO;
import com.huzhiyi.housereadily.entity.Broker;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Broker Biz Implement Class
 */
public abstract class AbstractBrokerServiceImpl implements IAbstractbrokerService {
	/**
	 *DAO对象注入
	 */
	private IBrokerDAO brokerDAO;

	public IBrokerDAO getBrokerDAO() {
		return this.brokerDAO;
	}

	public void setBrokerDAO(IBrokerDAO brokerDAO) {
		this.brokerDAO = brokerDAO;
	}

	/**
	 *查询所有
	 */
	public List<Broker> findAll() {
		return brokerDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Broker> findByExample(Broker example) {
		return brokerDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Broker> findByProperty(String propertyName, Object value) {
		return brokerDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Broker findById(Integer id) {
		return brokerDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Broker example) {
		brokerDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(Broker example) {
		brokerDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Broker example) {
		brokerDAO.delete(example);
	}
}