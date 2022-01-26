<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ include file="/menu.jsp" %>

<link href="css/admin.css" rel="stylesheet">  
<script src ="script/memberList.js"></script>
</head>
<body>
<br><br>
<div id="wrap">
<article>
<h1>회원 리스트</h1>
<form name="frm" method="post">
<table  style="float:right;" >
	<tr style="text-align:right;"><td width="642">회원검색&nbsp;<input type="text" name="key" value="${key}">
		<input id="button2" type="button" name="btn_search" value="검색" 
		onClick="go_msearch();">
		<input id="button2" type="button" name="btn_total" value="전체보기 "
		onClick="go_mtotal();">
</table>

<div id="table" align="center">
<table id="movieList" >
	<tr style=" border-bottom: 2px solid #333;"><th>번호</th><th style=" padding-left:50px;">아이디</th><th>Email</th><th>phone</th>
	<c:forEach items="${memberList}" var="memberList" varStatus="status">
		<tr><td height="23" align="center" >${paging.totalCount-((paging.page-1)*10+status.index)}</td>
			<td style=" padding-left:50px;">
				<a${memberList.id}style="color:white;">
					&nbsp;${memberList.id}</a></td>
			<td> ${memberList.email}</td>
			<td> ${memberList.phone}</td>
		</tr>
	</c:forEach>
</table><br>
<div id="paging" align="center" style="font-size:110%;">
	<c:url var="action" value="movie.do?command=adminMemberList" />
	<c:if test="${paging.prev}">
		<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
	</c:if>
	<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" 
		var="index">
		<c:choose>
        	<c:when test="${paging.page==index}">
        		<span style="color:red;font-weight:bold">${index}&nbsp;</span>
        	</c:when>
	        <c:otherwise>
				<a href="${action}&page=${index}" style="color:white;">${index}</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${paging.next}">
			<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
	</c:if>
	</div>	
</div>
</form>
</article>
</div>
