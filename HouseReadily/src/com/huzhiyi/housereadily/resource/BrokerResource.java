package com.huzhiyi.housereadily.resource;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.IBrokerService;
import com.huzhiyi.housereadily.request.CustomerCommand;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;

public class BrokerResource extends BaseResource {

	private static final String SOUFUN = "soufun";

	@Override
	protected void doInit() throws ResourceException {
		command = new CustomerCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
	}

	public CustomerCommand getCommand() {
		return (CustomerCommand) command;
	}

	private Representation souFun() {
		boolean result = brokerService.executeSouFun();
		return JsonHelper.getJson(getStatusResult(1, result ? Configuration.SUBMIT_SUCCESS : Configuration.SUBMIT_FAILURE));
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;

		if (SOUFUN.equals(command.getAction())) {
			representation = souFun();
		}

		return representation;
	}

	@Post
	@Override
	public Representation post(Representation entity) throws ResourceException {
		Representation representation = null;
		Form form = new Form(entity);
		initData(form);

		return representation;
	}

	private IBrokerService brokerService;

	public IBrokerService getBrokerService() {
		return brokerService;
	}

	public void setBrokerService(IBrokerService brokerService) {
		this.brokerService = brokerService;
	}
}
