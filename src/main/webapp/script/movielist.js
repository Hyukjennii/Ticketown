function go_search(){
	if( document.frm.key.value=="") return;
	var url = "movie.do?command=adminMovieList&page=1";
	document.frm.action = url;
    document.frm.submit();
}

function go_total(){
	document.frm.key.value="";
	document.frm.action = "movie.do?command=adminMovieList&page=1";
	document.frm.submit();
}

function go_wrt(){
	document.frm.action = "movie.do?command=adminMovieWriteForm";
	document.frm.submit();
}

function go_save(){
	var theForm = document.frm;
	if( theForm.genre.value == '' ){
		alert("장르를 선택하세요");
		theForm.genre.focus();
	}else if (theForm.title.value == '') {
		alert('영화제목을 입력하세요.'); 	theForm.title.focus();	
	} else if (theForm.director.value == '') {
		alert('감독을 입력하세요.'); 		theForm.director.focus();
	} else if (theForm.actor.value == '') {
		alert('주연을 입력하세요.'); 		theForm.actor.focus();
	} else if (theForm.agegrade.value == '') {
		alert('연령을 입력하세요.'); 		theForm.agegrade.focus();
	} else if (theForm.playtime.value == '') {
		alert('진행시간을 입력하세요.'); 	theForm.playtime.focus();	
	}else if (theForm.opendate.value == '') {
		alert('개봉일을 입력하세요.'); 	theForm.opendate.focus();
	}else if (theForm.content.value == '') {
		alert('설명을 입력하세요.'); 	theForm.content.focus();	
	}else if(theForm.image.value =='')   {
      alert("이미지를 넣어주세요"); theForm.image.focus();
   }else if(theForm.video.value =='')   {
      alert("영상을 넣어주세요"); theForm.video.focus();
   }else{
      theForm.action = "movie.do?command=adminMovieWrite";
      theForm.submit();
	}
}


function go_mov(){
	location.href = "movie.do?command=adminMovieList";
	
}

function go_detail( movieno ){
	var url = "movie.do?command=adminMovieDetail&movieno=" + movieno;
	document.frm.action = url; 
	document.frm.submit();
}

function go_mod(movieno){
	var url = "movie.do?command=adminMovieUpdateForm&movieno=" + movieno;
	location.href=url;
}
function go_mod_save(){
	if (document.frm.genre.value == '') {
		  alert('장르를 선택하세요'); 	  document.frm.genre.focus();
	 } else if (document.frm.title.value == '') {
		  alert('영화제목을 입력하세요');	  document.frm.title.focus();
	 } else if (document.frm.director.value == '') {
		  alert('감독을 입력하세요');	  document.frm.director.focus();
	 } else if (document.frm.actor.value == '') {
		  alert('주연을 입력하세요');	  document.frm.actor.focus();
	 } else if (document.frm.agegrade.value == '') {
		  alert('연령대를 입력하세요');	  document.frm.agegrade.focus();
	 }else if (document.frm.opendate.value == '') {
		  alert('개봉일을 입력하세요');	  document.frm.opendate.focus();
	 }else if (document.frm.content.value == '') {
		  alert('설명을 입력하세요');	  document.frm.content.focus();
	 }else{
		if( confirm('수정하시겠습니까?') ){
			 document.frm.action = "movie.do?command=adminMovieUpdate";
			 document.frm.submit();
		}
	}
}
function go_mod_delete(movieno){
	if(confirm('삭제하시겠습니까?')){
	var url="movie.do?command=adminMovieDelete&movieno="+movieno;
	location.href=url;
	}
}
