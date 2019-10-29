<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String prdName=(String)request.getAttribute("prdName");
    	String prdSnImg = (String)request.getAttribute("prdSnImg");
    %>
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
<script type="text/javascript" src="/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script> 
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
					<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 등록!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 등록!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 등록!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 등록!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 등록!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 등록!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 등록!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<div class="qnaContainer">
			
				<ul id="qna">
					<li>Q&A</li>
				</ul>
				<form action="/qPrdInsert" method="post" id="frm">
				<div class="table-wrapper">
					<table class="table qna-view-table">
						<thead>
							<tr>
								<th>Category</th>
								<td>
								<!-- qCategory 값 받아오기 -->
								<select name="qCtgr">
									<option value="사이즈">사이즈</option>
									<option value="컬러">컬러</option>
									<option value="기타">기타</option>
								</select>
								</td>
							</tr>
							<tr>
								<th>subject</th>
								<td><input type="text" name="qTitle" class="inputText" id="title"></td>
							</tr>
							<tr>
								<th>Writer</th>
								<td> <%=m.getId()%>
									<input type="hidden" name="qWriter" value="<%=m.getId()%>">
								</td>
							</tr>
							
						</thead>
						<tbody>
							<tr>
							<td>
								<div class="product-div">
							
							<img src="/upload/photo/<%=prdSnImg %>" width="150"><br>
							<span><%=prdName %></span>
							<input type="hidden" name="prdSnImg" value="<%=prdSnImg %>">
							<input type="hidden" name="prdName" value="<%=prdName %>">
							</div>
							</td>
							<td>
									<textarea id="ir1" name="qContent" cols="90" rows="10"></textarea>
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
													} 
												 // 에디터의 내용에 대한 값 검증은 이곳에서
												 // document.getElementById("ir1").value를 이용해서 처리한다.
												 try {
												     $("#frm").submit();
												     
												 } catch(e) {}
											});											
											

										});
											 </script>
									</td>	
							</tr>
					</table>
				</div>
				<div class="qna-btn">
					<br>
					
					<a href="/views/test_board/qna/qnaListTest.jsp" class="btn btn-default btn-md" >List</a>
					<button type="button" class="btn btn-default btn-md insertBtn" id="insertBtn">등록</button>
				
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