<%@page import="kr.magasin.board.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("reviewList");
    	String pageNavi = (String)request.getAttribute("pageNavi");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>***review***</title>
<link rel="stylesheet" href="/css/board_css/review.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
<style>

.review-contents{
	padding-left: 20px;
}
.review-img-container {
	border: 1px dashed black;
	width: 100%;
	padding: 10px;
	margin-left: 10px;
}

.review-img-div {
	width: 100px;
	float: left;
	margin-right: 10px;
	margin-left: 15px;
	border: 1px solid white;
}
.paging-btn {
	color: black;
}
.selectPage{
	color: purple;
	
}
</style>
<script>
									
	function lookContent(obj){
		console.log(obj);
		var index = $(".lookReview").index(obj);
		if($(".lookReview").eq(index).text()=="접기"){
			$(".review-contents").eq(index).hide(500);
			$(".lookReview").eq(index).text("내용보기");
		}else if($(".lookReview").eq(index).text()=="내용보기"){
			$(".review-contents").eq(index).show(500);	
			$(".lookReview").eq(index).text("접기");	
		}
		
	}	
		
												
</script>
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
								<div class="reviewContainer">
				<!-- test용 버튼입니당~~~~~ -->
				<!-- test용 버튼입니당~~~~~ -->
				<!-- test용 버튼입니당~~~~~ -->
				<!-- test용 버튼입니당~~~~~ -->
				<!-- test용 버튼입니당~~~~~ -->
				<!-- test용 버튼입니당~~~~~ -->
				<a href="/reviewWrite" class="btn writeBtn">Write</a>
				<ul id="review">
					<li>review</li>
				</ul>
				<div class="table-wrapper">
					<table class="table table-hover review-table">
						<thead>
							<tr>
								<th style="width: 5%;">No.</th>
								<th style="width: 10%;">Product</th>
								<th style="width: 45%;">Subject</th>
								<th style="width: 15%;">
								<img src="/img/board_img/yellowstar1.png" width="12">
								</th>
								<th style="width: 10%;">Writer</th>
								<th style="width: 5%;">Date</th>
								
							</tr>
						</thead>
						<tbody>
					
							<%
								for (Review r : list) {
							%>
							
							<tr>
								<td style="width: 8%;">No.<%=r.getReviewNo() %></td>
								<td style="width: 10%;">
								<img src="/img/product/<%=r.getPrdSnImg() %>" width="100">
								<%=r.getPrdName() %>
								</td>
								<td style="width: 42%;"><span><%=r.getReviewTitle() %></span> &nbsp;&nbsp;
								<span class="lookReview" onclick="lookContent(this);">내용보기</span><br>
							
								<!-- contents 보이기 -->
							
								<div class="review-contents" style="width:100%;">	
								<hr>	
									<div class="review-con">
									<p style="text-align:center;"><%=r.getReviewCont() %>
									
									</p>
									</div>
									<%if(r.getReviewFilepath1()!=null||r.getReviewFilepath2()!=null){ %>
									<div class="review-img-container" style="width:80%;margin-left:45px;">
									<!-- 리뷰작성때 업로드한 이미지 있으면, 없으면 안생김 또는 사진 없음 X표시 -->
										<%if(r.getReviewFilepath1()!=null){ %>
										<div class="review-img-div">
										<img src="/img/review_upload/<%=r.getReviewFilepath1() %>" width="100px;"> 
										</div>
										<%} %>
										<%if(r.getReviewFilepath2()!=null){ %>
										<div class="review-img-div">
										<img src="/img/review_upload/<%=r.getReviewFilepath2() %>" width="100px;">
										</div>
										<%} %>
									</div>
									<%} %>
									<style>
										.review-ud>a{
											color:black;
										}
										.review-ud>a:hover{
											color:purple;
										}
									</style>
									<%if(m!=null&&(m.getId().equals(r.getReviewWriter()))){
										%>
									<div class="review-ud" style="width:100%; text-align:right; clear:both;">
									<a href="/reviewUpdate?reviewNo=<%=r.getReviewNo()%>" class="btn btn-sm">수정</a>
									<a href="/reviewDelete?reviewNo=<%=r.getReviewNo()%>&reviewFilepath1=<%=r.getReviewFilepath1() %>&reviewFilepath2=<%=r.getReviewFilepath2() %>" class="btn btn-sm">삭제</a>
									</div>
									<%} %>
								</div>
								</td>
								<td style="width: 15%;">
								<%for(int i=0; i<r.getReviewPoint() ; i++){ %>
								<img src="/img/board_img/yellowstar1.png" width="12">
								<%} %>
								</td>
								<td style="width: 10%;"><%=r.getReviewWriter() %></td>
								<td style="width: 5%;"><%=r.getReviewDate() %></td>
								
							</tr>
								
							<%
								}
							%>
								
						<tfoot>
							<tr>
								<td colspan="7">
									<%=pageNavi %>
								</td>
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