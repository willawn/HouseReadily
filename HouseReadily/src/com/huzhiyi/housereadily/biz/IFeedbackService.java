package com.huzhiyi.housereadily.biz;

import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

@com.huzhiyi.annotation.RDEBiz
public interface IFeedbackService extends IAbstractfeedbackService {

	/**
	 * @Title: add
	 * @Description: 提交意见反馈
	 *               <p>
	 * @author willter
	 * @date 2012-11-5
	 *       <p>
	 * @param command
	 * @return
	 */
	public Feedback add(ICommand command);

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