<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- ckEditor links -->
<script src="//cdn.ckeditor.com/4.13.0/standard/ckeditor.js"></script>
<link rel="stylesheet" href="/css/board_css/notice.css">
<link rel="stylesheet" href="/css/common_css/layout.css">
<!-- BootStrab links -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
</head>
<body id="body1">
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
				<form action="/noticeInsert" method="post">
				
				<div class="table-wrapper">
					<table class="table write-table">
						<thead>
							<tr>
								<th>subject</th>
								<td><input type="text" name="noticeTitle" class="inputText"></td>
							</tr>
							<tr>
								<th>Writer</th>
								<td><img src="/img/common_img/footerlogo2.png" height="27">
								<input type="hidden" name="noticeWriter" class="inputText"
								value="admin">
								</td>
							</tr>
							
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<textarea id="editor" name="noticeContent" cols="100" rows="10" style="text-align:center;"></textarea>
								</td>
							</tr>
					</table>
				</div>
				<div class="notice-btn">
					<br>
					
					<a href="/noticeList" class="btn btn-md" >List</a>
					<button type="submit" class="btn btn-md" id="insertBtn" >등록</button>
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
</body>
</html>