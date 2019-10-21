<%@page import="kr.magasin.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
 	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/common_css/header.css">
</head>
<body>

<div class="header-left">
					<a href="/index.jsp"><img src="/img/common_img/mainlogo.png" width="170"></a>
				</div>
				<div class="header-center">
				</div>
				<div class="header-right">
					<div class="header-menu">
						<ul class="header-menu-bar">
							<li><a href="/views/member/join.jsp">join</a></li>
							<li><a href="/views/member/login.jsp">log-in</a></li>
							<% if (m == null){ %>
								<li><a href="/views/myPage/myPage.jsp">mypage</a></li>
							<% }else{%>
								<li><a href="/mypage?id=<%= m.getId() %>">mypage</a></li>
							<%} %>
							
							<li><a href="#" id="cart-img">cart<img src="/img/common_img/jang.png" width="20"></a></li>
						</ul>
					</div>
					
					<div class="header-search">
						<input type="text" name="headerSearch" class="searchBar">
						<a href="#"><img src="/img/common_img/searchIcon.png" width="30" height="28" id="searchIcon"></a>
					</div>
				</div> 
</body>
</html>
