<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container body">
		<form class="form-group" action="<%= request.getContextPath()%>/board/register" method="POST" enctype="multipart/form-data">
			<h1>BOARD detail</h1>
			<div class="form-group">
				<label>Title</label>
				<input class="form-control" type="text" name="bd_title">
			</div>
			<div class="form-group">
			    <label>Contents</label>
			    <textarea class="form-control" rows="10" name="bd_contents"></textarea>
		  	</div>
		  	<div class="form-group">
	  			<label>파일 첨부</label>
	  			<input type="file" class="form-control" name="file"/>
	  			<input type="file" class="form-control" name="file"/>
	  			<input type="file" class="form-control" name="file"/>
	  		</div>
		  	<a href="<%= request.getContextPath()%>/board/register">
	  			<button class="btn btn-success">confirm</button>
	  		</a>
	  		<div class="form-group">
	  			<input type="hidden" name="user" value="${user.me_id}">
	  		</div>
	  		
	  	</form>
	</div>
	
	 
</body>
</html>