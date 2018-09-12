<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String serverPort = request.getServerPort() != 80 ? ":" + request.getServerPort() : "";
	String basePath = request.getScheme() + "://" + request.getServerName() + serverPort + path + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/ext/ext3.1/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" id="skincsslink" />
<script type="text/javascript" src="<%=basePath%>js/ext/ext3.1/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ext/ext3.1/ext-all.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ext/extlangzhCN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.4.2.min.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>js/ext/ext3.2.1/ext-base.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ext/ext3.2.1/ext-all.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ext/extlangzhCN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.4.2.min.js"></script>
 -->
<script type="text/javascript">
	var basePath = "<%=basePath%>", extPath = basePath + "js/ext/ext3.2.1/";

	if(Ext && Ext.state.Manager && Ext.QuickTips){
		Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
		Ext.QuickTips.init();
	}
</script>
