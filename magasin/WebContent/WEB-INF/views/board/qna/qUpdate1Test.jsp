<%@page import="kr.magasin.board.model.vo.QEtc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% QEtc q = (QEtc)request.getAttribute("q"); %>
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
<link rel="stylesheet" href="/css/board_css/qna.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
</head>
<body id="body1">
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 일반 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->

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
				<form action="/qUpdateEnd" method="post">
				<div class="table-wrapper">
					<table class="table qna-view-table">
						<thead>
							<tr>
								<th>Category</th>
								<td>
								<input type="hidden" name="qNo" value="<%=q.getqNo()%>">
								<input type="hidden" name="ctgr" value="etc">
								<!-- qCategory 값 받아오기 -->
								<script>
								$(document).ready(function(){
									for(var i=0; i<$(".sel").length;i++){
										if($(".sel").eq(i).attr("value")=='<%=q.getqCtgr()%>'){
											$(".sel").eq(i).attr("selected",'selected');
										}
									}
								});
								</script>
								<select name="qCtgr">
									<option value="배송" class="sel">배송</option>
									<option value="주문" class="sel">주문</option>
	 								<option value="결제" class="sel">결제</option>
									<option value="환불" class="sel">환불</option>
									<option value="기타" class="sel">기타</option>
								</select>
								</td>
							</tr>
							<tr>
								<th>subject</th>
								<td><input type="text" name="qTitle" class="inputText" value="<%=q.getqTitle()%>"></td>
							</tr>
							<tr>
								<th>Writer</th>
								<td> <%=q.getqWriter() %>
									<input type="hidden" name="qWriter" value="<%=q.getqWriter()%>">
								</td>
							</tr>
							
						</thead>
						<tbody>
							<tr>
							<td colspan="2">
								<div>
								<textarea name="qContent" cols="100" rows="10"><%=q.getqCont() %></textarea>
								</div>
								
								</td>
							</tr>
					</table>
				</div>
				<div class="qna-btn">
					<br>
					
					<a href="/qnaList" class="btn btn-default btn-md" >List</a>
					<button type="submit" class="btn btn-default btn-md" >수정</button>
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