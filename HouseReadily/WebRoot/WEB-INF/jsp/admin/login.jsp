<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/comm/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>随手房 — 后台登录</title>

	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<script src="js/jquery/jquery.cookie.js" type="text/javascript"></script>
	<script type="text/javascript">
		Ext.form.Field.prototype.msgTarget = 'side';   
		//定义表单   
		var simple = new Ext.FormPanel({   
		    labelWidth: 55,   
		    baseCls: 'x-plain',   
		    width: 170,   
		    defaultType: 'textfield',//默认字段类型 
		    submit: function() {
	            this.getForm().getEl().dom.submit();
	        },
		    //定义表单元素   
		    items: [{   
		        fieldLabel: '帐户',
		        id: 'userName',
		        name: 'userName',//元素名称   
		        anchor:'90%',//也可用此定义自适应宽度   
		        allowBlank:false,//不允许为空   
		        blankText:'帐户不能为空'//错误提示内容   
		    },{   
		        inputType:'password',   
		        fieldLabel: '密码',   
		        anchor:'90%',
		        id: 'password',
		        name: 'password',   
		        allowBlank:false,   
		        blankText:'密码不能为空'   
		    },{
			    width: 200,
	         	xtype: 'panel',
	         	layout: 'form',
	         	//labelWidth: 58,
	         	items:[{
	           		layout: 'column',
	           		items: [{
	            		columnWidth: .5,
	             		xtype: 'checkbox',
	             		name: 'remember',
	             		id: 'remember',
	             		inputValue: 'remember',
	             		boxLabel: '记住密码'        
	           		},{
	            		columnWidth: .5,
	             		xtype: 'checkbox',
	             		name: 'autoLogin',
	             		id: 'autoLogin',
	             		inputValue: 'autoLogin',
	             		boxLabel: '自动登录',
	             		listeners: {
							'check': function(chk, isChecked) {
								if(isChecked){
									Ext.getCmp('remember').setValue(isChecked);
									Ext.getCmp('remember').disable();
								}else{
									Ext.getCmp('remember').enable();
								}
           					}
	           			}
	           		}]
	         	}]
	        }],   
		    buttons: [{
			    id: 'btnSubmit',
		        text: '登录',   
		        type: 'submit',   
		        //定义表单提交事件   
		        handler:function(){   
		    		btnSubmitClick();
		        }   
		    },{
			    id: 'btnReset',
		        text: '取消',   
		        handler:function(){simple.form.reset();}//重置表单   
		    }]   
		});

		function btnSubmitClick() {
			if(simple.form.isValid()){//验证合法后使用加载进度条   
                Ext.MessageBox.show({   
                    title: '请稍等',   
                    msg: '正在加载...',   
                    progressText: '',   
                    width:250,   
                    progress:true,   
                    closable:false,   
                    animEl: 'loding'   
                });   
                //控制进度速度   
                var f = function(v){   
                    return function(){   
                        var i = v/11;   
                        Ext.MessageBox.updateProgress(i, '');   
                    };   
                };   
                for(var i = 1; i < 13; i++){   
                    setTimeout(f(i), i*150);   
                }   
                  
                //提交到服务器操作   
                simple.form.doAction('submit',{   
                    url:basePath+'admin/login.do',//请求路径   
                    method:'post',//提交方法post或get   
                    params:'',   
                    //提交成功的回调函数   
                    success:function(form,action){   
                    	result(action);
                    },   
                    //提交失败的回调函数   
                    failure:function(form,action){
                    	result(action); 
                    }   
                });   
            }
		}
		   
		//定义窗体   
		var win = new Ext.Window({   
		    id:'win',   
		    title:'用户登陆',   
		    layout:'fit', //之前提到的布局方式fit，自适应布局   
		    width:250,   
		    height:160,   
		    plain:true,   
		    bodyStyle:'padding:5px;',   
		    maximizable:false,//禁止最大化   
		    closeAction:'close',   
		    closable:false,//禁止关闭   
		    collapsible:true,//可折叠   
		    plain: true,   
		    buttonAlign:'center',   
		    items:simple//将表单作为窗体元素嵌套布局   
		});   
		  
		win.show();//显示窗体

		var r = '1368254';

		function setCookie(name, value, option) {
			$.cookie(name + r, value, option);
		}

		function getCookie(name) {
			return $.cookie(name + r);
		}
		
		function result(action){
			if (action.result.status == 1) {
				if(Ext.getCmp('remember').checked && getCookie('remember') == undefined) {
					setCookie('userName', Ext.getCmp('userName').getValue(), {expires: 30});
					setCookie('password', Ext.getCmp('password').getValue(), {expires: 30});
					setCookie('remember', Ext.getCmp('remember').checked, {expires: 30});
				}
				if(Ext.getCmp('autoLogin').checked && getCookie('autoLogin') == undefined) {
					setCookie('autoLogin', Ext.getCmp('autoLogin').checked, {expires: 30});
				}
				document.location = basePath + 'admin/manager.shtml';
			} else {
				Ext.Msg.alert('系统提示', '用户名或密码错误！');
			}
		}

		// 加载cookie
		if(getCookie('remember') != undefined) {
			Ext.getCmp('userName').setValue(getCookie('userName'));
			Ext.getCmp('password').setValue(getCookie('password'));
			Ext.getCmp('remember').setValue(getCookie('remember'));
		}
		if(getCookie('autoLogin') != undefined) {
			Ext.getCmp('autoLogin').setValue(getCookie('autoLogin'));
		}
		if(Ext.getCmp('autoLogin').checked) {
			btnSubmitClick();
			//Ext.getCmp('btnSubmit').fireEvent('click');
			//simple.submit();
		}
	</script>
  </head>
  
  <body>
  </body>
</html>
