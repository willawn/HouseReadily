package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstracthouseOwnerService;
import com.huzhiyi.housereadily.dao.IHouseOwnerDAO;
import com.huzhiyi.housereadily.entity.HouseOwner;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 HouseOwner Biz Implement Class
 */
public abstract class AbstractHouseOwnerServiceImpl implements IAbstracthouseOwnerService {
	/**
	 *DAO对象注入
	 */
	private IHouseOwnerDAO houseOwnerDAO;

	public IHouseOwnerDAO getHouseOwnerDAO() {
		return this.houseOwnerDAO;
	}

	public void setHouseOwnerDAO(IHouseOwnerDAO houseOwnerDAO) {
		this.houseOwnerDAO = houseOwnerDAO;
	}

	/**
	 *查询所有
	 */
	public List<HouseOwner> findAll() {
		return houseOwnerDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<HouseOwner> findByExample(HouseOwner example) {
		return houseOwnerDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<HouseOwner> findByProperty(String propertyName, Object value) {
		return houseOwnerDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public HouseOwner findById(Integer id) {
		return houseOwnerDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(HouseOwner example) {
		houseOwnerDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(HouseOwner example) {
		houseOwnerDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(HouseOwner example) {
		houseOwnerDAO.delete(example);
	}
}