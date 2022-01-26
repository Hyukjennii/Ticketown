<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp" %>

<link href="css/admin.css" rel="stylesheet">  
<script src ="script/movielist.js"></script>
<div id="wrap">
<article>
<h1>영화 상세 보기</h1>
<table id="list" >
	<tr><th>장르</th><td colspan="3">${genre}</td></tr>
	<tr><th> 영화제목</th>
		<td>${MovieVO.title}</td>
		<th>재생시간</th><td>${MovieVO.playtime}</td></tr>
	<tr><th>감독</th><td width="300">${MovieVO.director}</td>
		<th>주연</th><td  width="300">${MovieVO.actor}</td>
	<tr><th>연령대</th><td>${MovieVO.agegrade}</td>
		<th>개봉일</th><td>${MovieVO.opendate}</td></tr>
	<tr><th>설명</th><td colspan="3">${MovieVO.content}</td></tr>
	<tr><th>이미지</th><td>
		<img src="movie/files/${MovieVO.image}" width="200pt"></td>
	<th>비디오</th><td colspan="3" align="center">
		<video id="myVideo" src="movie/files/${MovieVO.video}" width="700px" controls autoplay></video>
</table><br><Br>
<input  id="button2" type="button" value="수정"
	onClick="go_mod('${MovieVO.movieno}')">
<input id="button2" type="button" value="목록" onClick="go_mov()">
<input id="button2" type="button" value="삭제" onClick="go_mod_delete(${MovieVO.movieno})">           
</article>
</div>