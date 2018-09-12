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

  </head>
  
  <body>
    <c:forEach var="mobile" items="${mobileList}">
    	<c:if test="${!empty mobile }">
    		${mobile }<br/>
    	</c:if>
    </c:forEach>
  </body>
</html>
