<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/comm/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>My JSP 'operateLogList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<script type="text/javascript" src="js/comm.js"></script>
	<script type="text/javascript">
		var store, colModel, dataGridTaskLog, searchForm, tabPanel, dataModePanel, imageModePanel;
		var searchHeight = 70, toolbarHeight = 58;
		Ext.onReady(function(){
			searchForm = new Ext.FormPanel({
		        labelWidth: 100,
		        height: searchHeight,
		        frame: true,
		        //url:'save-form.php',
		        bodyStyle:'padding:5px 5px 0',
		        renderTo: 'searchForm',
		        items: [{
		            layout:'column',
		            border:false,
		            items:[{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    fieldLabel: '积分ID',
		                    id:'txtTaskLogId',
		                    name: 'txtTaskLogId',
		                    anchor:'95%'
		                },{  
		                    fieldLabel: '社交平台',
		                    name: 'comShareType',
		                    id: 'comShareType',
		                    xtype: 'combo',
		                    //hiddenName: "terminal",  
		                    store: new Ext.data.SimpleStore({  
		                        //autoLoad: true,  
		                        fields: ["value", "text"],  
		                        data: [
									["0", "全部"],
				                    ["1", "新浪微博"],
				                    ["2", "腾讯微博"],
				                    ["3", "微信"],
				                    ["4", "QQ空间"],
				                    ["5", "其他"]
					            ]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—社交平台—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    fieldLabel: '用户名',
		                    id: 'txtUserName',
		                    name: 'txtUserName',
		                    anchor:'95%'
		                },{
		                    fieldLabel: '日志时间（开始）',
		                    name: 'beginDate',
		                    id: 'beginDate',
		                    xtype: 'datefield',
		                    format: 'Y-m-d',
		                    anchor: '95%',
		                    //vtype: 'daterange',
		                    endDateField: 'endDate'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{  
		                    fieldLabel: '任务类型',
		                    name: 'comType',
		                    id: 'comType',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                    	fields: ["value", "text"],  
		                        data: [
									["0", "全部"],
									["1", "一次性任务"],
									["2", "每日任务"],
									["3", "每周任务"],
									["4", "每月任务"]
						        ]
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—任务类型—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local",
		                    listeners: {
								'change': function(combo, newValue, oldValue) {
		                			initTaskData();
								}
							}
		                },{
		                    fieldLabel: '日志时间（结束）',
		                    name: 'endDate',
		                    id: 'endDate',
		                    xtype: 'datefield',
		                    format: 'Y-m-d',
		                    anchor: '95%',
		                    //vtype: 'daterange',
		                    startDateField: 'beginDate'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{  
		                    fieldLabel: '任务类别',
		                    name: 'comTaskId',
		                    id: 'comTaskId',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: []  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—任务类别—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                }]
		            },{  
		            	columnWidth:.1,
		                layout: 'form',
		                border:false,
		                items : [{
		                	text: '搜索',
		                    name: 'btnOK',
		                    id: 'btnOK',
		                    xtype: 'button',
		                    anchor: '95%',
		                    style: 'margin:15px 0 0 0',
		                    handler: function() {
		                		store.load({params:{start:0, limit:20}});
		                    }
		                }]  
		            },{  
		            	columnWidth:.1,
		                layout: 'form',
		                border:false,
		                items : [{
		                	text: '重置',
		                    name: 'btnReset',
		                    id: 'btnReset',
		                    xtype: 'button',
		                    anchor: '95%',
		                    style: 'margin:15px 0 0 0',
							handler: function() {
								Ext.getCmp('txtTaskLogId').reset();
								Ext.getCmp('txtUserName').reset();
								Ext.getCmp('comType').reset();
								Ext.getCmp('comTaskId').reset();
								Ext.getCmp('comShareType').reset();
								Ext.getCmp('beginDate').reset();
								Ext.getCmp('endDate').reset();
		                    }
		                }]  
		            }]
		        }]
		    });
		    
			store = new Ext.data.Store({
				reader: new Ext.data.JsonReader({
					root: 'rows',
					totalProperty: 'total',
					idProperty: 'id',
					remoteSort: true,
					fields: [
						'id', 'userId', 'userName', 'type', 'taskId', 'taskName', 'shareType', 'growing', 'integration', 'createTime'
					]
				}),
				proxy: new Ext.data.HttpProxy({
				　　url:basePath + 'task/taskLogList.do',
				　　method:'GET'
				}),
				remoteSort:true
			});
			store.on('beforeload', function(store, options){
				if(Ext.getCmp('txtTaskLogId').getValue().trim() != ""){
					options.params.id = Ext.getCmp('txtTaskLogId').getValue();
				}
				if(Ext.getCmp('txtUserName').getValue().trim() != ""){
					options.params.userName = Ext.getCmp('txtUserName').getValue();
				}
				if(Ext.getCmp('comType').getValue().trim() != "" && Ext.getCmp('comType').getValue() > 0){
					options.params.type = Ext.getCmp('comType').getValue();
				}
				if(Ext.getCmp('comTaskId').getValue().trim() != "" && Ext.getCmp('comTaskId').getValue() > 0){
					options.params.taskId = Ext.getCmp('comTaskId').getValue();
				}
				if(Ext.getCmp('comShareType').getValue().trim() != "" && Ext.getCmp('comShareType').getValue() > 0){
					options.params.shareType = Ext.getCmp('comShareType').getValue();
				}
				if(Ext.getCmp('beginDate').getValue() != ""){
					options.params.beginDate = Ext.getCmp('beginDate').getValue();
				}
				if(Ext.getCmp('endDate').getValue() != ""){
					options.params.endDate = Ext.getCmp('endDate').getValue();
				}
			});
			store.on('load', function(store){
				dataGridTaskLog.getSelectionModel().selectFirstRow();
				//dataGridTaskLog.setHeight(window.parent.Ext.get('menuPanel').getHeight() - 129);
			});
			window.onresize = function(){
				dataGridTaskLog.setHeight(window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight);
			}
			store.load({params:{start:0, limit:20}});

			colModel = new Ext.grid.ColumnModel([
				new Ext.grid.RowNumberer(),
				{id:'id',dataIndex:'id',header:'积分ID',width:20,sortable:true,hidden:false},
				{dataIndex:'userId',header:'用户ID',hidden:true},
				{dataIndex:'userName',header:'用户名',width:30,sortable:false},
				{dataIndex:'type',header:'任务类型',width:30,sortable:false,renderer:renderType},
				{dataIndex:'taskName',header:'任务类别',width:30,sortable:false},
				{dataIndex:'shareType',header:'社交平台',width:40,sortable:false,renderer:renderShareType},
				{dataIndex:'growing',header:'经验值',width:30,sortable:false},
				{dataIndex:'integration',header:'积分',width:30,sortable:false},
				{dataIndex:'createTime',header:'获得积分时间',sortable:true}
			]);
				
			dataGridTaskLog = new Ext.grid.GridPanel({
				width:'100%',
				autoWidth:true,
				height:window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight,
				//autoHeight:true,
				renderTo: 'dataGridTaskLog',
				store: store,
				trackMouseOver:false,
				//disableSelection:true,
				autoExpandColumn: 'createTime',
				loadMask: true,
				cm: colModel,
				sm: new Ext.grid.RowSelectionModel({  
					singleSelect: true  
				}),
				enableColumnMove:true,//拖放列   
				enableColumnResize:true,//改变列的宽度   
				stripeRows:true,//表格显示斑马线效果
				viewConfig: {
					//scrollOffset: 0, // 右边是否有滚动条
					forceFit:true, //平均分配  
					autoSizeColumn:true //根据内容填充列的大小
				},
				tbar: new Ext.PagingToolbar({
					pageSize: 20,
					store: store,
					displayInfo: true,
					displayMsg: '第 {0} 到 {1} 条记录,共 {2} 记录',
					emptyMsg: "没有记录",
					prevText: "上一页", 
					nextText: "下一页", 
					refreshText: "刷新", 
					lastText: "最后页", 
					firstText: "第一页"
				}),
				listeners: {
					'rowdblclick': function(grid, rowIndex, e) {
						var selectionModel = grid.getSelectionModel();    
						var record = selectionModel.getSelected();
						//window.parent.dataGrid_dbClick("key", record.data.roomId);
					}
				}
			});

			tabPanel = new Ext.TabPanel({
				id: 'tabPanel',
                autoScroll: true,
                deferredRender: false,
                activeTab: 0,
				autoHeight: true,
                applyTo: "tabPanel",
                items: [
                dataModePanel = new Ext.Panel({
                    layout: "fit",
					height: '100%',
                    title: "列表模式",
                    contentEl: 'dataModePanel'
                }), imageModePanel = new Ext.Panel({
                    layout: "fit",
                    height: window.parent.parent.Ext.get('menuPanel').getHeight() - 60,
                    title: "图形模式",
                    contentEl: "imageModePanel",
					html: '<iframe style="width: 100%; height: 100%;" frameborder="no" id="imageModeFrame" name="imageModeFrame" />',
					listeners: {
					  'activate': {
						fn: function() {
						var url = '<%=basePath%>task/toTaskImgList.do';
						document.getElementById('imageModeFrame').src = url;
						},single: true
					  }
					}
                })]
            });

			// 加载数据
		    initData();
		});

		function initData() {
			
		}

		function initTaskData() {
			Ext.getCmp('comTaskId').reset();
			Ext.getCmp('comTaskId').getStore().removeAll();
			
			var store = Ext.getCmp('comTaskId').getStore();
			var type = Ext.getCmp('comType').getValue();
			if(type != "" && type > 0){
				$.get(basePath + 'task/taskList.do?type=' + type, {}, function(json){
			    	var taskList = json.taskList;
			    	var records = new Array();
			    	records[0] = new Ext.data.Record({
						value: "0",
						text: "全部"
					});
			    	for(var i = 0, j = 1; i < taskList.length; i++){
			    		records[j++] = new Ext.data.Record({
			    			value: taskList[i].id,
							text: taskList[i].title
						});
					}
			    	store.add(records);
			    });
			}
		}

		function renderType(value, p, record, rowIndex, columnIndex, store) {
			if(value == "1"){
				return "一次性任务";
			}else if(value == "2"){
				return "每日任务";
			}else if(value == "3"){
				return "每周任务";
			}else if(value == "4"){
				return "每月任务";
			}else{
				return value;
			}
		}

		function renderShareType(value, p, record, rowIndex, columnIndex, store) {
			if(value == "1"){
				return "新浪微博";
			}else if(value == "2"){
				return "腾讯微博";
			}else if(value == "3"){
				return "微信";
			}else if(value == "4"){
				return "QQ空间";
			}else if(value == "5"){
				return "其他";
			}else{
				return value;
			}
		}
	</script>
  </head>
  
  <body>
  	<div id="tabPanel">
  		<div id="dataModePanel">
	  		<div id="searchForm"></div>
	    	<div id="dataGridTaskLog"></div>
    	</div>
    	<div id="imageModePanel">
    	</div>
    </div>
  </body>
</html>
