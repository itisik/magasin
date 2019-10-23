<%@page import="kr.magasin.board.model.vo.APrd"%>
<%@page import="kr.magasin.board.model.vo.QPrd"%>
<%@page import="kr.magasin.board.model.vo.AEtc"%>
<%@page import="kr.magasin.board.model.vo.QEtc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ArrayList<QEtc> qEtcList =(ArrayList<QEtc>)request.getAttribute("qEtcList");
    	ArrayList<AEtc> aEtcList = (ArrayList<AEtc>)request.getAttribute("aEtcList");
    	ArrayList<QPrd> qPrdList =(ArrayList<QPrd>)request.getAttribute("qPrdList");
    	ArrayList<APrd> aPrdList = (ArrayList<APrd>)request.getAttribute("aPrdList");
    	String pageNavi = (String)request.getAttribute("pageNavi");
    	
    %>
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
<link rel="stylesheet" href="/css/board_css/qna.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
<title>***Q&A***</title>
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
				
				
				<div class="q-category-container">
					 <ul class="q-category">
						<li>일반 문의</li>
						<li>상품 관련 문의</li>
					</ul> 
				</div>
				<%if(m!=null){ %>
				<p id="writeQ"><a href="/views/board/qna/qWrite1Test.jsp" class="btn writeBtn">Write</a></p>
				<%} %>
				
				<div class="qnaListContainer">
				<ul id="qna">
					<li>Q&A</li>
				</ul>
				<div class="table-wrapper normalQue">
				
					<table class="table table-hover qnalist-table">
						<thead>
							<tr>
								<th style="width: 10%;">Category</th>
								<th style="width: 55%;">Subject</th>
								<th style="width: 20%;">Writer</th>
								<th style="width: 10%;">Date</th>
							</tr>
						</thead>
						 <tbody>
							<%
								for (QEtc q : qEtcList) {
							%>
							<tr>
								<td><%=q.getqCtgr() %></td>
								<td><a href="/qEtcView?qNo=<%=q.getqNo() %>&id=<%=m.getId() %>" class="content"><%=q.getqTitle() %></a></td>
								<td><%=q.getqWriter()%></td>
								<td><%=q.getqDate() %></td>
							</tr>
							<!-- 답변 있으면 밑에 달리게-->
							<%
								for(AEtc a : aEtcList){
								if(q.getqNo()==a.getaQEtcNoRef()){
							%>
								<tr>
									<td></td>
									<td>
									<!-- 제목 -->
									<img src="/img/board_img/realRe.png">
									<a href="/aView?aQNoRef=<%=q.getqNo()%>"><%=q.getqWriter() %>님 <%=a.getaTitle() %></a>
									</td>
									<td>
									<img src="/img/common_img/footerlogo2.png" height="27">
								<input type="hidden" name="noticeWriter" class="inputText"
								value="admin">
									</td>
									<td><%=a.getaDate() %></td>
								</tr>
							
									<%}
								}%>
							<%}
							%>
							
						<tfoot>
							<tr>
								<td colspan="5"><%=pageNavi %></td>
							</tr>
						</tfoot>
					</table>
				</div>
				<!-- 제품 문의... -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				
				<script>
					$(document).ready(function(){
						$(".normalQue").show();
						$(".productQue").hide();
						
						$(".q-category>li").eq(0).click(function(){
							$(".productQue").hide();
							$(".writeBtn").show();
							
							$(".normalQue").show();
						
						});
						$(".q-category>li").eq(1).click(function(){
							$(".normalQue").hide();
							$(".writeBtn").hide();
							
							$(".productQue").show();
						});
					});
				</script>
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				<!-- *************************************** -->
				
				<div class="table-wrapper productQue">
					<table class="table table-hover qnalist-table">
						<thead>
							<tr>
								<th style="width: 10%;">Category</th>
								<th style="width:20%;">Product</th>
								<th style="width: 45%;">Subject</th>
								<th style="width: 15%;">Writer</th>
								<th style="width: 10%;">Date</th>
							</tr>
						</thead>
						 <tbody>
						 
						 <!-- 더보기 기능 추가할게용 -->
							<%
							for (QPrd q : qPrdList) {
								if(q.getPrdName()!=null&& q.getPrdSnImg()!=null){
							%>
							<tr>
								<td><%=q.getqCtgr() %></td>
								<td>
								<img src="/img/product/<%=q.getPrdSnImg() %>" width="70">
								<br>
								<%=q.getPrdName() %>
								</td>
								<td><a href="/qPrdView?qNo=<%=q.getqNo() %>&id=<%=m.getId() %>" class="content"><%=q.getqTitle() %></a></td>
								<td><%=q.getqWriter() %></td>
								<td><%=q.getqDate() %></td>
							</tr>
							<!-- 답변 있으면 밑에 뜨게 해주쇼 -->
							<% for(APrd a : aPrdList){
								if(q.getqNo()==a.getaQPrdNoRef()){
							%>
								<tr>
									<td colspan="2"></td>
									
									<td>
									<!-- 제목 -->
									<img src="/img/board_img/realRe.png">
									<a href="/aView?aNo=<%=a.getaNo()%>"><%=q.getqWriter() %>님 <%=a.getaTitle() %></a>
									</td>
									<td>
									<img src="/img/common_img/footerlogo2.png" height="27">
								<input type="hidden" name="noticeWriter" class="inputText"
								value="admin">
									</td>
									<td><%=a.getaDate() %></td>
								</tr>
								
							<%			}
									}
								}
								
							}
							%>
							
					</table>
					<!-- 임시로 -->
					<!-- 임시로 --><!-- 임시로 --><!-- 임시로 -->
					<!-- 임시로 --><!-- 임시로 --><!-- 임시로 --><!-- 임시로 -->
					<%if(m!=null){ %>
								
								<p id="writeQ"><a href="/qWrite" class="btn" id="write">Write</a></p>
								
								<%} %>
				</div>
				
				
				
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