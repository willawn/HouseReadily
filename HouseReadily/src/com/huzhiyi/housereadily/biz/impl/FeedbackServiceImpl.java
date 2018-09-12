package com.huzhiyi.housereadily.biz.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.IFeedbackService;
import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.housereadily.request.FeedbackCommand;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.model.PagingBean;

public class FeedbackServiceImpl extends AbstractFeedbackServiceImpl implements IFeedbackService {

	@Override
	public Feedback add(ICommand command) {
		FeedbackCommand feedbackCommand = (FeedbackCommand) command;
		String userName = feedbackCommand.getUserName();
		String email = feedbackCommand.getEmail();
		String description = feedbackCommand.getDescription();
		Integer userId = feedbackCommand.getUserId();

		long now = System.currentTimeMillis();
		Timestamp createTime = new Timestamp(now);

		// 提交意见反馈
		Feedback feedback = new Feedback();
		feedback.setUserName(userName);
		feedback.setEmail(email);
		feedback.setDescription(description);
		if (null != userId && userId > 0) {
			feedback.setCreater(userId);
		}
		feedback.setCreateTime(createTime);
		super.add(feedback);

		return feedback;
	}

	@Override
	public List<Feedback> findPaging(Date beginDate, Date endDate, String sort, String dir, PagingBean pagingBean) {
		return getFeedbackDAO().findPaging(beginDate, endDate, sort, dir, pagingBean);
	}
}