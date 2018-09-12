package com.huzhiyi.housereadily.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.huzhiyi.housereadily.dao.IBaseGroupDAO;
import com.huzhiyi.housereadily.entity.BaseGroup;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Constants;

public class BaseGroupDAOImpl extends AbstractBaseGroupDAOImpl implements IBaseGroupDAO {

	@Override
	public List<BaseGroup> findPaging(Integer userId, String sort, String dir, PagingBean pagingBean) throws Exception {
		StringBuffer hql = new StringBuffer();
		StringBuffer countHql = new StringBuffer();

		hql.append("select b.id, b.level, b.groupNum, b.groupName, b.acement, b.description, b.memberCount, b.houseReadilyCount, b.customerCount, ");
		hql.append("b.cityCode, b.bigAreaCode, b.smallAreaCode, b.syncTime, b.version, b.creater, b.createTime ");
		hql.append("from readily_basegroup b inner join readily_membergroup m on (b.id = m.baseGroupId) where m.userId = '");
		hql.append(userId).append("' and b.isDelete = 1 and m.isDelete = 1 order by m.createTime desc");

		countHql.insert(0, "select count(*) from (").append(hql).append(") t");

		Query countQuery = this.getSession().createSQLQuery(countHql.toString());
		Long cnt = ((java.math.BigInteger) countQuery.uniqueResult()).longValue();
		int inCnt = cnt.intValue();
		if (inCnt == 0) {
			return new ArrayList<BaseGroup>();
		}
		pagingBean.setMaxRows(inCnt);

		Query sqlQuery = this.getSession().createSQLQuery(hql.toString());
		sqlQuery.setFirstResult(pagingBean.getBeginRow());
		sqlQuery.setMaxResults(pagingBean.getPageRows());

		List<Object[]> list = sqlQuery.list();
		List<BaseGroup> baseGroupList = new ArrayList<BaseGroup>(list.size());
		Object[] objArray = null;
		BaseGroup baseGroup = null;
		for (int i = 0, size = list.size(); i < size; i++) {
			objArray = (Object[]) list.get(i);
			baseGroup = new BaseGroup();
			baseGroup.setId(Integer.parseInt(objArray[0].toString()));
			baseGroup.setLevel(Integer.parseInt(objArray[1].toString()));
			baseGroup.setGroupNum(objArray[2].toString());
			baseGroup.setGroupName(objArray[3].toString());
			baseGroup.setAcement(objArray[4].toString());
			baseGroup.setDescription(objArray[5].toString());
			baseGroup.setMemberCount(Integer.parseInt(objArray[6].toString()));
			baseGroup.setHouseReadilyCount(Integer.parseInt(objArray[7].toString()));
			baseGroup.setCustomerCount(Integer.parseInt(objArray[8].toString()));
			baseGroup.setCityCode(Integer.parseInt(objArray[9].toString()));
			baseGroup.setBigAreaCode(Integer.parseInt(objArray[10].toString()));
			baseGroup.setSmallAreaCode(Integer.parseInt(objArray[11].toString()));
			baseGroup.setSyncTime(new Timestamp(DateUtils.parse(objArray[12].toString(), Constants.DATEFORMAT).getTime()));
			baseGroup.setVersion(objArray[13].toString());
			baseGroup.setCreater(Integer.parseInt(objArray[14].toString()));
			baseGroup.setCreateTime(new Timestamp(DateUtils.parse(objArray[15].toString(), Constants.DATEFORMAT).getTime()));
			baseGroupList.add(baseGroup);
		}

		return baseGroupList;
	}

	@Override
	public Integer findCountByUserId(Integer userId) {
		String hql = "select count(*) from com.huzhiyi.housereadily.entity.BaseGroup o where o.isDelete = 1 and o.creater = ?";
		return Integer.parseInt(super.findByHQL(hql, userId).getUniqueResult().toString());
	}

	@Override
	public BaseGroup findByGroupNum(String groupNum) {
		String hql = "select o from com.huzhiyi.housereadily.entity.BaseGroup o where o.isDelete = 1 and o.groupNum = ?";
		return (BaseGroup) super.findByHQL(hql, groupNum).getUniqueResult();
	}

	@Override
	public List<BaseGroup> findPaging(Integer id, Integer level, String groupNum, String groupName, Integer cityCode, Integer bigAreaCode,
			Integer smallAreaCode, String userName, Date beginDate, Date endDate, Integer isDelete, String sort, String dir, PagingBean pagingBean ){
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.BaseGroup o where 1 = 1");
		if (null != id && id > 0) {
			hql.append(" and o.id = ").append(id);
		}
		if (null != level && level > 0 ){
			hql.append(" and o.level = ").append(level);
		}
		if (!StringUtils.isEmpty(groupNum)) {
			hql.append(" and o.groupNum like '%").append(groupNum).append("%'");
		}
		if (!StringUtils.isEmpty(groupName)) {
			hql.append(" and o.groupName like '%").append(groupName).append("%'");
		}
		if (null != cityCode && cityCode > 0) {
			hql.append(" and o.cityCode = ").append(cityCode);
		}
		if (null != bigAreaCode && bigAreaCode > 0) {
			hql.append(" and o.bigAreaCode = ").append(bigAreaCode);
		}
		if (null != smallAreaCode && smallAreaCode > 0) {
			hql.append(" and o.smallAreaCode = ").append(smallAreaCode);
		}
		if (StringUtils.isNotEmpty(userName)) {
			hql.append(" and o.creater in (select u.id from com.huzhiyi.housereadily.model.CUser u where u.name like '%").append(userName)
					.append("%')");
		}
		if (null != beginDate) {
			hql.append(" and o.createTime >= '").append(DateUtils.format(beginDate, Constants.DATEFORMAT)).append("'");
		}
		if (null != endDate) {
			hql.append(" and o.createTime < '").append(
					DateUtils.format(DateUtils.addDate(endDate, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT)).append("'");
		}
		if (null != isDelete && isDelete > -1) {
			hql.append(" and o.isDelete = ").append(isDelete);
		}
		if (StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(dir)) {
			hql.append(" order by o.").append(sort).append(" ").append(dir);
		} else {
			hql.append(" order by o.createTime desc");
		}

		return super.findPaging(hql.toString(), pagingBean);
		
	}
}