package com.huzhiyi.housereadily.biz.impl;

import java.io.Serializable;
import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractbaseGroupService;
import com.huzhiyi.housereadily.dao.IBaseGroupDAO;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 BaseGroup Biz Implement Class
 */
public abstract class AbstractBaseGroupServiceImpl implements IAbstractbaseGroupService {
	/**
	 *DAO对象注入
	 */
	private IBaseGroupDAO baseGroupDAO;

	public IBaseGroupDAO getBaseGroupDAO() {
		return this.baseGroupDAO;
	}

	public void setBaseGroupDAO(IBaseGroupDAO baseGroupDAO) {
		this.baseGroupDAO = baseGroupDAO;
	}

	/**
	 *查询所有
	 */
	public List<BaseGroup> findAll() {
		return baseGroupDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<BaseGroup> findByExample(BaseGroup example) {
		return baseGroupDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<BaseGroup> findByProperty(String propertyName, Object value) {
		return baseGroupDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public BaseGroup findById(Integer id) {
		return baseGroupDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(BaseGroup example) {
		baseGroupDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(BaseGroup example) {
		baseGroupDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(BaseGroup example) {
		baseGroupDAO.delete(example);
	}
}