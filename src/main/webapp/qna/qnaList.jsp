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
#qnaList {
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
		<h2>FAQ</h2>
		<button type="button" 
		onclick="location.href='movie.do?command=qnaWriteForm'"><span>1대1 질문하기</span></button>
	
	
		<h2>자주 찾는 질문 	</h2><br/>
		
	<dl class="faq_list">
      <dt class="active"><a>Q1.:영화 시간보다 늦었어요. 입장 가능한가요?</a></dt>
      <dd id="a1" class="active">
         <p>A:온라인으로 예매하신 경우에는 티켓 출력 후 영화 시간 내 언제든 입장이 가능합니다.<br/>
               다만, 지연 입장으로 인해 관람하지 못하신 영화의 앞 부분은 별도로 관람 및 환불이 어렵습니다.
</p>
      </dd>
      
      <dt class="active"><a>Q1.:상영관 내 다른 음식물의 반입이 되나요?</a></dt>
      <dd id="a2" class="active">
         <p>A:상영관 내 외부 음식물 반입은 가능합니다.<br/>
단, 강한 냄새로 인해 영화 관람 시 다른 고객님에게 방해가 되는 품목에 한해서 (예 : 족발, 순대 등)<br/>
취식 후 입장해 주실 것을 고객님께 양해(권고) 드리고 있습니다.</p>
      </dd>
      
      <dt class="active"><a>Q1.:인터넷 예매 후 예매내용 확인은 어떻게 하나요?</a></dt>
      <dd id="a3" class="active">
         <p>A:인터넷 예매 후 예매내역 확인을 원하시는 경우 다음과 같이 확인하세요. <br/>
   ■ 홈페이지에서 확인 시<br/>
  - 홈페이지 로그인 → [MYPAGE] </p>
      </dd>
   </dl>

	</div>
	<br/><br/><br><br>
			<h2>내 질문 목록 _ 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다. 	</h2><br/>
			
			<!-- 내 질문 목록 -->
<table id="qnaList">
	<tr><th style="color:black;">번호</th><th style="color:black;">제목</th><th style="color:black;">등록일</th><th style="color:black;">답변 여부</th></tr>
	<c:forEach items="${qnaList}"  var="qnaVO" varStatus="status">
		<tr><td>${paging.totalCount-((paging.page-1)*10+status.index)}</td>
    		<td><a href="movie.do?command=qnaView&qseq=${qnaVO.qseq}" style="color:white;">
    		${qnaVO.subject}</a></td>      
       		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
       		<td><c:choose>
				<c:when test="${qnaVO.rep==1}"> no </c:when>
				<c:when test="${qnaVO.rep==2}"> yes </c:when>
			</c:choose></td>    
   		</tr>
  	</c:forEach>
</table>
	<br />
	
	<div id="paging" align="center" style="font-size:110%; color: white;">
	<c:url var ="action" value="movie.do?command=qnaList"/>
	<c:if test="${paging.prev}">
		<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
	</c:if>
	
	<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
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
<!-- //UI Object -->
</body>
</html>
