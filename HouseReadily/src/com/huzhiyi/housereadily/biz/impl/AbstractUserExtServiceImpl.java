package com.huzhiyi.housereadily.biz.impl;

import com.huzhiyi.housereadily.entity.UserExt;
import java.io.Serializable;
import java.util.List;
import com.huzhiyi.model.abstraction.QueryResult;
import com.huzhiyi.housereadily.dao.IUserExtDAO;
import com.huzhiyi.housereadily.biz.IAbstractuserExtService;

/**
 *RDE(快速开发环境)自动生成代码 UserExt Biz Implement Class
 */
public abstract class AbstractUserExtServiceImpl implements IAbstractuserExtService {
	/**
	 *DAO对象注入
	 */
	private IUserExtDAO userExtDAO;

	public IUserExtDAO getUserExtDAO() {
		return this.userExtDAO;
	}

	public void setUserExtDAO(IUserExtDAO userExtDAO) {
		this.userExtDAO = userExtDAO;
	}

	/**
	 *查询所有
	 */
	public List<UserExt> findAll() {
		return userExtDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<UserExt> findByExample(UserExt example) {
		return userExtDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<UserExt> findByProperty(String propertyName, Object value) {
		return userExtDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public UserExt findById(Integer id) {
		return userExtDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(UserExt example) {
		userExtDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(UserExt example) {
		userExtDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(UserExt example) {
		userExtDAO.delete(example);
	}
}