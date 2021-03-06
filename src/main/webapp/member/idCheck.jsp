<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Yeon+Sung&display=swap" rel="stylesheet">
<style type="text/css">
	body{font-family: 'Yeon Sung', cursive;}
	#wrap{ margin: 0 60px; font-size:130%; font-weight:bold;}
	h1 {font-size: 45px;  color: gray; 	font-weight: normal;}
</style>
<script src="script/member.js"></script>
</head>
<body>
<div id="wrap">
<h1>ID 중복확인</h1>
<form method="post" name="idCheckFrm" action="movie.do">
	<input type="hidden" name="command" value="idCheckForm">
	User ID <input type=text name="id" value="${id}">
	<input type="submit" value="검색" class="submit"><br>
</form>
<div style="margin-top: 20px">
	<c:if test="${result == 1}">
		<script type="text/javascript">opener.document.joinForm.id.value="";</script>
		${id}는 이미 사용중인 아이디입니다.
	</c:if>
	<c:if test="${result == 0}">
		${id}는 사용 가능한 ID입니다.    
		<input type="button" value="사용" class="cancel" onclick="idok('${id}');">
	</c:if>
</div></div>
</body>
</html>