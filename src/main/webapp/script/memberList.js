function go_mtotal(){
	document.frm.key.value="";
	document.frm.action = "movie.do?command=adminMemberList&page=1";
	document.frm.submit();
}

function go_msearch(){
	if( document.frm.key.value=="") return;
	var url = "movie.do?command=adminMemberList&page=1";
	document.frm.action = url;
    document.frm.submit();
}