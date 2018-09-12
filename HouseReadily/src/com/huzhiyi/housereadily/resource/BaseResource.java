package com.huzhiyi.housereadily.resource;

import javax.servlet.http.HttpServletRequest;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.ext.servlet.internal.ServletCall;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;

import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.housereadily.action.TastyConfigAction;
import com.huzhiyi.housereadily.request.ICommand;
import com.huzhiyi.housereadily.response.BaseResult;
import com.huzhiyi.housereadily.response.StatusResult;
import com.tastysoft.swct.db.model.TastyEntity;
import com.tastysoft.swct.db.services.TastyService;
import com.tastysoft.swct.util.DateHelper;

public abstract class BaseResource extends ServerResource {
	protected ICommand command;
	protected BaseResult baseResult;
	protected Form queryForm;
	private int userId;
	private TastyService tastyService;
	private TastyConfigAction tastyConfigAction;
	protected HttpServletRequest request;

	public TastyService getTastyService() {
		return tastyService;
	}

	public void setTastyService(TastyService tastyService) {
		this.tastyService = tastyService;
	}

	public TastyConfigAction getTastyConfigAction() {
		return tastyConfigAction;
	}

	@Autowired
	public void setTastyConfigAction(TastyConfigAction tastyConfigAction) {
		this.tastyConfigAction = tastyConfigAction;
	}

	@Override
	protected void doInit() throws ResourceException {
		baseResult = null;
		// query
		queryForm = getRequest().getResourceRef().getQueryAsForm();

		request = ServletCall.getRequest(getRequest());

		command.setAuth(RequestUtils.requestPropertyValue(queryForm, "auth", ""));
		command.setFormat(RequestUtils.requestPropertyValue(queryForm, "format", "json"));
		command.setMethod(RequestUtils.requestPropertyValue(queryForm, "method", ""));
		command.setAction(RequestUtils.requestPropertyValue(queryForm, "action", ""));
		command.setTimestamp(DateHelper.stringToDate(RequestUtils.requestPropertyValue(queryForm, "timestamp")));
		command.setUserId(RequestUtils.requestPropertyIntValue(queryForm, "userId", 0));
		command.setType(RequestUtils.requestPropertyValue(queryForm, "type", ""));
		command.setOperate(RequestUtils.requestPropertyValue(queryForm, "operate", ""));
		command.setIp(RequestUtils.getIpAddr(request));
		String userId_ = (String) getRequestAttributes().get("userId");
		if (userId_ != null && userId_.length() > 0)
			userId = Integer.valueOf(userId_);
		else
			userId = 0;
		if (userId > 0 && userId != command.getUserId()) {
			// forbidden
			this.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
		}
		initQueryForm();
	}

	protected BaseResult getBaseResult() {
		if (baseResult == null) {
			baseResult = new BaseResult();
			baseResult.setCommand(command);
		}
		return baseResult;
	}

	protected StatusResult getStatusResult(int status, String msg) {
		StatusResult statusResult = new StatusResult();
		statusResult.setCommand(command);
		statusResult.setStatus(status);
		statusResult.setMsg(msg);
		return statusResult;
	}

	protected StatusResult getStatusResult(int status) {
		StatusResult statusResult = new StatusResult();
		statusResult.setCommand(command);
		statusResult.setStatus(status);
		return statusResult;
	}

	protected abstract void initQueryForm();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public TastyEntity fillterEntity(TastyEntity entity, String jsonPropsFilter) {
		if (entity == null)
			return entity;
		entity.setJsonPropsFilter(jsonPropsFilter);
		return entity;
	}

	public String getAppHost() {
		System.out.println("1" + this.getRequest().getRootRef().getScheme());
		System.out.println(this.getRequest().getResourceRef().getAuthority());
		String url = this.getRequest().getRootRef().getScheme() + "://" + this.getRequest().getRootRef().getAuthority()
				+ this.getRequest().getRootRef().getPath();
		return url;
	}

	// @Post
	// public Representation post(Representation entity) throws
	// ResourceException {
	// return get();
	// }
	//
	// @Put
	// public Representation put(Representation entity) throws ResourceException
	// {
	// return get();
	// }
	//	
	// @Delete
	// public Representation delete() throws ResourceException {
	// return get();
	// }
}
