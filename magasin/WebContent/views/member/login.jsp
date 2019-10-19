<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<!-- <link rel="stylesheet" href="/css/member/login.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        display: flex;
        justify-content: center;
        margin-top: 65px;
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
      	width: 300px;
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
</head>
  <body>
  <!-- 팀원이 각자 생성, 수정, 삭제하고 그 내용을 팀장에게 병합 요청하는 것을 보여주기 위해서 -->
  <!-- 이곳에 이런 주석을 달아보겠습니다. 비록 주석이라고 하더라도 git은 코드의 변화로 감지해줍니다. 훌륭하죠? -->
  	<section>
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
			          		<input type="text" name="pw" id="pw" placeholder="비밀번호 입력" />
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
    </section>
  </body>
</html>