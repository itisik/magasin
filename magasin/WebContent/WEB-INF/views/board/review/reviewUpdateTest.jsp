<%@page import="kr.magasin.board.model.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% Review r = (Review)request.getAttribute("review"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>***reviewView***</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script> 	
<title>***review***</title>
<link rel="stylesheet" href="/css/board_css/review.css">
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
				
	<div class="reviewContainer">

		<ul id="review">
			<li>review</li>
		</ul>
		<form action="/reviewUpdateEnd" method="post" enctype="multipart/form-data" id="frm">
			<div class="table-wrapper">
		
				<table class="table review-write-table">
					<thead>
						<tr>
							<th>subject</th>
							<td><input type="text" name="reviewTitle" class="inputText" value="<%=r.getReviewTitle()%>">
								<input type="hidden" name="reviewNo" value="<%=r.getReviewNo()%>">
							</td>
						</tr>
						<tr>
							<th>Writer</th>
							<td><%=r.getReviewWriter() %>
							<input type="hidden" value="<%=r.getReviewWriter() %>" name="reviewWriter">
							</td>
							
						</tr>
						<tr>
							<th>별점</th>
							<td>
							<%for(int i=0; i<5;i++){
								int count =r.getReviewPoint();
								
								if(count>0 && i<count){%>			
								<img src="/img/board_img/yellowstar1.png" width="20" onclick="changeStar(this);" class="stars">
							<%count--;
								}else{%>
									
								<img src="/img/board_img/star1.png" width="20" onclick="changeStar(this);" class="stars">
								<%}	%>
								
							<% } %>
								<input type="hidden" name="reviewPoint" id="point" value="<%=r.getReviewPoint()%>">
							</td>
						</tr>
						<script>
							var point = <%=r.getReviewPoint()%>;/* db POINT값 받아오기 */
							function changeStar(obj){
								var index= $(".stars").index(obj);
								if($(".stars").eq(index).attr("src")=="/img/board_img/star1.png"){
									$(".stars").eq(index).attr("src","/img/board_img/yellowstar1.png");	
									point++;
									console.log(point);
								}else if($(".stars").eq(index).attr("src")=="/img/board_img/yellowstar1.png"){
									$(".stars").eq(index).attr("src","/img/board_img/star1.png");
									point--;
									console.log(point);
								}
								
								$("#point").attr("value",point);
							}
						</script>
					</thead>
					<tbody>
						
						<tr>
							<th>
									<div class="pdt-div">

										<img src="/img/product/<%=r.getPrdSnImg() %>" width="150"><br>
										<p id="productName" style="width:100%;text-align:center;"><%=r.getPrdName() %></p>
										<input type="hidden" name="prdName" value="<%=r.getPrdName() %>">
										<input type="hidden" name="prdSnImg" value="<%=r.getPrdSnImg() %>">
								</div>
								
							</th>
							<td>

								<div class="review-content-div" style="width:100%;">
									
									<textarea id="ir1" name="reviewContent" cols="90" rows="10"><%=r.getReviewCont() %></textarea>
			<script type="text/javascript">
			$(document).ready(function(){
			var oEditors = [];
			nhn.husky.EZCreator.createInIFrame({
			 oAppRef: oEditors,
			 elPlaceHolder: "ir1",
			 sSkinURI: "/se2/SmartEditor2Skin.html",
			 fCreator: "createSEditor2"
			});
			

			$("#insertBtn").click(function(){
				 oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
				  if($("#title").val()==""){
						alert("제목을 입력하세요");
						return false;
					}else if($("#ir1").val()=="<p><br></p>"){
						alert("내용을 입력하세요");
						return false;
					} else if(point ==0){
						alert("별점을 입력하세요");
						return false;
					} 
				 // 에디터의 내용에 대한 값 검증은 이곳에서
				 // document.getElementById("ir1").value를 이용해서 처리한다.
				 try {
				     $("#frm").submit();
				     
				 } catch(e) {}
			});											
			

		});
			 </script>
	
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<p style="text-align:left;">Photo Upload <span style="font-size:7px;color:navy;">*두장까지 가능해요*</span></p>
								<input type="hidden" id="status1" name="status1" value="stay">
								<input type="hidden" id="status2" name="status2" value="stay">
								
								<%if(r.getReviewFilename1()!=null||r.getReviewFilename2()!=null){ 
									if(r.getReviewFilename1()!=null){
								%>
									
								<div>
										<img src="/img/review_upload/<%=r.getReviewFilepath1() %>" width="100px;" id="file-img1"> 
										<button type="button" id="fileDelBtn1" class="btn btn-sm">삭제</button>
										<input type="file" name="filename1" id="review-file1" style="display:none;">
								</div>
										<input type="hidden" name="oldFilename1" value="<%=r.getReviewFilename1() %>">
										<input type="hidden" name="oldFilepath1" value="<%=r.getReviewFilepath1() %>">
										<%}else{
											%>
											<input type="file" name="filename1">			
										<%} %>
									<%if(r.getReviewFilename2()!=null){ %>
								<div>
										<img src="/img/review_upload/<%=r.getReviewFilepath2() %>" width="100px;" id="file-img2">
										<input type="file" name="filename2" id="review-file2" style="display:none;">
										<button type="button" id="fileDelBtn2" class="btn btn-sm">삭제</button>
								</div>
								
								<input type="hidden" name="oldFilename2" value="<%=r.getReviewFilename2() %>">
								<input type="hidden" name="oldFilepath2" value="<%=r.getReviewFilepath2() %>">
									<%}else{
										%>
										<input type="file" name="filename2">
									<%} %>
								<%}else{ %>
								<input type="file" name="filename1">
								<input type="file" name="filename2">
								<%} %>
							</td>
						</tr>
						</tbody>
				</table>
			</div>
			<script type="text/javascript">
				$(document).ready(function(){
					$("#fileDelBtn1").click(function(){
						if(confirm("파일을 삭제하시겠습니까?")){
							$("#fileDelBtn1").hide();
							$("#file-img1").hide();
							$("#review-file1").show(100);
							$("#status1").val("delete");
						}
					});
					$("#fileDelBtn2").click(function(){
						if(confirm("파일을 삭제하시겠습니까?")){
							$("#fileDelBtn2").hide();
							$("#file-img2").hide();
							$("#review-file2").show(100);
							$("#status2").val("delete");
						}
					});
				});
			</script>
			<div class="review-btn">
				<br>

					<a href="/reviewList"
						class="btn btn-default btn-md">List</a>
					<button type="button"
						class="btn btn-default btn-md insertBtn" id="insertBtn">수정완료</button>


			
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