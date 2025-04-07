function loginck(){
	if(frm.mid.value == ""){
		alert("아이디를 입력하세요.");
		frm.mid.focus();
	}
	else if(frm.mpass.value == ""){
		alert("비밀번호를 입력하세요.");
		frm.mpass.focus();
	}
	else {
		frm.submit();
	}
}