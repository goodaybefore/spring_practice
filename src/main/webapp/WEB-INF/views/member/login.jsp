<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<div class="body">
		<h1 class="text-center">LOGIN</h1>
		<form action="<%= request.getContextPath()%>/login" method="POST">
		    <div class="form-group">
		      <label>ID:</label>
		      <input type="text" class="form-control" name="me_id" placeholder="ID">
		    </div>
		    <div class="form-group">
		      <label>PASSWORD:</label>
		      <input type="password" class="form-control" name="me_pw" placeholder="PW">
		    </div>
		    <button type="submit" class="btn col-12 btn-info">login</button>
		</form>
	</div>
</body>
</html>