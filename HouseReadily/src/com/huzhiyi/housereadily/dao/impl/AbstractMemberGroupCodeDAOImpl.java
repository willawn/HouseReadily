package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractmemberGroupCodeDAO;
import com.huzhiyi.housereadily.entity.MemberGroupCode;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MemberGroupCode DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMemberGroupCodeDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractmemberGroupCodeDAO {
	/**
	 *查询所有
	 */
	public List<MemberGroupCode> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<MemberGroupCode> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<MemberGroupCode> findByExample(MemberGroupCode example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<MemberGroupCode> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public MemberGroupCode findById(Integer id) {
		return (MemberGroupCode) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(MemberGroupCode example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(MemberGroupCode example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(MemberGroupCode example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return MemberGroupCode.class;
	}
}