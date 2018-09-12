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
		var houseReadily = jsonObject.houseReadily;
		var ownerData, ownerStore;
		var followData, followStore;
		var attachmentData, attachmentStore;
		var formPanel;
		var toolbarHeight = 58;
		Ext.onReady(function(){
			// 业主信息
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

			// 附件信息
			attachmentData = [];
			attachmentStore = new Ext.data.ArrayStore({
				fields: [
		        	{name: 'id'},
		        	{name: 'type'},
		         	{name: 'name'},
		         	{name: 'path'},
		           	{name: 'size'},
		           	{name: 'isPicture'},
		           	{name: 'createTime'}
		     	]
			});
			attachmentStore.loadData(attachmentData);

			// 房源信息
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
		                    fieldLabel: '房源ID',
		                    id:'txtHouseReadilyId',
		                    name: 'txtHouseReadilyId',
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
		                    fieldLabel: '房型',
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
		                    fieldLabel: '租售类型',
		                    editable: false,
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
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '大区',
		                    id: 'txtBigAreaName',
		                    name: 'txtBigAreaName',
		                    anchor:'95%'
		                },{
		                    xtype:'numberfield',
		                    readOnly: true,
		                    fieldLabel: '产权面积(㎡)',
		                    id:'txtArea',
		                    name: 'txtArea',
		                    decimalPrecision: 2, //精确到小数点后两位  
		                    allowDecimals: true, //允许输入小数
		                    allowNegative: false, //允许输入负数
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
		                    fieldLabel: '小区',
		                    id:'txtSmallAreaName',
		                    name: 'txtSmallAreaName',
		                    anchor:'95%'
		                },{
		                    xtype:'numberfield',
		                    readOnly: true,
		                    fieldLabel: '总价(元)',
		                    id:'txtTotalPrice',
		                    name: 'txtTotalPrice',
		                    decimalPrecision: 2, //精确到小数点后两位  
		                    allowDecimals: true, //允许输入小数
		                    allowNegative: false, //允许输入负数
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
		                    fieldLabel: '标题',
		                    id: 'txtTitle',
		                    name: 'txtTitle',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '栋数',
		                    id:'txtBuilding',
		                    name: 'txtBuilding',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '红本在手',
		                    id:'txtHasRedBook',
		                    name: 'txtHasRedBook',
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
		                    fieldLabel: '楼盘名称',
		                    id: 'txtProjectName',
		                    name: 'txtProjectName',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '房号',
		                    id:'txtHouseNum',
		                    name: 'txtHouseNum',
		                    anchor:'95%'
		                },{
		                    xtype:'textfield',
		                    readOnly: true,
		                    fieldLabel: '版本号',
		                    id:'txtVersion',
		                    name: 'txtVersion',
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
		                title:'业主信息',
		                layout:'fit',
			           	items: {
			           		xtype: 'grid',
			                ds: ownerStore,
			                cm: new Ext.grid.ColumnModel([
			 					new Ext.grid.RowNumberer(),
								{id:'id',dataIndex:'id',header:'ID',width:20,sortable:true,hidden:true},
								{dataIndex:'isMain',header:'主要联系人',width:15,sortable:false,renderer:renderYesNo},
								{dataIndex:'customerName',header:'姓名',width:20,sortable:false,renderer:renderCustomer2},
								{dataIndex:'gender',header:'性别',width:20,sortable:false,renderer:renderGender},
								{dataIndex:'mobile',header:'联系方式',sortable:false}
							]),
			                sm: new Ext.grid.RowSelectionModel({
			                    singleSelect: true
			                }),
			                autoExpandColumn: 'mobile',
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
		            },{
		                title:'附件信息',
		                layout:'fit',
			           	items: {
			           		xtype: 'grid',
			                ds: attachmentStore,
			                cm: new Ext.grid.ColumnModel([
			 					new Ext.grid.RowNumberer(),
								{id:'id',dataIndex:'id',header:'ID',width:20,sortable:true,hidden:true},
								{dataIndex:'isPicture',header:'是否图片',width:15,sortable:false,renderer:renderYesNo},
								{dataIndex:'name',header:'文件名',width:50,sortable:false,renderer:renderAttachmentPath},
								{dataIndex:'type',header:'类别',width:20,sortable:false,renderer:renderAttachmentType},
								{dataIndex:'size',header:'文件大小(字节)',width:30,sortable:false},
								{dataIndex:'createTime',header:'上传时间',sortable:false}
							]),
			                sm: new Ext.grid.RowSelectionModel({
			                    singleSelect: true
			                }),
			                autoExpandColumn: 'createTime',
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
			// 房源信息
			Ext.getCmp('txtHouseReadilyId').setValue(houseReadily.id);
			Ext.getCmp('comStype').setValue(houseReadily.stype);
			Ext.getCmp('comBuildType').setValue(houseReadily.buildType);
			Ext.getCmp('txtTitle').setValue(houseReadily.title);
			Ext.getCmp('txtProjectName').setValue(houseReadily.projectName);
			Ext.getCmp('txtCityName').setValue(houseReadily.cityName);
			Ext.getCmp('txtBigAreaName').setValue(houseReadily.bigAreaName);
			Ext.getCmp('txtSmallAreaName').setValue(houseReadily.smallAreaName);
			Ext.getCmp('txtBuilding').setValue(houseReadily.building);
			Ext.getCmp('txtHouseNum').setValue(houseReadily.houseNum);
			Ext.getCmp('txtRoomNum').setValue(renderRoomNum2(houseReadily.roomNum, houseReadily.hallNum));
			Ext.getCmp('txtArea').setValue(houseReadily.area);
			Ext.getCmp('txtTotalPrice').setValue(houseReadily.totalPrice);
			Ext.getCmp('txtHasRedBook').setValue(renderYesNo(houseReadily.hasRedBook));
			Ext.getCmp('txtVersion').setValue(houseReadily.version);
			Ext.getCmp('txtUserName').setValue(houseReadily.userName);
			Ext.getCmp('createTime').setValue(houseReadily.createTime);
			Ext.getCmp('lastFollowDate').setValue(houseReadily.lastFollowDate);
			Ext.getCmp('updateTime').setValue(houseReadily.updateTime);
			Ext.getCmp('syncTime').setValue(houseReadily.syncTime);
			Ext.getCmp('txtDescription').setValue(houseReadily.description);

			// 业主信息
			var houseOwners = houseReadily.houseOwners.list;
			if(houseOwners.length > 0){
				for(var i = 0; i < houseOwners.length; i++){
					ownerData.push(new Array(houseOwners[i].id, houseOwners[i].isMain, houseOwners[i].customerId, houseOwners[i].customerName, houseOwners[i].houseReadilyId, houseOwners[i].houseReadilyName, houseOwners[i].gender, houseOwners[i].mobile));
				}
				ownerStore.loadData(ownerData);
			}

			// 跟进记录
			var houseFollows = houseReadily.houseFollows.list;
			if(houseFollows.length > 0){
				for(var i = 0; i < houseFollows.length; i++){
					followData.push(new Array(houseFollows[i].id, houseFollows[i].customerName, houseFollows[i].mode, houseFollows[i].description, houseFollows[i].createTime));
				}
				followStore.loadData(followData);
			}

			// 附件信息
			var btAttachments = houseReadily.btAttachments.list;
			if(btAttachments.length > 0){
				for(var i = 0; i < btAttachments.length; i++){
					attachmentData.push(new Array(btAttachments[i].id, btAttachments[i].type, btAttachments[i].name, btAttachments[i].path, btAttachments[i].size, btAttachments[i].isPicture, btAttachments[i].createTime));
				}
			}
			var snAttachments = houseReadily.snAttachments.list;
			if(snAttachments.length > 0){
				for(var i = 0; i < snAttachments.length; i++){
					attachmentData.push(new Array(snAttachments[i].id, snAttachments[i].type, snAttachments[i].name, snAttachments[i].path, snAttachments[i].size, snAttachments[i].isPicture, snAttachments[i].createTime));
				}
			}
			var fxAttachments = houseReadily.fxAttachments.list;
			if(fxAttachments.length > 0){
				for(var i = 0; i < fxAttachments.length; i++){
					attachmentData.push(new Array(fxAttachments[i].id, fxAttachments[i].type, fxAttachments[i].name, fxAttachments[i].path, fxAttachments[i].size, fxAttachments[i].isPicture, fxAttachments[i].createTime));
				}
			}
			var xqAttachments = houseReadily.xqAttachments.list;
			if(xqAttachments.length > 0){
				for(var i = 0; i < xqAttachments.length; i++){
					attachmentData.push(new Array(xqAttachments[i].id, xqAttachments[i].type, xqAttachments[i].name, xqAttachments[i].path, xqAttachments[i].size, xqAttachments[i].isPicture, xqAttachments[i].createTime));
				}
			}
			attachmentStore.loadData(attachmentData);
		}
	</script>

  </head>
  
  <body>
  </body>
</html>
