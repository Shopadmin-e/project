<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ArrayList<String>> alldata = (ArrayList)request.getAttribute("alldata");
	
	String total_page = "0";	// 기본값 설정
	if(alldata != null && !alldata.isEmpty() && alldata.get(0).size() > 0){
		total_page = alldata.get(0).get(10);	// total
	}
	
	int pg = 1;
	if(total_page != null || !total_page.equals("")){
		float pg2 = Integer.parseInt(total_page) / 8f;
		pg = (int)Math.ceil(pg2);
	}
	
	String pno = request.getParameter("pageno");
	if(pno == null || pno.equals("1")){	// 최초 접근 또는 페이지 번호를 1 클릭한 경우
		pno = "1";
	}
	
	Date date = new Date();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>관리자 등록 페이지</title>
	<link rel="stylesheet" type="text/css" href="./css/basic.css">
	<link rel="stylesheet" type="text/css" href="./css/login.css?v=<%=date%>">
	<link rel="stylesheet" type="text/css" href="./css/main.css?v=<%=date%>">
	<link rel="icon" href="./img/logo.png" sizes="128x128">
	<link rel="icon" href="./img/logo.png" sizes="64x64">
	<link rel="icon" href="./img/logo.png" sizes="32x32">
	<link rel="icon" href="./img/logo.png" sizes="16x16">
<style>
.pagegin{
    height: 30px;
    float: left;
    font-size: 13px;
    line-height: 30px;
    text-align: center;
    position: relative;
}
</style>
</head>
<body>
<!-- 상단 -->
<%@ include file="./top.jsp" %>
<!-- 상단 -->
<!-- 메인 -->
<main class="maincss">
<section>
	<p>신규등록 관리자</p>
	<ol class="new_admin_title2">
		<li>NO</li>
		<li>관리자명</li>
		<li>아이디</li>
		<li>전화번호</li>
		<li>이메일</li>
		<li>담당부서</li>
		<li>담당직책</li>
		<li>가입일자</li>
		<li>승인여부</li>
	</ol>
<%
	if(alldata == null || alldata.isEmpty()){
%>	
	<ol class="new_admin_none">
		<li>신규 등록된 관리자가 없습니다.</li>
	</ol>
<%
	}
	else{
		// 총 데이터 개수 - ((페이지 번호 - 1) * 한 페이지당 출력 개수) 
		int total = Integer.parseInt(total_page) - ((Integer.parseInt(pno) - 1) * 8);
		int w = 0;
		while(w < alldata.size()){
%>
	<ol class="new_admin_lists2">
		<li><%=total%></li>
		<li><%=alldata.get(w).get(1)%></li>
		<li><%=alldata.get(w).get(2)%></li>
		<li><%=alldata.get(w).get(3)%><%=alldata.get(w).get(4)%><%=alldata.get(w).get(5)%></li>
		<li><%=alldata.get(w).get(6)%></li>
		<li><%=alldata.get(w).get(7)%></li>
		<li><%=alldata.get(w).get(8)%></li>
		<li><%=alldata.get(w).get(9).substring(0,10)%></li>
		<li>
			<button type="button" value="<%=alldata.get(w).get(0)%>" class="new_addbtn1" onclick="add_ok(this)">승인</button>
			<button type="button" value="<%=alldata.get(w).get(0)%>" class="new_addbtn2" onclick="add_no(this)">미승인</button>
		</li>
	</ol>
<%
			total--;
			w++;
		}
	}
%>
</section>
<!-- 페이징 -->
<section style="text-align: center; width:100%; margin-top: 30px;">
<table align="center" width="200" height="20">
<tr>
<%
	int ww = 1;
	while(ww <= pg){
%>
	<td><a href="./admin_list.do?pageno=<%=ww%>"><%=ww%></a></td>
<%
		ww++;
	}
%>
</tr>
</table>
</section>
</main>
<!-- 메인 -->
<!-- 카피라이터 -->
<footer class="main_copyright">
	<div>
		Copyright ⓒ 2024 shopbag All rights reserved.
	</div>
</footer>
<!-- 카피라이터 -->
</body>
<script src="./js/admin_list.js?v=<%=date%>"></script>
</html>