<%@page import="kr.magasin.board.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Notice n = (Notice)request.getAttribute("notice"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
<link rel="stylesheet" href="/css/board_css/notice.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
</head>
<body id="body1">
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
								<td><%=n.getNoticeTitle() %></td>
							</tr>
							<tr>
								<th>Writer</th>
								<td>
								<% if(n.getNoticeWriter().equals("admin")){ %>
									<img src="/img/common_img/footerlogo2.png" height="27">
								<%} %>
								</td>
							</tr>
							<tr>
								<th>Date</th>
								<td><%=n.getNoticeDate() %></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
								<style>
									.noticeContents{
										margin: 0 auto;
										border-radius : 10px;
										width:90%;
									}
								</style>
								<div class="noticeContents">
									<%=n.getNoticeCont() %>
								</div>
								</td>
							</tr>
					</table>
				</div>
				<div class="notice-view-btn">
					<br>
				
					<a href="/noticeList" class="btn btn-default btn-md" >List</a>
					<%if(m!=null&& m.getId().equals(n.getNoticeWriter())){ %>
					<a href="/noticeDelete?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-default btn-md" >삭제</a>
					<a href="/noticeUpdate?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-default btn-md" >수정</a>
					<%} %>
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
	
</body>
</html>