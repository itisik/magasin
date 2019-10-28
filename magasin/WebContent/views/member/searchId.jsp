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
    }
   .main_h3{
      text-align: left;
      font-size: 13px;
      color : #777777;
   }
   .search-id-table{
      width: 350px;
      height: 160px;
       border-top: 1.5px solid #d7d7d7;
       border-bottom: 1.5px solid #d7d7d7;
      text-align: center;
   }
   .search-id-table tr{
      border-bottom: 1px solid black;
   }
   .search-id-table tr th{
      background-color: #fafafa;
      width: 150px;
        font-size: 12px;
        color : #777777;
        padding: 14px;
   }
   .search-id-table tr td{
      text-align: left;
      font-size: 11px;
      line-height: 1.8;
      color: #666666;
      background-color: white;
      padding: 14px;
      vertical-align: middle;
   }
   .search-id-table tr td input{
      border: 1px solid #d7d7d7;
        color: #333;
        margin: 5px 0 0;
       border-radius: 5px;
    }
    .search-id-table tr td span{
       font-size: 12px;
    }
   #search-id-btn{
      text-align: left;
   }
    #search-id-btn button {
            font-size: 13px;
            height: 45px;
            width: 150px;
            border: 0;
            background-color: #444;
            color: white;
            border-radius: 3px;
    }
    .btn_searchId{
       display: inline;
    }
    .btn_main{
       display: inline;
    }

</style>
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
               <div class="main">
                  <form action="/searchId" onsubmit="return checkz();" method="post" id="searchId">
                   <div class="main_h3"><h3>아이디 찾기</h3></div>
                      <div class="container">
                        <table class="search-id-table">
                           <tr>
                              <th>아이디 찾기</th>
                              <td>
                                 <input type="radio" name="SearchId" id="showEmail" onclick="showEmail()" checked><label for="email"><span>이메일</span></label>&nbsp;
                                 <input type="radio" name="SearchId" id="showPhone" onclick="showPhone()"><label for="phone"><span>휴대폰번호</span></label>
                              </td>
                           </tr>
                           <tr>
                              <th>이름 </th>
                              <td><input type="text" name="name" id="name" class="form-control"></td>
                           </tr>
                           <tr id="viewEmail" style="display:;">
                              <th>이메일로 찾기 </th>
                              <td><input type="text" name="email" id="email" class="form-control"></td><!-- onchange="setDisplay()" -->
                           </tr>
                           <tr id="viewPhone" style="display:none;">
                              <th>휴대전화로 찾기 </th>
                              <td><input type="hidden" name="phone" id="phone" class="form-control"></td><!--onchange="setDisplay()"  -->
                           </tr>
                        </table>
                        </div>
                     <br>
                     <div>
                        <div id="search-id-btn">
                           <!-- 확인누르면 아이디보여주는 페이지. -->
                           <div class="btn_searchId"><a href="#"><button>확인</button></a></div>
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
   <script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
//   $('#id').attr('style', "display:'';");  //나타내기
//   $('#id').attr('style', "display:none;");  //숨기기   
   
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
    	if($("#name").val()==""){
			   alert("이름을 입력해주세요.");
			   $("#name").focus();
			   return false;
		   }
    	if($("#phone").val()==""){
			   alert("전화번호를 입력해주세요.");
			   $("#phone").focus();
			   return false;
		   }
    	if($("#email").val()==""){
			   alert("이메일을 확인해주세요.");
			   $("#email").focus();
			   return false;
		   }
    }

      /* 
      $("#viewPhone").click(function(){
         $('#viewPhone').attr('style',"display:'';");
         $('#viewEmail').attr('style',"display:none;");
      });

      $("#viewEmail").click(function(){
         $('#viewEmail').attr('style',"display:'';");
         $('#viewPhone').attr('style',"display:none;");
      });
    */
   
   /* $(document).ready(function(){
      $("#viewEmail").click(function(){
         status = $("#viewPhone").css("display"); 
         if (status == "none") {
            $("#viewPhone").css("display", ""); 
         } else { 
            $("#viewPhone").css("display", "none"); 
         }
      });
   });  */
   
/*       $(document).ready(function(){ 
          // 라디오버튼 클릭시 이벤트 발생
          $("input:radio[name=radio]").click(function(){
       
              if($("input[name=radio]:checked").val() == "1"){
                  $("input:text[name=text]").attr("disabled",false);
                  // radio 버튼의 value 값이 1이라면 활성화
       
              }else if($("input[name=radio]:checked").val() == "0"){
                    $("input:text[name=text]").attr("disabled",true);
                  // radio 버튼의 value 값이 0이라면 비활성화
              }
          });
      }); */
      
/*       function setDisplay(){
         if($('input:radio[id=email]').is(':checked')){
            $('#showEmail').show();
            $('#showPhone').hide();
         }else{
            $('#showEmail').hide();
            $('#showPhone').show();
         }
      } */
/*       
      //input에 적용할때
      function showEmail(){
         var p = document.getElementById("phone");
         var e = document.getElementById("email");
         p.type="hidden";
         e.type="text";
      }
      function showPhone(){
         var p = document.getElementById("phone");
         var e = document.getElementById("email");
         p.type="text";
         e.type="hidden";
      }
    */
   </script>

   
   

</body>
</html>