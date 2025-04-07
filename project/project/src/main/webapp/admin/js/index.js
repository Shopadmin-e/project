function loginck(){
	if(frm.mid.value == ""){
		alert("아이디를 입력하세요.");
		frm.mid.focus();
		return false;
	}
	else if(frm.mpass.value == ""){
		alert("비밀번호를 입력하세요.");
		frm.mpass.focus();
		return false;
	}
	else if(frm.mid.value == "master" && frm.mpass.value == "shop_master123"){
		return true;
	}
	else{
		alert("아이디 및 비밀번호를 확인하세요");
		frm.mid.value = "";
		frm.mpass.value = "";
		return false;
	}
}