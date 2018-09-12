<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/comm/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<script type="text/javascript" src="js/comm.js"></script>
	<script type="text/javascript">
		var taskData, storeTask, dataGridTask;
		var taskUserData, storeTaskUser, dataGridTaskUser;
		Ext.onReady(function(){
			
			//数据
			taskData = [];

			//创建容器
			storeTask = new Ext.data.SimpleStore({
			    fields: [
					{name: 'createTime'},
			    	{name: 'loginTask'},
			    	{name: 'houseReadilyTask'},
			    	{name: 'customerTask'},
			   		{name: 'shareSinaTask'},
			    	{name: 'shareTencentTask'},
			    	{name: 'shareWeiXinTask'},
			    	{name: 'shareQzoneTask'}
				]
			});
			storeTask.loadData(taskData);
			
			// 创建 Grid
			dataGridTask = new Ext.grid.GridPanel({
			    store: storeTask,
			    renderTo: 'dataGridTask',
			    columns: [
					{id: 'createTime', header: "日期", dataIndex: 'createTime', renderer:renderColor},
					{header: "登录", width: 100, dataIndex: 'loginTask', renderer:renderColor},
					{header: "房源", width: 100, dataIndex: 'houseReadilyTask', renderer:renderColor},
					{header: "客源", width: 100, dataIndex: 'customerTask', renderer:renderColor},
					{header: "新浪微博", width: 100, dataIndex: 'shareSinaTask', renderer:renderColor},
					{header: "腾讯微博", width: 100, dataIndex: 'shareTencentTask', renderer:renderColor},
					{header: "微信", width: 100, dataIndex: 'shareWeiXinTask', renderer:renderColor},
					{header: "QQ空间", width: 100, dataIndex: 'shareQzoneTask', renderer:renderColor}
			    ],
			    stripeRows: true,
			    autoExpandColumn: 'createTime',
			    height: 220,
			    width: 900,
			    title: '最近7日发放总积分统计（单位：积分）'
			});
			dataGridTask.getSelectionModel().selectFirstRow();
			
			Ext.Ajax.request({
			    url: '<%=basePath%>task/taskImgList.do',
			    params: {
			        //id: cell.getId()
			    },
			    success: function(response, options) {
			        var responseText = Ext.util.JSON.decode(response.responseText);
			        var taskImgs = responseText.rows;
			        if(taskImgs.length > 0){
						for(var i = 0; i < taskImgs.length; i++){
							taskData.push(new Array(taskImgs[i].createTime, taskImgs[i].loginTask, taskImgs[i].houseReadilyTask, taskImgs[i].customerTask, taskImgs[i].shareSinaTask, taskImgs[i].shareTencentTask, taskImgs[i].shareWeiXinTask, taskImgs[i].shareQzoneTask));
						}
						storeTask.loadData(taskData);
					}
			    },
			    failure: function(response, options) {
			        //var responseText = Ext.util.JSON.decode(response.responseText);
			        //Ext.Msg.alert('错误', responseText.error);
			    }
			});


			/*
			//数据
			taskUserData = [];

			//创建容器
			storeTaskUser = new Ext.data.SimpleStore({
			    fields: [
					{name: 'createTime'},
			    	{name: 'loginTask'},
			    	{name: 'houseReadilyTask'},
			    	{name: 'customerTask'},
			   		{name: 'shareSinaTask'},
			    	{name: 'shareTencentTask'},
			    	{name: 'shareWeiXinTask'},
			    	{name: 'shareQzoneTask'}
				]
			});
			storeTaskUser.loadData(taskUserData);
			
			// 创建 Grid
			dataGridTaskUser = new Ext.grid.GridPanel({
			    store: storeTaskUser,
			    renderTo: 'dataGridTaskUser',
			    columns: [
					{id: 'createTime', header: "日期", dataIndex: 'createTime', renderer:renderColor},
					{header: "登录", width: 100, dataIndex: 'loginTask', renderer:renderColor},
					{header: "房源", width: 100, dataIndex: 'houseReadilyTask', renderer:renderColor},
					{header: "客源", width: 100, dataIndex: 'customerTask', renderer:renderColor},
					{header: "新浪微博", width: 100, dataIndex: 'shareSinaTask', renderer:renderColor},
					{header: "腾讯微博", width: 100, dataIndex: 'shareTencentTask', renderer:renderColor},
					{header: "微信", width: 100, dataIndex: 'shareWeiXinTask', renderer:renderColor},
					{header: "QQ空间", width: 100, dataIndex: 'shareQzoneTask', renderer:renderColor}
			    ],
			    stripeRows: true,
			    autoExpandColumn: 'createTime',
			    height: 220,
			    width: 900,
			    title: '最近7日用户积分排行统计（单位：积分）'
			});
			dataGridTaskUser.getSelectionModel().selectFirstRow();
			
			Ext.Ajax.request({
			    url: '<%=basePath%>task/taskImgList.do',
			    params: {
			        //id: cell.getId()
			    },
			    success: function(response, options) {
			        var responseText = Ext.util.JSON.decode(response.responseText);
			        var taskImgs = responseText.rows;
			        if(taskImgs.length > 0){
						for(var i = 0; i < taskImgs.length; i++){
							taskUserData.push(new Array(taskImgs[i].createTime, taskImgs[i].loginTask, taskImgs[i].houseReadilyTask, taskImgs[i].customerTask, taskImgs[i].shareSinaTask, taskImgs[i].shareTencentTask, taskImgs[i].shareWeiXinTask, taskImgs[i].shareQzoneTask));
						}
						storeTaskUser.loadData(taskUserData);
					}
			    },
			    failure: function(response, options) {
			        //var responseText = Ext.util.JSON.decode(response.responseText);
			        //Ext.Msg.alert('错误', responseText.error);
			    }
			});
			*/
		});

		function renderColor(value, p, record, rowIndex, columnIndex, store) {
			//Ext.util.Format.dateRenderer('Y年m月d日')
			if(rowIndex == 0) {
				if (p.id == 'createTime') {
					return '<span style="color:red;">' + new Date(value).format('Y年m月d日') + '</span>';
				} else {
					return '<span style="color:red;">' + value + '</span>';
				}
			} else {
				if (p.id == 'createTime') {
					return '<span style="color:green;">' + new Date(value).format('Y年m月d日') + '</span>';
				} else {
					return '<span style="color:green;">' + value + '</span>';
				}
			}
			return value;
		}
	</script>
  </head>
  
  <body>
  	<div id="dataGridTask" style="padding-left: 10px; padding-top: 10px;">
    </div>
    <div id="dataGridTaskUser" style="padding-left: 10px; padding-top: 10px;">
    </div>
  </body>
</html>
