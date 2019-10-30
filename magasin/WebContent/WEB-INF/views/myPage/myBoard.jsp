<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board_css/review.css">
<link rel="stylesheet" href="/css/board_css/qna.css">
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
<style>
	.review-ud>a{
		color:black;
	}
	.review-ud>a:hover{
		color:purple;
	}
</style>
<style>
.paging-btn {
	color: black;
}
.selectPage{
	color: purple;
	
}
.a-title{
	color:navy;
}
.a-title:hover{
	font-weight:bold;
	text-decoration:none;
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
								<div class="reviewContainer">
				
				<ul id="review">
					<li>MY BOARD</li>
				</ul>
				<div class="table-wrapper">
				<c:if test="${not empty rBoard || sessionScope.member.id == rBoard.reviewWriter}">
					<h3 style="border-bottom: 1px solid black;">MY Review</h3>
					
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
							<c:forEach items="${rBoard}" var="r" varStatus="i">
							<tr>
								<td style="width: 8%;">No.${r.reviewNo }</td>
								<td style="width: 10%;">
								<img src="/upload/photo/${r.prdSnImg}" width="100">
								${r.prdName }
								</td>
								<td style="width: 42%;"><span>${r.reviewTitle}</span> &nbsp;&nbsp;
								<span class="lookReview" onclick="lookContent(this);">내용보기</span><br>
							
								<!-- contents 보이기 -->
							
								<div class="review-contents" style="width:100%;">	
								<hr>	
									<div class="review-con">
									<p style="text-align:center;">${r.reviewCont}
									
									</p>
									</div>
									
									<c:if test="${not empty r.reviewFilepath1 || not empty r.reviewFilepath2}">
									
									
									<div class="review-img-container" style="width:80%;margin-left:45px;">
									<!-- 리뷰작성때 업로드한 이미지 있으면, 없으면 안생김 또는 사진 없음 X표시 -->
										
										<c:if test="${not empty r.reviewFilepath1 }">
										<div class="review-img-div">
										<img src="/img/review_upload/${r.reviewFilepath1}" width="100px;"> 
										</div>
										</c:if>
										<c:if test="${not empty r.reviewFilepath2 }">
										<div class="review-img-div">
										<img src="/img/review_upload/${r.reviewFilepath2 }" width="100px;">
										</div>
										</c:if>
										
									</div>
									</c:if>
									
									<style>
										.review-ud>a{
											color:black;
										}
										.review-ud>a:hover{
											color:purple;
										}
									</style>
									
									<div class="review-ud" style="width:100%; text-align:right; clear:both;">
									<a href="/reviewUpdate?reviewNo=${r.reviewNo}" class="btn btn-sm">수정</a>
									<a href="/reviewDelete?reviewNo=${r.reviewNo}&reviewFilepath1=${r.reviewFilepath1}&reviewFilepath2=${r.reviewFilepath2}" class="btn btn-sm">삭제</a>
									</div>
									
								</div>
								</td>
								<td style="width: 15%;">

								<c:forEach var="i" begin="0" end="${r.reviewPoint}">
									<img src="/img/board_img/yellowstar1.png" width="12">
								</c:forEach>
								
								
								</td>
								<td style="width: 10%;">${r.reviewWriter }</td>
								<td style="width: 5%;">${r.reviewDate }</td>
								
							</tr>
							
						</c:forEach>		
						
					</table>
							</c:if>
					
					
					<hr>
					<br>
					<!-- Q&A  Etc table -->
					<c:if test="${not empty qEtc || sessionScope.member.id == qEtc.qWriter}">
					
					<h3 style="border-bottom:1px solid black;">일반 문의</h3>
					<table class="table table-hover qnalist-table">
						<thead>
							<tr>
								<th style="width: 10%;">Category</th>
								<th style="width: 60%;">Subject</th>
								<th style="width: 20%;">Writer</th>
								<th style="width: 10%;">Date</th>
							</tr>
						</thead>
						 <tbody>
							
							<c:forEach items="${qEtc }" var="q" varStatus="i">
							<tr>
								<td>${q.qCtgr }</td>
								<td><a href="/qEtcView?qNo=${q.qNo }&id=${sessionScope.member.id}" class="content">${q.qTitle}</a></td>
								<td>${q.qWriter }</td>
								<td>${q.qDate }</td>
							</tr>
							<!-- 답변 있으면 밑에 달리게-->
							
							<c:forEach items="${aEtc }" var="a" varStatus="i">
								<c:if test="${q.qNo == a.aQEtcNoRef }">
							<tr>
							<td></td>
							<c:if test="${not empty sessionScope.member }">
								<td>
								<img src="/img/board_img/realRe.png">
										<a href="/aView?ctgr=etc&aNo=${a.aNo }&id=${sessionScope.member.id}" class="a-title">${a.aTitle }</a>
								</td>
							</c:if>
								<td>
									<img src="/img/common_img/footerlogo2.png" height="27">
								</td>
								<td>${a.aDate }</td>
							</tr>
							
							</c:if>
							</c:forEach>
							</c:forEach>
						</tbody>					
					</table>
					</c:if>
							
					
					<!-- Q&A Prd Table -->
					<h3 style="border-bottom:1px solid black;">상품 문의</h3>
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
						 
						 
							<c:forEach items="${qPrd }" var="q" varStatus="i">
								<c:if test="${not empty q.prdName && not empty q.prdSnImg }">
								
								<tr>
								<td>${q.qCtgr }</td>
								<td>
								<img src="/upload/photo/${q.prdSnImg }" width="70">
								<br>
								${q.prdName }
								</td>
								<td><a href="/qPrdView?qNo=${q.qNo }&id=${sessionScope.member.id}" class="content">${q.qTitle }</a></td>
								
								<td>${q.qWriter }</td>
								<td>${q.qDate }</td>
							</tr>
							<c:forEach items="${aPrd }" var="a" varStatus="i">
								<c:if test="${q.qNo == a.aQPrdNoRef }">
								
									<tr>
									<td colspan="2"></td>
									

									
									<!-- 제목 -->
									
									
									<td>
									<img src="/img/board_img/realRe.png">
									<a href="/aView?ctgr=prd&aNo=${a.aNo }&id=${sessionScope.member.id}" class="a-title">${a.aTitle }</a>
									</td>
									
									
									
									<td>
									<img src="/img/common_img/footerlogo2.png" height="27">
									</td>
									<td>${a.aDate }</td>
								</tr>
							
								</c:if>
							</c:forEach>
								</c:if>
							</c:forEach>
						
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