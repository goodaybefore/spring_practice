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
		<h1>BOARD DETAIL</h1>
		<div class="form-group">
			<label>Title</label>
			<input class="form-control" type="text" value="${board.bd_title}" readonly>
		</div>
		<div class="form-group">
			<label>Writer</label>
			<input class="form-control" type="text" value="${board.bd_me_id}" readonly>
		</div>
		<div class="form-group">
		    <label>Contents</label>
		    <textarea class="form-control" rows="10" readonly>${board.bd_contents }</textarea>
	  	</div>
	</div>
</body>
</html>