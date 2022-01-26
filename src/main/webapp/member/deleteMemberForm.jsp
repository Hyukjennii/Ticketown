<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" rel="stylesheet"> 
<script src ="script/member.js"></script>
<script>
	window.onload = function(){
		var deleteAttr = document.getElementById('deleteAttr').value;
		if(deleteAttr == 'Y'){
			alert("탈퇴가 처리 되었습니다.")			
			opener.location.href = "movie.do?command=main";
			self.close();
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
 <input type="hidden" id="deleteAttr" value="${deleteAttr }" />
 <h1>회원탈퇴 페이지</h1>
    <form name="frm" method="post">
        <TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
        <TR height="30">
            <TD colspan="2" align="middle">
                <font size="+1" ><b>회원 탈퇴</b></font>
            </TD>
        </TR>
        <TR height="30">
            <TD width="110" align=center>비밀번호</TD>
            <TD width="150" align=center>
                <input type=password name="pwd" size="15" maxlength="12">
            </TD>
        </TR>
       
        <TR height="30">
            <TD colspan="2" align="middle">
                <input type="submit" value="탈퇴" onclick="go_delete2()">
                <input type="button" value="취소" onclick="window.close()">
            </TD>
        </TR>
        </TABLE>
        <br><br>${errorMessage}
    </form>
</body>

</html>