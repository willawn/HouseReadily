<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>"/>

		<title>随手房 — 后台管理中心</title>

		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>js/ext/ext2.2/css/ext-all.css" />
		<link rel="stylesheet" type="text/css" id="skincsslink" />
		<script type="text/javascript" src="<%=basePath%>js/ext/ext2.2/ext-base.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ext/ext2.2/ext-all.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ext/extlangzhCN.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.4.2.min.js"></script>
		<script type="text/javascript">
			var basePath = "<%=basePath%>", extPath = basePath + "js/ext/ext2.2/";
			if(Ext && Ext.state.Manager && Ext.QuickTips){
				Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
				Ext.QuickTips.init();
			}
		</script>
		<script type="text/javascript" src="js/ext/TabCloseMenu.js"></script>
		<script type="text/javascript" src="js/manager.js"></script>
		<style type="text/css">
			.settings {
	        	background-image:url(images/icon/cog.png);
		    }
		    .nav {
		        background-image:url(images/icon/user_suit.png);
		    }
		</style>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#seltheme").change(function(){
					var url=extPath+"css/xtheme-" + $(this).children("option:selected").val() + ".css";
					document.getElementById('skincsslink').href=url;
				});
			});
		</script>
	</head>

	<body>
		<div id="west">
		</div>
		<div id="north">
			<div  style="width: 400px; float: left;">
				<img src="images/logo.png" style="padding-left: 0px;" width="200" height="80"/>
			</div>
			<div style="float: right; height: 100%; text-align: center;">
				<div id="ptheme" style="margin-top: 30px; margin-right: 10px;">
				<FORM id="ftheme" method="post">
					<LABEL style="font-weight: bold;">主题: </LABEL>
			      <select id="seltheme" name="seltheme" onChange="">
				      <option value="galdaka">galdaka</option>
				      <option value="black">black</option>
				      <option value="darkgray">darkgray</option>
				      <option value="gray">gray</option>
				      <option value="olive">olive</option>
				      <option value="purple">purple</option>
				      <option value="slate">slate</option>
				      <option value="access">access</option>
			      </select>
				</FORM>
			</div>
			</div>
			
		</div>
		<div id="center">
			<img src="images/main.jpg" width="100%" height="100%" />
		</div>
		<div id="props-panel" style="width: 200px; height: 200px; overflow: hidden;">
		</div>
	</body>
</html>
