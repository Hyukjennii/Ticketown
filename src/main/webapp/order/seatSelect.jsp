<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../menu.jsp" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>seatSelect.jsp</title>
<script src="script/jquery-3.6.0.js"></script>
<style>
body{background:black; color:white;}
#wrap{

   width:1000px; 
   height:600px; 
   border:2px solid gray;
   position: fixed; 
    top:50%; left:50%;
    transform: translate(-50%,-50%);
}

#seats{
   background:black;
   position:relative;
   float:left;
   width:800px;
   height:600px;
}
#select{
   width:500px;
   height:350px;
    position: relative; 
    top:40%; 
    left:50%;
      transform: translate(-50%,-50%);   
   /*  border:1px solid blue; */
}
#information{
   background:white;
   position:relative;
   float:left;
   width:200px;
   height:600px;
    font-size : 110%;
    color:#1E3269;
    font-weight:bold;
    overflow:hidden;
}
#order{
   width:195px;
   position:absolute;
   bottom : 30px;
   text-align:center;
}
#order input{
   border : none;
   width:100%;
   height:100%;
   background:#eee;
   color:white;
}

#screen{
   margin : 20px auto;
   width:500px;
   height:50px;
   text-align:center;
   line-heigth:50px;
   background:#eeeeee;
   font-size:200%;
   color:skyblue;
   
}
.seat {
          width: 45px;
          height: 45px;
          
        }
.clicked {
          background-color: red;
          color: white;
    }
.seat-wrapper{
   margin : 0 auto;
   text-align:center;
}        
#buttons{
   width:80%;
   height:80px;
   margin: 0 auto;
}
#buttons input{
   width:150px;
   height:30px;
   background:#eee;
   border:none;
   color:gray;
}
#buttons input:hover{   background:#164976;
   color:white;}
       
</style>
</head>
<body>
   <div id="wrap">
      <form method="post" name="seatselect">
         <input type="hidden" name="command" value="seatSelectComplete">
<!--          <div id="title">좌석선택</div>
 -->         <div>
            <div id="seats">
               <div id="screen">screen</div>
               <!-- <form name="seatselect" method="post" action="movie.do" >
               <input type="hidden" name="command" value="seatSelectComplete"> -->
                  <div class="seat-wrapper"></div><br>
                     <!-- <div id="order"> -->
                      <div id="buttons" align="center">
                     <input type="button" class="submit" value="좌석 선택"
                        onclick="seatSelectOk()" />&nbsp;&nbsp;<input type="button" value="뒤로가기" onclick="history.go(-1)"></div>
                     <!-- </div> -->
            </div>
            <div id="information">
               <input type="hidden" name="movieno" value="${MovieVO.movieno }" name="quantity1" value="${Quantity1}" 
               name="quantity2" value="${Quantity2}" name="date" value="${Date }" name="time" value="${Time}">
               <input type="hidden" name="cinemas" value="${TheatersVO.cinemas}">
               <div><img src="movie/files/${MovieVO.image}" width="200" height="270"></div><br>
               <div align="center">${MovieVO.title}</div>
               <div align="center">(${MovieVO.playtime})</div><br>
               <div align="center">${TheatersVO.cinemas}관</div>
                     <div align="center">성인_${Quantity1}명</div>
                     <div align="center">소인_${Quantity2}명</div>
                     <div align="center">${Totalprice}원</div>   <br>
                     <div align="center">좌석</div>
               <div align="center" id="k"></div>      <br>
                <div align="center" id="buttons"><input type="button" value="예매완료" onclick="go_order()"></div>
               </div>
            <div>
         </div>
      </div>
   </form>
</div>
</body>
<script type="text/javascript">
function go_order(){
   var url = "movie.do?command=seatSelectComplete&cinemas=" + "${TheatersVO.cinemas}" + "&movieno=" + ${MovieVO.movieno} + 
         "&quantity1=" + ${Quantity1} + "&quantity2=" + ${Quantity2} + "&seat=" + selectedSeats +
         "&date=" + "${Date}" + "&time=" + "${Time}";
   location.href=url;
}
</script>
<script type="text/javascript">

    let test = [];
    let selectedSeats = new Array();
    let selectedSeatsMap = [];
    const seatWrapper = document.querySelector(".seat-wrapper");
    // seat-wrapper클래스의 첫번째 요소 반환
    let clicked = "";
    let div = "";

    for (let i = 0; i <10; i++) {
        div = document.createElement("div");
        // 지정한 tagname의 html요소를 만들어 반환
        seatWrapper.append(div);
        for (let j = 0; j < 14; j++) {
            const input = document.createElement('input');
            input.type = "button";
            input.name = "seats"
            input.classList = "seat";
            //3중포문을 사용하지 않기위해 
            mapping(input, i, j);
            div.append(input);
            input.addEventListener('click', function(e) {
                console.log(e.target.value);
               
                //중복방지 함수
                selectedSeats = selectedSeats.filter((element, index) => selectedSeats.indexOf(element) != index);

                //click class가 존재할때(제거해주는 toggle)
                if (input.classList.contains("clicked")) {
                    input.classList.remove("clicked");
                    clicked = document.querySelectorAll(".clicked");
                    selectedSeats.splice(selectedSeats.indexOf(e.target.value), 1);
                    clicked.forEach((data) => {
                        selectedSeats.push(data.value);
                    });
                    //click class가 존재하지 않을때 (추가해주는 toggle)
                } else {
                    input.classList.add("clicked");
                    clicked = document.querySelectorAll(".clicked");
                    clicked.forEach((data) => {
                        selectedSeats.push(data.value);
                    })
                }
                console.log(selectedSeats);
            })
        }
    }
    
        function seatSelectOk(){
      // seat = input.seats.value;
       document.getElementById("k").innerHTML = selectedSeats;
       // document.seatselect.action = "movie.do";
       // document.seatselect.submit();
    }; 
   /*  function(){
         $(".seat").click(function(){
          alert($(this).val());
   });} */

    function mapping(input, i, j) {
        if (i === 0) {
            input.value = "A" + j;
        } else if (i === 1) {
            input.value = "B" + j;
        } else if (i === 2) {
            input.value = "C" + j;
        } else if (i === 3) {
            input.value = "D" + j;
        } else if (i === 4) {
            input.value = "E" + j;
        } else if (i === 5) {
            input.value = "F" + j;
        } else if (i === 6) {
            input.value = "G" + j;
       } else if (i === 7) {
           input.value = "H" + j;
      } else if (i === 8) {
          input.value = "I" + j;
      } else if (i === 9) {
          input.value = "J" + j;
      }
    }
</script>
</html>