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
		var searchHeight = 45, toolbarHeight = 58;
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
		            items:[/*{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    fieldLabel: '用户ID',
		                    id:'txtUserId',
		                    name: 'txtUserId',
		                    anchor:'95%'
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
		                }]
		            },*/{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    fieldLabel: '积分时间（开始）',
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
		                    fieldLabel: '积分时间（结束）',
		                    name: 'endDate',
		                    id: 'endDate',
		                    xtype: 'datefield',
		                    format: 'Y-m-d',
		                    anchor: '95%',
		                    //vtype: 'daterange',
		                    startDateField: 'beginDate'
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
		                    //style: 'margin:15px 0 0 0',
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
		                    //style: 'margin:15px 0 0 0',
							handler: function() {
								//Ext.getCmp('txtUserId').reset();
								//Ext.getCmp('txtUserName').reset();
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
						'rownum', 'userId', 'userName', 'sumGrowing'
					]
				}),
				proxy: new Ext.data.HttpProxy({
				　　url:basePath + 'task/taskUserList.do',
				　　method:'GET'
				}),
				remoteSort:true
			});
			store.on('beforeload', function(store, options){
				/*
				if(Ext.getCmp('txtUserId').getValue().trim() != ""){
					options.params.userId = Ext.getCmp('txtUserId').getValue();
				}
				if(Ext.getCmp('txtUserName').getValue().trim() != ""){
					options.params.userName = Ext.getCmp('txtUserName').getValue();
				}
				*/
				if(Ext.getCmp('beginDate').getValue() != ""){
					options.params.beginDate = Ext.getCmp('beginDate').getValue();
				}
				if(Ext.getCmp('endDate').getValue() != ""){
					options.params.endDate = Ext.getCmp('endDate').getValue();
				}
			});
			store.on('load', function(store){
				//dataGridTaskLog.getSelectionModel().selectFirstRow();
				//dataGridTaskLog.setHeight(window.parent.Ext.get('menuPanel').getHeight() - 129);
			});
			window.onresize = function(){
				dataGridTaskLog.setHeight(window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight);
			}
			store.load({params:{start:0, limit:20}});

			colModel = new Ext.grid.ColumnModel([
				new Ext.grid.RowNumberer(),
				{id:'id',dataIndex:'rownum',header:'排名',width:20,sortable:false,hidden:false},
				{dataIndex:'userId',header:'用户ID',width:30,sortable:false},
				{dataIndex:'userName',header:'用户名',width:30,sortable:false},
				{dataIndex:'sumGrowing',header:'经验值',width:30,sortable:false}
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
					height: '100%',
                    title: "图形模式",
                    contentEl: "imageModePanel"
                })]
            });

			// 加载数据
		    initData();
		});

		function initData() {
			
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
