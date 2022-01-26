<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<style>
body{
	background:black;
	color:white;
}
#wrap{
	width: 971px;
	height:800px;
/* 	border: 1px dashed white; */
	position: fixed; 
    top:50%; left:50%;
    transform: translate(-50%,-50%);
    text-align:center;
}

th, td{ 
 padding: 8px 5px;
 
}

table#qnaList {
 border-collapse: collapse; /* border 사이의 간격 없앰 */
 border-top: 2px solid #333;
 border-bottom: 1px solid #333;
 width: 100%; /* 전체 테이블 길이 설정 */
 text-align:left;
}
#button2{
	padding : 7px 15px;
	border:none;
	border-radius : 5px 5px 5px 5px;
	background:#a0a0a0;
	color:white;
	font-size:93%;
	
}
</style>
<script src="script/admin.js"></script>
<div id="wrap">
<article>
<h1>Q&amp;A 게시판</h1>
<form name="frm" method="post">
<input type="hidden" name="qseq" value="${qnaVO.qseq}">
<table id="qnaList"><!-- 게시물의 내용 -->
   <tr><th width="20%">제목</th>
      <td align="left">${qnaVO.subject}</td></tr>
   <tr><th> 등록일</th>
      <td align="left"><fmt:formatDate value="${qnaVO.indate}"/></td></tr>
   <tr><th>내용</th>
      <td align="left">${qnaVO.content}</td></tr>
</table>
<!-- 관리자가 쓴 답글 또는 답글 쓰는 입력란 표시 -->
<c:choose>
   <c:when test='${qnaVO.rep=="1"}'><!-- 관리자 답변 전 표시 -->
      <table id="qnaList">
         <tr><td colspan="2">
            <textarea name="reply" rows="2" cols="110"></textarea>
            <input type="button" id="button2" value="저장"
             onClick="go_rep()"></td>
             </tr>
      </table>
      </c:when>
      <c:otherwise><!-- 관리자 답변 완료 후 표시 -->
         <table id="qnaList">
            <tr><th>댓글</th><td>${qnaVO.reply}</td></tr>
         </table>
      </c:otherwise>
   </c:choose><br>
   <input type="button" id="button2"  value="목록" onclick="go_list()">
</form>
</article>
</div>
