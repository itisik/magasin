<%@page import="kr.magasin.board.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--  <% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("noticeList");
    	String pageNavi = (String)request.getAttribute("pageNavi"); 
    %> --%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>MAGASIN > Notice</title>

<link rel="stylesheet" href="/css/board_css/notice.css">
<link rel="stylesheet" href="/css/common_css/layout.css">

<style>
.paging-btn {
	color: black;
}
.selectPage{
	color: purple;
	
}
</style>
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
					
					<c:if test="${not empty sessionScope.member && sessionScope.member.id=='admin' }">
					<a href="/views/board/notice/noticeWriteTest.jsp" class="btn writeBtn">Write</a>
					</c:if>
					
					<ul id="notice">
						<li>Notice</li>
					</ul>
				<div class="table-wrapper">
					<table class="table table-hover list-table">
						<thead>
							<tr>
								<th style="width: 5%;">No.</th>
								<th style="width: 55%;">Subject</th>
								<th style="width: 20%;">Writer</th>
								<th style="width: 10%;">Date</th>
								<th style="width: 10%;">조회수</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${noticeList}" var="n" varStatus="i">
						<tr>
								<td>No.${n.noticeNo }</td>
								<td><a href="/noticeView?noticeNo=${n.noticeNo }" class="content">${n.noticeTitle }</a></td>
								<td><img src="/img/common_img/footerlogo2.png" height="27"></td>
								<td>${n.noticeDate }</td>
								<td>${n.noticeCount }</td>
							</tr>
						</c:forEach>
						<tfoot>
							<!-- 페이징할거에요~~~~~ -->
							<tr>
								<%-- <td colspan="5"><%=pageNavi %></td> --%>
								<td colspan="5">${pageNavi}</td>
							</tr>
						</tfoot>
					</table>
					
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