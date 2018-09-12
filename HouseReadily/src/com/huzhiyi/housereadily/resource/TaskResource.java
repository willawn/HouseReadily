package com.huzhiyi.housereadily.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.ITaskLogService;
import com.huzhiyi.housereadily.biz.ITaskService;
import com.huzhiyi.housereadily.request.TaskCommand;
import com.huzhiyi.housereadily.response.TaskListResult;
import com.huzhiyi.housereadily.response.TaskResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class TaskResource extends BaseResource {

	private static final String LIST = "list";
	private static final String SHARE = "share";

	@Override
	protected void doInit() throws ResourceException {
		command = new TaskCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setShareType(RequestUtils.requestPropertyIntValue(form, "shareType"));
	}

	public TaskCommand getCommand() {
		return (TaskCommand) command;
	}

	private void initData(List taskList, PagingBean pagingBean, TaskListResult taskListResult) {
		Map parseDataKey = new HashMap();
		//parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "lastFollowDate", "createTime", "updateTime", "syncTime" });
		parseDataKey.put(Constants.PARSEIMGKEY, new String[] { "img" });

		JSONObject tasks = ResponseUtils.getJSONByPagingBean(pagingBean, taskList, parseDataKey, "id", "title", "description",
				"explanation", "total", "count", "growing", "growed", "isComplete", "img", "type");

		taskListResult.setCommand(command);
		taskListResult.setTasks(tasks);
	}

	private Representation share() {
		TaskResult taskResult = new TaskResult();
		Integer userId = getCommand().getUserId();
		Integer shareType = getCommand().getShareType();
		Integer growing = 0;
		try {
			if (shareType != 5) {
				growing += taskLogService.add(userId, Integer.parseInt(Configuration.TASK_FIRSTSHARE_ID), shareType);
				growing += taskLogService.add(userId, Integer.parseInt(Configuration.TASK_SHARE_ID), shareType);
			}
		} catch (Exception e) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.SHARE_FAILURE));
		}

		taskResult.setStatus(1);
		taskResult.setMsg(Configuration.SHARE_SUCCESS);
		taskResult.setGrowing(growing);

		return JsonHelper.getJson(taskResult);
	}

	private Representation list() {
		TaskListResult taskListResult = new TaskListResult();
		Integer userId = getCommand().getUserId();

		List taskList = null;
		try {
			taskList = taskService.findAll(userId, 1);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SELECT_FAILURE));
		}

		initData(taskList, null, taskListResult);

		return JsonHelper.getJson(taskListResult);
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;

		if (LIST.equals(command.getAction())) {
			representation = list();
		} else if (SHARE.equals(command.getAction())) {
			representation = share();
		}

		return representation;
	}

	@Post
	@Override
	public Representation post(Representation entity) throws ResourceException {
		Representation representation = null;
		Form form = new Form(entity);
		initData(form);

		// if (SHARE.equals(command.getAction())) {
		// representation = share();
		// }

		return representation;
	}

	private ITaskService taskService;
	private ITaskLogService taskLogService;

	public ITaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(ITaskService taskService) {
		this.taskService = taskService;
	}

	public ITaskLogService getTaskLogService() {
		return taskLogService;
	}

	public void setTaskLogService(ITaskLogService taskLogService) {
		this.taskLogService = taskLogService;
	}
}
