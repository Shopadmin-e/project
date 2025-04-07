// 아이디 중복체크
function idch(){
	if(frm.mid.value == ""){
		alert("생성할 관리자 아이디를 입력하세요.");
	}
	else{
		ajaxpost(frm.mid.value);
	}
}

var ok = "";
function ajaxpost(data){
	// console.log(data);
	function wck(){
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();	// 신규 XHR 통신 생성
		}		
	}
	
	function getdata(){
		if(ok.readyState == XMLHttpRequest.DONE && ok.status == 200){
			// console.log(this.response);
			if(this.response == "ok"){	// ok 값이 전송되었을 때
				alert("사용가능한 아이디입니다.");
				frm.mid.readOnly = true;	// 아이디를 더 이상 수정하지 않음
				frm.mid_ch.value = "Y";	// 중복체크 여부 값을 Y로 설정
				// console.log(frm.mid_ch.value);
			}
			else if(this.response == "no"){	// no 값이 전송되었을 때
				alert("해당 아이디는 이미 사용 중입니다.");
				frm.mid.value = "";
			}
		}
	}
	
	ok = wck();
	ok.onreadystatechange = getdata;
	ok.open("GET","./idcheck.do?mid="+data,true);
	ok.send();
}

// 관리자 등록 버튼
function add_m(){
	if(frm.mid.value == ""){
		alert("생성할 관리자 아이디를 입력하세요.");
		frm.mid.focus();
	}
	else if(frm.mid_ch.value != "Y"){
		alert("아이디 중복체크를 해야 합니다.");
	}
	else if(frm.mpass.value == ""){
		alert("접속할 패스워드를 입력하세요.");
		frm.mpass.focus();
	}
	else if(frm.mpass2.value == "" || frm.mpass.value != frm.mpass2.value){
		alert("동일한 패스워드를 입력하세요.");
		frm.mpass2.value = "";
		frm.mpass2.focus();
	}
	else if(frm.mname.value == ""){
		alert("담당자 이름을 입력하세요.");
		frm.mname.focus();
	}
	else if(frm.memail.value == ""){
		alert("담당자 이메일을 입력하세요.");
		frm.memail.focus();
	}
	else if(frm.mtel2.value == ""){
		alert("담당자 전화번호를 입력하세요.");
		frm.mtel2.focus();
	}
	else if(frm.mtel3.value == ""){
		alert("담당자 전화번호를 입력하세요.");
		frm.mtel3.focus();
	}
	else if(frm.dep.value == ""){
		alert("담당자 부서를 선택하세요.");
		frm.dep.focus();
	}
	else if(frm.pos.value == ""){
		alert("담당자 직책을 선택하세요.");
		frm.pos.focus();
	}
	else{
		alert("가입이 완료 되었습니다. 로그인은 전산 담당자가 확인 후에 가능합니다.");
		location.href = "./index.jsp";
	}
}

// 등록 취소 버튼
function add_c(){
	alert("관리자 등록이 취소되었습니다.");
	location.href = "./index.jsp";
}