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
	<script type="text/javascript" src="js/ext/TabCloseMenu.js"></script>
	<script type="text/javascript" src="js/comm.js"></script>
	<script type="text/javascript">
		var store, colModel, dataGridCustomer, searchForm, tabPanel, dataModePanel, imageModePanel;
		var searchHeight = 100, toolbarHeight = 58;
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
		                    fieldLabel: '客源ID',
		                    id:'txtCustomerId',
		                    name: 'txtCustomerId',
		                    anchor:'95%'
		                },{  
		                    fieldLabel: '性别',
		                    name: 'comGender',
		                    id: 'comGender',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: [
				                	["0", "全部"], 
				                    ["1", "男"], 
				                    ["2", "女"]
					            ]
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—性别—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                },{
		                    xtype:'textfield',
		                    fieldLabel: '创建人',
		                    id: 'txtUserName',
		                    name: 'txtUserName',
		                    anchor:'95%'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    fieldLabel: '客户类型',
		                    name: 'comCtype',
		                    id: 'comCtype',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: [
				                	["0", "全部"],
				                	["1", "业主"],
				                	["2", "求租"],
				                	["3", "求购"]
					            ]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—客户类型—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                },{
		                    xtype:'textfield',
		                    fieldLabel: '手机',
		                    id: 'txtMobile',
		                    name: 'txtMobile',
		                    anchor:'95%'
		                },{
		                    fieldLabel: '更新时间（开始）',
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
		                    fieldLabel: '房产类型',
		                    name: 'comBuildType',
		                    id: 'comBuildType',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: [
				                	["0", "全部"], 
				                    ["1", "住宅"], 
				                    ["2", "别墅"],
				                    ["3", "写字楼"],
				                    ["4", "商铺"],
				                    ["5", "小产权"],
				                    ["6", "厂房"],
				                    ["7", "其他"]
					            ]
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—房产类型—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                },{  
		                    fieldLabel: '户型',
		                    name: 'comRoomNum',
		                    id: 'comRoomNum',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: [
									["0", "全部"], 
									["1", "1室"], 
									["2", "2室"],
									["3", "3室"],
									["4", "4室"],
									["5", "5室以上"]
						        ]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—户型—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                },{
		                    fieldLabel: '更新时间（结束）',
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
		                    xtype:'textfield',
		                    fieldLabel: '姓名',
		                    id: 'txtName',
		                    name: 'txtName',
		                    anchor:'95%'
		                },{  
		                    fieldLabel: '产权面积',
		                    name: 'comArea',
		                    id: 'comArea',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: [
									["0", "全部"], 
									["1", "100㎡以下"], 
									["2", "100—200㎡"],
									["3", "200—300㎡"],
									["4", "300㎡以上"]
						        ]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—产权面积—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                },{  
		                    fieldLabel: '是否删除',
		                    name: 'comIsDelete',
		                    id: 'comIsDelete',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: [
									["-1", "全部"], 
				                	["0", "是"], 
				                    ["1", "否"]
					            ]
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—是否删除—",
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
		                    style: 'margin:26px 0 0 0',
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
		                    style: 'margin:26px 0 0 0',
							handler: function() {
								Ext.getCmp('txtCustomerId').reset();
								Ext.getCmp('comCtype').reset();
								Ext.getCmp('comBuildType').reset();
								Ext.getCmp('txtName').reset();
								Ext.getCmp('comGender').reset();
								Ext.getCmp('txtMobile').reset();
								Ext.getCmp('comRoomNum').reset();
								Ext.getCmp('comArea').reset();
								Ext.getCmp('txtUserName').reset();
								Ext.getCmp('beginDate').reset();
								Ext.getCmp('endDate').reset();
								Ext.getCmp('comIsDelete').reset();
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
						"id", "buildType", "buildTypeName", "ctype", "name", "gender", "phone", "mobile", "bigAreaCode", "bigAreaName", 
						"smallAreaCode", "smallAreaName", "roomNum", "hallNum", "toiletNum", "beginFirstPayment", "endFirstPayment", 
						"beginArea", "endArea", "beginUnitPrice", "endUnitPrice", "beginTotalPrice", "endTotalPrice", "year", "month", 
						"description", "syncTime", "version", "updateTime", "creater", "userName", "createTime", "isDelete"
					]
				}),
				proxy: new Ext.data.HttpProxy({
				　　url:basePath + 'customer/customerList.do',
				　　method:'GET'
				}),
				remoteSort:true
			});
			store.on('beforeload', function(store, options){
				if(Ext.getCmp('txtCustomerId').getValue().trim() != ""){
					options.params.id = Ext.getCmp('txtCustomerId').getValue();
				}
				if(Ext.getCmp('comCtype').getValue() != "" && Ext.getCmp('comCtype').getValue() > 0){
					options.params.ctype = Ext.getCmp('comCtype').getValue();
				}
				if(Ext.getCmp('comBuildType').getValue() != "" && Ext.getCmp('comBuildType').getValue() > 0){
					options.params.buildType = Ext.getCmp('comBuildType').getValue();
				}
				if(Ext.getCmp('txtName').getValue().trim() != ""){
					options.params.name = Ext.getCmp('txtName').getValue();
				}
				if(Ext.getCmp('comGender').getValue() != "" && Ext.getCmp('comGender').getValue() > 0){
					options.params.gender = Ext.getCmp('comGender').getValue();
				}
				if(Ext.getCmp('txtMobile').getValue().trim() != ""){
					options.params.mobile = Ext.getCmp('txtMobile').getValue();
				}
				if(Ext.getCmp('comRoomNum').getValue() != "" && Ext.getCmp('comRoomNum').getValue() > 0){
					if(Ext.getCmp('comRoomNum').getValue() == 1){
						options.params.beginRoomNum = 1;
						options.params.endRoomNum = 1;
					}else if(Ext.getCmp('comRoomNum').getValue() == 2){
						options.params.beginRoomNum = 2;
						options.params.endRoomNum = 2;
					}else if(Ext.getCmp('comRoomNum').getValue() == 3){
						options.params.beginRoomNum = 3;
						options.params.endRoomNum = 3;
					}else if(Ext.getCmp('comRoomNum').getValue() == 4){
						options.params.beginRoomNum = 4;
						options.params.endRoomNum = 4;
					}else if(Ext.getCmp('comRoomNum').getValue() == 5){
						options.params.beginRoomNum = 5;
					}
				}
				if(Ext.getCmp('comArea').getValue() != "" && Ext.getCmp('comArea').getValue() > 0){
					if(Ext.getCmp('comArea').getValue() == 1){
						options.params.endArea = 100;
					}else if(Ext.getCmp('comArea').getValue() == 2){
						options.params.beginArea = 100;
						options.params.endArea = 200;
					}else if(Ext.getCmp('comArea').getValue() == 3){
						options.params.beginArea = 200;
						options.params.endArea = 300;
					}else if(Ext.getCmp('comArea').getValue() == 4){
						options.params.beginArea = 300;
					}
				}
				if(Ext.getCmp('txtUserName').getValue().trim() != ""){
					options.params.userName = Ext.getCmp('txtUserName').getValue();
				}
				if(Ext.getCmp('beginDate').getValue() != ""){
					options.params.beginDate = Ext.getCmp('beginDate').getValue();
				}
				if(Ext.getCmp('endDate').getValue() != ""){
					options.params.endDate = Ext.getCmp('endDate').getValue();
				}
				if(Ext.getCmp('comIsDelete').getValue() != "" && Ext.getCmp('comIsDelete').getValue() > -1){
					options.params.isDelete = Ext.getCmp('comIsDelete').getValue();
				}
			});
			store.on('load', function(store){
				dataGridCustomer.getSelectionModel().selectFirstRow();
				//dataGridCustomer.setHeight(window.parent.Ext.get('menuPanel').getHeight() - 129);
			});
			window.onresize = function(){
				dataGridCustomer.setHeight(window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight);
			}
			store.load({params:{start:0, limit:20}});

			colModel = new Ext.grid.ColumnModel([
				new Ext.grid.RowNumberer(),
				{id:'id',dataIndex:'id',header:'客源ID',width:20,sortable:true,hidden:false},
				{dataIndex:'ctype',header:'客户类型',width:23,sortable:false,renderer:renderCtype},
				{dataIndex:'buildType',header:'房产类型',width:23,sortable:false,renderer:renderBuildType},
				{dataIndex:'name',header:'姓名',width:30,sortable:false,renderer:renderCustomer},
				{dataIndex:'gender',header:'性别',width:15,sortable:false,renderer:renderGender},
				{dataIndex:'mobile',header:'手机',width:30,sortable:false},
				{header:'户型',width:20,sortable:false,renderer:renderRoomNum},
				{header:'产权面积',width:30,sortable:false,renderer:renderArea},
				{dataIndex:'userName',header:'创建人',width:30,sortable:false},
				{dataIndex:'updateTime',header:'更新时间',width:50,sortable:true},
				{dataIndex:'version',header:'版本号',width:20,sortable:true},
				{dataIndex:'isDelete',header:'是否删除',width:25,sortable:false,renderer:renderIsDelete},
				{dataIndex:'description',header:'描述',sortable:false}
			]);
				
			dataGridCustomer = new Ext.grid.GridPanel({
				width:'100%',
				autoWidth:true,
				height:window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight,
				//autoHeight:true,
				renderTo: 'dataGridCustomer',
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
						detailCustomer(record);
					}
				}
			});

			tabPanel = new Ext.TabPanel({
				id: 'tabPanel',
                autoScroll: true,
                deferredRender: false,
                activeTab: 0,
				autoHeight: true,
				plugins: new Ext.ux.TabCloseMenu(),
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
	    	<div id="dataGridCustomer"></div>
    	</div>
    	<div id="imageModePanel">
    	</div>
    </div>
  </body>
</html>