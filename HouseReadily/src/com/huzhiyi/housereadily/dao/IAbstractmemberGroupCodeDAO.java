package com.huzhiyi.housereadily.dao;

import java.io.Serializable;
import java.util.List;

import com.huzhiyi.annotation.RDEDao;
import com.huzhiyi.housereadily.entity.MemberGroupCode;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MemberGroupCode DAO Interface
 */
@RDEDao
public abstract interface IAbstractmemberGroupCodeDAO {
	/**
	 *查询所有
	 */
	List<MemberGroupCode> findAll();

	/**
	 *根据HQL查询
	 */
	QueryResult<MemberGroupCode> findByHQL(String hql);

	/**
	 *根据实例查询
	 */
	QueryResult<MemberGroupCode> findByExample(MemberGroupCode example);

	/**
	 *根据属性名查询
	 */
	QueryResult<MemberGroupCode> findByProperty(String propertyName, Object value);

	/**
	 *根据ID查询
	 */
	MemberGroupCode findById(Integer id);

	/**
	 *新增操作
	 */
	void add(MemberGroupCode example);

	/**
	 *更新操作
	 */
	void update(MemberGroupCode example);

	/**
	 *删除操作
	 */
	void delete(MemberGroupCode example);
}