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
		var store, colModel, dataGridOperateLog, searchForm, tabPanel, dataModePanel, imageModePanel;
		var searchHeight = 70, toolbarHeight = 58;
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
		                    xtype:'textfield',
		                    fieldLabel: '日志ID',
		                    id:'txtOperateId',
		                    name: 'txtOperateId',
		                    anchor:'95%'
		                },{
		                    fieldLabel: '日志类型',
		                    name: 'comType',
		                    id: 'comType',
		                    xtype: 'combo',
		                    //hiddenName: "type",  
		                    store: new Ext.data.SimpleStore({  
		                        //autoLoad: true,  
		                        fields: ["value", "text"],  
		                        data: [
				                	["0", "全部"],
				                	["1", "新增房源"],
				                	["2", "修改房源"],
				                	["3", "删除房源"],
				                	["4", "新增客源"],
				                	["5", "修改客源"],
				                	["6", "删除客源"],
				                	["7", "创建群"],
				                	["8", "修改群公告"],
				                	["9", "删除群"],
				                	["10", "群主添加群成员"],
				                	["11", "群主移除群成员"],
				                	["12", "群成员退出群"],
				                	["13", "群分享房源"],
				                	["14", "群删除房源"],
				                	["15", "群分享客源"],
				                	["16", "群删除客源"],
				                	["17", "群新增留言"],
				                	["18", "群删除留言"]
					            ]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—日志类型—",
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
		                    fieldLabel: '注册来源',
		                    name: 'comRegSource',
		                    id: 'comRegSource',
		                    xtype: 'combo',
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
		                    fieldLabel: '移动平台',
		                    name: 'comTerminal',
		                    id: 'comTerminal',
		                    xtype: 'combo',
		                    //hiddenName: "terminal",  
		                    store: new Ext.data.SimpleStore({  
		                        //autoLoad: true,  
		                        fields: ["value", "text"],  
		                        data: [["0", "全部"], ["ios", "ios"], ["android", "android"]]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—移动平台—",
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
								Ext.getCmp('txtOperateId').reset();
								Ext.getCmp('comType').reset();
								Ext.getCmp('txtUserName').reset();
								Ext.getCmp('beginDate').reset();
								Ext.getCmp('comRegSource').reset();
								Ext.getCmp('endDate').reset();
								Ext.getCmp('comTerminal').reset();
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
						'id', 'userId', 'userName', 'regSource', 'ip', 'ipAddress', 'terminal', 'type', 'description', 'createTime'
					]
				}),
				proxy: new Ext.data.HttpProxy({
				　　url:basePath + 'operateLog/operateLogList.do',
				　　method:'GET'
				}),
				remoteSort:true
			});
			store.on('beforeload', function(store, options){
				if(Ext.getCmp('txtOperateId').getValue().trim() != ""){
					options.params.id = Ext.getCmp('txtOperateId').getValue();
				}
				if(Ext.getCmp('comType').getValue() != "" && Ext.getCmp('comType').getValue() > 0){
					options.params.type = Ext.getCmp('comType').getValue();
				}
				if(Ext.getCmp('txtUserName').getValue().trim() != ""){
					options.params.userName = Ext.getCmp('txtUserName').getValue();
				}
				if(Ext.getCmp('comRegSource').getValue().trim() != "" && Ext.getCmp('comRegSource').getValue() > 0){
					options.params.regSource = Ext.getCmp('comRegSource').getValue();
				}
				if(Ext.getCmp('beginDate').getValue() != ""){
					options.params.beginDate = Ext.getCmp('beginDate').getValue();
				}
				if(Ext.getCmp('endDate').getValue() != ""){
					options.params.endDate = Ext.getCmp('endDate').getValue();
				}
				if(Ext.getCmp('comTerminal').getValue().trim() != "" && Ext.getCmp('comTerminal').getValue() != 0){
					options.params.terminal = Ext.getCmp('comTerminal').getValue();
				}
				options.params.isRequestIpAddress = false;
			});
			store.on('load', function(store){
				dataGridOperateLog.getSelectionModel().selectFirstRow();
				//dataGridOperateLog.setHeight(window.parent.Ext.get('menuPanel').getHeight() - 129);
			});
			window.onresize = function(){
				dataGridOperateLog.setHeight(window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight);
			}
			store.load({params:{start:0, limit:20}});

			colModel = new Ext.grid.ColumnModel([
				new Ext.grid.RowNumberer(),
				{id:'id',dataIndex:'id',header:'日志ID',width:20,sortable:true,hidden:false},
				{dataIndex:'userId',header:'用户ID',hidden:true},
				{dataIndex:'userName',header:'用户名',width:30,sortable:false},
				{dataIndex:'regSource',header:'注册来源',width:20,sortable:false,renderer:renderRegSource},
				{dataIndex:'ip',header:'IP',width:35,sortable:false},
				{dataIndex:'ipAddress',header:'IP地址',width:50,sortable:false/*,renderer:renderIpAddress*/},
				{dataIndex:'terminal',header:'移动平台',width:20,sortable:false},
				{dataIndex:'type',header:'日志类型',width:30,sortable:false,renderer:renderTypeOperateLog},
				{dataIndex:'createTime',header:'日志时间',width:40,sortable:true},
				{dataIndex:'description',header:'描述',sortable:false,renderer:cellNormal}
			]);
				
			dataGridOperateLog = new Ext.grid.GridPanel({
				width:'100%',
				autoWidth:true,
				height:window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight,
				//autoHeight:true,
				renderTo: 'dataGridOperateLog',
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
                    contentEl: "imageModePanel"/*,
					html: '<iframe style="width: 100%; height: 100%;" frameborder="no" id="imageModeFrame" name="imageModeFrame" />',
					listeners: {
					  'activate': {
						fn: function() {
							var url = '<%=path%>/zj/rec/pc/showOperation.jsp';
							if("RENTAL" == type){
								url += '?rentId=' + encodeURIComponent(rentId);
							}else if("SALE" == type){
								url += '?saleId=' + encodeURIComponent(saleId);
							}
							document.getElementById('operationFrame').src = url;
						},single: true
					  }
					}*/
                })]
            });
		});
	</script>
  </head>
  
  <body>
  	<div id="tabPanel">
  		<div id="dataModePanel">
	  		<div id="searchForm"></div>
	    	<div id="dataGridOperateLog"></div>
    	</div>
    	<div id="imageModePanel">
    	</div>
    </div>
  </body>
</html>
