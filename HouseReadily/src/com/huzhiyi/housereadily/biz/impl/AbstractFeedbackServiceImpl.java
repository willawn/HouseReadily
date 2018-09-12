package com.huzhiyi.housereadily.biz.impl;

import java.util.List;

import com.huzhiyi.housereadily.biz.IAbstractfeedbackService;
import com.huzhiyi.housereadily.dao.IFeedbackDAO;
import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.model.abstraction.QueryResult;

/**
 *RDE(快速开发环境)自动生成代码 Feedback Biz Implement Class
 */
public abstract class AbstractFeedbackServiceImpl implements IAbstractfeedbackService {
	/**
	 *DAO对象注入
	 */
	private IFeedbackDAO feedbackDAO;

	public IFeedbackDAO getFeedbackDAO() {
		return this.feedbackDAO;
	}

	public void setFeedbackDAO(IFeedbackDAO feedbackDAO) {
		this.feedbackDAO = feedbackDAO;
	}

	/**
	 *查询所有
	 */
	public List<Feedback> findAll() {
		return feedbackDAO.findAll();
	}

	/**
	 *根据实例查询
	 */
	public QueryResult<Feedback> findByExample(Feedback example) {
		return feedbackDAO.findByExample(example);
	}

	/**
	 *根据属性名查询
	 */
	public QueryResult<Feedback> findByProperty(String propertyName, Object value) {
		return feedbackDAO.findByProperty(propertyName, value);
	}

	/**
	 *根据ID查询
	 */
	public Feedback findById(Integer id) {
		return feedbackDAO.findById(id);
	}

	/**
	 *新增操作
	 */
	public void add(Feedback example) {
		feedbackDAO.add(example);
	}

	/**
	 *更新操作
	 */
	public void update(Feedback example) {
		feedbackDAO.update(example);
	}

	/**
	 *删除操作
	 */
	public void delete(Feedback example) {
		feedbackDAO.delete(example);
	}
}