<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/menu.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>F&Q</title>
	<style>
	/* reset */
	html,body{width:100%;height:100%}
	body,p,h1,h2,h3,h4,h5,h6,ul,ol,li,dl,dt,dd,table,th,td,form,fieldset,legend,input,textarea,button,select{margin:0;padding:0}
	body,input,textarea,select,button,table{font-family:'Malgun Gothic',Dotum,AppleGothic,sans-serif;font-size:12px;color:white;}
	img,fieldset{border:0}
	ul,ol{list-style:none}
	em,address{font-style:normal}
	a{text-decoration:none}
	a:hover,a:active,a:focus{text-decoration:underline}

	/* style */
	.faq {
		width: 50%;
		height: 120%;
		margin: 0 auto;
	}
	.faq .hgroup {
		*zoom: 1;
	}
	.faq .hgroup:after {
		content: '';
		display: block;
		clear: both;
	}
	.faq .hgroup h2 {
		float: ;
		padding: 15px 0;
	}
	.faq .hgroup button {
		float: right;
		margin: 15px 0 0 0;
		border: 0;
		color: white;
		background: none;
		letter-spacing: -1px;
		cursor: pointer;
	}
	.faq .faq_list {
		border-top: 1px solid #ccc;
		
	}
	.faq .faq_list dt {}
	.faq .faq_list dt a {
		display: block;
		padding: 8px 10px;
		
		border-bottom: 1px solid #ccc;
		color: #666;
	}
	.faq .faq_list dt.active a {
		border-bottom: none;
		background-color: #eee;
		color: #222;
		text-decoration: none;
		font-weight: bold;
	}
	.faq .faq_list dt a:hover {
		background-color: #eee;
		color: #222;
	}
	.faq .faq_list dd {
		display: none;
		padding: 8px 10px;
		border-bottom: 1px solid #ccc;
		color:white;
		line-height: 1.5;
	}
	.faq .faq_list dd.active {
		display: block;
	}

	.faq .faq_list dd p {
		margin: 8px 0;
	}
	/*my Q&A list*/
	#wrap {	width: 971px;margin: 0;	margin-left: auto;	margin-right: auto;}
h1 {	color: green;}
table {	width: 100%;	border-collapse: collapse;	font-size: 12px; line-height: 24px; color: white; text-align:center; }
table td,th {border: #d3d3d3 solid 1px;padding: 5px;}
th {	background: whitesmoke; }
a {text-decoration: none;	color: black; }
a:HOVER {	text-decoration: underline; color: green;}
#myList {
 border-collapse: collapse; /* border 사이의 간격 없앰 */
 border-top: 2px solid #333;
 border-bottom: 1px solid #333;
 width: 100%; /* 전체 테이블 길이 설정 */
 text-align:center;
}
	</style>
</head>
<body>
<br><br><br>
<!-- UI Object -->
<br/><br/><br/><br/>
<div class="faq">
	<div class="hgroup">
		<h2>MyPage</h2>
	</div>
	<br/><br/>
<table id="myList">
	<tr><th style="color:black;">주문번호</th><th style="color:black;">영화제목</th><th style="color:black;">상영날짜</th><th style="color:black;">예매날짜</th></tr>
	<c:forEach items="${OrdersVO}"  var="OrdersVO" varStatus="status">
		<tr><td>${paging.totalCount-((paging.page-1)*10+status.index)}</td>
    		<td><a href="movie.do?command=orderList&orderno=${OrdersVO.orderno}" style="color:white;">
    			${OrdersVO.title}</a></td>   
     		<td>${OrdersVO.moviedate}</td>
       		<td>${OrdersVO.orderdate}</td>
   		</tr>
  	</c:forEach>
</table>
	<br />
	<div id="paging" align="center" style="font-size:110%; color: white;">
	<c:url var ="action" value="movie.do?command=myPage"/>
	<c:if test="${paging.prev}">
		<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
	</c:if>
	
	<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
		<c:choose>
			<c:when test="${paging.page==index}">
			<span style="color:red;font-weight:bold">${index}&nbsp;</span>
			</c:when>
			<c:otherwise>
			<a href="${action}&page=${index}"  style="color:white;">${index}</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${paging.next}">
		<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
	</c:if>
	</div>
</div>
<!-- //UI Object -->
</body>
</html>
