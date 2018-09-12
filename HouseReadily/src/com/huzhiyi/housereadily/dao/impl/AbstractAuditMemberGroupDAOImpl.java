package com.huzhiyi.housereadily.dao.impl;

import java.util.List;

import com.huzhiyi.comm.dao.HibernateBaseDAO;
import com.huzhiyi.housereadily.dao.IAbstractauditMemberGroupDAO;
import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 AuditMemberGroup DAO Implement Class
 */
@SuppressWarnings("unchecked")
public abstract class AbstractAuditMemberGroupDAOImpl extends HibernateBaseDAO<Integer> implements IAbstractauditMemberGroupDAO {
	/**
	 *查询所有
	 */
	public List<AuditMemberGroup> findAll() {
		return super.findAll();
	}

	/**
	 *根据HQL查询
	 */
	public QueryResult<AuditMemberGroup> findByHQL(String hql) {
		return super.findByHQL(hql);
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<AuditMemberGroup> findByExample(AuditMemberGroup example) {
		return super.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<AuditMemberGroup> findByProperty(String propertyName, Object value) {
		return super.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public AuditMemberGroup findById(Integer id) {
		return (AuditMemberGroup) super.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(AuditMemberGroup example) {
		super.save(example);
	}

	/**
	 *更新操作
	 */
	public void update(AuditMemberGroup example) {
		super.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(AuditMemberGroup example) {
		super.delete(example);
	}

	@Override
	protected Class getEntityClass() {
		return AuditMemberGroup.class;
	}
}