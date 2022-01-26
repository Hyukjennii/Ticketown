<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table tr:hover{background-color:red; color:white;}

</style>
</head>
<body>


	<h2 style="text-align: center;">아이디 찾기 / 비밀번호 찾기</h2>
	<hr>
	<br />
	<br />
	<table align="center" bgcolor="black" cellspacing="1" width="200" >
		<tr align="center" bgcolor="white" height="170"
			onClick="location.href='movie.do?command=findIdForm'">
			<td width="230"><h3>아이디 찾기</h3></td>
			
			
			<tr align="center" bgcolor="white" height="170" 
			onClick="location.href='movie.do?command=findPwdForm'">
			<td width="230"><h3>비밀번호 찾기</h3></td>
		
		
		</tr>
	</table>
</body>
</html>