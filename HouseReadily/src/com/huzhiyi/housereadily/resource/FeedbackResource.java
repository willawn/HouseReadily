/**   
 * @Title: FeedbackResource.java
 * @Package com.huzhiyi.housereadily.resource
 * @Description: TODO(描述文件)
 * 		<p>
 * @author willter
 * @date 2012-11-5
 */
package com.huzhiyi.housereadily.resource;

import static com.huzhiyi.model.PagingBean.cpn;
import static com.huzhiyi.model.PagingBean.cps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.IFeedbackService;
import com.huzhiyi.housereadily.entity.Feedback;
import com.huzhiyi.housereadily.request.FeedbackCommand;
import com.huzhiyi.housereadily.response.FeedbackListResult;
import com.huzhiyi.housereadily.response.FeedbackResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

/**
 * @ClassName: FeedbackResource
 * @Description: 意见反馈
 *               <p>
 * @author willter
 * @date 2012-11-5
 */
public class FeedbackResource extends BaseResource {

	private static final String ADD = "add";
	private static final String LIST = "list";

	@Override
	protected void doInit() throws ResourceException {
		command = new FeedbackCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setUserName(RequestUtils.requestPropertyValue(form, "userName", ""));
		getCommand().setEmail(RequestUtils.requestPropertyValue(form, "email", ""));
		getCommand().setDescription(RequestUtils.requestPropertyValue(form, "description", ""));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
	}

	public FeedbackCommand getCommand() {
		return (FeedbackCommand) command;
	}

	/**
	 * @Title: add
	 * @Description: 提交意见反馈
	 *               <p>
	 * @author willter
	 * @date 2012-10-31
	 *       <p>
	 * @return
	 */
	private Representation add() {
		FeedbackResult feedbackResult = new FeedbackResult();
		Feedback feedback = feedbackService.add(command);

		feedbackResult.setStatus(1);
		feedbackResult.setMsg(Configuration.SUBMIT_SUCCESS);
		feedbackResult.setCommand(command);
		feedbackResult.setId(feedback.getId());
		feedbackResult.setUserName(feedback.getUserName());
		feedbackResult.setEmail(feedback.getEmail());
		feedbackResult.setDescription(feedback.getDescription());
		feedbackResult.setCreateTime(DateUtils.formatDate(feedback.getCreateTime()));

		return JsonHelper.getJson(feedbackResult);
	}

	private Representation list() {
		FeedbackListResult feedbackListResult = new FeedbackListResult();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();

		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		List feedbackList = feedbackService.findPaging(null, null, null, null, pagingBean);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		JSONObject feedbacks = ResponseUtils.getJSONByPagingBean(pagingBean, feedbackList, parseDataKey, "id", "userName", "email",
				"description", "creater", "createTime");

		feedbackListResult.setCommand(command);
		feedbackListResult.setFeedbacks(feedbacks);
		return JsonHelper.getJson(feedbackListResult);
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;

		if (LIST.equals(command.getAction())) {
			representation = list();
		}

		return representation;
	}

	@Post
	@Override
	public Representation post(Representation entity) throws ResourceException {
		Representation representation = null;
		Form form = new Form(entity);
		initData(form);

		if (ADD.equals(command.getAction())) {
			representation = add();
		}

		return representation;
	}

	private IFeedbackService feedbackService;

	public IFeedbackService getFeedbackService() {
		return feedbackService;
	}

	public void setFeedbackService(IFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
}
