<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common_css/layout.css">
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<style type="text/css">
	body {
        padding: 60px;
        background-color: rgb(246,246,246);
    }
    .main{
    	text-align: center;
       	width: 80%;
    }
	.main_h3{
		text-align: left;
		font-size: 13px;
		color : #777777;
	}
	.search-pw-table{
		width: 350px;
		height: 160px;
	    border-top: 1.5px solid #d7d7d7;
	    border-bottom: 1.5px solid #d7d7d7;
		text-align: center;
	}
	.search-pw-table tr{
		border-bottom: 1px solid black;
	}
	.search-pw-table tr th{
		background-color: #fafafa;
		width: 150px;
        font-size: 12px;
        color : #777777;
        padding: 14px;
	}
	.search-pw-table tr td{
		text-align: left;
		font-size: 11px;
		line-height: 1.8;
		color: #666666;
		background-color: white;
		padding: 14px;
		vertical-align: middle;
	}
	.search-pw-table tr td input{
		border: 1px solid #d7d7d7;
        color: #333;
        margin: 5px 0 0;
	    border-radius: 5px;
    }
    .search-pw-table tr td span{
    	font-size: 12px;
    }
	#search-pw-btn {
		text-align: left;
	}
    #search-pw-btn button {
            font-size: 13px;
            height: 45px;
            width: 150px;
            border: 0;
            background-color: #444;
            color: white;
            border-radius: 3px;
    }
    .btn_searchPw{
    	display: inline;
    }
    .btn_main{
    	display: inline;
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
					<div class="main">
						 <div class="main_h3"><h3>비밀번호 찾기</h3></div>
						 	<div class="container">
								<table class="search-pw-table">
									<tr>
										<th>비밀번호 찾기 </th>
										<td><input type="radio" name="SearchPw" id="email" value="email" selected><label for="email"><span>이메일</span></label>&nbsp;
											<input type="radio" name="SearchPw" id="phone" value="phone"><label for="phone"><span>휴대폰번호</span></label>
										</td>
									</tr>
									<tr>
										<th>아이디 </th>
										<td><input type="text" name="id" id="id" class="form-control"></td>
									</tr>
									<tr>
										<th>이름 </th>
										<td><input type="text" name="name" id="name" class="form-control"></td>
									</tr>
									<tr id="showEmail">
										<th>이메일로 찾기 </th>
										<td><input type="text" name="email" id="email" class="form-control" onchange="setDisplay()"></td>
									</tr>
									<tr id="showPhone">
										<th>휴대전화로 찾기</th>
										<td><input type="text" name="phone" id="phone" class="form-control" onchange="setDisplay()"></td>
									</tr>  	    
								</table>
				            </div>
							<br>
							<div>
								<div id="search-pw-btn">
									<div class="btn_searchPw"><a href="/member/login.jsp"><button>로그인</button></a></div>
									<div class="btn_main"><a href="/index.html"><button>메인으로 이동</button></a></div>
								</div>	
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