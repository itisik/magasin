<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="kr.magasin.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
	 Member member = (Member)request.getAttribute("member");
 	 String[] addrList = (String[])request.getAttribute("addrList");
 	 String[] emailList = (String[])request.getAttribute("emailList");
 	 String[] phoneArr = (String[])request.getAttribute("phoneArr");
 %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="/css/myPage/myInfoUpdate.css"> 
<script type="text/javascript" src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

<form action="/updateMember" method="post" >
	<div class="miu-wrapper">
	<div class="miu-div-1">
	<%if(member != null){ %>
	<h3>저의 쇼핑몰을 이용해주셔서 감사합니다. <span><%=member.getName() %></span>님은 <span><%=member.getGrade() %></span> 회원이십니다.</h3>
	<%} %>
	</div> 
		<div class="miu-div-2">
	
	<h3 class="miu-div-2-h3">기본정보</h3>
	
	
	
	<table class="miu-div-2-table">
		<tbody>
			<tr>
				<th>아이디  </th><td><input type="text" name="id" class="form-control" value="<%=member.getId() %>" readonly> (영문소문자/숫자,4~16자)</td>
			</tr>
			<tr>
				<th>비밀번호  </th><td><input type="password" name="pw" value="<%= member.getPw()%>"> (영문 대소문자/숫자/특수문자 중 2가지이상 조합 8~16자)</td>
			</tr>
						<tr>
				<th>비밀번호 확인 </th><td><input type="password" value="<%= member.getPw()%>"></td>
			</tr>
						<tr>
				<th>이름</th><td><input type="text" name="name" value="<%=member.getName()  %>"  readonly></td>
			</tr>
				<tr>
				<th >주소 </th>
			
				<td>
				<!-- 다음주소찾기 api사용  -->
				   <ul class="mif-table-addr">
					    <li>
					     <input id="mif-postCode" type="text"  class="form-control" name="addrList3" value="<%=addrList[3]%>" readonly >
					     <button id="mif-addrSearchBtn" onclick="addrSearch();" class="btn btn-primary" >주소검색</button>
					    </li>
					    <li>
					     <input id="mif-roadAddr"  type="text"  class="form-control" name="addrList0"  value="<%=addrList[0] %>" readonly > 기본주소
					    <input id="jibunAddr"  name="addrList1" value="<%=addrList[1]%>"style="width:400px; display:inline-block;" type="text"  class="form-control" readonly>
					     
					    </li>
					    <li>
					     <input id="mif-detailAddr"  type="text" name="addrList2" value="<%=addrList[2] %>" class="form-control"> 나머지주소
					     
					    </li>
						
	
    					  
   					</ul> 	
				</td>
					</tr>
						<tr>
				<th>휴대전화 </th>
				<td>
				<input id="phone1" type="text" name="phoneArr0" value="<%=phoneArr[0]%>"> - 
				<input id="phone2" type="text"  name="phoneArr1" value="<%=phoneArr[1]%>"> - <input  name="phoneArr2" id="phone3" type="text" value="<%=phoneArr[2]%>"></td>
		
			</tr>
						<tr>
				<th>이메일 </th><td><input type="text" name="emailList0" value="<%=emailList[0] %>"> @ <input type="text" name="emailList1"  value="<%=emailList[1] %>">
					<select id="mif-email">
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="hotmail.com">hotmail.com</option>
					<option value="yahoo.com">yahoo.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="etc">직접입력</option>
				</select></td>

			</tr> 

		</tbody>
	</table>
	
	</div>
		<div class="miu-div-3">
		<ul>
			<li class=" miu-div-3-li1" ><button type="submit">회원 정보 수정</button></li>
			<li class=" miu-div-3-li2"><button type="reset">취소</button></li>
			<li class=" miu-div-3-li3"><button type="button" onclick="location.href='/deleteMember?id=<%=member.getId()%>'">회원탈퇴</button></li>
		</ul>
	</div>
	</div>
	</form>
</body>
<script>
function addrSearch(){
		new daum.Postcode({
			oncomplete:function(data){
				$("mif-postCode").val(data.zonecode);
				$("mif-roadAddr").val(data.roadAddress);
				$("mif-jibanAddr").val(data.jibunAddress);
			}
		}).open();
	}

</script>
</html>