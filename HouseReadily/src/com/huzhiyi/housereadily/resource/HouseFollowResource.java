package com.huzhiyi.housereadily.resource;

import static com.huzhiyi.model.PagingBean.cpn;
import static com.huzhiyi.model.PagingBean.cps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import com.huzhiyi.housereadily.biz.IHouseFollowService;
import com.huzhiyi.housereadily.entity.HouseFollow;
import com.huzhiyi.housereadily.request.HouseFollowCommand;
import com.huzhiyi.housereadily.response.HouseFollowListResult;
import com.huzhiyi.housereadily.response.HouseFollowResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class HouseFollowResource extends BaseResource {

	private static final String ADD = "add";
	private static final String LIST = "list";
	private static final String FIND = "find";

	@Override
	protected void doInit() throws ResourceException {
		command = new HouseFollowCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
		getCommand().setHouseReadilyId(RequestUtils.requestPropertyIntValue(form, "houseReadilyId"));
		getCommand().setCustomerId(RequestUtils.requestPropertyIntValue(form, "customerId"));
		getCommand().setCtype(RequestUtils.requestPropertyIntValue(form, "ctype"));
		getCommand().setMode(RequestUtils.requestPropertyIntValue(form, "mode"));
		getCommand().setDescription(RequestUtils.requestPropertyValue(form, "description", ""));
		getCommand().setIds(RequestUtils.requestPropertyValue(form, "ids", ""));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
	}

	public HouseFollowCommand getCommand() {
		return (HouseFollowCommand) command;
	}

	private Representation add() {
		HouseFollowResult houseFollowResult = new HouseFollowResult();
		HouseFollow houseFollow = houseFollowService.add(command);

		houseFollowResult.setStatus(1);
		houseFollowResult.setMsg(Configuration.SUBMIT_SUCCESS);
		houseFollowResult.setCommand(command);
		houseFollowResult.setId(houseFollow.getId());
		houseFollowResult.setHouseReadilyId(houseFollow.getHouseReadilyId());
		houseFollowResult.setCustomerId(houseFollow.getCustomerId());
		houseFollowResult.setMode(houseFollow.getMode());
		houseFollowResult.setDescription(houseFollow.getDescription());
		houseFollowResult.setCreater(houseFollow.getCreater());
		houseFollowResult.setCreateTime(houseFollow.getCreateTime());

		return JsonHelper.getJson(houseFollowResult);
	}

	private Representation list() {
		HouseFollowListResult houseFollowListResult = new HouseFollowListResult();
		Integer houseReadilyId = getCommand().getHouseReadilyId();
		Integer customerId = getCommand().getCustomerId();
		Integer ctype = getCommand().getCtype();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();

		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		List houseFollowList = houseFollowService.findPaging(houseReadilyId, customerId, ctype, pagingBean);

		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "createTime" });
		JSONObject houseFollows = ResponseUtils.getJSONByPagingBean(pagingBean, houseFollowList, parseDataKey, "id", "houseReadilyId",
				"projectId", "projectName", "title", "building", "houseNum", "customerId", "ctype", "customerName", "gender", "phone",
				"mobile", "mode", "description", "creater", "createTime");

		houseFollowListResult.setCommand(command);
		houseFollowListResult.setHouseFollows(houseFollows);
		return JsonHelper.getJson(houseFollowListResult);
	}

	private Representation find() {
		HouseFollowResult houseFollowResult = new HouseFollowResult();
		Integer id = getCommand().getId();
		HouseFollow houseFollow = houseFollowService.findById(id);
		houseFollowResult.setCommand(command);
		houseFollowResult.setId(houseFollow.getId());
		houseFollowResult.setHouseReadilyId(houseFollow.getHouseReadilyId());
		houseFollowResult.setCustomerId(houseFollow.getCustomerId());
		houseFollowResult.setMode(houseFollow.getMode());
		houseFollowResult.setDescription(houseFollow.getDescription());
		houseFollowResult.setCreater(houseFollow.getCreater());
		houseFollowResult.setCreateTime(houseFollow.getCreateTime());

		return JsonHelper.getJson(houseFollowResult);
	}
	
	@Delete
	@Override
	public Representation delete() throws ResourceException {
		String ids = getCommand().getIds();
		houseFollowService.delete(ids);
		
		return JsonHelper.getJson(getStatusResult(1, Configuration.DELETE_SUCCESS));
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;
		if (LIST.equals(command.getAction())) {
			representation = list();
		} else if (FIND.equals(command.getAction())) {
			representation = find();
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

	private IHouseFollowService houseFollowService;

	public IHouseFollowService getHouseFollowService() {
		return houseFollowService;
	}

	public void setHouseFollowService(IHouseFollowService houseFollowService) {
		this.houseFollowService = houseFollowService;
	}
}
