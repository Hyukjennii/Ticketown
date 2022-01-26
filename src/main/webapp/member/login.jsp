<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link href="css/member.css" rel="stylesheet">  
<script src="script/member.js"></script>
</head>
<body>
<div class="wrap">
<h1 style=" color:white;" id="logo">로그인</h1>
<hr><br>
<form method="post" name="loginfrm" action="movie.do"><br><br>
<input type="hidden" name="command" value="login">
	  <div class="text"><input name="id" class="id1" size="50" type="text"  placeholder="아이디 입력"></div><br> <br>
	  <div class="text"><input name="pwd" class="id1" size="50" type="password"  placeholder="비밀번호 입력"></div><br><br><br>
    <div id="button" align="center">
            <input type="submit" value="로그인" class="submit" style="background:red" 
            											onClick="return loginCheck()"> <br><br>
            <input type="button" value="회원가입" 
            onclick="location.href='movie.do?command=joinForm'"> <br><br>
            
            <input type="button" value="아이디 / 비밀번호 찾기" class="submit" 
            onclick="find_id()">                
     </div><br><br>
     <div style="color :white;" align="center">${message}</div>
</form>
</div>
</body>
</html>