<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="containter body">
	<h1>BOARD LIST</h1>
		<table class="table table-info info table-hover">
		    <thead>
		      <tr>
		        <th>게시글 번호</th>
		        <th>제목</th>
		        <th>작성자</th>
		        <th>작성날짜</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach items="${list}" var="board">
			      <tr>
			      	<td>${board.bd_num }</td>
			        <td>${board.bd_title}</td>
			        <td>${board.bd_me_id}</td>
			        <td>${board.bd_reg_date}</td>
			      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
	</div>
</body>
</html>