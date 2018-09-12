package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractcodeService;
import com.huzhiyi.housereadily.dao.ICodeDAO;
import com.huzhiyi.housereadily.entity.Code;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Code Biz Implement Class
 */
public abstract class AbstractCodeServiceImpl implements IAbstractcodeService {
	/**
	 *DAO对象注入
	 */
	private ICodeDAO codeDAO;

	public ICodeDAO getCodeDAO() {
		return this.codeDAO;
	}

	public void setCodeDAO(ICodeDAO codeDAO) {
		this.codeDAO = codeDAO;
	}

	/**
	 *查询所有
	 */
	public List<Code> findAll() {
		return codeDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Code> findByExample(Code example) {
		return codeDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Code> findByProperty(String propertyName, Object value) {
		return codeDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Code findById(Integer id) {
		return codeDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Code example) {
		codeDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(Code example) {
		codeDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Code example) {
		codeDAO.delete(example);
	}
}