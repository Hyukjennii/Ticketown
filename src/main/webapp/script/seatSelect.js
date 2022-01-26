function seatSelect() {
  	if($('#quantity1').val() == 0 && $('#quantity2').val() == 0){
  		alert("최소 1인이상 선택해주세요.");
  	}else{
  		var url = "movie.do?command=seatSelect&movieno=" + $('#seat').val() + 
		"&quantity1=" + $('#quantity1').val() + "&quantity2=" + $('#quantity2').val() + 
		"&date=" + $('#date').val() + "&cinemas=" + $('#cinemas').val() + "&time=" + $('#time').val();
	
		location.href=url;
  	}
}



