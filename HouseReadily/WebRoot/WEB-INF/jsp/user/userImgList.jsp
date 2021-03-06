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
		var store, dataGridUser;
		Ext.onReady(function(){
			//数据
			var userData = [];

			//创建容器
			store = new Ext.data.SimpleStore({
			    fields: [
					{name: 'createTime'},
			    	{name: 'activeCount'},
			    	{name: 'loginCount'},
			    	{name: 'registerCount'},
			   		{name: 'houseReadilyCount'},
			    	{name: 'customerCount'},
			    	{name: 'houseFollowCount'}
				]
			});
			store.loadData(userData);
			
			// 创建 Grid
			dataGridUser = new Ext.grid.GridPanel({
			    store: store,
			    renderTo: 'dataGridUser',
			    columns: [
					{id: 'createTime', header: "日期", dataIndex: 'createTime', renderer:renderColor},
					{header: "活跃人数", width: 100, dataIndex: 'activeCount', renderer:renderColor},
					{header: "登录人数", width: 100, dataIndex: 'loginCount', renderer:renderColor},
					{header: "注册人数", width: 100, dataIndex: 'registerCount', renderer:renderColor},
					{header: "房源数量", width: 100, dataIndex: 'houseReadilyCount', renderer:renderColor},
					{header: "客源数量", width: 100, dataIndex: 'customerCount', renderer:renderColor},
					{header: "跟进数量", width: 100, dataIndex: 'houseFollowCount', renderer:renderColor}
			    ],
			    stripeRows: true,
			    autoExpandColumn: 'createTime',
			    height: 620,
			    width: 900,
			    title: '最近30日用户活跃度统计'
			});
			dataGridUser.getSelectionModel().selectFirstRow();
			
			Ext.Ajax.request({
			    url: '<%=basePath%>user/userImgList.do',
			    params: {
			        //id: cell.getId()
			    },
			    success: function(response, options) {
			        var responseText = Ext.util.JSON.decode(response.responseText);
			        var userImgs = responseText.rows;
			        if(userImgs.length > 0){
						for(var i = 0; i < userImgs.length; i++){
							userData.push(new Array(userImgs[i].createTime, userImgs[i].activeCount, userImgs[i].loginCount, userImgs[i].registerCount, userImgs[i].houseReadilyCount, userImgs[i].customerCount, userImgs[i].houseFollowCount));
						}
						store.loadData(userData);
					}
			    },
			    failure: function(response, options) {
			        //var responseText = Ext.util.JSON.decode(response.responseText);
			        //Ext.Msg.alert('错误', responseText.error);
			    }
			});
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
  	<div id="dataGridUser" style="padding-left: 10px; padding-top: 10px;">
    </div>
  </body>
</html>
