package com.huzhiyi.housereadily.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.huzhiyi.housereadily.dao.ITaskDAO;
import com.huzhiyi.housereadily.entity.Task;
import com.huzhiyi.housereadily.entity.TaskTrend;
import com.huzhiyi.housereadily.entity.TaskUserTrend;
import com.huzhiyi.model.PagingBean;
import com.huzhiyi.util.DateUtils;
import com.huzhiyi.utils.Constants;

public class TaskDAOImpl extends AbstractTaskDAOImpl implements ITaskDAO {

	@Override
	public List<Task> findAll(Integer isDisplay) {
		StringBuffer hql = new StringBuffer("select o from com.huzhiyi.housereadily.entity.Task o where isDisplay = ?");
		return super.findByHQL(hql.toString(), isDisplay).getList();
	}
	
	@Override
	public List<TaskTrend> findByTaskTrend(Date createTime) throws Exception {
		StringBuffer hql = new StringBuffer();
		
		hql.append(getTaskTrendSql(createTime));
		hql.append(" union all \n");
		hql.append(getTaskTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -1)));
		hql.append(" union all \n");
		hql.append(getTaskTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -2)));
		hql.append(" union all \n");
		hql.append(getTaskTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -3)));
		hql.append(" union all \n");
		hql.append(getTaskTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -4)));
		hql.append(" union all \n");
		hql.append(getTaskTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -5)));
		hql.append(" union all \n");
		hql.append(getTaskTrendSql(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, -6)));
		hql.append(";");
		
		Query sqlQuery = this.getSession().createSQLQuery(hql.toString());
		
		List<Object[]> list = sqlQuery.list();
		List<TaskTrend> taskTrendList = new ArrayList<TaskTrend>(list.size());
		Object[] objArray = null;
		TaskTrend taskTrend = null;
		for (int i = 0, size = list.size(); i < size; i++) {
			objArray = (Object[]) list.get(i);
			taskTrend = new TaskTrend();
			taskTrend.setCreateTime(new Timestamp(DateUtils.parse(objArray[0].toString(), Constants.DATEFORMAT).getTime()));
			taskTrend.setLoginTask(null != objArray[1] ? Integer.parseInt(objArray[1].toString()) : 0);
			taskTrend.setHouseReadilyTask(null != objArray[2] ? Integer.parseInt(objArray[2].toString()) : 0);
			taskTrend.setCustomerTask(null != objArray[3] ? Integer.parseInt(objArray[3].toString()) : 0);
			taskTrend.setShareSinaTask(null != objArray[4] ? Integer.parseInt(objArray[4].toString()) : 0);
			taskTrend.setShareTencentTask(null != objArray[5] ? Integer.parseInt(objArray[5].toString()) : 0);
			taskTrend.setShareWeiXinTask(null != objArray[6] ? Integer.parseInt(objArray[6].toString()) : 0);
			taskTrend.setShareQzoneTask(null != objArray[7] ? Integer.parseInt(objArray[7].toString()) : 0);
			taskTrendList.add(taskTrend);
		}
		
		return taskTrendList;
	}
	
	private String getTaskTrendSql(Date createTime) {
		/*select * from (select 
		(select sum(growing) from readily_tasklog where createTime > '2013-05-31' and createTime < '2013-06-07' and taskId = 4) as loginTask,
		(select sum(growing) from readily_tasklog where createTime > '2013-05-31' and createTime < '2013-06-07' and taskId = 5) as houseReadilyTask,
		(select sum(growing) from readily_tasklog where createTime > '2013-05-31' and createTime < '2013-06-07' and taskId = 6) as customerTask,
		(select sum(growing) from readily_tasklog where createTime > '2013-05-31' and createTime < '2013-06-07' and (taskId = 3 or taskId = 7) and shareType = 1) as shareSinaTask,
		(select sum(growing) from readily_tasklog where createTime > '2013-05-31' and createTime < '2013-06-07' and (taskId = 3 or taskId = 7) and shareType = 2) as shareTencentTask,
		(select sum(growing) from readily_tasklog where createTime > '2013-05-31' and createTime < '2013-06-07' and (taskId = 3 or taskId = 7) and shareType = 3) as shareWeiXinTask,
		(select sum(growing) from readily_tasklog where createTime > '2013-05-31' and createTime < '2013-06-07' and (taskId = 3 or taskId = 7) and shareType = 4) as shareQzoneTask
		) a;*/
		
		StringBuffer hql = new StringBuffer();
		
		hql.append("select * from (select ");
		
		// 日期
		hql.append("'").append(DateUtils.format(createTime, Constants.DATEFORMAT)).append("' as createTime,");
		
		// 登录数
		hql.append("(select sum(growing) from readily_tasklog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and taskId = 4) as loginTask,");
		
		// 房源数
		hql.append("(select sum(growing) from readily_tasklog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and taskId = 5) as houseReadilyTask,");
		
		// 客源数
		hql.append("(select sum(growing) from readily_tasklog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and taskId = 6) as customerTask,");
		
		// 新浪微博
		hql.append("(select sum(growing) from readily_tasklog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and (taskId = 3 or taskId = 7) and shareType = 1) as shareSinaTask,");
		
		// 腾讯微博
		hql.append("(select sum(growing) from readily_tasklog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and (taskId = 3 or taskId = 7) and shareType = 2) as shareTencentTask,");
		
		// 微信
		hql.append("(select sum(growing) from readily_tasklog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and (taskId = 3 or taskId = 7) and shareType = 3) as shareWeiXinTask,");
		
		// QQ空间
		hql.append("(select sum(growing) from readily_tasklog where createTime > '");
		hql.append(DateUtils.format(createTime, Constants.DATEFORMAT));
		hql.append("' and createTime < '");
		hql.append(DateUtils.format(DateUtils.addDate(createTime, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT));
		hql.append("' and (taskId = 3 or taskId = 7) and shareType = 4) as shareQzoneTask");
		
		hql.append(") b\n");
		
		return hql.toString();
	}
	
	@Override
	public List<TaskUserTrend> findPagingByTaskUserTrend(Integer userId, String userName, Date beginDate, Date endDate, String sort,
			String dir, PagingBean pagingBean) throws Exception {
		//set @mycnt = 0;select (@mycnt := @mycnt + 1) as rownum, userId, b.name as userName, sumGrowing from 
		//(select userId, sum(growing) as sumGrowing from readily_tasklog where createTime > '2013-07-01 00:00:00' 
		//and createTime < '2013-07-12 00:00:00' group by userId order by sumGrowing desc) a inner join users b 
		//on (a.userId = b.id);
		
		// hibernate
		StringBuffer countSql = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		StringBuffer filter = new StringBuffer();
		//sql.append("set @mycnt = 0;select (@mycnt := @mycnt + 1) as rownum, userId, b.name as userName, sumGrowing");
		
		countSql.append("select count(*) from (select userId,sum(growing) as sumGrowing from readily_tasklog o where taskId != 8");
		
		sql.append("select userId, b.name as userName, sumGrowing");
		sql.append(" from (select userId,sum(growing) as sumGrowing from readily_tasklog o where taskId != 8");
//		if (null != id && id > 0) {
//			sql.append(" and o.id = ").append(id);
//		}
//		if (StringUtils.isNotEmpty(userName)) {
//			sql.append(" and o.name like '%").append(userName).append("%'");
//		}
		if (null != beginDate) {
			filter.append(" and o.createTime >= '").append(DateUtils.format(beginDate, Constants.DATEFORMAT)).append("'");
		}
		if (null != endDate) {
			filter.append(" and o.createTime < '").append(
					DateUtils.format(DateUtils.addDate(endDate, Calendar.DAY_OF_MONTH, 1), Constants.DATEFORMAT)).append("'");
		}
		
		// 加入过滤条件
		countSql.append(filter);
		sql.append(filter);
		
		countSql.append(" group by userId order by sumGrowing desc) t;");
		sql.append(" group by userId order by sumGrowing desc) a inner join users b on (a.userId = b.id)");
		sql.append(" limit ").append(pagingBean.getBeginRow()).append(",").append(pagingBean.getPageRows()).append(";");
		
		// 查询
		Query countQuery = this.getSession().createSQLQuery(countSql.toString());
		Long cnt = ((java.math.BigInteger) countQuery.uniqueResult()).longValue();
		int inCnt = cnt.intValue();
		if (inCnt == 0) {
			return new ArrayList<TaskUserTrend>();
		}
		pagingBean.setMaxRows(inCnt);
		
		Query sqlQuery = this.getSession().createSQLQuery(sql.toString());
		//sqlQuery.setFirstResult(pagingBean.getBeginRow());
		//sqlQuery.setMaxResults(pagingBean.getPageRows());
		
		List<Object[]> list = sqlQuery.list();
		List<TaskUserTrend> taskUserTrendList = new ArrayList<TaskUserTrend>(list.size());
		Object[] objArray = null;
		TaskUserTrend taskUserTrend = null;
		Integer rownum = pagingBean.getBeginRow() + 1;
		for (int i = 0, size = list.size(); i < size; i++) {
			objArray = (Object[]) list.get(i);
			taskUserTrend = new TaskUserTrend();
			taskUserTrend.setRownum(rownum++);
			taskUserTrend.setUserId(Integer.parseInt(objArray[0].toString()));
			taskUserTrend.setUserName(objArray[1].toString());
			taskUserTrend.setSumGrowing(Integer.parseInt(objArray[2].toString()));
			taskUserTrendList.add(taskUserTrend);
		}
		
		// 排名相同的修改和上一名一样的名次
		for (int i = 0, size = taskUserTrendList.size(); i < size; i++) {
			if (i > 0) {
				if (taskUserTrendList.get(i).getSumGrowing().equals(taskUserTrendList.get(i - 1).getSumGrowing())) {
					taskUserTrendList.get(i).setRownum(taskUserTrendList.get(i - 1).getRownum());
				}
			}
		}
		
		// jdbc
//		Session session = this.getSession();
//		Connection con = session.connection();      
//        PreparedStatement ps = con.prepareStatement(sql.toString());      
//        ResultSet rs = ps.executeQuery();      
//        List<KnowledgeQueryBean> all = new ArrayList<KnowledgeQueryBean>();      
//       while(rs.next()){      
//            KnowledgeQueryBean kqb = new KnowledgeQueryBean();      
//            kqb.setKnowledgeQueryId( rs.getLong("KNOWLEDGEQUERYID"));      
//            kqb.setTitle(rs.getString("TITILE"));      
//            kqb.setCreateDate(rs.getDate("CREATEDATE"));      
//            kqb.setContent(rs.getString("USERNAME"));      
//            kqb.setUserId(rs.getLong("USERID"));      
//            kqb.setCount(rs.getInt("COUNT"));      
//            all.add(kqb);      
//        }      
//        rs.close();      
//        ps.close();      
//        session.flush();      
//        session.close();
		
		return taskUserTrendList;
	}
}