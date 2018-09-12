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

import com.huzhiyi.housereadily.biz.IAuditMemberGroupService;
import com.huzhiyi.housereadily.biz.IBaseGroupService;
import com.huzhiyi.housereadily.biz.IMemberGroupService;
import com.huzhiyi.housereadily.entity.AuditMemberGroup;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.housereadily.request.AuditMemberGroupCommand;
import com.huzhiyi.housereadily.response.AuditMemberGroupListResult;
import com.huzhiyi.housereadily.response.AuditMemberGroupResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class AuditMemberGroupResource extends BaseResource {

	private static final String ADD = "add";
	private static final String LIST = "list";
	private static final String AUDIT = "audit";

	@Override
	protected void doInit() throws ResourceException {
		command = new AuditMemberGroupCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
		getCommand().setBaseGroupId(RequestUtils.requestPropertyIntValue(form, "baseGroupId"));
		getCommand().setDescription(RequestUtils.requestPropertyValue(form, "description", ""));
		getCommand().setIsPass(RequestUtils.requestPropertyIntValue(form, "isPass"));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
	}

	public AuditMemberGroupCommand getCommand() {
		return (AuditMemberGroupCommand) command;
	}

	private void initData(AuditMemberGroup auditMemberGroup, AuditMemberGroupResult auditMemberGroupResult) {
		auditMemberGroupResult.setCommand(command);
		auditMemberGroupResult.setId(auditMemberGroup.getId());
		auditMemberGroupResult.setBaseGroupId(auditMemberGroup.getBaseGroupId());
		auditMemberGroupResult.setGroupNum(auditMemberGroup.getGroupNum());
		auditMemberGroupResult.setGroupName(auditMemberGroup.getGroupName());
		auditMemberGroupResult.setUserId(auditMemberGroup.getUserId());
		auditMemberGroupResult.setUserName(auditMemberGroup.getUserName());
		auditMemberGroupResult.setRealName(auditMemberGroup.getRealName());
		auditMemberGroupResult.setDescription(auditMemberGroup.getDescription());
		auditMemberGroupResult.setIsPass(auditMemberGroup.getIsPass());
		auditMemberGroupResult.setIsRead(auditMemberGroup.getIsRead());
		auditMemberGroupResult.setAuditer(auditMemberGroup.getAuditer());
		auditMemberGroupResult.setAuditerName(auditMemberGroup.getAuditerName());
		auditMemberGroupResult.setAuditerRealName(auditMemberGroup.getAuditerRealName());
		auditMemberGroupResult.setAuditTime(auditMemberGroup.getAuditTime());
		auditMemberGroupResult.setCreateTime(auditMemberGroup.getCreateTime());
	}

	private void initData(List auditMemberGroupList, PagingBean pagingBean, AuditMemberGroupListResult auditMemberGroupListResult) {
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "auditTime", "createTime" });
		JSONObject auditMemberGroups = ResponseUtils.getJSONByPagingBean(pagingBean, auditMemberGroupList, parseDataKey, "id",
				"baseGroupId", "groupNum", "groupName", "userId", "userName", "realName", "cityCode", "cityEn", "cityName", "avatar",
				"mobile", "email", "description", "isPass", "isRead", "auditer", "auditerName", "auditerRealName", "auditTime",
				"createTime");

		auditMemberGroupListResult.setCommand(command);
		auditMemberGroupListResult.setAuditMemberGroups(auditMemberGroups);
	}

	private Representation add() {
		AuditMemberGroupResult auditMemberGroupResult = new AuditMemberGroupResult();

		Integer userId = getCommand().getUserId();
		Integer baseGroupId = getCommand().getBaseGroupId();

		// 查找群是否存在
		BaseGroup baseGroup = baseGroupService.findById(baseGroupId);
		if (null == baseGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_BASEGROUP_NUM));
		}

		// 判断群是否存在这个用户
		boolean isExits = memberGroupService.exitsMemberGroup(baseGroupId, userId);
		if (isExits) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.MEMBERGROUP_EXIST));
		}

		// 判断是否已经发送申请信息
		List auditMemberGroupList = null;
		try {
			auditMemberGroupList = auditMemberGroupService.findPaging(baseGroupId, userId, 0, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!auditMemberGroupList.isEmpty()) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.SEND_AUDIT_ALREADY));
		}

		// 当前每个群只能有10名群成员，后期会开放高级用户创建更多群成员功能
		List<MemberGroup> memberGroupList = memberGroupService.findByBaseGroupId(baseGroupId);
		Integer count = memberGroupList.size();
		if (count >= 10) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NORMAL_MEMBERGROUP_ADD_FAILURE));
		}

		AuditMemberGroup auditMemberGroup = null;
		try {
			auditMemberGroup = auditMemberGroupService.add(command);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SEND_AUDIT_FAILURE));
		}

		auditMemberGroupResult.setStatus(1);
		auditMemberGroupResult.setMsg(Configuration.SEND_AUDIT_SUCCESS);

		initData(auditMemberGroup, auditMemberGroupResult);

		return JsonHelper.getJson(auditMemberGroupResult);
	}

	private Representation audit() {
		AuditMemberGroupResult auditMemberGroupResult = new AuditMemberGroupResult();

		String result = auditMemberGroupService.updateAudit(command);
		if (StringUtils.isNotEmpty(result)) {
			return JsonHelper.getJson(getStatusResult(0, result));
		}

		AuditMemberGroupCommand auditMemberGroupCommand = (AuditMemberGroupCommand) command;
		Integer id = auditMemberGroupCommand.getId();
		AuditMemberGroup auditMemberGroup = auditMemberGroupService.findById(id);

		auditMemberGroupResult.setStatus(1);
		auditMemberGroupResult.setMsg(Configuration.AUDIT_SUCCESS);

		initData(auditMemberGroup, auditMemberGroupResult);

		return JsonHelper.getJson(auditMemberGroupResult);
	}

	private Representation list() {
		AuditMemberGroupListResult auditMemberGroupListResult = new AuditMemberGroupListResult();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();

		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);
		Integer userId = getCommand().getUserId();
		List auditMemberGroupList = null;
		try {
			auditMemberGroupList = auditMemberGroupService.findPaging(null, userId, null, "createTime", "desc", pagingBean);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonHelper.getJson(getStatusResult(0, Configuration.SELECT_FAILURE));
		}

		auditMemberGroupListResult.setStatus(1);

		initData(auditMemberGroupList, pagingBean, auditMemberGroupListResult);

		return JsonHelper.getJson(auditMemberGroupListResult);
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;

		if (LIST.equals(command.getAction())) {
			representation = list();
		} else if (AUDIT.equals(command.getAction())) {
			representation = audit();
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

	private IAuditMemberGroupService auditMemberGroupService;
	private IMemberGroupService memberGroupService;
	private IBaseGroupService baseGroupService;

	public IAuditMemberGroupService getAuditMemberGroupService() {
		return auditMemberGroupService;
	}

	public void setAuditMemberGroupService(IAuditMemberGroupService auditMemberGroupService) {
		this.auditMemberGroupService = auditMemberGroupService;
	}

	public IMemberGroupService getMemberGroupService() {
		return memberGroupService;
	}

	public void setMemberGroupService(IMemberGroupService memberGroupService) {
		this.memberGroupService = memberGroupService;
	}

	public IBaseGroupService getBaseGroupService() {
		return baseGroupService;
	}

	public void setBaseGroupService(IBaseGroupService baseGroupService) {
		this.baseGroupService = baseGroupService;
	}
}
