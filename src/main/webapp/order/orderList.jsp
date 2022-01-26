<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

body{
   background:black;
   color:white;
}
/*  tr, th, td{
   border:1px dashed white;
}  */ 
th, td{
   height:50px;
   text-align:left;
}
#table2 th{
	width:100px;
}
#table2{
	width:400px;
	font-size:110%;
	padding:5px 40px;
}
#wrap{
	position: fixed; 
    top:50%; left:50%;
    transform: translate(-50%,-50%);
}
#button2{
	padding : 7px 15px;
	border:none;
	border-radius : 5px 5px 5px 5px;
	background:#a0a0a0;
	color:white;
	font-size:95%;
	}
	

</style>
</head>
<body>
<br>
<div id="wrap" align="center">
<h1 style="border-bottom:2px dashed white; width:900px; height:60px;">예매 내역</h1><br>
<input type="hidden" id="seat" value="${OrdersVO.orderno }">
<table>
   <tr><td>
      <img src="movie/files/${OrdersVO.image}" width="350" height="490">
      </td>
      <td>
         <table id="table2">
            <tr><th> 영화제목 </th><td>${OrdersVO.title}</td></tr>
            <tr><th> 날짜 </th><td>${OrdersVO.moviedate }</td></tr>
            <tr><th> 시작시간 </th><td>${OrdersVO.movietime}</td></tr>
            <tr><th>특별관</th><td>${OrdersVO.cinemas }</td></tr>
            <tr><th>성인</th><td>${OrdersVO.quantity1}명</td></tr>
            <tr><th>소인</th><td>${OrdersVO.quantity2}명</td></tr>
            <%-- <tr><th>금액</th><td><fmt:formatNumber type="currency"></fmt:formatNumber></td></tr> --%>
            <tr><th>좌석</th><td>${OrdersVO.seat}</td></tr>
            <tr><td>
              <input type="button" id="button2" style="background:gray; opacity:0.9; " value="목록보기" class="submit"
               onclick="history.go(-1)"></td><td>
              <input type="button" id="button2" style="background:gray; opacity:0.9; " value="취소하기" class="submit"
               onclick="go_mod_delete(${OrdersVO.orderno })"></td></tr>
         </table>
      </td>
   </tr>
</table>
</div>
</body>
<script type="text/javascript">
function go_mod_delete(orderno){
	if(confirm('예매를 취소하시겠습니까?')){
	var url="movie.do?command=orderDelete&orderno="+orderno;
	location.href=url;
	}
}

</script>
</html>