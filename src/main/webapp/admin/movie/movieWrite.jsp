<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ include file="/menu.jsp" %> 

<style>

#wrap2{
	width: 971px;
	height:800px;
	/* border: 1px dashed white; */
	position: fixed; 
    top:50%; left:50%;
    transform: translate(-50%,-50%);
    text-align:center;
}
#list2 td{ 
 padding: 8px 5px;
 text-align: left;
}
#list2 {
	border: 1px solid gray;
	padding : 30px;
}

</style>
<link href="css/admin.css" rel="stylesheet">  
<script src ="script/movielist.js"></script>
</head>
<body>
<div id="wrap2">
<article>
<h1>영화 추가</h1>
<form name="frm" method="post" enctype="multipart/form-data">
<div id="table" align="center">
<table id="list2">
	<tr><th>장르</th>
		<td colspan="5">
			<select name="genre">
				<option value="">선택</option>
				<c:forEach items="${genreList}" var="genre" varStatus="status">
    				<option value="${status.count}">${genre}</option>
   				</c:forEach>
			</select>
		</td></tr>
	<tr><th>영화제목</th><td width="343" colspan="5">
       	<input type="text" name="title" size="68" maxlength="100"></td></tr>
	<tr><th>감독</th>
		<td width="70"><input type="text" name="director" size="25"></td>
  		<th>주연</th><td width="70">
  			<input type="text" name="actor" size="20"></td>
	<tr><th>연령대</th>
		<td width="70"><input type="text" name="agegrade" size="25"></td>
  		<th>진행시간</th><td width="70">
  			<input type="text" name="playtime" size="20"></td>
	<tr><th>개봉일</th>
		<td width="70"><input type="text" name="opendate" size="25"></td></tr>
	<tr><th>설명</th><td colspan="5">
	<textarea name="content" rows="20" cols="70"></textarea></td>
	<tr><th>이미지</th>
		<td width="343" colspan="5">
		<input type="file" name="image"></td></tr>  
	<tr><th>비디오</th>
		<td width="343" colspan="5">
		<input type="file" name="video"></td></tr> 
</table>
<br><br>
<input id="button2" type="button" value="등록" onClick="go_save()">           
<input  id="button2"type="button" value="목록" onClick="go_mov()">
</div>
</form>
</article>
</div>
