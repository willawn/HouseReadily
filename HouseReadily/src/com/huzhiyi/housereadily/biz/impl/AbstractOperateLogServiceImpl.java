package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractoperateLogService;
import com.huzhiyi.housereadily.dao.IOperateLogDAO;
import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 OperateLog Biz Implement Class
 */
public abstract class AbstractOperateLogServiceImpl implements IAbstractoperateLogService {
	/**
	 *DAO对象注入
	 */
	private IOperateLogDAO operateLogDAO;

	public IOperateLogDAO getOperateLogDAO() {
		return this.operateLogDAO;
	}

	public void setOperateLogDAO(IOperateLogDAO operateLogDAO) {
		this.operateLogDAO = operateLogDAO;
	}

	/**
	 *查询所有
	 */
	public List<OperateLog> findAll() {
		return operateLogDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<OperateLog> findByExample(OperateLog example) {
		return operateLogDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<OperateLog> findByProperty(String propertyName, Object value) {
		return operateLogDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public OperateLog findById(Integer id) {
		return operateLogDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(OperateLog example) {
		operateLogDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(OperateLog example) {
		operateLogDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(OperateLog example) {
		operateLogDAO.delete(example);
	}
}