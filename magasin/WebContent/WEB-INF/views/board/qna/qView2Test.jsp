<%@page import="kr.magasin.board.model.vo.QPrd"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% QPrd q = (QPrd)request.getAttribute("qPrd"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>***Question***</title>
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
					
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->


	
			<div class="qnaContainer">
			
				<ul id="qna">
					<li>Q&A</li>
				</ul>
				<div class="table-wrapper">
					<table class="table qna-view-table">
						<thead>
							<tr>
								<th>Category</th>
								<td>
								<%=q.getqCtgr() %>
								</td>
							</tr>
							<tr>
								<th>subject</th>
								<td><%=q.getqTitle() %></td>
							</tr>
							<tr>
								<th>Writer</th>
								<td><%=q.getqWriter() %></td>
							</tr>
							<tr>
								<th>Date</th>
								<td><%=q.getqDate() %></td>
							</tr>
						</thead>
						<tbody>
							<tr>
							<td>
							<div class="product-div">
							
							<img src="/img/product/<%=q.getPrdSnImg() %>" width="150"><br>
							<span><%=q.getPrdName() %></span>
							
							</div>
							</td>
							<td>
								<div>
								<%=q.getqCont() %>
								</div>
								
								</td>
							</tr>
					</table>
				</div>
				<div class="qna-btn">
					<br>
				
					<a href="/qnaList" class="btn btn-default btn-md" >List</a>
					<%if(m!=null){ 
						if(m.getId().equals("admin")){
					%>
					<!-- 관리자일때 -->
					<a href="/aPrdWrite" class="btn btn-default btn-md" >답변</a>
					<%}else if(m.getId().equals(q.getqWriter())){ %>
					<!-- 글쓴이 일때 -->
					<a href="/qPrdDelete?qNo=<%=q.getqNo() %>" class="btn btn-default btn-md" >삭제</a>
					<a href="/qPrdUpdate?qNo=<%=q.getqNo() %>" class="btn btn-default btn-md" >수정</a>
					<%} 
					}%>
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