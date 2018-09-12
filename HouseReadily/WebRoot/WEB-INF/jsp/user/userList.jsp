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
		var store, colModel, dataGridUser, searchForm, tabPanel, dataModePanel, imageModePanel;
		var searchHeight = 70, toolbarHeight = 58;
		Ext.onReady(function(){
			searchForm = new Ext.FormPanel({
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
		                    fieldLabel: '用户ID',
		                    id:'txtUserId',
		                    name: 'txtUserId',
		                    anchor:'95%'
		                },{
		                    fieldLabel: 'Email',
		                    name: 'txtEmail',
		                    id: 'txtEmail',
		                    xtype: 'textfield',
		                    anchor: '95%'
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
		                    mode: "local"
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
		                    fieldLabel: '注册时间（开始）',
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
		                    fieldLabel: '手机',
		                    name: 'txtMobile',
		                    id: 'txtMobile',
		                    xtype: 'textfield',
		                    anchor: '95%'
		                },{
		                    fieldLabel: '注册时间（结束）',
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
		                },{
		                	text: '导出手机号码',
		                    name: 'btnExportMoblie',
		                    id: 'btnExportMoblie',
		                    xtype: 'button',
		                    anchor: '95%',
		                    //style: 'margin:15px 0 0 0',
		                    handler: function() {
								var url = basePath + 'user/export.do?t=' + new Date().getTime();
								if(Ext.getCmp('txtUserId').getValue().trim() != ""){
									url += '&txtUserId=' + Ext.getCmp('txtUserId').getValue();
								}
								if(Ext.getCmp('txtEmail').getValue().trim() != ""){
									url += '&email=' + Ext.getCmp('txtEmail').getValue();
								}
								if(Ext.getCmp('txtUserName').getValue().trim() != ""){
									url += '&userName=' + Ext.getCmp('txtUserName').getValue();
								}
								if(Ext.getCmp('comRegSource').getValue().trim() != "" && Ext.getCmp('comRegSource').getValue() > 0){
									url += '&regSource=' + Ext.getCmp('comRegSource').getValue();
								}
								if(Ext.getCmp('comCityCode').getValue() != "" && Ext.getCmp('comCityCode').getValue() > 0){
									url += '&cityCode=' + Ext.getCmp('comCityCode').getValue();
								}
								if(Ext.getCmp('beginDate').getValue() != ""){
									var d = Ext.getCmp('beginDate').getValue();
									url += '&beginDate=' + d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
								}
								if(Ext.getCmp('endDate').getValue() != ""){
									var d = Ext.getCmp('endDate').getValue();
									url += '&endDate=' + d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
								}
								if(Ext.getCmp('txtMobile').getValue().trim() != "" && Ext.getCmp('txtMobile').getValue() > 0){
									url += '&mobile=' + Ext.getCmp('txtMobile').getValue();
								}
	                			window.open(url, '', 'width=1024,height=768,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
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
								Ext.getCmp('txtUserId').reset();
								Ext.getCmp('txtEmail').reset();
								Ext.getCmp('txtUserName').reset();
								Ext.getCmp('comCityCode').reset();
								Ext.getCmp('beginDate').reset();
								Ext.getCmp('comRegSource').reset();
								Ext.getCmp('endDate').reset();
								Ext.getCmp('txtMobile').reset();
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
						'id', 'name', 'cityName', 'email', 'mobile', 'regDate', 'regSource', 'houseReadilyCount', 'customerCount', 'level', 'growing', 'integration'
					]
				}),
				proxy: new Ext.data.HttpProxy({
				　　url:basePath + 'user/userList.do',
				　　method:'GET'
				}),
				remoteSort:true
			});
			store.on('beforeload', function(store, options){
				if(Ext.getCmp('txtUserId').getValue().trim() != ""){
					options.params.id = Ext.getCmp('txtUserId').getValue();
				}
				if(Ext.getCmp('txtEmail').getValue().trim() != ""){
					options.params.email = Ext.getCmp('txtEmail').getValue();
				}
				if(Ext.getCmp('txtUserName').getValue().trim() != ""){
					options.params.userName = Ext.getCmp('txtUserName').getValue();
				}
				if(Ext.getCmp('comRegSource').getValue().trim() != "" && Ext.getCmp('comRegSource').getValue() > 0){
					options.params.regSource = Ext.getCmp('comRegSource').getValue();
				}
				if(Ext.getCmp('comCityCode').getValue() != "" && Ext.getCmp('comCityCode').getValue() > 0){
					options.params.cityCode = Ext.getCmp('comCityCode').getValue();
				}
				if(Ext.getCmp('beginDate').getValue() != ""){
					options.params.beginDate = Ext.getCmp('beginDate').getValue();
				}
				if(Ext.getCmp('endDate').getValue() != ""){
					options.params.endDate = Ext.getCmp('endDate').getValue();
				}
				if(Ext.getCmp('txtMobile').getValue().trim() != "" && Ext.getCmp('txtMobile').getValue() > 0){
					options.params.mobile = Ext.getCmp('txtMobile').getValue();
				}
			});
			store.on('load', function(store){
				dataGridUser.getSelectionModel().selectFirstRow();
				//dataGridUser.setHeight(window.parent.Ext.get('menuPanel').getHeight() - 29);
			});
			window.onresize = function(){
				dataGridUser.setHeight(window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight);
			}
			store.load({params:{start:0, limit:20}});

			colModel = new Ext.grid.ColumnModel([
				new Ext.grid.RowNumberer(),
				{id:'id',dataIndex:'id',header:'用户ID',width:20,sortable:true,hidden:false},
				{dataIndex:'name',header:'用户名',width:40,sortable:false,renderer:renderCuser},
				{dataIndex:'cityName',header:'城市',width:20,sortable:false},
				{dataIndex:'mobile',header:'手机',width:40,sortable:false/*,align:'center',renderer:renderRoom*/},
				{dataIndex:'email',header:'Email',width:40,sortable:false},
				{dataIndex:'houseReadilyCount',header:'房源数',width:20,sortable:true},
				{dataIndex:'customerCount',header:'客源数',width:20,sortable:true},
				{dataIndex:'level',header:'等级',width:20,sortable:true},
				{dataIndex:'growing',header:'经验值',width:20,sortable:true},
				{dataIndex:'integration',header:'积分',width:20,sortable:true},
				{dataIndex:'regDate',header:'注册时间',width:50,sortable:true},
				{dataIndex:'regSource',header:'注册来源',width:50,sortable:false,renderer:renderRegSource}
			]);
				
			dataGridUser = new Ext.grid.GridPanel({
				width:'100%',
				autoWidth:true,
				height:window.parent.Ext.get('menuPanel').getHeight() - searchHeight - toolbarHeight,
				//autoHeight:true,
				renderTo: 'dataGridUser',
				store: store,
				trackMouseOver:false,
				disableSelection:true,
				loadMask: true,
				cm: colModel,
				sm: new Ext.grid.RowSelectionModel({  
					singleSelect: true  
				}),
				enableColumnMove:true,//拖放列   
				enableColumnResize:true,//改变列的宽度   
				stripeRows:true,//表格显示斑马线效果
				viewConfig: {
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
						detailCuser(record);
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
                    //id: 'dataModePanel',
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
							var url = '<%=basePath%>user/toUserImgList.do';
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
	</script>
  </head>
  
  <body>
  	<div id="tabPanel">
  		<div id="dataModePanel">
	  		<div id="searchForm"></div>
	    	<div id="dataGridUser"></div>
    	</div>
    	<div id="imageModePanel">
    	</div>
    </div>
  </body>
</html>
