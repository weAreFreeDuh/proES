<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정하기</title>
</head>
<style>
	table, td, th{
		border : 1px solid black;
		border-collapse : collapse;
		padding : 10px;
	}
</style>
<body>
	<h1>게시글 수정하기</h1>
	<!-- 
		private int pNum;				// 글넘버
	private String pId;				// 작성자 아이디
	private String pTitle;			// 작성한 글제목
	private String pContent;		// 글 내용
	private Date pDate;				// 글쓴 날짜
	
	private MultipartFile bFile;	// 업로드 파일
	private String bFileName;		// 파일 이름
	 -->
	
	
	<form action="PModify" method="POST" enctype="multipart/form-data">
	<table>
	<caption>게시글 수정</caption>
	<tr>
		<td>작성자</td>	
		<th><input type="text" name="pId"/></th>
	</tr>
	<tr>
		<td>글제목</td>	
		<th><input type="text" name="pTitle"/></th>
	</tr>
	<tr>
		<td>글 내용</td>	
		<th><textarea name="pContent"></textarea></th>
	</tr>
	<tr>
		<td>파일넣기</td>	
		<th><input type="file" name="pFile"/></th>
	</tr>
	<tr>
		<td colspan="2">
		<button>수정</button>
		</td>
	</tr>
	
		<input type="hidden" name="pNum" value="${board.pNum}">
	</table>
	</form>
		<button onclick="location.href='index'">취소</button>


</body>
</html>