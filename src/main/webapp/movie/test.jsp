<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>영화관 좌석 배치</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/hiphop5782/js@0.0.13/cinema/hacademy-cinema.css">
    <style>
        *{
            box-sizing: border-box;
        }
        .float-box > div{
            float:left;
            width:50%;
        }
        .float-box::after{
            content:"";
            display: block;
            clear:both;
        }
        .float-box > .result {
            padding:0.5rem;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/gh/hiphop5782/js@0.0.13/cinema/hacademy-cinema.js"></script>
    <script>
        window.addEventListener("load", function(){
            var cinema = new Hacademy.Reservation("#cinema");
            cinema.addChangeListener(function(seat){
                print(this);
            });
            print(cinema);
            function print(app){
                document.querySelector(".result").textContent = app.getQueryString();
            }
        });
    </script>
</head>
<body>
    <h1 align="center">Demo 2 : Client auto mode</h1>
    <ul>
        <li>사용자 모드에서는 좌석의 선택만 가능</li>
        <li>.cinema-seat-area에 data-mode="client"로 설정하거나 미작성 시 사용자 모드 설정</li>
        <li>좌석번호를 표시하고 싶은 경우 .cinema-seat-area에 data-seatno="visible"로 설정</li>
        <li>좌석번호는 현재 임의의 수정이 불가</li>
        <li>좌석 열 수는 .cinema-seat-area에 data-rowsize로 설정</li>
        <li>좌석 칸 수는 .cinema-seat-area에 data-colsize로 설정</li>
    </ul>
    <div class="float-box">
        <div>
            <form action="example.html" method="get">
                <div id="cinema" class="cinema-wrap" data-name="seat">
                    <div class="cinema-seat-area" data-rowsize="5" data-colsize="9" data-mode="client" data-fill="auto" data-seatno="visible"></div>
                </div>
        
                <input type="submit" value="선택">
            </form>
        </div>

        <h2 align="center">전송되는 데이터 형태</h2>
        <div class="result">

        </div>
    </div>
</body>
</html>