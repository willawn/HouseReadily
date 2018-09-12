package com.huzhiyi.housereadily.biz.impl;

import com.huzhiyi.housereadily.model.CProject;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.housereadily.dao.IProjectDAO;
import com.huzhiyi.housereadily.biz.IAbstractprojectService;

/**
 *RDE(快速开发环境)自动生成代码 CProject Biz Implement Class
 */
public abstract class AbstractProjectServiceImpl implements IAbstractprojectService {
	/**
	 *DAO对象注入
	 */
	private IProjectDAO projectDAO;

	public IProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	/**
	 *查询所有
	 */
	public List<CProject> findAll() {
		return projectDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<CProject> findByExample(CProject example) {
		return projectDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<CProject> findByProperty(String propertyName, Object value) {
		return projectDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public CProject findById(Integer id) {
		return projectDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(CProject example) {
		projectDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(CProject example) {
		projectDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(CProject example) {
		projectDAO.delete(example);
	}
}