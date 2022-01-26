function check_id() {
   var id = document.getElementById('id').value;

   if (id.length < 4 || id.length > 10) {
      document.getElementById('checkid').innerHTML = '아이디는 4자 이상 10자 이하로 해주세요.';
      document.getElementById('checkid').style.color = 'red';
      document.getElementById('id').value = '';
   } else {
      document.getElementById('checkid').innerHTML = '중복체크해주세요.';
      document.getElementById('checkid').style.color = 'green';
   }
}

function check_pw() {
   var pw = document.getElementById('pw').value;

   if (pw.length < 4 || pw.length > 16) {
      window.alert('비밀번호는 4글자 이상, 16글자 이하만 이용 가능합니다.');
      document.getElementById('pw').value = '';
   }
   if (document.getElementById('pw').value != '' && document.getElementById('pw2').value != '') {
      if (document.getElementById('pw').value == document.getElementById('pw2').value) {
         document.getElementById('check').innerHTML = '비밀번호가 일치합니다.'
         document.getElementById('check').style.color = 'green';
      }
      else {
         document.getElementById('check').innerHTML = '비밀번호가 일치하지 않습니다.';
         document.getElementById('check').style.color = 'red';
      }
   }
}
function go_save() {
   if (document.joinForm.id.value == "") {
      alert("아이디를 입력하여 주세요.");
      document.joinForm.id.focus();

   } else if (document.joinForm.pwd.value == "") {
      alert("비밀번호를 입력해 주세요.");
      document.joinForm.pwd.focus();

   } else if (document.joinForm.reid.value != document.joinForm.id.value) {
      alert("아이디 중복확인을 하지 않았습니다");
      document.joinForm.id.focus();

   } else if (document.joinForm.pwd.value == "") {
      alert("비밀번호를 입력해 주세요.");
      document.joinForm.pwd.focus();

   } else if (document.joinForm.pwd.value != document.joinForm.pwdCheck.value) {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
      document.joinForm.pwd.focus();

   } else if (document.joinForm.email.value == "") {
      alert("이메일을 입력해 주세요.");
      document.joinForm.email.focus();

   } else if (document.joinForm.email.value == "") {
      alert("이메일을 입력해 주세요.");
      document.joinForm.email.focus();

   } else {
      alert("회원가입이 완료되었습니다.");
      document.joinForm.action = "movie.do";
      document.joinForm.submit();
   }
}



function idcheck() {
   if (document.joinForm.id.value == "") {
      alert("아이디를 입력하세요");
      documnet.joinForm.id.focus();
      return;
   }
   var url = "movie.do?command=idCheckForm&id=" + document.joinForm.id.value;
   var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250";
   window.open(url, "IdCheck", opt);
}

function loginCheck() {
   if (document.loginfrm.id.value == "") {
      alert("아이디를 입력하세요");
      document.loginfrm.id.focus();
      return false;
   }
   if (document.loginfrm.pwd.value == "") {
      alert("비밀번호를 입력하세요");
      document.loginfrm.pwd.focus();
      return false;
   }
   return true;
}

function idok(userid) {
   opener.joinForm.id.value = userid;
   opener.joinForm.reid.value = userid;
   self.close();
}

function editCheck() {
   if (document.frm.name.value.length == 0) {
      alert("이름은 필수입력사항입니다");
      document.frm.name.focus();
      return false;
   }
   if (document.frm.pwd.value == "") {
      alert("비밀번호는 반드시 입력하여야 합니다");
      document.frm.pwd.focus();
      return false;
   }
   if (document.frm.pwd.value != document.frm.pwd_check.value) {
      alert("비밀번호와 확인이 일치하지 않습니다");
      document.frm.pwd_check.focus();
      return false;
   }
   return true;
}

function go_update() {
   if (document.updateForm.pwd.value == "") {
      alert("비밀번호를 입력해 주세요.");
      document.updateForm.pwd.focus();
   } else if ((document.updateForm.pwd.value != document.updateForm.pwdCheck.value)) {
      alert("비밀번호가 일치하지 않습니다.");
      document.updateForm.pwd.focus();
   } else if (document.updateForm.name.value == "") {
      alert("이름을 입력해 주세요.");
      document.updateForm.name.focus();
   } else if (document.updateForm.email.value == "") {
      alert("이메일을 입력해 주세요.");
      document.updateForm.email.focus();
   } else {
      alert("수정이 완료되었습니다");
      document.updateForm.action = "movie.do";
      document.updateForm.submit();
   }
}

function find_id() {
   var url = "movie.do?command=findIdPwd";
   var opt = "toolbar=no,menubar=no,scrollbars=no,resizable=no,width=700,";
   opt = opt + "height=500, top=300, left=300";
   window.open(url, "Find Id/Pw", opt);
}

function go_delete(){
   var url="movie.do?command=deleteMemberForm";
   var opt ="toolbar=no,menubar=no,scrollbars=no,resizable=no,width=700,";
   opt = opt +"height=500, top=300, left=300";
   window.open(url,"deleteMember", opt);
   
}

function go_delete2(){
   if(confirm("회원탈퇴 하시겠습니까?")){
      document.frm.action = "movie.do?command=deleteMember";
      document.frm.submit();
   }else{
      window.close()
   }
   
}
