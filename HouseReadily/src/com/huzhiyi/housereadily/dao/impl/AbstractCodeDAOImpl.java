package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractcodeDAO;
import com.huzhiyi.housereadily.entity.Code;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Code DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractCodeDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractcodeDAO {
	/**
	 *查询所有
	 */
	public List<Code> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<Code> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Code> findByExample(Code example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Code> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Code findById(Integer id) {
		return (Code) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Code example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(Code example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Code example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return Code.class;
	}
}