// 승인
function add_ok(btn){
	ajax_post1(btn.value);
}

function ajax_post1(midx){
	// console.log(midx);
	
	var http;
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			// console.log(this.response);
			if(this.response == "ok"){
				alert('해당 관리자를 승인하였습니다.');
				location.href='./admin_list.do';
			}
			else{
				alert('시스템 오류로 인하여 해당 관리자를 승인하지 못하였습니다.');
				location.href='./admin_list.do';
			}
		}
		else if(http.status == 404){
			console.log("경로 오류 발생");
		}
		else if(http.status == 405){
			console.log("통신 규격 오류 발생");
		}
	}
	
	// POST 방식
	http.open("post","./adminok.do",true);
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	http.send("midx="+midx);
}

// 미승인
function add_no(btn){
	ajax_post2(btn.value);
}

function ajax_post2(midx){
	// console.log(midx);
	
	var http;
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			// console.log(this.response);
			if(this.response == "ok"){
				if(confirm('해당 관리자를 미승인시 복구되지 않습니다.')){
					location.href='./admin_list.do';					
				}
			}
			else{
				alert('시스템 오류로 인하여 해당 관리자를 승인하지 못하였습니다.');
				location.href='./admin_list.do';
			}
		}
		else if(http.status == 404){
			console.log("경로 오류 발생");
		}
		else if(http.status == 405){
			console.log("통신 규격 오류 발생");
		}
	}
	
	// POST 방식
	http.open("post","./adminno.do",true);
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	http.send("midx="+midx);
}