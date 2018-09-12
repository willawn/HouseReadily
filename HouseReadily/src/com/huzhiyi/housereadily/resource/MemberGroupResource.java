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

import com.huzhiyi.housereadily.biz.IBaseGroupService;
import com.huzhiyi.housereadily.biz.IMemberGroupService;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.housereadily.entity.MemberGroup;
import com.huzhiyi.housereadily.request.MemberGroupCommand;
import com.huzhiyi.housereadily.response.BaseGroupListResult;
import com.huzhiyi.housereadily.response.MemberGroupListResult;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.Configuration;
import com.huzhiyi.utils.Constants;
import com.huzhiyi.utils.JsonHelper;
import com.huzhiyi.utils.RequestUtils;
import com.huzhiyi.utils.ResponseUtils;

public class MemberGroupResource extends BaseResource {

	private static final String LIST = "list";
	private static final String QUITGROUP = "quitgroup";

	@Override
	protected void doInit() throws ResourceException {
		command = new MemberGroupCommand();
		super.doInit();
	}

	@Override
	protected void initQueryForm() {
		initData(queryForm);
	}

	private void initData(Form form) {
		getCommand().setId(RequestUtils.requestPropertyIntValue(form, "id"));
		getCommand().setBaseGroupId(RequestUtils.requestPropertyIntValue(form, "baseGroupId"));
		getCommand().setPageNo(cpn(RequestUtils.requestPropertyIntValue(form, "pageNo")));
		getCommand().setPageSize(cps(RequestUtils.requestPropertyIntValue(form, "pageSize")));
	}

	public MemberGroupCommand getCommand() {
		return (MemberGroupCommand) command;
	}

	private void initData(List memberGroupList, PagingBean pagingBean, MemberGroupListResult memberGroupListResult) {
		Map parseDataKey = new HashMap();
		parseDataKey.put(Constants.PARSEDATEKEY, new String[] { "syncTime", "createTime" });
		JSONObject memberGroups = ResponseUtils.getJSONByPagingBean(pagingBean, memberGroupList, parseDataKey, "id", "baseGroupId",
				"roleType", "userId", "userName", "realName", "cityCode", "cityEn", "cityName", "avatar", "mobile", "email", "syncTime",
				"version", "createTime");

		memberGroupListResult.setCommand(command);
		memberGroupListResult.setMemberGroups(memberGroups);
	}

	private Representation list() {
		MemberGroupListResult memberGroupListResult = new MemberGroupListResult();
		Integer pageNo = getCommand().getPageNo();
		Integer pageSize = getCommand().getPageSize();

		PagingBean pagingBean = new PagingBean();
		pagingBean.setCurrentPage(pageNo);
		pagingBean.setPageRows(pageSize);

		MemberGroupCommand memberGroupCommand = (MemberGroupCommand) command;
		Integer userId = memberGroupCommand.getUserId();
		Integer baseGroupId = memberGroupCommand.getBaseGroupId();

		// 查找群是否存在
		BaseGroup baseGroup = baseGroupService.findById(baseGroupId);
		if (null == baseGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_BASEGROUP_NUM));
		}

		// 判断群是否存在这个用户
		boolean isExits = memberGroupService.exitsMemberGroup(baseGroupId, userId);
		if (!isExits) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_MEMBERGROUP));
		}

		List<MemberGroup> memberGroupList = null;
		try {
			memberGroupList = memberGroupService.findPaging(baseGroupId, null, null, pagingBean);
		} catch (Exception e) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.SELECT_FAILURE));
		}

		memberGroupListResult.setStatus(1);

		initData(memberGroupList, pagingBean, memberGroupListResult);

		return JsonHelper.getJson(memberGroupListResult);
	}

	/**
	 * @Title: quitgroup
	 * @Description: 群成员退出群
	 *               <p>
	 * @author willter
	 * @date 2013-8-16
	 *       <p>
	 * @return
	 */
	private Representation quitgroup() {
		MemberGroupCommand memberGroupCommand = (MemberGroupCommand) command;
		Integer userId = memberGroupCommand.getUserId();
		Integer baseGroupId = memberGroupCommand.getBaseGroupId();

		// 查找群是否存在
		BaseGroup baseGroup = baseGroupService.findById(baseGroupId);
		if (null == baseGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_BASEGROUP_NUM));
		}

		// 判断群是否存在这个用户
		boolean isExits = memberGroupService.exitsMemberGroup(baseGroupId, userId);
		if (!isExits) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_MEMBERGROUP));
		}

		// 判断当前用户是否是群主，如果是群主不能执行退出群操作，只能执行解散群操作
		if (userId.equals(baseGroup.getCreater())) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.CANNOT_QUITGROUP_CREATER_LOG));
		}

		// 退出群
		try {
			memberGroupService.deleteQuitGroup(command);
		} catch (Exception e) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.QUITGROUP_FAILURE));
		}

		return JsonHelper.getJson(getStatusResult(1, Configuration.QUITGROUP_SUCCESS));
	}

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: delete
	 * @Description: TODO(群主移除群成员)
	 *               <p>
	 * @author willter
	 * @date 2013-8-16
	 *       <p>
	 * @return
	 * @throws ResourceException
	 * @see org.restlet.resource.ServerResource#delete()
	 */
	@Delete
	@Override
	public Representation delete() throws ResourceException {
		MemberGroupCommand memberGroupCommand = (MemberGroupCommand) command;
		Integer id = memberGroupCommand.getId();

		// 查找群成员是否存在
		MemberGroup memberGroup = memberGroupService.findById(id);
		if (null == memberGroup) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_MEMBERGROUP));
		}

		// 判断群是否存在这个用户
		boolean isExits = memberGroupService.exitsMemberGroup(memberGroup.getBaseGroupId(), memberGroup.getUserId());
		if (!isExits) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.NOT_FIND_MEMBERGROUP));
		}

		// 判断删除人是否是群主
		BaseGroup baseGroup = baseGroupService.findById(memberGroup.getBaseGroupId());
		Integer userId = memberGroupCommand.getUserId();
		if (!userId.equals(baseGroup.getCreater())) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.UPDATER_NOTEQUALS_CREATER));
		}

		// 移除群成员
		try {
			memberGroupService.delete(command);
		} catch (Exception e) {
			return JsonHelper.getJson(getStatusResult(0, Configuration.DELETE_FAILURE));
		}

		return JsonHelper.getJson(getStatusResult(1, Configuration.DELETE_SUCCESS));
	}

	@Get
	@Override
	public Representation get() throws ResourceException {
		Representation representation = null;

		if (LIST.equals(command.getAction())) {
			representation = list();
		} else if (QUITGROUP.equals(command.getAction())) {
			representation = quitgroup();
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

	private IMemberGroupService memberGroupService;
	private IBaseGroupService baseGroupService;

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
