<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<span style="color: green; font-weight: bold;">입력한 이메일로 받은 인증번호를 입력하세요. (인증번호가 맞아야 다음 단계로 넘어가실 수 있습니다.)</span><br><br>
		<div style="text-align:center;">
			<table border="1" width="300" height="300" align= "center">
	            <tr>        
	                <td>
	                    <form action="join_injeung.do${dice}" method="post" name="email_injeungForm" onSubmit="return check()"> <!-- 받아온 인증코드를 컨트롤러로 넘겨서 일치하는지 확인-->
	                        	인증번호 입력 : <input type="text" name="email_injeungNum" placeholder="인증번호를 입력하세요.">
	                        <button type="submit" name="submit">확인</button>
	                     </form>
	                 </td>
	             </tr>
			</table>
		</div>
	</center>
	<script>
		function check(){
			
		}
	
	</script>
</body>
</html>