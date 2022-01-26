<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.button:hover{background-color: red};

</style>
<script type="text/javascript" >
function resetPwd(){
	if(document.frm.pwd==""){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd==document.frm.pwd_chk){
		alert("비밀번호확인이 일치하지 않습니다");
		document.frm.pwd_chk.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<h2 style="text-align: center;">비밀번호 재설정</h2>
<hr><br/>
<form method="post" name="frm" action="movie.do">
<input type="hidden" name="command" value="resetPwd">
<input type="hidden" name="id" value="${member.id}">
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="white" ><td width="430">
		<h3>비밀번호 <input type="password" name="pwd"></h3></td></tr>
	<tr align="center" bgcolor="white" ><td width="430">
		<h3>비밀번호확인<input type="password" name="pwd_chk"></h3></td>
	</tr>
	<tr align="center" bgcolor="white" ><td width="430">
		<h3 styl "><input type="submit" class="button" value="비밀번호 재설정" 
			onClick="return resetPwd();"></h3></td></tr>
</table>
</form>
</body>
</head>
<body>

</body>
</html>

