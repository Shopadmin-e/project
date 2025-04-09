function ok(){
   if(frm.homepagename.value == ""){
      alert("홈페이지 이름을 입력해주세요");
   }else if(frm.admin_email.value == ""){
      alert("관리자 메일 주소를 입력해주세요");
   }else if(frm.use_points.value == ""){
      alert("포인트 사용 유/무를 선택해주세요");
   }else if(frm.signup_bonus.value == ""){
      alert("회원가입시 적립금을 입력해주세요");
   }else if(frm.signup_level.value == ""){
      alert("회원가입시 권한레벨을 입력해주세요");
   }else if(frm.corp_name.value == ""){
      alert("회사명을 입력해주세요");
   }else if(frm.ceo_name.value == ""){
      alert("대표자명을 입력해주세요");
   }else if(frm.corp_telno.value == ""){
      alert("통신판매업 신고번호를 입력해주세요");
   }else if(frm.corp_postno.value == ""){
      alert("사업장 우편번호를 입력해주세요");
   }else if(frm.corp_addr.value == ""){
      alert("사업장 주소를 입력해주세요");
   }else if(frm.corp_master.value == ""){
      alert("정보관리 책임자명을 입력해주세요");
   }else if(frm.master_email.value == ""){
      alert("정보관리 책임자 이메일을 입력해주세요");
   }else if(frm.corp_no.value == ""){
      alert("사업자 등록번호를 입력해주세요");
   }else if(frm.master_no.value == ""){
      alert("대표 전화번호를 입력해주세요");
   }else if(frm.corp_telno2.value == ""){
      alert("부가통신 사업자 번호를 입력해주세요");
   }else if(frm.bank.value == ""){
      alert("무통장 은행명을 입력해주세요");
   }else if(frm.bank_no.value == ""){
      alert("은행 계좌번호를 입력해주세요");
   }else if(frm.card.value == ""){
      alert("신용카드 사용 여부를 선택해 주세요");
   }else if(frm.phone.value == ""){
      alert("휴대폰 결제 여부를 선택해 주세요");
   }else if(frm.book.value == ""){
      alert("도서 상품권 사용 여부를 선택해 주세요");
   }else if(frm.cash_smallpoint.value == ""){
      alert("결제 최소포인트를 입력해 주세요");
   }else if(frm.cash_maxpoint.value == ""){
      alert("결제 최대포인트를 입력해 주세요");
   }else if(frm.cash_receipt.value == ""){
      alert("현금 영수증 발급 여부를 선택해 주세요");
   }else if(frm.delivery_name.value == ""){
      alert("배송업체명을 입력해 주세요");
   }else if(frm.delivery_cash.value == ""){
      alert("배송비 가격을 입력해 주세요");
   }else if(frm.delivery_date.value == ""){
      alert("희망 배송일을 입력해 주세요");
   }else{
      if(confirm("해당 정보를 사이드에 반영하시겠습니까?")){
         frm.action = "./admin_siteinfook.do";
         frm.submit();
      }
   }
}

function no(){
   if(confirm('해당 정보를 반영하지 않으시겠습니까?')){
      location.reload();
   }
}