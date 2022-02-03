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
	<h1>Modify page</h1>
	<form class="form-group" action="<%= request.getContextPath()%>/board/modify" method="POST">
		<h1>BOARD detail</h1>
		<div class="form-group">
			<label>Title</label>
			<input class="form-control" type="text" name="bd_title" value="${board.bd_title}">
		</div>
		<div class="form-group">
		    <label>Contents</label>
		    <textarea class="form-control" rows="10" name="bd_contents">${board.bd_contents}</textarea>
	  	</div>
	  	
  		<button class="btn btn-success">confirm</button>
  		
  		<input type="hidden" name="bd_me_id" value="${board.bd_me_id}">
  		<input type="hidden" name="bd_num" value="${board.bd_num}">
  	</form>
	</div>
</body>
</html>