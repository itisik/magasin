<%@page import="kr.magasin.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//joinServlet에서 키값 member를 받아옴
    	Member m = (Member)request.getAttribute("member");
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	        body {
            padding: 60px;
        }
        .main{
            text-align: center;
        }
        .main_h2{
            padding: 0 0 10px;
        }
        .container{
            text-align: center;
        }
        .table_join_success{
            text-align: center;
            border: 1px solid black;
            width: 400px;
            height: 200px;
            margin: auto;
        }
        .table_join_success>tr>th,td{
            text-align: left;
        }
        button {
        font-size: 15px;
        height: 60px;
        width: 250px;
        border: 0;
        background-color: #2f2f2f;
        color: white;
        }
        .btn_login{
            display: inline;
        }
        .btn_main{
            display: inline;
        }
</style>
</head>
<body>
	<div class="main">
		 <div class="main_h2"><h2>회원 가입 완료</h2></div>
		 	<div class="container">
				<h3>회원가입이 완료 되었습니다.</h3>
				<table class="table_join_success">
					<tr>
						<th>아이디 : </th>
						<td><%=m.getId() %></td>
					</tr>
					<tr>
						<th>이름 : </th>
						<td><%=m.getName()%></td>
					</tr>
					<tr>
						<th>휴대폰번호: </th>
						<td><%=m.getPhone() %></td>
					</tr>
					<tr>
						<th>이메일 : </th>
						<td><%=m.getEmail() %></td>
					</tr>
				</table>
			</div>
			<br><br>
			<div>
			<%=m.getName() %> 님은 [<%=m.getGrade() %>] 회원이십니다.
	
				<div id="btn_join_success">
					<div class="btn_login"><a href="/member/login.jsp"><button>로그인</button></a></div>
					<div class="btn_main"><a href="/index.html"><button>메인으로 이동</button></a></div>
				</div>	
			</div>
	</div>
</body>
</html>