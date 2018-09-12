package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractsystemLogService;
import com.huzhiyi.housereadily.dao.ISystemLogDAO;
import com.huzhiyi.housereadily.entity.SystemLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 SystemLog Biz Implement Class
 */
public abstract class AbstractSystemLogServiceImpl implements IAbstractsystemLogService {
	/**
	 *DAO对象注入
	 */
	private ISystemLogDAO systemLogDAO;

	public ISystemLogDAO getSystemLogDAO() {
		return this.systemLogDAO;
	}

	public void setSystemLogDAO(ISystemLogDAO systemLogDAO) {
		this.systemLogDAO = systemLogDAO;
	}

	/**
	 *查询所有
	 */
	public List<SystemLog> findAll() {
		return systemLogDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<SystemLog> findByExample(SystemLog example) {
		return systemLogDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<SystemLog> findByProperty(String propertyName, Object value) {
		return systemLogDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public SystemLog findById(Integer id) {
		return systemLogDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(SystemLog example) {
		systemLogDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(SystemLog example) {
		systemLogDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(SystemLog example) {
		systemLogDAO.delete(example);
	}
}