/*var border_add = document.getElementsByClassName("border_add")[0];
var border_del = document.getElementsByClassName("border_del")[1];

border_add.addEventListener("click", function(){
	alert("공지사항 등록");
})
border_del.addEventListener("click", function(){
	alert("공지사항 삭제");
})*/

function sign(){
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
			frm.submit();
		}
	}
}

function list(){
	alert("목록으로 돌아가시겠습니까? 작성된 정보는 전부 지워집니다.");
	frm.submit();
}