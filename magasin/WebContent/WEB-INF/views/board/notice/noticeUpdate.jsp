<%@page import="kr.magasin.board.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%-- <% Notice n = (Notice)request.getAttribute("notice"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAGASIN > Notice</title>
 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
 <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
<script type="text/javascript" src="/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script> 
<link rel="stylesheet" href="/css/board_css/notice.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
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
			
				<ul id="notice">
					<li>Notice</li>
				</ul>
				<form action="/noticeUpdateEnd" method="post" id="frm">
				
				<div class="table-wrapper">
					<table class="table view-table">
						<thead>
							<tr>
								<th>subject</th>
								<!-- 원래 Title 받아올거에요~ -->
								<td><input type="text" name="noticeTitle" class="inputText" value="${notice.noticeTitle }" id="title">
								</td>
							</tr>
							<tr>
								<th>Writer</th>
								<td><img src="/img/common_img/footerlogo2.png" height="27">
								<!-- 관리자 넘겨줄거에요~ -->
								<input type="hidden" name="noticeWriter" class="inputText"
								value="admin">
								<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
								</td>
							</tr>
							
						</thead>
						<tbody>
							<tr>
								<td colspan="2" style="padding-left:100px;">
								
									<textarea id="ir1" name="noticeContent" cols="100" rows="10">${notice.noticeCont }</textarea>
									
								</td>
							</tr>
					</table>
				</div>
				
				<div class="notice-btn">
				<br>
					<a href="/noticeList" class="btn btn-md" >List</a>
					<button type="button" class="btn btn-md btn-default insertBtn" id="insertBtn">수정</button>
				</div>
				<style>
					#insertBtn{
						background:white;
					}
				</style>
				
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