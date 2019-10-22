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
</head>
<body>
	<section>
			<div class="noticeContainer">
			
				<ul id="notice">
					<li>Notice</li>
				</ul>
				<form action="/noticeUpdateEnd" method="get">
				
				<div class="table-wrapper">
					<table class="table view-table">
						<thead>
							<tr>
								<th>subject</th>
								<!-- 원래 Title 받아올거에요~ -->
								<td><input type="text" name="noticeTitle" class="inputText" value="<%=n.getNoticeTitle()%>">
								</td>
							</tr>
							<tr>
								<th>Writer</th>
								<td><img src="/img/common_img/footerlogo2.png" height="27">
								<!-- 관리자 넘겨줄거에요~ -->
								<input type="hidden" name="noticeWriter" class="inputText"
								value="admin">
								<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo() %>">
								</td>
							</tr>
							
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<textarea cols="120" rows="20" style="text-align: center;" 
									 name="noticeContent"><%=n.getNoticeCont() %></textarea>
								</td>
							</tr>
					</table>
				</div>
				
				<div class="notice-btn">
				<br>
					<a href="/noticeList" class="btn btn-md" >List</a>
					<button type="submit" class="btn btn-md">Update</button>
				</div>
				</form>
			</div>
	</section>
</body>
</html>