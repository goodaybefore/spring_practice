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
			        <td><a href="<%=request.getContextPath()%>/board/detail?bd_num=${board.bd_num}">${board.bd_title}</a></td>
			        <td>${board.bd_me_id}</td>
			        <td>${board.bd_reg_date}</td>
			      </tr>
		      </c:forEach>
		    </tbody>
		  </table>
		  
		  <c:if test="${user.me_id !=null }">
			  <a href="<%= request.getContextPath()%>/board/register">
			  	<button class="btn btn-success">write</button>
			  </a>
		  </c:if>
	</div>
</body>
</html>