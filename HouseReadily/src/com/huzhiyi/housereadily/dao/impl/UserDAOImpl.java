package com.huzhiyi.housereadily.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.huzhiyi.housereadily.dao.IUserDAO;
import com.huzhiyi.housereadily.entity.UserTrend;
import com.huzhiyi.housereadily.model.CUser;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.Constants;

public class UserDAOImpl extends AbstractUserDAOImpl implements IUserDAO {

	/**
	 * (非 Javadoc)
	 * 
	 * @Title: verify
	 * @Description: TODO(登录校验)
	 *               <p>
	 * @author willter
	 * @date 2012-10-29
	 *       <p>
	 * @param user
	 * @return
	 * @see com.huzhiyi.housereadily.dao.IUserDAO#verify(com.huzhiyi.housereadily.model.CUser)
	 */
	public CUser verify(CUser user) {
		//String hql = "select o from com.huzhiyi.housereadily.model.CUser o where (o.name=? or o.email=? or o.mobile=?) and o.passwd=?";
		String hql = "select o from com.huzhiyi.housereadily.model.CUser o where o.name=? and o.passwd=?";
		CUser user$ = (CUser) super.findByHQL(hql, user.getName(), user.getPasswd()).getUniqueResult();
		if (user$ == null) {
			hql = "select o from com.huzhiyi.housereadily.model.CUser o where o.mobile=? and o.passwd=?";
			List<CUser> userList = super.findByHQL(hql, user.getName(), user.getPasswd()).getList();
			if (!userList.isEmpty() && userList.size() == 1) {
				user$ = userList.get(0);
			}
		}
		return user$;
	}
	
	@Override
	public List<CUser> findByMobileAndPassword(String mobile, String password) {
		String hql = "select o from com.huzhiyi.housereadily.model.CUser o where o.mobile=? and o.passwd=?";
		return super.findByHQL(hql, mobile, password).getList();
	}

	@Override
	public Integer countByEmail(String email) {
		String hql = "select count(*) from com.huzhiyi.housereadily.model.CUser o where o.email = ?";
		return Integer.parseInt(super.findByHQL(hql, email).getUniqueResult().toString());
	}

	@Override
	public Integer countByUsername(String username) {
		String hql = "select count(*) from com.huzhiyi.housereadily.model.CUser o where o.name = ?";
		return Integer.parseInt(super.findByHQL(hql, username).getUniqueResult().toString());
	}
	
