<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>information.jsp</title>
<style>
body{
 	background:black;
 	color:white;
}
#wrap{
	width:70%;
	border:3px solid gray;
	margin: 0 auto;
}
#title{
	position: relative; 
	width: 100%; 
	height: 70px; 
/* 	margin : 0 auto;
	text-align: center;  */
	line-height: 70px; 
	opacity:0.7; 

}
#box{
	position:relative;
	width:100%;
	height:320px;
/* 	border-bottom:1px solid gray;
 */	margin-bottom : 30px;
 border-bottom:1px solid gray;border-top:1px solid gray;
}
#box2{
	position:relative;
	left:50px;
	float:left;
	width:16%;
	height:320px;
	margin-right:48px;
	
}
#go a:link{text-decoration:none; color:white;}
#go a:visited{color:white;}
#go a{margin : 20px;}
#go a:text{color:white;}
#go{
	width:98.5%;
	height:50px;
	border-bottom:3px solid gray;
	text-align:center;
	line-height:50px;
	padding : 10px;
	font-size:130%;
/* 	 font-family: 'Do Hyeon', sans-serif;  */
	font-weight:bold;
}
#up{width:40px; height:40px; border:2px solid gray; position:fixed; bottom:10px; right:200px;}
</style>
</head>
<body>

<br><br>
<div id="wrap">
	<div id="go">
	<a href="#Drama">드라마</a>&nbsp;&nbsp;<a href="#Thriller">스릴러</a>&nbsp;&nbsp;<a href="#Action">액션</a>&nbsp;&nbsp;<a href="#Comedy">코미디</a>&nbsp;&nbsp;
	<a href="#Animation">애니메이션</a>&nbsp;&nbsp;<a href="#Fantasy">판타지</a></div>
	<h1 id="title">&nbsp;&nbsp;상영중인 영화</h1>
	<div id="box">
		<c:forEach var = "MovieVO" items="${MovieVO}" begin="0" end="4">
			<div id="box2">
				<img src="movie/files/${MovieVO.image }" width="100%"  height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${MovieVO.movieno}'">
			</div>
		</c:forEach>
	</div>
	<div id="box">
		<c:forEach var = "MovieVO" items="${MovieVO}" begin="5" end="9">
			<div id="box2">
				<img src="movie/files/${MovieVO.image }" width="100%"  height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${MovieVO.movieno}'">
			</div>
		</c:forEach>
	</div>
	<a id="Drama"></a>
	<h1 id="title">&nbsp;&nbsp;드라마</h1>
	<div id="box">
		<c:forEach var = "Drama" items="${Drama}">
			<div id="box2">
				<img src="movie/files/${Drama.image}" width="100%" height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${Drama.movieno}'"> 
			</div>
		</c:forEach>
	</div>
	<a id="Thriller"></a>
	<h1 id="title">&nbsp;&nbsp;스릴러</h1>
	<div id="box">
		<c:forEach var = "Thriller" items="${Thriller}">
			<div id="box2">
				<img src="movie/files/${Thriller.image}" width="100%" height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${Thriller.movieno}'"> 
			</div>
		</c:forEach>
	</div>
	<a id="Action"></a>
	<h1 id="title">&nbsp;&nbsp;액션</h1>
	<div id="box">
		<c:forEach var = "Action" items="${Action}">
			<div id="box2">
				<img src="movie/files/${Action.image}" width="100%" height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${Action.movieno}'"> 
			</div>
		</c:forEach>
	</div>
	<a id="Comedy"></a>
	<h1 id="title">&nbsp;&nbsp;코미디</h1>
	<div id="box">
		<c:forEach var = "Comedy" items="${Comedy}">
			<div id="box2">
				<img src="movie/files/${Comedy.image}" width="100%" height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${Comedy.movieno}'"> 
			</div>
		</c:forEach>
	</div>
	<a id="Animation"></a>
	<h1 id="title">&nbsp;&nbsp;애니메이션</h1>
	<div id="box">
		<c:forEach var = "Animation" items="${Animation}">
			<div id="box2">
				<img src="movie/files/${Animation.image}" width="100%" height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${Animation.movieno}'"> 
			</div>
		</c:forEach>
	</div>
	<a id="Fantasy"></a>
	<h1 id="title">&nbsp;&nbsp;판타지</h1>
	<div id="box">
		<c:forEach var = "Fantasy" items="${Fantasy}">
			<div id="box2">
				<img src="movie/files/${Fantasy.image}" width="100%" height="100%"
				onclick="location.href='movie.do?command=movieDetail&movieno=${Fantasy.movieno}'"> 
			</div>
		</c:forEach>
	</div>
</div>
<div id="up"><a href="#header"><img src="images/up.PNG" width="40" height="40" ></a></div>
</body>
</html>