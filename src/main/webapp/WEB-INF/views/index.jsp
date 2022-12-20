<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<style>
	table, td, th{
		border : 1px solid black;
		border-collapse : collapse;
		padding : 10px;
	}
</style>
<body>
	<h1> 게시글 창 </h1>
	<!-- 게시글 목록 --><!-- 클릭 후 목록 확인 가능 -->
	<!-- 게시글 쓰기 -->
	<table>
	<caption></caption>
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>글제목</th>
		<th>글쓴 날짜</th>
	</tr>
	<c:forEach var="list" items="${boardList}">
	<tr>
		<td>${list.pNum}</td>
		<td>${list.pId}</td>
		<td><a href="PView?pNum=${list.pNum}">${list.pTitle}</a></td>
		<td>${list.pDate}</td>
	</tr>
	
	</c:forEach>
	
	<tr>
		<td colspan="3">
		<button onclick="location.href='pWriteForm'">작성하기</button>
		<button onclick="location.href='PList'">게시글목록</button>
		<td>
	</tr>
	
	</table>
	
	
</body>
</html>