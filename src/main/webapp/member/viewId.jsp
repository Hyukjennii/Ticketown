<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewId.jsp</title>
<script type="text/javascript">
function move_login(){
	opener.location.href='movie.do?command=loginForm';
	self.close();
}
</script>
<style>
.login:hover{background-color:red};
.find_pwd:hover{background-color:red};
</style>
</head>
<body>
<h2 style="text-align: center;">Id 찾기</h2>
<hr>
<br/>
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="white" >
		<td width="430">	<h3>성명 : ${member.name}</h3></td>
	</tr>
	<tr align="center" bgcolor="white" >
		<td width="430">	<h3>전화번호 : ${member.phone}</h3></td>
	</tr>
	<tr align="center" bgcolor="white" >
		<td width="430">
		<h3>조회한 회원의 아이디는 ${member.id} 입니다</h3>
		<input type="button" class="login" value="로그인 창으로" onClick="move_login();">
		<input type="button" class="login" value="비밀번호찾기" onClick="location.href='movie.do?command=findPwdForm&id=${member.id}'"></td>
	</tr>
</table>
</body>
</html>

