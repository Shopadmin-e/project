// 아이디 중복체크
function idch(){
	// 아이디 정규식 코드
	var id = frm.mid.value.trim();
	let ck = /^[a-z0-9][a-z0-9_]*$/i;
	// console.log(ck.test(id));
	var result = ck.test(id);
	
	if(id === ""){
		alert("생성할 관리자 아이디를 입력하세요.");
		frm.mid.focus();
	}
	else if(result == false){
		alert("아이디는 영어 대소문자, 숫자와 특수문자(_)만 사용 가능합니다.");
		frm.mid.value = "";
		frm.mid.focus();
	}
	else{
		ajaxpost(id);
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
	// 정규식 코드	
	// 비밀번호 정규식 코드
	var pw = frm.mpass.value;
	let ck2 = /^[a-z0-9][a-z0-9_!-]*$/i;
	// console.log(ck2.test(pw));
	var result2 = ck2.test(pw);
	
	// 이메일 정규식 코드
	var mail = frm.memail.value;
	let ck3 = /^[a-z0-9][a-z0-9_]*@[a-z0-9ㄱ-힇-]+\.[a-z]{2,}$/i;
	// console.log(ck3.test(mail));
	var result3 = ck3.test(mail);
	
	// 전화번호 정규식 코드
	var tel2 = frm.mtel2.value;
	let ck4 = /^\d{3,4}$/;
	// console.log(ck4.test(tel2));
	var result4 = ck4.test(tel2);
	
	var tel3 = frm.mtel3.value;
	let ck5 = /^\d{3,4}$/;
	// console.log(ck5.test(tel3));
	var result5 = ck5.test(tel3);

	if(frm.mid.value.trim() === ""){
		alert("생성할 관리자 아이디를 입력하세요.");
		frm.mid.focus();
	}
	else if(frm.mid_ch.value != "Y"){
		alert("아이디 중복체크를 해야 합니다.");
	}
	else if(frm.mpass.value.trim() === ""){
		alert("접속할 패스워드를 입력하세요.");
		frm.mpass.focus();
	}
	else if(frm.mpass.value.trim().length < 6){
		alert("비밀번호는 최소 6자 이상이어야 합니다.");
		frm.mpass.value = "";
		frm.mpass2.value = "";
		frm.mpass.focus();
	}
	else if(result2 == false){
		alert("비밀번호는 영어 대소문자, 숫자와 특수문자(-_!)만 사용 가능합니다.");
		frm.mpass.value = "";
		frm.mpass2.value = "";
		frm.mpass.focus();
	}
	else if(frm.mpass2.value.trim() === "" || frm.mpass.value != frm.mpass2.value){
		alert("동일한 패스워드를 입력하세요.");
		frm.mpass2.value = "";
		frm.mpass2.focus();
	}
	else if(frm.mname.value.trim() === ""){
		alert("담당자 이름을 입력하세요.");
		frm.mname.focus();
	}
	else if(frm.memail.value.trim() === ""){
		alert("담당자 이메일을 입력하세요.");
		frm.memail.focus();
	}
	else if(result3 == false){
		alert("올바른 이메일을 입력하세요.");
		frm.memail.value = "";
		frm.memail.focus();
	}
	else if(frm.mtel2.value.trim() === ""){
		alert("담당자 전화번호를 입력하세요.");
		frm.mtel2.focus();
	}
	else if(result4 == false){
		alert("올바른 전화번호를 입력하세요.");
		frm.mtel2.value = "";
		frm.mtel2.focus();
	}
	else if(frm.mtel3.value.trim() === ""){
		alert("담당자 전화번호를 입력하세요.");
		frm.mtel3.focus();
	}
	else if(result5 == false){
		alert("올바른 전화번호를 입력하세요.");
		frm.mtel3.value = "";
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
		frm.submit();
	}
}

// 등록 취소 버튼
function add_c(){
	alert("관리자 등록이 취소되었습니다.");
	location.href = "./index.jsp";
}