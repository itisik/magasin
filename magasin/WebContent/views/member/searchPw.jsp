<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!public int getRandom() {
		int random = 0;
		random = (int) Math.floor((Math.random() * (99999 - 10000 + 1))) + 10000;
		return random;
	}%>
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
                  <form action="/searchPw" onsubmit="return checkz();" method="post" id="searchPw">
                   <div class="main_h3"><h3>비밀번호 찾기</h3></div>
                      <div class="container">
                        <table class="search-pw-table">
                           <tr>
                              <th>아이디 </th>
                              <td><input type="text" name="id" id="id" class="form-control"></td>
                           </tr>
                           <tr>
                              <th>이름 </th>
                              <td><input type="text" name="name" id="name" class="form-control"></td>
                           </tr>
                           <tr id="viewEmail" style="display:;">
                              <th>이메일 </th>
                              <td> <!-- 회원가입이랑 똑같이 창띄워서  하기 -->
                              		<input type="text" name="email" id="email" class="form-control" placeholder="ex)choiji@naver.com"> 
									<input type="submit" id="email_btn" class="btn-box" onclick="sendEmailWindow()" value="인증번호 발송">
									<span id="emailChkMsg"></span> <!-- 이메일 중복된건지 체크 -->
									<input type="hidden" readonly="readonly" name="code_check" id="code_check" value="<%=getRandom()%>"/>
									<input type="hidden" readonly="readonly" id="chkAfter" name="chkAfter"/><!-- 값1이면 비번찾아주는 창 띄우게 -->
									<div id="chkAfterMsg"></div>
                              </td>
                           </tr>  
                        </table>
                        </div>
                     <br>
                     <div>
                        <div id="search-pw-btn">
                        	<div class="btn_searchPw"><a href="#"><button>확인</button></a></div>
                        	<div class="btn_main"><a href="/index.jsp"><button>메인으로 이동</button></a></div>
                        </div>   
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
   <script type="text/javascript">
    $(document).ready(function(){
         $("#showPhone").click(function(){
            $("#viewPhone").css("display", ""); 
            $("#viewEmail").css("display", "none");
            var p = document.getElementById("phone");
            var e = document.getElementById("email");
            p.type="text";
            e.type="hidden";
         });
         
         $("#showEmail").click(function(){
            $("#viewEmail").css("display", ""); 
            $("#viewPhone").css("display", "none");
            var p = document.getElementById("phone");
            var e = document.getElementById("email");
            p.type="hidden";
            e.type="text";
         });
      });

    function checkz(){
    	if($("#id").val()==""){
			   alert("아이디를 입력해주세요");
			   $("#id").focus();
			   return false;
		   }
    	if($("#name").val()==""){
			   alert("이름을 입력해주세요.");
			   $("#name").focus();
			   return false;
		   }
    	if($("#email").val()==""){
			   alert("이메일을 입력해주세요.");
			   $("#email").focus();
			   return false;
		   }
    	//이메일 인증 했는지 체크
		var chkAfter = document.getElementById("chkAfter");
		//alert(chkAfter.value);
		if(chkAfter.value != '1'){
		alert("이메일 인증번호를 인증해주세요.");
		return false;
		}
    }
	function sendEmailWindow(){
		var email = document.getElementById("email").value;
		var code_check = document.getElementById("code_check").value;
		var closetime = 10;

		//alert(email);
		if(email == ""){
			alert("이메일을 입력해주세요.");
			return;
		}

		//email, code_check(랜덤숫자)값 넘겨줌
		var url = "/sendEmail?email="+email+"&code_check="+code_check+""; //요청 서블릿 url
		var title = "checkNumWindow";
		var status = "left=500px, top=100px, width=300px, height=200px, menubar=no, status=no, scrollbar=yes";
		window.open(url,title,status);
		
		//var popup = window.open("",title,status);
		//checkNumFrm.checkNum.value = code_check;
		//checkNumFrm.target = title;
		//checkNumFrm.action = url;
		//checkNumFrm.method ="post";
		//checkNumFrm.submit();
		//alert(code_check);
		
		//자동으로 닫히는 시간 설정 -되는지 확인하기
		//if(closetime) setTimeout("numChkWindow.close();", closetime*1000);
//		var popup = window.open(url,title,status);
//		checkNumFrm.code_check.value=email;
//		checkNumFrm.target=title;
//		checkNumFrm.action = url;
//		checkNumFrm.method="post";
//		checkNumFrm.submit();
		//빈 창 오픈
		//var popup = window.open(url,title,status); //빈창이랑 checkIdFrm 연결해서 form수행했을 때 창에 뜰 수 있게해서 중복체크하고 넘겨줌     //나중엔 ajax쓰기
		//checkIdFrm.checkId.value = id; //input hidden에 값 설정
		//checkIdFrm.target = title; //popup창과 form태그를 연결
		//action, method설정 후 form태그 submit
		//checkIdFrm.action = url;
		//checkIdFrm.method = "post";
		//checkIdFrm.submit();
	}
	
   </script>
</body>
</html>