<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
   <form id="form2">
      <table>
         <tr>
            <td><span>인증번호</span></td>
            <td>
               <input type="text" name="code" id="code"
               onkeyup="checkCode()" placeholder="인증번호를 입력하세요."/>
            <div id="checkCode"></div></td>
            <td>
               <input type="hidden" readonly="readonly" name="code_check"
               id="code_check" value="<%=request.getAttribute("code")%>"/>
            </td>
         </tr>
      </table>
      <input id="checkBtn" type="hidden" onclick="closePop()" value='인증하기'/>
   </form>
   <script type="text/javascript">
      function checkCode(){
         var v1 = form2.code_check.value;
         var v2 = form2.code.value;
         var btn = document.getElementById("checkBtn");
         if(v1!=v2){
            document.getElementById('checkCode').style.color="red";
            document.getElementById('checkCode').innerHTML = "잘못된인증번호";
            //makeNull();
            var btn = document.getElementById("checkBtn");
            btn.type="hidden";
         }else{
            document.getElementById('checkCode').style.color="blue";
            document.getElementById('checkCode').innerHTML = "인증되었습니다.";
            //makeReal();
            var btn = document.getElementById("checkBtn");
            btn.type="submit";
         }
      }
      
      
      function closePop(){
    	  var checkAfter = opener.document.getElementById("chkAfter");
    	  var checkAfterMsg = opener.document.getElementById("chkAfterMsg");
    	  checkAfter.value = "1";
    	  //checkAfterMsg.value="인증되었습니다."; //닫는태그가 없는 <input>일 경우 value사용 
    	  checkAfterMsg.innerHTML="인증되었습니다."; //innerHTML은 <span></span>사이에 넣는다는거.
    	  window.self.close();
    	  
         //alert("인증되었습니다.");
         //console.log("인증!!");
         
         //$("#chkAfter",opener.document).val("1");
         //$("#chkAfterMsg",opener.document).html("인증되었습니다.");
         
         //window.opener.document.getElementById("chkAfter").value='Y';
         //window.opener.document.getElementById("chkAfterMsg").html("인증되었습니다.");
         
           //var chkAfter = window.opener.document.getElementById("chkAfter");
           //chkAfter.value='Y';
         //alert(chkAfter);
         //window.opener.document.getElementById("chkAfterMsg").html("인증되었습니다.");
         
         //window.opener.document.form1.chkAfterMsg.value="인증되었습니다.";
      }
      //function successCode(){
         //window.opener.document.getElementById("chkAfter").value = "부모창으로 전달할 값";
         //$("#chkAfterMsg",parent.opener.document).html("인증되었습니다."); //인증하기 누르면 부모창에서 인증되었습니다 출력
         //$("#chkAfter",parent.opener.document).val("1");//히든인풋 값 1 넣어줘서 1이면 가입 되게하고 0이며 안되게하기(유효성)
         
         //opener.document.getElementById("chkAfter").value="1";
         //parent.$("chkAfter").val("Y");
         
         //window.opener.document.getElementById("chkAfter").value='Y';
         //window.opener.document.getElementById("chkAfterMsg").html("인증되었습니다.");
      //}
/*       function makeReal(){
         var hi = document.getElementById("hi");
         hi.type="submit";
         
      }
      function makeNull(){
         var hi = document.getElementById("hi");
         hi.type="hidden";
      } */
      /* function sameCode(){
         opener.document.getElementById("chkAfter").value = document.getElementById("hi").value;
         
         window.close();
      } */
   </script>
</body>
</html>