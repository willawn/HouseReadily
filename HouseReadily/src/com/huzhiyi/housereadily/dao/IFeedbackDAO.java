package com.huzhiyi.housereadily.dao;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.model.PagingBean;

public interface IFeedbackDAO extends IAbstractfeedbackDAO {
	
	/**
	 * @Title: findPaging
	 * @Description: 意见反馈分页
	 *               <p>
	 * @author willter
	 * @date 2013-3-11
	 *       <p>
	 * @param pagingBean
	 * @return
	 */
	public List<Feedback> findPaging(Date beginDate, Date endDate, String sort, String dir, PagingBean pagingBean);
}