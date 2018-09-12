<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/comm/taglibs.jsp" %>

<!DOCTYPE html>
<html class="ui-mobile">
  <head>
    <base href="<%=basePath%>">
    <title>积分规则</title>
	<link rel="shortcut icon" href="favicon.ico" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache,must-revalidate">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width initial-scale=1 maximum-scale=1 minimum-scale=1 user-scalable=0">
	<meta name="HandheldFriendly" content="true">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<link rel="stylesheet" charset="UTF-8" type="text/css" href="css/min.css">
	<meta name="keywords" content="随手房,随手房移动产品功能展示" />
	<meta name="description" content="随手房移动产品功能介绍，她专为房地产中介经纪人而生的一套房客源管理系统，地产经纪人必备的手机应用助手，随时随地跟进房源、客源信息记录，维系客户绝不遗忘，帮助房地产经纪人快速查找所需，简洁至极！房产经纪人力荐的客户、房源手机管理录入存储应用。" />
	<script type="text/javascript" src="js/jquery/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/browser.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			orient();
		});

		function orient() {
			//document.writeln("window.orientation: "+window.orientation+"<br/>");
			if(browser.versions.ios) {
				if (window.orientation == 90 || window.orientation == -90) {
					//ipad、iphone横屏
					$("#gzBack").attr("style", "width:17%; position:absolute; z-index:10000; left:7%; top:9%;");
				} else if (window.orientation == 0 || window.orientation == 180) {
					//ipad、iphone竖屏
					$("#gzBack").attr("style", "width:17%; position:absolute; z-index:10000; left:7%; top:5%;");
				}
			} else if(browser.versions.android) {
				if (window.orientation == 90 || window.orientation == -90) {
					//Andriod横屏
					$("#gzBack").attr("style", "width:17%; position:absolute; z-index:20000; left:7%; top:11%;");
				} else if (window.orientation == 0 || window.orientation == 180) {
					//Andriod竖屏
					$("#gzBack").attr("style", "width:17%; position:absolute; z-index:20000; left:7%; top:4%;");
				}
			}
			return false;
		}
		//用户变化屏幕方向时调用
		$(window).bind('orientationchange', function(e){
			orient();
		});
	</script>
  </head>
  
  <body>
    <div>
    	<a href="" onclick="history.back();return false;"><img id="gzBack" src="images/gz_back.png" style="width:17%; position:absolute; z-index:10000; left:7%; top:5%;" /></a>
    	<img src="images/gz.png" alt="" style="width: 100%;" />
    </div>
  </body>
</html>
