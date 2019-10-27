<%@page import="kr.magasin.board.model.vo.QEtc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% QEtc q = (QEtc)request.getAttribute("qEtc"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>***Quewstion View***</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/common_css/layout.css">
<link rel="stylesheet" href="/css/board_css/qna.css">
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
					<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 View!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->

	<section>
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
								<!-- qCategory 값 받아오기 -->
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
								<td><%=q.getqDate()%></td>
							</tr>
						</thead>
						<tbody>
							<tr>
							<td colspan="2">
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
					<%if(m!=null){ %>
					<!-- 관리자일때 -->

					<%if(m.getId().equals("admin")&&q.getqIsA()==0){ %>
					<a href="/aWrite?ctgr=etc&qNo=<%=q.getqNo()%>" class="btn btn-default btn-md" >답변</a>

					<%}else if(m.getId().equals(q.getqWriter())){ %>
					<!-- 글쓴이 일때 -->
					<a href="/qDelete?ctgr=etc&qNo=<%=q.getqNo()%>" class="btn btn-default btn-md" >삭제</a>
					<a href="/qUpdate?ctgr=etc&qNo=<%=q.getqNo()%>" class="btn btn-default btn-md" >수정</a>
					
					<%}

					}else{
					%>
					<script>
						location.href="/views/member/login.jsp";
					</script>
					<%}%>

				</div>
			</div>
	</section>
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