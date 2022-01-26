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
/*    border: 1px dashed white; */
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
 text-align:center;
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
<br>
<div id="wrap">
<article>
<h1>Q&amp;A 게시글 리스트</h1>
<form name="qna" method="post"> 
<table style="float:right;">
   <tr><td>작성자 이름<input type="text" name="key" value="${key}">
         <input class="btn" id="button2" type="button" value="검색"
         onclick="go_search_qna()"></td></tr>
</table>


<div id="table" align="center">
<table id="qnaList">
   <tr style=" border-bottom: 2px solid #333;" ><th>번호(답변여부)</th><th>제목</th><th>작성자</th>
      <th>작성일</th></tr>
   <c:forEach items="${qnaList}" var="qnaVO">
      <tr><td>${qnaVO.qseq}
         <c:choose>
            <c:when test='${qnaVO.rep=="1"}'>(미처리)</c:when>
            <c:otherwise>(답변처리완료)</c:otherwise>
         </c:choose></td>
         <td><a href="#" onclick="javascript:go_view('${qnaVO.qseq}')" style="color:white;">
                                             ${qnaVO.subject}</a></td>
         <td> ${qnaVO.id}</td>
         <td><fmt:formatDate value="${qnaVO.indate}"/></td>
      </tr>
   </c:forEach>
</table>
</div>
<br>
<!-- 페이지 표시 영역 -->
<div id="paging" align="center" style="font-size:110%;">
   <c:url var="action" value="movie.do?command=adminQnaList" />
   <c:if test="${paging.prev}">
      <a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
   </c:if>
   <c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
      <c:choose>
           <c:when test="${paging.page==index}">
              <span style="color:red;font-weight:bold">${index}&nbsp;</span>
           </c:when>
           <c:otherwise> 
            <a href="${action}&page=${index} " style="color:white;">${index}</a>&nbsp;
         </c:otherwise>
      </c:choose>
   </c:forEach>
   
   <c:if test="${paging.next}">
         <a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
   </c:if>   
</div> <!-- paging 의 끝 -->
</form>
</article>
</div>