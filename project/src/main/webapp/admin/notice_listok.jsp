<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
ArrayList<ArrayList<String>> notice = (ArrayList<ArrayList<String>>)request.getAttribute("result");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 리스트 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/basic.css">
    <link rel="stylesheet" type="text/css" href="./css/login.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/main.css?v=10">
    <link rel="stylesheet" type="text/css" href="./css/notice.css?v=10">
    <link rel="icon" href="./img/logo.png" sizes="128x128">
    <link rel="icon" href="./img/logo.png" sizes="64x64">
    <link rel="icon" href="./img/logo.png" sizes="32x32">
    <link rel="icon" href="./img/logo.png" sizes="16x16">
</head>
<body>

<!-- 상단 로고 및 메뉴 -->
<%@include file="./top.jsp" %>
<!-- 상단 로고 및 메뉴 -->

<main class="maincss">
<section>
    <p>공지사항 관리페이지</p>
    <form id="frm" method="get" action="./notice_writeok.do">
    <div class="subpage_view">
    <%
    	int f;
    	for(f=0; f<notice.size(); f++){
    
    %>
    <ul>
        <li><input type="checkbox"></li>
        <li>NO</li>
        <li>제목</li>
        <li>글쓴이</li>
        <li>날짜</li>
        <li>조회</li>
    </ul>
    <ol>
        <li><input type="checkbox"></li>
        <li><%=notice.get(f).get(0)%></li>
        <li><%=notice.get(f).get(1)%></li>
        <li><%=notice.get(f).get(2)%></li>
        <li><%=notice.get(f).get(3)%></li>
        <li><%=notice.get(f).get(4)%></li>
    </ol>
    <%
    	}
    %>
    <ol class="none_text">
        <li>등록된 공지 내용이 없습니다.</li>
    </ol>
    </div>
    <div class="board_btn">
        <button class="border_del" type="button" onclick="del()">공지삭제</button>
        <button class="border_add" type="button" onclick="sign()">공지등록</button>
    </div>
    <div class="border_page">
        <ul class="pageing">
            <li><img src="./ico/double_left.svg"></li>
            <li><img src="./ico/left.svg"></li>
            <li>1</li>
            <li><img src="./ico/right.svg"></li>
            <li><img src="./ico/double_right.svg"></li>
        </ul>
    </div>
     </form>
</section>
</main>
<footer class="main_copyright">
    <div>
        Copyright ⓒ 2024 shopbag All rights reserved.
    </div>
</footer>
</body>
<script src="./notice2.js?v=1"></script>

</html>