if(Ext && Ext.state.Manager && Ext.QuickTips){
	// 初始化Ext状态管理器，在Cookie中记录用户的操作状态，如果不启用，刷新时就不会保存当前的状态，而是重新加载
	// 如果窗口中有用可拖动面板的话，刷新后面板仍然会在拖动后的位置。如果不启用的话是不是就会按照默认的排列方式排列
	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	// 读取标签中的ext:qtip属性，并为它赋予显示提示的动作
	Ext.QuickTips.init();
}

Ext.onReady(function() {
	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	
	var menuTree = new Ext.tree.TreePanel({
		id:'menuTree',
		split:true,
		autoScroll:true,
		autoHeight:true,
		collapsible:true,
		border: false,
		root: new Ext.tree.AsyncTreeNode({
			id:'root',
			text:'后台管理',
			draggable:false,
            expanded: true,
            children: [{
                text: '用户管理',
                url: basePath + 'user/toUserList.do',
                leaf: true
            },{
                text: '房源管理',
                url: basePath + 'houseReadily/toHouseReadilyList.do',
                leaf: true
            },{
                text: '客源管理',
                url: basePath + 'customer/toCustomerList.do',
                leaf: true
            },{
                text: '群组管理',
                url: basePath + 'baseGroup/toBaseGroupList.do',
                leaf: true
            },{
                text: '意见反馈',
                url: basePath + 'feedback/toFeedbackList.do',
                leaf: true
            }]
        }),
        rootVisable:false
	});
	menuTree.on('click', treeClick);
	
	/*
	var houseReadilyTree = new Ext.tree.TreePanel({
		id:'houseReadilyTree',
		split:true,
		autoScroll:true,
		autoHeight:true,
		collapsible:true,
		border: false,
		root: new Ext.tree.AsyncTreeNode({
			id:'root',
			text:'房源管理',
			draggable:false,
            expanded: true,
            children: [{
                text: '房源管理',
                url: basePath + 'houseReadily/toHouseReadilyList.do',
                leaf: true
            }]
        }),
        rootVisable:false
	});
	houseReadilyTree.on('click', treeClick);
	
	var customerTree = new Ext.tree.TreePanel({
		id:'customerTree',
		split:true,
		autoScroll:true,
		autoHeight:true,
		collapsible:true,
		border: false,
		root: new Ext.tree.AsyncTreeNode({
			id:'root',
			text:'客源管理',
			draggable:false,
            expanded: true,
            children: [{
                text: '客源管理',
                url: basePath + 'customer/toCustomerList.do',
                leaf: true
            }]
        }),
        rootVisable:false
	});
	customerTree.on('click', treeClick);
	*/
	
	var systemTree = new Ext.tree.TreePanel({
		id:'systemTree',
		split:true,
		autoScroll:true,
		autoHeight:true,
		collapsible:true,
		border: false,
		root: new Ext.tree.AsyncTreeNode({
			id:'root',
			text:'系统管理',
			draggable:false,
            expanded: true,
            children: [{
                text: '系统日志',
                url: basePath + 'systemLog/toSystemLogList.do',
                leaf: true
            },{
                text: '操作日志',
                url: basePath + 'operateLog/toOperateLogList.do',
                leaf: true
            },{
                text: '积分日志',
                url: basePath + 'task/toTaskLogList.do',
                leaf: true
            },{
                text: '积分排行',
                url: basePath + 'task/toTaskUserList.do',
                leaf: true
            }]
        }),
        rootVisable:false
	});
	systemTree.on('click', treeClick);
	
	function treeClick(node, e) {
		if(node.isLeaf()){ 
			e.stopEvent(); 
	        var n = tabPanel.getComponent(node.id);
	        if (!n) { 
	            var n = tabPanel.add({ 
	                id : node.id, 
	                title : node.text, 
	                closable: true,
	                html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+node.attributes.url+'"></iframe>'    
	            }); 
	        } 
	        tabPanel.setActiveTab(n); 
       }
    }

	var tabPanel = new Ext.TabPanel( {
		id : 'tabPanel',
		region : 'center',
		deferredRender : false,
		activeTab : 0,
		enableTabScroll: true,
		plugins: new Ext.ux.TabCloseMenu(),
	    beforeInit: Ext.emptyFn,
	    loadChild: Ext.emptyFn,
		items : [ {
			contentEl : 'center',
			title : '首页',
			autoScroll : true
		} ]
	});
	
	var viewport = new Ext.Viewport( {
		layout : 'border',
		items : [ new Ext.BoxComponent( {
					region : 'north',
					el : 'north',
					height : 80
				}), {
			region : 'west',
			id : 'menuPanel',
			title : '菜单管理',
			split : true,
			width : 200,
			minSize : 175,
			maxSize : 400,
			collapsible : true,
			margins : '0 0 0 5',
			layout : 'accordion',
			layoutConfig : {
				animate : true
			},
			items : [{
				contentEl : 'west',
				title : '后台管理',
				border : false,
				iconCls : 'nav',
				items : [
					menuTree
				]
			},{
				title : '系统管理',
				border : false,
				iconCls : 'settings',
				items : [
				    systemTree
				]
			}]
		}, tabPanel]
	});
	
	/*
	var cob=new Ext.form.ComboBox({
		store: new Ext.data.SimpleStore({
			fields: ['id', 'state'],
			data : [
				['black','black'],
				['darkgray','darkgray'],
				['galdaka','galdaka'],
				['gray','gray'],
				['olive','olive'],
				['purple','purple'],
				['slate','slate']
			]
		}),
		typeAhead: true,
		displayField:'state',
		mode: 'local',
		triggerAction: 'all',
		editable:false,
		renderTo:'ptheme',
		selectOnFocus:true,
		onSelect: function(i){
			var url="js/ext/css/xtheme-"+i.data.id+".css";
			document.getElementById('skincsslink').href=url;
		}
	})
	*/
});
