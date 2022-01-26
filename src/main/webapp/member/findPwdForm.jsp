<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.button:hover{background-color:red ;border-radius : 5px 5px 5px 5px;};
</style>
</head>
<body>
<h2 style="text-align: center;">password 찾기</h2>
<hr>
<br/>
<p>
		비밀번호가 기억나지 않으세요? 전화번호로 본인인증 하시면 비밀번호를 재설정하실 수 있습니다. <br /> 본인인증 시 제공되는
		정보는 해당 인증기관에서 직접 수집 하며, 인증 이외의 용도로 이용 또는 저장하지 않습니다.
	</p>
<form method="post" name="frm" action="movie.do">
<input type="hidden" name="command" value="findPwdStep1">
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="white" ><td width="430"><h3>아이디 
		<input type="text" name="id" value="${id}"></h3></td></tr>
	<tr align="center" bgcolor="white" >	<td width="430"><h3>성명 
		<input type="text" name="name" value="${name}"></h3></td></tr>
	<tr align="center" bgcolor="white" ><td width="430">
		<h3>전화번호 <input type="text" name="phone"  value="${phone}">
		</h3></td></tr>
	<tr align="center" bgcolor="white" >
		<td width="430"><h3>	<input type="submit" class="button" value="인증번호 전송"></h3>
		${msg}</td></tr>
</table>
</form>
</body>
</body>
</html>