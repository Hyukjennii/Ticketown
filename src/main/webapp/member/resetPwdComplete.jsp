<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function move_login() {
		opener.location.href = 'movie.do?command=loginForm';
		self.close();
	}

</script>
<style>
.login:hover{background-color: red;}
</style>
</head>
<body>
	<h2 style="text-align: center;">비밀번호 재설정 완료</h2>
	<hr>
	<br />
	<table align="center" bgcolor="black" cellspacing="1" width="400">
		<tr align="center" bgcolor="white" height="200">
			<td width="230"><h3>비밀번호 재설성이 완료되었습니다</h3>
				<br> <input type="button" class="login" value="로그인 페이지로 "
				onClick="move_login();"></td>
		</tr>
	</table>
</body>
</html>