// 아이디 중복체크
function idch(){
	if(frm.mid.value == ""){
		alert("아이디를 입력하세요.");
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
				frm.mid_ch.value == "Y";
				console.log(frm.mid_ch.value);
			}
			else if(this.response == "no"){	// no 값이 전송되었을 때
				alert("해당 아이디는 이미 사용 중입니다.");
				frm.mid.value == "";
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
}

// 등록 취소 버튼
function add_c(){
	
}