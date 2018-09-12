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
	<script type="text/javascript" scr="js/jquery/jquery.json.js"></script>
	<script type="text/javascript" src="js/comm.js"></script>
	<script type="text/javascript">
		var store, colModel, dataGridHouseReadily, searchForm, tabPanel, dataModePanel, imageModePanel;
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
		                    fieldLabel: '房源ID',
		                    id:'txtHouseReadilyId',
		                    name: 'txtHouseReadilyId',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    fieldLabel: '楼盘名称',
		                    id: 'txtProjectName',
		                    name: 'txtProjectName',
		                    anchor:'95%'
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
		                    fieldLabel: '租售类型',
		                    name: 'comStype',
		                    id: 'comStype',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: [
				                	["0", "全部"],
				                	["1", "出售"],
				                	["2", "出租"]
					            ]  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—租售类型—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local"
		                },{  
		                    fieldLabel: '城市',
		                    name: 'comCityCode',
		                    id: 'comCityCode',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: []  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—城市—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local",
			                listeners: {
								'change': function(combo, newValue, oldValue) {
		                			initAreaData();
								}
							}
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
		                    fieldLabel: '大区',
		                    name: 'comBigAreaCode',
		                    id: 'comBigAreaCode',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: []  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—大区—",
		                    anchor: '95%',
		                    triggerAction: 'all',
		                    mode: "local",
		                    listeners: {
								'change': function(combo, newValue, oldValue) {
		                			initSubAreaData();
								}
							}
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
		                    fieldLabel: '标题',
		                    id: 'txtTitle',
		                    name: 'txtTitle',
		                    anchor:'95%'
		                },{  
		                    fieldLabel: '小区',
		                    name: 'comSmallAreaCode',
		                    id: 'comSmallAreaCode',
		                    xtype: 'combo',
		                    store: new Ext.data.SimpleStore({  
		                        fields: ["value", "text"],  
		                        data: []  
		                    }),
		                    //editable: false,
		                    valueField: "value",
		                    displayField: "text",
		                    emptyText: "—小区—",
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
								Ext.getCmp('txtHouseReadilyId').reset();
								Ext.getCmp('comStype').reset();
								Ext.getCmp('comBuildType').reset();
								Ext.getCmp('txtTitle').reset();
								Ext.getCmp('txtProjectName').reset();
								Ext.getCmp('comCityCode').reset();
								Ext.getCmp('comBigAreaCode').reset();
								Ext.getCmp('comBigAreaCode').getStore().removeAll();
								Ext.getCmp('comSmallAreaCode').reset();
								Ext.getCmp('comSmallAreaCode').getStore().removeAll();
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
						"id", "stype", "projectId", "projectName", "cityCode", "cityEn", "cityName", "bigAreaCode", "bigAreaName", 
						"smallAreaCode", "smallAreaName", "lon", "lat", "buildType", "buildTypeName", "title", "building", 
						"houseNum", "roomNum", "hallNum", "toiletNum", "area", "unitPrice", "totalPrice", "hasRedBook", "description", 
						"address", "lastFollowDate", "syncTime", "version", "updateTime", "creater", "userName", "createTime", "isDelete"
					]
				}),
				proxy: new Ext.data.HttpProxy({
				　　url:basePath + 'houseReadily/houseReadilyList.do',
				　　method:'GET'
				}),
				remoteSort:true
			});
			store.on('beforeload', function(store, options){
				if(Ext.getCmp('txtHouseReadilyId').getValue().trim() != ""){
					options.params.id = Ext.getCmp('txtHouseReadilyId').getValue();
				}
				if(Ext.getCmp('comStype').getValue() != "" && Ext.getCmp('comStype').getValue() > 0){
					options.params.stype = Ext.getCmp('comStype').getValue();
				}
				if(Ext.getCmp('comBuildType').getValue() != "" && Ext.getCmp('comBuildType').getValue() > 0){
					options.params.buildType = Ext.getCmp('comBuildType').getValue();
				}
				if(Ext.getCmp('txtTitle').getValue().trim() != ""){
					options.params.title = Ext.getCmp('txtTitle').getValue();
				}
				if(Ext.getCmp('txtProjectName').getValue().trim() != ""){
					options.params.projectName = Ext.getCmp('txtProjectName').getValue();
				}
				if(Ext.getCmp('comCityCode').getValue() != "" && Ext.getCmp('comCityCode').getValue() > 0){
					options.params.cityCode = Ext.getCmp('comCityCode').getValue();
				}
				if(Ext.getCmp('comBigAreaCode').getValue() != "" && Ext.getCmp('comBigAreaCode').getValue() > 0){
					options.params.bigAreaCode = Ext.getCmp('comBigAreaCode').getValue();
				}
				if(Ext.getCmp('comSmallAreaCode').getValue() != "" && Ext.getCmp('comSmallAreaCode').getValue() > 0){
					options.params.smallAreaCode = Ext.getCmp('comSmallAreaCode').getValue();
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
				dataGridHouseReadily.getSelectionModel().selectFirstRow();
				//dataGridHouseReadily.setHeight(window.parent.Ext.get('menuPanel').getHeight() - 129);
			});
			window.onresize = function(){
				dataGridHouseReadily.setHeight(window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight);
			}
			store.load({params:{start:0, limit:20}});

			colModel = new Ext.grid.ColumnModel([
				new Ext.grid.RowNumberer(),
				{id:'id',dataIndex:'id',header:'房源ID',width:20,sortable:true,hidden:false},
				{dataIndex:'stype',header:'租售类型',width:23,sortable:false,renderer:renderStype},
				{dataIndex:'buildType',header:'房产类型',width:23,sortable:false,renderer:renderBuildType},
				{dataIndex:'title',header:'标题',width:50,sortable:false},
				{dataIndex:'projectName',header:'楼盘名称',width:50,sortable:false,renderer:renderHouseReadily},
				{dataIndex:'cityName',header:'城市',width:20,sortable:false},
				{dataIndex:'bigAreaName',header:'大区',width:20,sortable:false},
				{dataIndex:'smallAreaName',header:'小区',width:20,sortable:false},
				{dataIndex:'userName',header:'创建人',width:30,sortable:false},
				{dataIndex:'lastFollowDate',header:'最后跟进时间',width:50,sortable:true},
				{dataIndex:'updateTime',header:'更新时间',width:50,sortable:true},
				{dataIndex:'version',header:'版本号',width:20,sortable:true},
				{dataIndex:'isDelete',header:'是否删除',width:25,sortable:false,renderer:renderIsDelete},
				{dataIndex:'description',header:'描述',sortable:false}
			]);
				
			dataGridHouseReadily = new Ext.grid.GridPanel({
				width:'100%',
				autoWidth:true,
				height:window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight,
				//autoHeight:true,
				renderTo: 'dataGridHouseReadily',
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
						detailHouseReadily(record);
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

			// 加载数据
		    initData();
		});

		function initData() {
			var store = Ext.getCmp('comCityCode').getStore();
			if(store.data.length == 0){
				$.get(basePath + 'rest/cityArea/10461?auth=ae5b5f5b0494a0a7eaffdc1658ed5159&userId=10461&format=json&timestamp=2012-12-25 14:43:41&action=citylist', {}, function(json){
			    	var cityList = eval('('+json.housereadily+')').tableSet.list;
			    	var records = new Array();
			    	records[0] = new Ext.data.Record({
						value: "0",
						text: "全部"
					});
			    	for(var i = 0; i < cityList.length; i++){
			    		records[i + 1] = new Ext.data.Record({
			    			value: cityList[i].cityCode,
							text: cityList[i].cityName
						});
					}
			    	store.add(records);
			    });
			}
		}

		function initAreaData() {
			Ext.getCmp('comBigAreaCode').reset();
			Ext.getCmp('comSmallAreaCode').reset();
			Ext.getCmp('comBigAreaCode').getStore().removeAll();
			Ext.getCmp('comSmallAreaCode').getStore().removeAll();
			
			var store = Ext.getCmp('comBigAreaCode').getStore();
			var cityCode = Ext.getCmp('comCityCode').getValue();
			if(cityCode != "" && cityCode > 0){
				$.get(basePath + 'rest/cityArea/10461?auth=ae5b5f5b0494a0a7eaffdc1658ed5159&userId=10461&format=json&timestamp=2012-12-25 14:47:34&action=arealist&cityCode=' + cityCode, {}, function(json){
			    	var areaList = eval('('+json.housereadily+')').tableSet.list;
			    	var records = new Array();
			    	records[0] = new Ext.data.Record({
						value: "0",
						text: "全部"
					});
			    	for(var i = 0; i < areaList.length; i++){
			    		records[i + 1] = new Ext.data.Record({
			    			value: areaList[i].id,
							text: areaList[i].name
						});
					}
			    	store.add(records);
			    });
			}
		}

		function initSubAreaData() {
			Ext.getCmp('comSmallAreaCode').reset();
			Ext.getCmp('comSmallAreaCode').getStore().removeAll();
			
			var store = Ext.getCmp('comSmallAreaCode').getStore();
			var cityCode = Ext.getCmp('comCityCode').getValue();
			var bigAreaCode = Ext.getCmp('comBigAreaCode').getValue();
			if(bigAreaCode != "" && bigAreaCode > 0){
				$.get(basePath + 'rest/cityArea/10461?auth=ae5b5f5b0494a0a7eaffdc1658ed5159&userId=10461&format=json&timestamp=2012-12-25 14:47:34&action=arealist&cityCode=' + cityCode, {}, function(json){
			    	var areaList = eval('('+json.housereadily+')').tableSetTwo.list;
			    	var records = new Array();
			    	records[0] = new Ext.data.Record({
						value: "0",
						text: "全部"
					});
			    	for(var i = 0, j = 1; i < areaList.length; i++){
				    	if(areaList[i].parentId == bigAreaCode){
				    		records[j++] = new Ext.data.Record({
				    			value: areaList[i].id,
								text: areaList[i].name
							});
						}
					}
			    	store.add(records);
			    });
			}
		}
	</script>
  </head>
  
  <body>
    <div id="tabPanel">
  		<div id="dataModePanel">
	  		<div id="searchForm"></div>
	    	<div id="dataGridHouseReadily"></div>
    	</div>
    	<div id="imageModePanel">
    	</div>
    </div>
  </body>
</html>