	@Override
	public CUser findByNameAndMobile(String username, String mobile) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.model.CUser o where 1 = 1");
		if (StringUtils.isNotEmpty(username)) {
			hql.append(" and o.name = '").append(username).append("'");
		}
		if (StringUtils.isNotEmpty(mobile)) {
			hql.append(" and o.mobile = '").append(mobile).append("'");
		}
		List<CUser> userList = findByHQL(hql.toString()).getList();
		if (!userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public List<CUser> findPaging(Integer id, String userName, Integer regSource, Integer cityCode, String mobile, String email, Date beginDate,
			Date endDate, String sort, String dir, PagingBean pagingBean, boolean isSelectUserExt) {
		StringBuffer countHql = new StringBuffer("");
		StringBuffer hql = new StringBuffer("");
		StringBuffer hql_1 = new StringBuffer("select * from users o where o.regSource = 2");
		StringBuffer hql_2 = new StringBuffer("select distinct o.* from readily_systemlog s inner join users o on (s.creater = o.id) where s.type = 1 and (o.regSource = 1 or o.regSource is null)");
		StringBuffer filter = new StringBuffer("");
		StringBuffer order = new StringBuffer("");
		StringBuffer nhql = new StringBuffer("");
		if (isSelectUserExt) {
			nhql.append("select o from com.huzhiyi.housereadily.model.CUser o, com.huzhiyi.housereadily.entity.UserExt ext where o.id = ext.userId and o.id in (");
		} else {
			nhql.append("select o from com.huzhiyi.housereadily.model.CUser o where o.id in (");
		}
		
		// 过滤条件
		if (null != id && id > 0) {
			filter.append(" and o.id = ").append(id);
		}
		if (StringUtils.isNotEmpty(userName)) {
			filter.append(" and o.name like '%").append(userName).append("%'");
		}
		if (null != regSource && regSource > 0) {
			if (regSource == 1) {
				filter.append(" and o.regSource is null or o.regSource = ").append(regSource);
			} else if (regSource == 2) {
				filter.append(" and o.regSource = ").append(regSource);
			}
		}
		if (null != cityCode && cityCode > 0) {
			filter.append(" and o.cityCode = ").append(cityCode);
		}
		if (StringUtils.isNotEmpty(mobile)) {
			filter.append(" and o.mobile like '%").append(mobile).append("%'");
		}
		if (StringUtils.isNotEmpty(email)) {
			filter.append(" and o.email like '%").append(email).append("%'");
		}
		if (null != beginDate) {
			filter.append(" and o.regDate >= '").append(DateUtils.format(beginDate, Constants.DATEFORMAT)).append("'");
		}
		if (null != endDate) {
			filter.append(" and o.regDate < '").append(
					DateUtils.format(DateUtils.addDate(endDate, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT)).append("'");
		}
		
		// 排序条件
		if (StringUtils.isNotEmpty(sort) && StringUtils.isNotEmpty(dir) && isSelectUserExt) {
			if ("houseReadilyCount".equals(sort) || "customerCount".equals(sort) || "level".equals(sort) || "growing".equals(sort) || "integration".equals(sort)) {
				order.append(" order by ext.").append(sort).append(" ").append(dir);
			} else {
				order.append(" order by ").append(sort).append(" ").append(dir);
			}
		} else {
			order.append(" order by regDate desc");
		}

		// 组装hql语句
		hql_1.append(filter);
		hql_2.append(filter);
		
		/*********总行数查询********/
		countHql.append("select count(t.id) from (").append(hql_1).append(" union all ").append(hql_2).append(") t");//.append(order);
		
		/**********结果查询********/
		hql.append("select t.id from (");
		// 租售365用户
		hql.append(hql_1);
		// union all
		hql.append(" union all ");
		// 随手房用户
		hql.append(hql_2);
		hql.append(") t");
		// 用户扩展表
		if (isSelectUserExt) {
			hql.append(" left join readily_userext ext on (t.id = ext.userId)");
		}
		// 排序条件
		hql.append(order);
		
		// 查询
		Query countQuery = this.getSession().createSQLQuery(countHql.toString());
		Long cnt = ((java.math.BigInteger) countQuery.uniqueResult()).longValue();
		int inCnt = cnt.intValue();
		if (inCnt == 0) {
			return new ArrayList<CUser>();
		}
		pagingBean.setMaxRows(inCnt);

		Query sqlQuery = this.getSession().createSQLQuery(hql.toString());
		sqlQuery.setFirstResult(pagingBean.getBeginRow());
		sqlQuery.setMaxResults(pagingBean.getPageRows());

		StringBuilder sb = new StringBuilder(nhql);
		List<Object> idList = sqlQuery.list();
		int size = idList.size();
		for (int i = 0; i < size; i++) {
			sb.append("?,");
		}

		int len = sb.length();
		sb.replace(len - 1, len, ")");
		sb.append(order); // 加入排序条件
		final Query q = createQuery(sb.toString());
		int i = 0;
		for (Object id$ : idList) {
			q.setParameter(i++, id$);
		}
		return q.list();
	}
	
	@Override
	public List<Object> export(Integer id, String userName, Integer regSource, Integer cityCode, String mobile, String email, Date beginDate, Date endDate,
			String sort, String dir) {
		StringBuffer hql = new StringBuffer("");
		StringBuffer hql_1 = new StringBuffer("select mobile from users o where o.regSource = 2");
		StringBuffer hql_2 = new StringBuffer("select distinct o.mobile from readily_systemlog s inner join users o on (s.creater = o.id) where s.type = 1 and (o.regSource = 1 or o.regSource is null)");
		StringBuffer filter = new StringBuffer("");
		StringBuffer order = new StringBuffer("");
		
		// 过滤条件
		if (null != id && id > 0) {
			filter.append(" and o.id = ").append(id);
		}
		if (StringUtils.isNotEmpty(userName)) {
			filter.append(" and o.name like '%").append(userName).append("%'");
		}
		if (null != regSource && regSource > 0) {
			if (regSource == 1) {
				filter.append(" and o.regSource is null or o.regSource = ").append(regSource);
			} else if (regSource == 2) {
				filter.append(" and o.regSource = ").append(regSource);
			}
		}
		if (null != cityCode && cityCode > 0) {
			filter.append(" and o.cityCode = ").append(cityCode);
		}
		if (StringUtils.isNotEmpty(mobile)) {
			filter.append(" and o.mobile like '%").append(mobile).append("%'");
		}
		if (StringUtils.isNotEmpty(email)) {
			filter.append(" and o.email like '%").append(email).append("%'");
		}
		if (null != beginDate) {
			filter.append(" and o.regDate >= '").append(DateUtils.format(beginDate, Constants.DATEFORMAT)).append("'");
		}
		if (null != endDate) {
			filter.append(" and o.regDate < '").append(
					DateUtils.format(DateUtils.addDate(endDate, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT)).append("'");
		}
		
		// 排序条件
		order.append(" order by regDate desc");

		// 组装hql语句
		hql_1.append(filter);
		hql_2.append(filter);
		
		/**********结果查询********/
		hql.append("select distinct t.mobile from (");
		// 租售365用户
		hql.append(hql_1);
		// union all
		hql.append(" union all ");
		// 随手房用户
		hql.append(hql_2);
		hql.append(") t;");
		
		// 查询
		Query sqlQuery = this.getSession().createSQLQuery(hql.toString());

		List<Object> mobileList = sqlQuery.list();
		
		return mobileList;
	}
	
	public List<UserTrend> findByUserTrend(Date createTime) throws Exception {
		StringBuffer hql = new StringBuffer();
		
		hql.append(getUserTrendSql(createTime));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -1)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -2)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -3)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -4)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -5)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -6)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -7)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -8)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -9)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -10)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -11)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -12)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -13)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -14)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -15)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -16)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -17)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -18)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -19)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -20)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -21)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -22)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -23)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -24)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -25)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -26)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -27)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -28)));
		hql.append(" union all \n");
		hql.append(getUserTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -29)));
		hql.append(";");
		
		Query sqlQuery = this.getSession().createSQLQuery(hql.toString());
		
		List<Object[]> list = sqlQuery.list();
		List<UserTrend> userTrendList = new ArrayList<UserTrend>(list.size());
		Object[] objArray = null;
		UserTrend userTrend = null;
		for (int i = 0, size = list.size(); i < size; i++) {
			objArray = (Object[]) list.get(i);
			userTrend = new UserTrend();
			userTrend.setCreateTime(new Timestamp(DateUtils.parse(objArray[0].toString(), Constants.DATEFORMAT).getTime()));
			userTrend.setActiveCount(Integer.parseInt(objArray[1].toString()));
			userTrend.setLoginCount(Integer.parseInt(objArray[2].toString()));
			userTrend.setRegisterCount(Integer.parseInt(objArray[3].toString()));
			userTrend.setHouseReadilyCount(Integer.parseInt(objArray[4].toString()));
			userTrend.setCustomerCount(Integer.parseInt(objArray[5].toString()));
			userTrend.setHouseFollowCount(Integer.parseInt(objArray[6].toString()));
			userTrendList.add(userTrend);
		}
		
		return userTrendList;
	}
	
	private String getUserTrendSql(Date createTime) {
		/*select * from (select 
		(select count(*) from (select userId from readily_operatelog where createTime < '2013-06-07' and createTime > '2013-05-31' group by (userId)) a) as l1,
		(select count(*) from (select userId from readily_systemlog where createTime < '2013-06-07' and createTime > '2013-06-06' and type = 1 group by (userId)) a) as l2,
		(select count(*) from (select userId from readily_systemlog where createTime < '2013-06-07' and createTime > '2013-06-06' and type = 2 group by (userId)) a) as l3,
		(select count(*) from readily_housereadily where updateTime < '2013-06-07' and updateTime > '2013-06-06') as l4,
		(select count(*) from readily_customer where updateTime < '2013-06-07' and updateTime > '2013-06-06') as l5,
		(select count(*) from readily_housefollow where createTime < '2013-06-07' and createTime > '2013-06-06') as l6
		) b;*/
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("select * from (select ");
		
		// 日期
		hql.append("'").append(DateUtils.format(createTime, Constants.DATEFORMAT)).append("' as createTime,");
		
		// 活跃数
		hql.append("(select count(*) from (select userId from readily_operatelog where createTime > '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -6), Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' group by (userId)) a) as activeCount,");
		
		// 登录数
		hql.append("(select count(*) from (select userId from readily_systemlog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and type = 1 group by (userId)) a) as loginCount,");
		
		// 注册数
		hql.append("(select count(*) from (select userId from readily_systemlog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and type = 2 group by (userId)) a) as registerCount,");
		
		// 房源数
		hql.append("(select count(*) from readily_housereadily where updateTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and updateTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("') as houseReadilyCount,");
		
		// 客源数
		hql.append("(select count(*) from readily_customer where updateTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and updateTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("') as customerCount,");
		
		// 跟进数
		hql.append("(select count(*) from readily_housefollow where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("') as houseFollowCount");
		
		hql.append(") b\n");
		
		return hql.toString();
	}
}