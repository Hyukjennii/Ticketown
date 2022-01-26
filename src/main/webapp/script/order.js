function go_cart(){
	if (document.formm.quantity1.value == "") {
	    alert("성인 수량을 입력하여 주세요.");
	    document.formm.quantity1.focus();
	    
	}else if(document.formm.quantity2.value == "") {
	    alert("아이 수량을 입력하여 주세요.");
	    document.formm.quantity2.focus();
    }
}



function order(){
	document.formm.action ="movie.do?command=orderForm&movieno";
	document.formm.submit();
}
