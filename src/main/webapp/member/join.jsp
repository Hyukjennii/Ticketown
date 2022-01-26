<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
<link href="css/member.css" rel="stylesheet">
<script src="script/member.js"></script>
</head>
<body>
	<div class="wrap">
		<h1 style="color: white;" id="logo">회원가입</h1>
		<article>
			<form method="post" name="joinForm">
				<hr><br>
				<br> <input type="hidden" name="command" value="join">
				<div class="title">아이디</div>
				<div class="text">
					<input type="text" class="id1" name="id"
						placeholder="아이디 입력(아이디는 4자 이상 10자 이하)" size="36" id="id"
						onchange="check_id()"> &nbsp;<input type="hidden" name="reid">
					<input type="button" id="button2" value="중복 체크" class="dup" onclick="idcheck()">
					&nbsp;<span id="checkid"></span>
				</div>

				<br>
				<br>
				<div class="title">비밀번호</div>
				<div class="text">
					<input type="password" class="id1" name="pwd" id="pw"
						placeholder="비밀번호(4자 이상 16자 이하)" size="50" onchange="check_pw()">
				</div><br>
				<div class="text">
					<input type="password" class="id1" name="pwdCheck" id="pw2"
						placeholder="비밀번호 확인" size="50" onchange="check_pw()">&nbsp;<span
						id="check"></span>
				</div>
				<br /> <br>
				<div class="title">이름</div>
				<div class="text">
					<input type="text" class="id1" name="name" placeholder="이름 입력"
						size="50">
				</div>
				<br>
				<div class="title">이메일</div>
				<div class="text">
					<input type="text" class="id1" name="email" placeholder="이메일 입력"
						size="50">
				</div>
				<br>
				<div class="title">전화번호</div>
				<div class="text">
					<select class="id1">
						<option>+82</option>
						<option>+1 Canada</option>
						<option>+63 Philippines</option>
						<option>+55 Brazil</option>
					</select>&nbsp;&nbsp;<input type="text" class="id1" name="phone"
						placeholder="전화번호 입력" size="30">
				<br /><br>
				<div align="center">
					<input type="button" id="button2" value="회원가입" class="submit"
						onclick="go_save()"> <input type="reset" id="button2" value="취소"
						class="cancel">
				</div>
			</form>
		</article>
	</div>
</body>
</html>