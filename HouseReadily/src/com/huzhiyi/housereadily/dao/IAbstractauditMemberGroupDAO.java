package com.huzhiyi.housereadily.dao;

import java.io.Serializable;
import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 AuditMemberGroup DAO Interface
 */
@RDEDao
public abstract interface IAbstractauditMemberGroupDAO {
	/**
	 *查询所有
	 */
	List<AuditMemberGroup> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<AuditMemberGroup> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<AuditMemberGroup> findByExample(AuditMemberGroup example);

	/**
	 *根据属性名查询
	 */
	QueryResult<AuditMemberGroup> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	AuditMemberGroup findById(Integer id);

	/**
	 *新增操作
	 */
	void add(AuditMemberGroup example);

	/**
	 *更新操作
	 */
	void update(AuditMemberGroup example);

	/**
	 *删除操作
	 */
	void delete(AuditMemberGroup example);
}