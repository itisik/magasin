<%@page import="kr.magasin.board.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%-- <% Notice n = (Notice)request.getAttribute("notice"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAGASIN > Notice</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
<link rel="stylesheet" href="/css/board_css/notice.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">

</head>
<body id="body1">
	<div class="wrapper">
		<header>
		<div class="header">
				<%@include file="/WEB-INF/views/common/header.jsp"%>
			</div>
	</header>
	<section>
				<div class="mainContainer">
				<div class="side-nav">
					<%@include file="/WEB-INF/views/common/nav.html"%>
				</div>
				<div class="mainContent" style="width: 943px;">
					<!-- 만드신 콘텐츠 넣으세요!!!!!!!!!!!!!!!!width 반드시 943!!!!!!!!!!!!!!!!!!!!!!!!!! -->
					<div class="noticeContainer">
			
				<ul id="notice">
					<li>Notice</li>
				</ul>
				<div class="table-wrapper">
					<table class="table view-table">
						<thead>
							<tr>
								<th>subject</th>
								<td>${notice.noticeTitle }</td>
							</tr>
							<tr>
								<th>Writer</th>
								<td>
								<c:if test="${notice.noticeWriter=='admin' }">
									<img src="/img/common_img/footerlogo2.png" height="27">
								</c:if>
							<%-- 	<% if(n.getNoticeWriter().equals("admin")){ %>
									<img src="/img/common_img/footerlogo2.png" height="27">
								<%} %> --%>
								</td>
							</tr>
							<tr>
								<th>Date</th>
								<td>${notice.noticeDate }</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
							
								<div class="noticeContents">
									${notice.noticeCont }
								</div>
								</td>
							</tr>
					</table>
				</div>
				<div class="notice-view-btn">
					<br>
				
					<a href="/noticeList" class="btn btn-default btn-md" >List</a>
					<c:if test="${not empty sessionScope.member.id && sessionScope.member.id==notice.noticeWriter}">
					<a href="/noticeDelete?noticeNo=${notice.noticeNo }" class="btn btn-default btn-md" >삭제</a>
					<a href="/noticeUpdate?noticeNo=${notice.noticeNo }" class="btn btn-default btn-md" >수정</a>
					
					</c:if>
					
				</div>
			</div>
	
				
					</div>
				</div>
	</section>
	<footer>
		<div class="footer">
				<%@include file="/WEB-INF/views/common/footer.jsp"%>
			</div>
	</footer>
	</div>
	
</body>
</html>