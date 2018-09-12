package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractmemberGroupCodeService;
import com.huzhiyi.housereadily.dao.IMemberGroupCodeDAO;
import com.huzhiyi.housereadily.entity.MemberGroupCode;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 MemberGroupCode Biz Implement Class
 */
public abstract class AbstractMemberGroupCodeServiceImpl implements IAbstractmemberGroupCodeService {
	/**
	 *DAO对象注入
	 */
	private IMemberGroupCodeDAO memberGroupCodeDAO;

	public IMemberGroupCodeDAO getMemberGroupCodeDAO() {
		return this.memberGroupCodeDAO;
	}

	public void setMemberGroupCodeDAO(IMemberGroupCodeDAO memberGroupCodeDAO) {
		this.memberGroupCodeDAO = memberGroupCodeDAO;
	}

	/**
	 *查询所有
	 */
	public List<MemberGroupCode> findAll() {
		return memberGroupCodeDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<MemberGroupCode> findByExample(MemberGroupCode example) {
		return memberGroupCodeDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<MemberGroupCode> findByProperty(String propertyName, Object value) {
		return memberGroupCodeDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public MemberGroupCode findById(Integer id) {
		return memberGroupCodeDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(MemberGroupCode example) {
		memberGroupCodeDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(MemberGroupCode example) {
		memberGroupCodeDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(MemberGroupCode example) {
		memberGroupCodeDAO.delete(example);
	}
}