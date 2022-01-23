<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		    <li class="nav-item">
		      <a class="nav-link" href="<%= request.getContextPath()%>/signup">signup</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="#">Link</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link disabled" href="#">Disabled</a>
		    </li>
		</ul>
	</nav>
</body>
</html>