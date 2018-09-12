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
		var jsonObject = ${jsonObject};
		var customer = jsonObject.customer;
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
		        	{name: 'isMain'},
		        	{name: 'customerId'},
		         	{name: 'customerName'},
		         	{name: 'houseReadilyId'},
		         	{name: 'houseReadilyName'},
		           	{name: 'gender'},
		           	{name: 'mobile'}
		     	]
			});
			ownerStore.loadData(ownerData);

			// 跟进记录
			followData = [];
			followStore = new Ext.data.ArrayStore({
				fields: [
		        	{name: 'id'},
		         	{name: 'customerName'},
		           	{name: 'mode'},
		           	{name: 'description'},
		           	{name: 'createTime'}
		     	]
			});
			followStore.loadData(followData);

			// 客源信息
			formPanel = new Ext.FormPanel({
		        labelWidth: 80,
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
		                    fieldLabel: '客源ID',
		                    id:'txtCustomerId',
		                    name: 'txtCustomerId',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '城市',
		                    id:'txtCityName',
		                    name: 'txtCityName',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '户型',
		                    id:'txtRoomNum',
		                    name: 'txtRoomNum',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
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
		                    editable: false,
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
		                    readOnly: true,
		                    fieldLabel: '大区',
		                    id: 'txtBigAreaName',
		                    name: 'txtBigAreaName',
		                    anchor:'95%'
		                },{
		                	xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '产权面积',
		                    id:'txtArea',
		                    name: 'txtArea',
		                    anchor:'95%'
		                },{
		                    fieldLabel: '创建时间',
		                    name: 'createTime',
		                    id: 'createTime',
		                    xtype: 'datefield',
		                    format: 'Y-m-d H:i:s',
		                    anchor: '95%'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                	fieldLabel: '房产类型',
		                	editable: false,
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
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '小区',
		                    id:'txtSmallAreaName',
		                    name: 'txtSmallAreaName',
		                    anchor:'95%'
		                },{
		                	xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '总价',
		                    id:'txtTotalPrice',
		                    name: 'txtTotalPrice',
		                    anchor:'95%'
		                },{
		                    fieldLabel: '最后跟进时间',
		                    name: 'lastFollowDate',
		                    id: 'lastFollowDate',
		                    xtype: 'datefield',
		                    format: 'Y-m-d H:i:s',
		                    anchor: '95%'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '姓名',
		                    id: 'txtName',
		                    name: 'txtName',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '联系方式',
		                    id:'txtMobile',
		                    name: 'txtMobile',
		                    anchor:'95%'
		                },{
		                	xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '首付',
		                    id:'txtFirstPayment',
		                    name: 'txtFirstPayment',
		                    anchor:'95%'
		                },{
		                    fieldLabel: '更新时间',
		                    name: 'updateTime',
		                    id: 'updateTime',
		                    xtype: 'datefield',
		                    format: 'Y-m-d H:i:s',
		                    anchor: '95%'
		                }]
		            },{
		                columnWidth:.2,
		                layout: 'form',
		                border:false,
		                items: [{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '性别',
		                    id: 'txtGender',
		                    name: 'txtGender',
		                    anchor:'95%'
		                },{
		                	xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '电话',
		                    id: 'txtPhone',
		                    name: 'txtPhone',
		                    anchor:'95%'
		                },{
		                	xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '入住时间',
		                    id: 'checkInDate',
		                    name: 'checkInDate',
		                    anchor:'95%'
		                },{
		                    fieldLabel: '同步时间',
		                    name: 'syncTime',
		                    id: 'syncTime',
		                    xtype: 'datefield',
		                    format: 'Y-m-d H:i:s',
		                    anchor: '95%'
		                }]
		            }]
		        },{
		            xtype:'textfield',
		            readOnly: true,
		            id:'txtDescription',
		            name:'txtDescription',
		            fieldLabel:'描述',
		            //height:200,
		            anchor:'99%'
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
		                title:'关联房源',
		                layout:'fit',
			           	items: {
			           		xtype: 'grid',
			                ds: ownerStore,
			                cm: new Ext.grid.ColumnModel([
			 					new Ext.grid.RowNumberer(),
								{id:'id',dataIndex:'id',header:'ID',width:20,sortable:true,hidden:true},
								{dataIndex:'houseReadilyName',header:'房源',sortable:false,renderer:renderHouseReadily2}
							]),
			                sm: new Ext.grid.RowSelectionModel({
			                    singleSelect: true
			                }),
			                autoExpandColumn: 'houseReadilyName',
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
		                title:'跟进记录',
		                layout:'fit',
			           	items: {
			           		xtype: 'grid',
			                ds: followStore,
			                cm: new Ext.grid.ColumnModel([
			 					new Ext.grid.RowNumberer(),
								{id:'id',dataIndex:'id',header:'ID',width:20,sortable:true,hidden:true},
								{dataIndex:'customerName',header:'姓名',width:20,sortable:false},
								{dataIndex:'mode',header:'跟进方式',width:20,sortable:false,renderer:renderMode},
								{dataIndex:'createTime',header:'跟进时间',width:30,sortable:false},
								{dataIndex:'description',header:'描述',sortable:false,renderer:cellNormal}
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
		            }]
		        }]/*,
		        buttons: [{
		            text: 'Save'
		        },{
		            text: 'Cancel'
		        }]*/
		    });

		    formPanel.render(document.body);
		    //formPanel.disable();
		    Ext.getCmp('createTime').disable();
		    Ext.getCmp('lastFollowDate').disable();
			Ext.getCmp('updateTime').disable();
			Ext.getCmp('syncTime').disable();

		    // 加载数据
		    initData();
		});

		window.onresize = function(){
			formPanel.setHeight(window.parent.parent.Ext.get('menuPanel').getHeight() - toolbarHeight);
			Ext.getCmp('tabPanelEdit').setHeight(window.parent.parent.Ext.get('menuPanel').getHeight() - toolbarHeight - 150);
		}

		function initData() {
			// 客源信息
			Ext.getCmp('txtCustomerId').setValue(customer.id);
			Ext.getCmp('comCtype').setValue(customer.ctype);
			Ext.getCmp('comBuildType').setValue(customer.buildType);
			Ext.getCmp('txtName').setValue(customer.name);
			Ext.getCmp('txtGender').setValue(renderGender(customer.gender));
			Ext.getCmp('txtCityName').setValue(customer.cityName);
			Ext.getCmp('txtBigAreaName').setValue(customer.bigAreaName);
			Ext.getCmp('txtSmallAreaName').setValue(customer.smallAreaName);
			Ext.getCmp('txtMobile').setValue(customer.mobile);
			Ext.getCmp('txtPhone').setValue(customer.phone);
			Ext.getCmp('txtRoomNum').setValue(renderRoomNum2(customer.roomNum, customer.hallNum));
			Ext.getCmp('txtArea').setValue(renderArea2(customer.beginArea, customer.endArea));
			Ext.getCmp('txtTotalPrice').setValue(renderPrice2(customer.ctype, customer.beginTotalPrice, customer.endTotalPrice));
			Ext.getCmp('txtFirstPayment').setValue(renderPrice2(customer.ctype, customer.beginFirstPayment, customer.endFirstPayment));
			Ext.getCmp('checkInDate').setValue(rendercheckInDate2(customer.year, customer.month));
			Ext.getCmp('txtUserName').setValue(customer.userName);
			Ext.getCmp('createTime').setValue(customer.createTime);
			Ext.getCmp('lastFollowDate').setValue(customer.lastFollowDate);
			Ext.getCmp('updateTime').setValue(customer.updateTime);
			Ext.getCmp('syncTime').setValue(customer.syncTime);
			Ext.getCmp('txtDescription').setValue(customer.description);

			// 关联房源
			var houseOwners = customer.houseOwners.list;
			if(houseOwners.length > 0){
				for(var i = 0; i < houseOwners.length; i++){
					ownerData.push(new Array(houseOwners[i].id, houseOwners[i].isMain, houseOwners[i].customerId, houseOwners[i].customerName, houseOwners[i].houseReadilyId, houseOwners[i].houseReadilyName, houseOwners[i].gender, houseOwners[i].mobile));
				}
				ownerStore.loadData(ownerData);
			}

			// 跟进记录
			var houseFollows = customer.houseFollows.list;
			if(houseFollows.length > 0){
				for(var i = 0; i < houseFollows.length; i++){
					followData.push(new Array(houseFollows[i].id, houseFollows[i].customerName, houseFollows[i].mode, houseFollows[i].description, houseFollows[i].createTime));
				}
				followStore.loadData(followData);
			}
		}
	</script>

  </head>
  
  <body>
  </body>
</html>
