<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<style>
	table, td, th{
		border : 1px solid black;
		border-collapse : collapse;
		padding : 10px;
	}
</style>
<body>
	<h1>게시글 상세보기</h1>
	
	<table>
	<caption>게시글 상세보기</caption>
	<tr>
		<td>작성자</td>	
		<th>${board.pId}</th>
	</tr>
	<tr>
		<td>글제목</td>	
		<th>${board.pTitle}</th>
	</tr>
	<tr>
		<td>글 내용</td>	
		<th>${board.pContent}</th>
	</tr>
	<tr>
		<td>날짜</td>	
		<th>${board.pDate}</th>
	</tr>
	<tr>
		<td>사진</td>	
		<th><img src="resources/fileUpload${board.pFileName}" width="200px"></th>
	</tr>
	<tr>
		<td colspan="2">
		<button onclick="location.href='PModifyForm?pNum=${board.pNum}'">수정</button>
		</td>
	</tr>
	
	
	</table>



</body>
</html>