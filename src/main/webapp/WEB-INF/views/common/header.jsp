<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-info navbar-dark">
		<ul class="navbar-nav">
		    <li class="nav-item active">
		      <a class="nav-link" href="<%= request.getContextPath()%>">Main</a>
		    </li>
		    <c:if test="${user==null}">
		    	<li class="nav-item">
			      <a class="nav-link" href="<%= request.getContextPath()%>/login">login</a>
			    </li>
			    <li class="nav-item">
			      <a class="nav-link" href="<%= request.getContextPath()%>/signup">signup</a>
			    </li>
		    </c:if>
		    <c:if test="${user != null}">
		    	<li class="nav-item">
			      <a class="nav-link" href="<%= request.getContextPath()%>/logout">logout</a>
			    </li>
		    </c:if>
		    
		    
		    <li class="nav-item">
		      <a class="nav-link disabled" href="#">Disabled</a>
		    </li>
		    
		</ul>
	</nav>
</body>
</html>