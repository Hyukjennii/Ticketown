<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../menu.jsp" %>
<style>
article{color: white; width: 50%; height: 50; margin: auto;}
fieldset{height: 510px;}
textarea{position: absolute; resize:none; overflow-y:scroll;}
#buttons input{padding : 7px 15px;
   border:none;
   border-radius : 5px 5px 5px 5px;
   background:#a0a0a0;
   color:white;
   font-size:93%;}
</style>
<article>
<h2> 1:1 고객 게시판(수정) </h2>
<h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    
<form name="formm" method="post"	action="movie.do">
	<input type="hidden" name="command" value="qnaUpdate">
	<input type="hidden" name="id" value="${qna.qseq}">
	<fieldset>
	<div class="control-group board_write_category">
            <label class="control-label cm-required" for="board_write_category">분류</label>
            <div class="controls" style="padding-top:5px;">
                <select id="board_write_category" name="category">
                        <option value="예매" selected="selected">예매</option>
                        <option value="결제" >결제</option>
						<option value="취소" >취소</option>
						<option value="분실물" >분실물</option>
						<option value="membership" >membership</option>
						<option value="보상규정" >보상규정</option>
						<option value="기타" >기타</option>
                </select>
            </div>
        </div> 
	    <label>제목</label><br/><input type="text" name="subject"  size="60" ><br>
		<label>내용</label><br/><textarea rows="24%" cols="120%" name="content"></textarea>
		
	</fieldset>
	<div class="control-group board_write_file monster_board_write_file">
            <label class="control-label" for="board_write_file">첨부파일</label>
            <input type="hidden" name="type_board_write_file" value="local">
            <div class="controls">
	            <p>'png', 'gif', 'jpg', 'jpeg' 파일만 업로드가 가능합니다.</p>
				<input type="hidden" name="file_board_write_file[0]" id="" />
	            <input type="file" name="file_board_write_file[0]" id="" onchange=""
	            class="file cm-image-field" data-ca-empty-file="" accept="image/*"
	           	onclick="" />
          	</div>
     </div>
	<div class="clear"></div>
	<div id="buttons" style="float:right">
		<input type="submit"  value="수정하기"   class="submit"> 
		<input type="reset"   value="취소"    class="cancel">
		<input type="button"  value="Q&A로 돌아가기"  class="submit"  
		onclick="location.href='movie.do?command=qnaList'">
	</div>
</form>
</article>
