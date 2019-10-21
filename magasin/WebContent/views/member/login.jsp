<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="/css/member/login.css"> -->
<style type="text/css">
      body {
        padding: 30px;
        background-color: rgb(246,246,246);
      }
      nav,
      .window__btns {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
      }
     .main {
     	width: 80%;
        display: flex;
        justify-content: center;
      }
      .window__title {
        text-align: center;
        font-size: 24px;
        margin-bottom: 60px;
      }

      .window__title a {
        font-weight: bold;
        text-decoration: none;
        color: #2f2f2f;
      }
      .window__pw {
        margin-top: 25px;
        margin-bottom: 40px;
      }

      .login-window .window__id input,
      .login-window .window__pw input {
        border: 0;
        padding: 5px 10px;
        border-bottom: 1px solid #2f2f2f;
        height: 30px;
        width: 180px;
      }
      .window__btns2 {
        margin-top: 70px;
        display: flex;
        align-items: center;
        flex-direction: column;
      }
      .window__btns2 .window__join {
        margin-top: 30px;
        border-radius: 4px;
      }
      .window__join {
      	width: 350px;
      	margin: 8px 0;
      	padding:14px 16px;
      	display: inline-block;
      	border: 1px solid #ddd;
      	border-radius: 2px;
      	font-size: 13px;
      	line-height: 18px;
      	text-align: center;
      	white-space: nowrap;
      	color: #666;
      	background-color: #fff;
      	text-decoration: none;
      }
      .btn1{
      	text-align: left;
      	font-size: 12px;
      }
      .btn2{
      	text-align: right;
      	font-size: 12px;
      }
      .btn2 a{
      	text-decoration: none;
      }
      .window__join a{
      	text-decoration: none;
      }
      button {
        font-size: 15px;
        height: 100px;
        width: 120px;
        border: 0;
        background-color: #2f2f2f;
        color: white;
        border-radius: 3px;
      }
     
      .window_login_input,
      .window__loginBtn{
      	display: inline-block;
      }
      
      .window__loginBtn{
	    margin: 0 27px;
	    position: absolute;
    	line-height: 76px;
    	border-radius: 3px;
      }
</style>
<title>Insert title here</title>
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
				  		<form action="/login" method="post" id="login-box">
				  			<div class="main">
				  				<div class="login-window">
					        		<div class="window__title">
					          			<a>회원 로그인</a>
					        		</div>
					        		<div class="window_login_input">
					        			<div class="window__id">
					        				<input type="text" name="id" id="id" placeholder="아이디 입력" />
					        			</div>
							        	<div class="window__pw">
							          		<input type="password" name="pw" id="pw" placeholder="비밀번호 입력" />
							        	</div>
							        </div>
							        <div class="window__loginBtn"><button type="submit" style="cursor:pointer">LOGIN</button></div>
							        <div class="window__btns">
							          	<div class="btn1">
							            	보안접속&nbsp;&nbsp;&nbsp;<input type="checkbox" style="cursor:pointer">아이디저장
							          	</div>&nbsp;&nbsp;
							          	<div class="btn2">
							          		<a href="/views/member/searchId.jsp" style="cursor:pointer" class="">아이디 찾기</a> /  
							          	 	<a href="/views/member/searchPw.jsp" style="cursor:pointer" class="">비밀번호 찾기</a>
							          	</div>
							        </div>
							        <div class="window__join">
							          <a href="/views/member/join.jsp" style="cursor:pointer">회원가입하기</a>
							        </div>
							     </div>
							</div>
				    	</form>
				   </div>
				</div>
			</section>
			<br><br>
			<footer>
				<div class="footer">
					<%@include file="/WEB-INF/views/common/footer.jsp"%>
				</div>
			</footer>
		</div>
	</body>
</html>