<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp" %>
<link href="css/admin.css" rel="stylesheet">  
<script src ="script/movielist.js"></script>
<div id="wrap">
<article>
<h1>영화수정</h1>
<form name="frm" method="post" enctype="multipart/form-data">
<input type="hidden" name="movieno" value="${MovieVO.movieno}">
<input type="hidden" name="oldImage" value="${MovieVO.image}">
<input type="hidden" name="oldVideo" value="${MovieVO.video}">
<table id="list">
	<tr><th>상품분류</th><td>
		<select name="genre">
			<c:forEach items="${genreList}" var="genre" varStatus="status">				
			<c:choose>
					<c:when test="${MovieVO.genre==status.count}">
            			<option value="${status.count}" selected="selected">
            			${genre}</option>
            			<!-- 영화의 genre 값과  select 의 count 값이 같은 경우 미리 선택 -->
          			</c:when>
          			<c:otherwise>
            			<option value="${status.count}">${genre}</option>
          			</c:otherwise>
				</c:choose>
			</c:forEach>
		</select></td>
		<th>사용유무</th>
		<td><c:choose>
	     	<c:when test='${MovieVO.useyn=="y"}'>
	     		<input type="checkbox" name="useyn" value="y" 
	     		checked="checked">
	     	</c:when>
	      	<c:otherwise>
	        	<input type="checkbox" name="useyn" value="y">
	      	</c:otherwise>
	    </c:choose>
	 </td></tr>
	<tr><th>영화제목</th><td>
		<input type="text" name="title" size="20" maxlength="100" 
			value="${MovieVO.title}"></td>
		<th>재생시간</th><td ><input type="text" name="playtime" size="20" 
			maxlength="100" value="${MovieVO.playtime}"></td>
		</tr>
	<tr><th>감독</th><td><input type="text" name="director" size="20" 
			value="${MovieVO.director}"></td>
		<th>주연</th><td ><input type="text" name="actor" size="20" 
			value="${MovieVO.actor}"></td>
	<tr><th>연령대</th><td><input type="text" name="agegrade" size="20" 
			value="${MovieVO.agegrade}"></td>
		<th>개봉일</th><td><input type="text" name="opendate" size="20" 
			value="${MovieVO.opendate}"></td></tr>
	<tr><th>설명</th><td colspan="3">	<textarea name="content" rows="5" 
			cols="130" >${MovieVO.content}</textarea></td></tr>
	<tr><th>이미지</th><td>
		<img src="movie/files/${MovieVO.image}" width="200pt">     
      	<br><input type="file" name="image"></td>
	<th>비디오</th><td align="center">
		<video id="myVideo" src="movie/files/${MovieVO.video}" width="700px" controls autoplay></video>
		<input type="file" name="video">
</table><br><Br>
<input id="button2" type="button" value="수정" onClick="go_mod_save()">           
<input id="button2" type="button" value="취소"  onClick=
"location.href='movie.do?command=adminMovieDetail&movieno=${MovieVO.movieno}'">
</form>
</article>
</div>