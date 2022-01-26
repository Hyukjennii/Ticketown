<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ include file="/menu.jsp" %> --%>
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
   body,input,textarea,select,table{font-family:'Malgun Gothic',Dotum,AppleGothic,sans-serif;font-size:12px;color:white;}
   img,fieldset{border:0}
   ul,ol{list-style:none}
   em,address{font-style:normal}
   a{text-decoration:none}
   a:hover,a:active,a:focus{
 border-collapse: collapse; /* border 사이의 간격 없앰 */
 border-top: 2px solid #333;
 border-bottom: 1px solid #333;
 width: 100%; /* 전체 테이블 길이 설정 */
 text-align:left;}

   body{background:black;}
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
      color: black;
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
  .buttons{color: black;}
   #buttons input{padding : 7px 15px;
      border:none;
   border-radius : 5px 5px 5px 5px;
   background:#a0a0a0;
   color:white;
   font-size:93%;}

   </style>
</head>
<body>
<br><br><br>
<!-- UI Object -->
<br/><br/><br/><br/>
<div class="faq">
   <div class="hgroup">
      <h2>FAQ</h2>
      <h2>나의 질문</h2><br/><br/>
      <dl class="faq_list">
            <dt class="active">
               <a href="#a1">제목 : ${qnaVO.subject}</a>
               <p> 내용 : ${qnaVO.content }</p>
            </dt>
            <dd id="a1" class="active">
               <p>답변내용 : ${qnaVO.reply}</p>
            </dd>
      </dl>
   </div>
   <br/><br/>
    
   
   <div class="clear"></div>
   <div id="buttons" style="float:right;">
     
      <!-- onclick="location.href='movie.do?command=qnaDelete&qseq=${qnaVO.qseq}'"> -->
      <input type="button"  value="수정하기"  class="submit"
      onclick="location.href='movie.do?command=qnaReviseForm&qseq=${qnaVO.qseq}'">
       <input type="button"  value="삭제하기"  class="submit"
      onclick="qnaDelete();">
      <input type="button"  value="Q&A로 돌아가기"  class="submit"  
      onclick="location.href='movie.do?command=qnaList'">
   </div>      
</div>
<!-- //UI Object -->
</body>
<script type="text/javascript">
function qnaDelete(){
   if(confirm("삭제하시겠습니까?")){
      location.href='movie.do?command=qnaDelete&qseq=${qnaVO.qseq}';      
   }
}
</script>
</html>