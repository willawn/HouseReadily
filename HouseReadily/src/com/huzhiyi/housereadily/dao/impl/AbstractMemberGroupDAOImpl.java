package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractmemberGroupDAO;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MemberGroup DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMemberGroupDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractmemberGroupDAO {
	/**
	 *查询所有
	 */
	public List<MemberGroup> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<MemberGroup> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<MemberGroup> findByExample(MemberGroup example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<MemberGroup> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public MemberGroup findById(Integer id) {
		return (MemberGroup) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(MemberGroup example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(MemberGroup example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(MemberGroup example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return MemberGroup.class;
	}
}