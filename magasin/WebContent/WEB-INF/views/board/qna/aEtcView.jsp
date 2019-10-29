<%@page import="kr.magasin.board.model.vo.AEtc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
				<!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 -->
				
				<div class="qnaContainer">
			
				<ul id="qna">
					<li>Q&A</li>
				</ul>
				<div class="table-wrapper">
					<table class="table qna-view-table">
						<thead>
							<tr>
								<th>subject</th>
								<td>
									<img src="/img/board_img/realRe.png">${a.aTitle }
									
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
								<td>${a.aDate }</td>
							</tr>
						</thead>
						<tbody>
							<tr>
							<td colspan="2">
								<div style="text-align:center; width:800px; height:300px; margin: 0 auto; padding-top:30px;">
								${a.aCont }
								</div>
								
								</td>
							</tr>
					</table>
				</div>
				<div class="qna-btn">
					<br>
					<a href="/qnaList" class="btn btn-default btn-md" >List</a>
					<c:if test="${not empty sessionScope.member && sessionScope.member.id == 'admin' }">
						<a href="/aDelete?ctgr=etc&aNo=${a.aNo }&qNo=${a.aQEtcNoRef}" class="btn btn-default btn-md" >삭제</a>
						<a href="/aUpdate?ctgr=etc&aNo=${a.aNo }" class="btn btn-default btn-md" >수정</a>
						
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