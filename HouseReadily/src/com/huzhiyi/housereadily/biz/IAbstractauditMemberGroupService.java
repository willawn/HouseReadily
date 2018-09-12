package com.huzhiyi.housereadily.biz;

import java.util.List;

import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 AuditMemberGroup DAO Interface
 */
public abstract interface IAbstractauditMemberGroupService {
	/**
	 *查询所有
	 */
	List<AuditMemberGroup> findAll();

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