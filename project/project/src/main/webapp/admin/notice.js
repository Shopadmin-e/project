//notice_writeok.jsp
//공지사항 등록
function signin(){
	if(frm.mtitle.value==""){
		alert("제목을 입력하세요");
		frm.mtitle.focus();
		return false;
	}
	else if(frm.mname.value==""){
		alert("이름을 입력하세요");
		frm.mname.focus();
		return false;
	}
	else{
		if(frm.mtext.value==""){
			alert("내용을 입력하세요");
			frm.mtext.focus();
			return false;			
		}
		else{
			//location.href = "http://localhost:8080/project/admin/notice_list.jsp"
			frm.submit();
			
		}
	}
}

//공지사항 목록으로 되돌아감
function list(){
	alert("목록으로 돌아가시겠습니까? 작성된 정보는 전부 지워집니다.");
	//location.href = "http://localhost:8080/project/admin/notice_list.jsp"
	frm.submit();
}
