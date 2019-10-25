<%@page import="kr.magasin.board.model.vo.AEtc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% AEtc a = (AEtc)request.getAttribute("a"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>***Answer View***</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/board_css/qna.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
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
								<div class="qnaContainer">
			
				<ul id="qna">
					<li>Q&A</li>
				</ul>
				<form action="/aUpdateEnd" method="post">
				<div class="table-wrapper">
					<table class="table qna-view-table">
						<thead>
							<tr>
								<th>subject</th>
								<td>
									<input type="hidden" name="ctgr" value="etc">
									<input type="hidden" name="aNo" value="<%=a.getaNo() %>">
									<img src="/img/board_img/realRe.png">
								<input type="text" name="aTitle" class="inputText"
								value="<%=a.getaTitle()%>">
								</td>
							</tr>
							<tr>
								<th>Writer</th>
								<td><img src="/img/common_img/footerlogo2.png" height="27">
								<input type="hidden" name="aWriter" class="inputText"
								value="admin"></td>
							</tr>
							<tr>
								<th>Date</th>
								<td><%=a.getaDate() %></td>
							</tr>
						</thead>
						<tbody>
							<tr>		
							<td colspan="2">
								<textarea name="aContent" cols="100" rows="10" ><%=a.getaCont() %></textarea>
								</td>
							</tr>	
						</table>
				</div>
				<div class="qna-btn">
					<br>
				
					<a href="/qnaList" class="btn btn-default btn-md" >List</a>
					<!-- 관리자 일때만 보이게~ -->
					<!-- <a href="#" class="btn btn-default btn-md" >삭제</a> -->
					<button type="submit" class="btn btn-default btn-md" >수정완료</button>
					
				</div>
				</form>
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