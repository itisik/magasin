<%@page import="kr.magasin.board.model.vo.QPrd"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% QPrd q = (QPrd)request.getAttribute("q"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>***Quewstion	***</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script> 
<link rel="stylesheet" href="/css/board_css/qna.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
</head>
<body id="body1">
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 상품 문의 수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	
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
				<form action="/qUpdateEnd" method="post" id="frm">
				<div class="table-wrapper">
					<table class="table qna-view-table">
						<thead>
							<tr>
								<th>Category</th>
								<td>
								<!-- qCategory 값 받아오기 -->
								<script>
								$(document).ready(function(){
									for(var i=0; i<$(".sel").length; i++){
										if($(".sel").eq(i).attr("value")=='<%=q.getqCtgr()%>'){
											$(".sel").eq(i).attr("selected","selected");
										}
									}
								});
								</script>
								<input type="hidden" name="qNo" value="<%=q.getqNo()%>">
								<input type="hidden" name="ctgr" value="prd">
								<select name="qCtgr">
									<option value="사이즈" class="sel">사이즈</option>
									<option value="컬러" class="sel">컬러</option>
									<option value="기타" class="sel">기타</option>
								</select>
								</td>
							</tr>
							<tr>
								<th>subject</th>
								<td><input type="text" name="qTitle" class="inputText" value="<%=q.getqTitle()%>" id="title"></td>
							</tr>
							<tr>
								<th>Writer</th>
								<td><%=q.getqWriter() %>
									<input type="hidden" name="qWriter" value="<%=q.getqWriter()%>">
								</td>
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
							
								<textarea id="ir1" name="qContent" cols="90" rows="10"><%=q.getqCont() %></textarea>
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

								</div>
								
								</td>
							</tr>
					</table>
				</div>
				<div class="qna-btn">
					<br>
					<a href="/qnaList" class="btn btn-default btn-md" >List</a>
					<button type="button" class="btn btn-default btn-md insertBtn"  id="insertBtn">수정</button>
				
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