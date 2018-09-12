package com.huzhiyi.housereadily.biz.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.huzhiyi.housereadily.biz.IOperateLogService;
import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.OperateLog;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.utils.RequestUtils;

public class OperateLogServiceImpl extends AbstractOperateLogServiceImpl implements IOperateLogService {

	@Override
	public OperateLog add(Integer userId, String ip, String operate, Integer type, String description, Timestamp createTime) {
		OperateLog operateLog = new OperateLog();
		operateLog.setUserId(userId);
		operateLog.setIp(ip);
		operateLog.setTerminal(operate);
		operateLog.setType(type); // 1：新增房源，2：修改房源，3：删除房源，4：新增客源，5：修改客源，6：删除客源
		operateLog.setDescription(description);
		operateLog.setCreater(userId);
		operateLog.setCreateTime(null != createTime ? createTime : new Timestamp(System.currentTimeMillis()));
		super.add(operateLog);

		return operateLog;
	}

	@Override
	public List<OperateLog> findPaging(Integer id, String userName, Integer regSource, String terminal, Integer type, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean, boolean isRequestIpAddress) {
		List<OperateLog> operateLogs = getOperateLogDAO().findPaging(id, userName, regSource, terminal, type, beginDate, endDate, sort,
				dir, pagingBean);
		for (OperateLog operateLog : operateLogs) {
			initOperateLogForeignValue(operateLog, isRequestIpAddress);
		}
		return operateLogs;
	}

	@Override
	public OperateLog findById(Integer id) {
		OperateLog operateLog = super.findById(id);
		initOperateLogForeignValue(operateLog, true);
		return operateLog;
	}

	private void initOperateLogForeignValue(OperateLog operateLog, boolean isRequestIpAddress) {
		if (null != operateLog) {
			Integer operateLogId = operateLog.getId();

			CUser user = userDAO.findById(operateLog.getUserId());
			if (isRequestIpAddress) {
				operateLog.setIpAddress(RequestUtils.getIpAddress(operateLog.getIp()));
			}
			operateLog.setUserName(user.getName());
			operateLog.setRegSource(user.getRegSource());
		}
	}

	private IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
}