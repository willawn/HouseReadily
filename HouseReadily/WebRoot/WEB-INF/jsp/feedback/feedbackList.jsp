<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/comm/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>My JSP 'houseReadilyList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<script type="text/javascript" src="js/comm.js"></script>
	<script type="text/javascript">
		var store, colModel, dataGridFeedback, searchForm, tabPanel, dataModePanel, imageModePanel;
		var searchHeight = 45, toolbarHeight = 58;
		Ext.onReady(function(){
			searchForm = new Ext.FormPanel({
				//labelAlign: 'top',
		        //frame:true,
		        //width: 650,
		        //defaults: {width: 230},
		        //defaultType: 'textfield',
		        labelWidth: 100,
		        height: searchHeight,
		        frame: true,
		        url:'save-form.php',
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
		                    fieldLabel: '提交时间（开始）',
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
		                    fieldLabel: '提交时间（结束）',
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
		                    handler: function() {
		                		store.load({params:{start:0, limit:10}});
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
							handler: function() {
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
						"id", "userName", "email", "description", "creater", "createTime"
					]
				}),
				proxy: new Ext.data.HttpProxy({
				　　url:basePath + 'feedback/feedbackList.do',
				　　method:'GET'
				}),
				remoteSort:true
			});
			store.on('beforeload', function(store, options){
				if(Ext.getCmp('beginDate').getValue() != ""){
					options.params.beginDate = Ext.getCmp('beginDate').getValue();
				}
				if(Ext.getCmp('endDate').getValue() != ""){
					options.params.endDate = Ext.getCmp('endDate').getValue();
				}
			});
			store.on('load', function(store){
				dataGridFeedback.getSelectionModel().selectFirstRow();
				//dataGridFeedback.setHeight(window.parent.Ext.get('menuPanel').getHeight() - 129);
			});
			window.onresize = function(){
				dataGridFeedback.setHeight(window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight);
			}
			store.load({params:{start:0, limit:15}});

			colModel = new Ext.grid.ColumnModel([
				new Ext.grid.RowNumberer(),
				{id:'id',dataIndex:'id',header:'反馈ID',width:10,sortable:true,hidden:false},
				{dataIndex:'userName',header:'用户名',width:30,sortable:false},
				{dataIndex:'email',header:'Email',width:30,sortable:false},
				{dataIndex:'createTime',header:'提交时间',width:40,sortable:true},
				{dataIndex:'description',header:'描述',sortable:false,renderer:cellNormal}
			]);
				
			dataGridFeedback = new Ext.grid.GridPanel({
				width:'100%',
				autoWidth:true,
				height:window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight,
				//autoHeight:true,
				renderTo: 'dataGridFeedback',
				store: store,
				trackMouseOver:false,
				//disableSelection:true,
				autoExpandColumn: 'description',
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
					pageSize: 15,
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
		});
	</script>
  </head>
  
  <body>
    <div id="tabPanel">
  		<div id="dataModePanel">
	  		<div id="searchForm"></div>
	    	<div id="dataGridFeedback"></div>
    	</div>
    	<div id="imageModePanel">
    	</div>
    </div>
  </body>
</html>
