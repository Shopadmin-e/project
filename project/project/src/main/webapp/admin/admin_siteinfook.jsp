<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%
    Map<String, String> siteInfo = (Map<String, String>) request.getAttribute("siteInfo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= siteInfo.get("homepagename") %></title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="./css/main.css">
    <link rel="stylesheet" type="text/css" href="./css/subpage.css?v=5">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>
<%@include file="./top.jsp" %>
<main class="maincss">
<section>
    <p>홈페이지 가입환경 설정</p>
<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" value="<%= siteInfo.get("homepagename") %>" class="in_form1" name="homepagename"> 
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" class="in_form2" name="admin_email" value="<%= siteInfo.get("admin_email") %>"> 
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
            <em><label><input type="radio" class="ckclass" name="use_points" value="Y" <%= "Y".equals(siteInfo.get("use_points")) ? "checked" : "" %>> 포인트 사용</label></em> 
            <em><label><input type="radio" class="ckclass" name="use_points" value="N" <%= "N".equals(siteInfo.get("use_points")) ? "checked" : "" %>> 포인트 미사용</label></em>
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" class="in_form3" maxlength="5" name="signup_bonus" value="<%= siteInfo.get("signup_bonus") %>"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" class="in_form3" maxlength="1" name="signup_level" value="<%= siteInfo.get("signup_level") %>"> 레벨
    </li>
</ul> 
</div>
<p>홈페이지 기본환경 설정</p>
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" class="in_form0" name="corp_name" value="<%= siteInfo.get("corp_name") %>"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" class="in_form0" name="corp_no" value="<%= siteInfo.get("corp_no") %>"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" class="in_form0" name="ceo_name" value="<%= siteInfo.get("ceo_name") %>"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" class="in_form0" name="master_no" value="<%= siteInfo.get("master_no") %>"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" class="in_form0" name="corp_telno" value="<%= siteInfo.get("corp_telno") %>"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" class="in_form0" name="corp_telno2" value="<%= siteInfo.get("corp_telno2") %>"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" class="in_form0" name="corp_postno" value="<%= siteInfo.get("corp_postno") %>"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" class="in_form2" name="corp_addr" value="<%= siteInfo.get("corp_addr") %>"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" class="in_form0" name="corp_master" value="<%= siteInfo.get("corp_master") %>"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" class="in_form1" name="master_email" value="<%= siteInfo.get("master_email") %>"> 
    </li>
</ul>
</div>
<p>결제 기본환경 설정</p>
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input type="text" class="in_form0" name="bank" value="<%= siteInfo.get("bank") %>"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" class="in_form1" name="bank_no" value="<%= siteInfo.get("bank_no") %>"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="card" value="Y" <%= "Y".equals(siteInfo.get("card")) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="card" value="N" <%= "N".equals(siteInfo.get("card")) ? "checked" : "" %>> 미사용</label></em>
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="phone"  value ="Y" <%= "Y".equals(siteInfo.get("phone")) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="phone" value="N" <%= "N".equals(siteInfo.get("phone")) ? "checked" : "" %>> 미사용</label></em>
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="book" value="Y" <%= "Y".equals(siteInfo.get("book")) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="book" value="N" <%= "N".equals(siteInfo.get("book")) ? "checked" : "" %>> 미사용</label></em>
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="cash_smallpoint" value="<%= siteInfo.get("cash_smallpoint") %>"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" name="cash_maxpoint" value="<%= siteInfo.get("cash_maxpoint") %>"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
            <em><label><input type="radio" class="ckclass" name="cash_receipt" value="Y" <%= "Y".equals(siteInfo.get("cash_receipt")) ? "checked" : "" %>> 사용</label></em> 
            <em><label><input type="radio" class="ckclass" name="cash_receipt" value="N" <%= "N".equals(siteInfo.get("cash_receipt")) ? "checked" : "" %>> 미사용</label></em>
     </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" class="in_form0" name="delivery_name" value="<%= siteInfo.get("delivery_name") %>"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" class="in_form0" maxlength="7" name="delivery_cash" value="<%= siteInfo.get("delivery_cash") %>"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
            <em><label><input type="radio" class="ckclass" name="delivery_date" value="Y" <%= "Y".equals(siteInfo.get("delivery_date")) ? "checked" : "" %>> 사용</label></em> 
            <em><label><input type="radio" class="ckclass" name="delivery_date" value="N" <%= "N".equals(siteInfo.get("delivery_date")) ? "checked" : "" %>> 미사용</label></em>
     </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소">저장 취소</button>
</div>
</section>
<section></section>
<section></section>
</main>
<footer class="admin_copy_login">
        <div>
           회사명 : <%= siteInfo.get("corp_name") %>
           대표자명 : <%= siteInfo.get("ceo_name") %>
           통신판매업 신고번호 : <%= siteInfo.get("corp_telno") %>
           사업장 우편번호 : <%= siteInfo.get("corp_postno") %>
           정보관리책임자명 : <%= siteInfo.get("corp_master") %><br>
           사업자등록번호 : <%= siteInfo.get("corp_no") %>
           대표전화번호 : <%= siteInfo.get("master_no") %>
           부가통신 사업자번호 : <%= siteInfo.get("corp_telno2") %>
           사업장 주소 : <%= siteInfo.get("corp_addr") %>
           정보책임자 E-mail : <%= siteInfo.get("master_email") %>
        <br>
           Copyright © 2024 shopbag All rights reserved.
    </div>
</footer>
</body>
</html>