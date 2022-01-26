function go_view(qseq){
    location.href = "movie.do?command=adminQnaDetail&qseq=" + qseq;

}

function go_rep(qseq){
   document.frm.action="movie.do?command=adminQnaRepsave";
   document.frm.submit();
}

function go_list(){
   location.href="movie.do?command=adminQnaList";
}

function go_search_qna(){
   if( document.qna.key.value=="") return;
   var url = "movie.do?command=adminQnaList&page=1";
   document.frm.action = url;
    document.frm.submit();
}