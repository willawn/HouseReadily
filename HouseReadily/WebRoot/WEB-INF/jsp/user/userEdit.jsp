<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/comm/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/comm.js"></script>
	<script type="text/javascript">
		var jsonObject = ${jsonObject};
		var cuser = jsonObject.cuser;
		var ownerData, ownerStore;
		var followData, followStore;
		var formPanel;
		var toolbarHeight = 58;
		Ext.onReady(function(){
			// 关联房源
			ownerData = [];
			ownerStore = new Ext.data.ArrayStore({
				fields: [
		        	{name: 'id'},
		        	{name: 'projectName'}
		     	]
			});
			ownerStore.loadData(ownerData);

			// 客源
			followData = [];
			followStore = new Ext.data.ArrayStore({
				fields: [
		        	{name: 'id'},
		        	{name: 'name'},
		           	{name: 'mobile'}
		     	]
			});
			followStore.loadData(followData);
			
			//用户信息
			formPanel = new Ext.FormPanel({
		        labelWidth: 100,
		        bodyStyle:'padding:5px 5px 0',
		        height: window.parent.parent.Ext.get('menuPanel').getHeight() - toolbarHeight,
		        items: [{
		            layout:'column',
		            border:false,
		            items:[{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '用户ID',
		                    id:'txtUserId',
		                    name: 'txtUserId',
		                    anchor:'95%'
		                },{
		                    fieldLabel: 'Email',
		                    name: 'txtEmail',
		                    id: 'txtEmail',
		                    xtype: 'textfield',
		                    readOnly: true,
		                    anchor: '95%'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '用户名',
		                    id: 'txtUserName',
		                    name: 'txtUserName',
		                    anchor:'95%'
		                },{  
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '城市',
		                    id:'txtCityName',
		                    name: 'txtCityName',
		                    anchor:'95%'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{  
		                    fieldLabel: '注册来源',
		                    name: 'comRegSource',
		                    id: 'comRegSource',
		                    xtype: 'combo',
		                    readOnly: true,
		                    //hiddenName: "regSource",  
		                    store: new Ext.data.SimpleStore({  
		                        //autoLoad: true,  
		                        fields: ["value", "text"],  
		                        data: [["0", "全部"], ["1", "租售365"], ["2", "随手房"]]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—注册来源—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                },{
		                    fieldLabel: '注册时间',
		                    name: 'regDate',
		                    id: 'regDate',
		                    xtype: 'datefield',
		                    format: 'Y-m-d H:i:s',
		                    anchor: '95%'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{  
		                    fieldLabel: '手机',
		                    name: 'txtMobile',
		                    id: 'txtMobile',
		                    xtype: 'textfield',
		                    readOnly: true,
		                    anchor: '95%'
		                }]
		            }]
		        },{
			        id:'tabPanelEdit',
		            xtype:'tabpanel',
		            //contentEl: 'tabPanel',
		            plain:true,
		            activeTab: 0,
		            height:window.parent.parent.Ext.get('menuPanel').getHeight() - toolbarHeight - 140,
		            deferredRender: false,
		            defaults:{bodyStyle:'padding:5px'},
		            items:[{
		                title:'房源',
		                layout:'fit',
			           	items: {
			           		xtype: 'grid',
			                ds: ownerStore,
			                cm: new Ext.grid.ColumnModel([
			 					new Ext.grid.RowNumberer(),
								{id:'id',dataIndex:'id',header:'ID',width:20,sortable:true,hidden:true},
								{dataIndex:'projectName',header:'房源',sortable:false,renderer:renderHouseReadily3}
							]),
			                sm: new Ext.grid.RowSelectionModel({
			                    singleSelect: true
			                }),
			                autoExpandColumn: 'projectName',
			                //height: 250,
			                //title:'Company Data',
			                enableColumnMove:true,//拖放列   
							enableColumnResize:true,//改变列的宽度   
							stripeRows:true,//表格显示斑马线效果
							viewConfig: {
								//scrollOffset: 0, // 右边是否有滚动条
								forceFit:true, //平均分配  
								autoSizeColumn:true //根据内容填充列的大小
							}
			            }
		            },{
		                title:'客源',
		                layout:'fit',
			           	items: {
			           		xtype: 'grid',
			                ds: followStore,
			                cm: new Ext.grid.ColumnModel([
			 					new Ext.grid.RowNumberer(),
								{id:'id',dataIndex:'id',header:'ID',width:20,sortable:true,hidden:true},
								{dataIndex:'name',header:'姓名',width:20,sortable:false,renderer:renderCustomer3},
								{dataIndex:'mobile',header:'联系方式',sortable:false}
							]),
			                sm: new Ext.grid.RowSelectionModel({
			                    singleSelect: true
			                }),
			                autoExpandColumn: 'description',
			                //height: 250,
			                //title:'Company Data',
			                enableColumnMove:true,//拖放列   
							enableColumnResize:true,//改变列的宽度   
							stripeRows:true,//表格显示斑马线效果
							viewConfig: {
								//scrollOffset: 0, // 右边是否有滚动条
								forceFit:true, //平均分配  
								autoSizeColumn:true //根据内容填充列的大小
							}
			            }
		            },{
	                    layout: 'fit',
	                    title: '重置密码',
	                    id: 'passwordPanel',
						html: '<iframe style="width: 100%; height: 100%;" frameborder="no" id="passwordFrame" name="passwordFrame" />',
						listeners: {
						  'activate': {
							fn: function() {
								var url = '<%=basePath%>user/password.do' + '?id=' + cuser.id ;
								document.getElementById('passwordFrame').src = url;
							},single: true
						  }
						}
	                }]
		        }]
		    });
		    
		    formPanel.render(document.body);
		    Ext.getCmp('regDate').disable();
		    
		    // 加载数据
		    initData();
		});

		window.onresize = function(){
			formPanel.setHeight(window.parent.parent.Ext.get('menuPanel').getHeight() - toolbarHeight);
			Ext.getCmp('tabPanelEdit').setHeight(window.parent.parent.Ext.get('menuPanel').getHeight() - toolbarHeight - 150);
		}
		
		function initData() {
			// 客源信息
			Ext.getCmp('txtUserId').setValue(cuser.id);
			Ext.getCmp('txtEmail').setValue(cuser.email);
			Ext.getCmp('txtUserName').setValue(cuser.name);
			Ext.getCmp('txtCityName').setValue(cuser.cityName);
			Ext.getCmp('comRegSource').setValue(cuser.gender);
			Ext.getCmp('regDate').setValue(cuser.regDate);
			Ext.getCmp('txtMobile').setValue(cuser.mobile);

			// 关联房源
			var houseOwners = cuser.houseReadilys.list;
			if(houseOwners.length > 0){
				for(var i = 0; i < houseOwners.length; i++){
					ownerData.push(new Array(houseOwners[i].id, houseOwners[i].projectName));
				}
				ownerStore.loadData(ownerData);
			}

			// 关联客源
			var houseFollows = cuser.houseFollows.list;
			if(houseFollows.length > 0){
				for(var i = 0; i < houseFollows.length; i++){
					followData.push(new Array(houseFollows[i].id, houseFollows[i].name, houseFollows[i].mobile));
				}
				followStore.loadData(followData);
			}
		}
		
		
	</script>

  </head>
  
  <body>
  </body>
</html>
