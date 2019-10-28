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
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
		<th><label for="pw">비밀번호 </label></th>
		<td><input type="password" name="pw" id="pw" class="form-control"  value="<%=member.getPw() %>" pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}" required><span>(영문 대소문자/숫자/특수문자 포함한 8자~15자)</span></td>
		</tr>
		<tr>
		<th><label for="pw2">비밀번호확인</label></th>
		<td><input type="password" id="pw2" class="form-control"  value="<%=member.getPw() %>" required><span id="mif-pwChkMsg"></span></td> <!-- 데이터넘길 필요없으니까 name속성안줌 -->
		</tr>
								
						<tr>
				<th>이름</th><td><input type="text" name="name" value="<%=member.getName()  %>"  readonly></td>
			</tr>

			<tr>
			<% for(int i=0;i<addrList.length;i++){
				if(addrList[i].equals("0")){
					addrList[i] = "";
				}
			} %>
                <th><label for="jibunAddress">주소</label></th><!-- label id로 넘겨줌-->
              
                <td>
                
                    <!--addr_1,addr_2,addr_3 합쳐서 DB에 넣어주기 -->
                    <input type="text" name="addrList3" id="addr_postcode"   value="<%=addrList[3]%>" readonly="readonly">
                    <button type="button" id="addr_btn" class="btn-box" onclick="sample6_execDaumPostcode()" value="우편번호찾기">우편번호찾기</button><br>
                    <input type="text"  name="addrList0" id="addr_address" value="<%=addrList[0] %>" placeholder="기본 도로명 주소"><br>
                    <input type="text" name="addrList1" id="addr_detailAddress" value="<%=addrList[1] %>" placeholder="상세주소">
                    <input type="text"  name="addrList2" id="addr_extraAddress" value="<%=addrList[2]%>" placeholder="참고항목">
                </td>
            </tr>
			

						<tr>
				<th>휴대전화 </th>
				<td>
				<input id="phone1" type="text" name="phoneArr0" value="<%=phoneArr[0]%>"> - 
				<input id="phone2" type="text"  name="phoneArr1" value="<%=phoneArr[1]%>"> - <input  name="phoneArr2" id="phone3" type="text" value="<%=phoneArr[2]%>"></td>
		
			</tr>
						<tr>
				<th>이메일 </th><td><input type="text" name="emailList0" value="<%=emailList[0] %>"> @ <input type="text" id="emailList1" name="emailList1"  value="<%=emailList[1] %>">
					<!-- <select id="mif-email">
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="hotmail.com">hotmail.com</option>
					<option value="yahoo.com">yahoo.com</option>
					<option value="1">gmail.com</option>
					<option value="etc">직접입력</option>
				</select> --></td>

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

<script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
//다음 api 주소찾기
     function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? '/ ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        document.getElementById("addr_extraAddress").value = extraAddr;

                    } else {
                        document.getElementById("addr_extraAddress").value = '';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('addr_postcode').value = data.zonecode;
                    document.getElementById("addr_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("addr_detailAddress").focus();
                }
            }).open();
        }
        
   //비밀번호, 비밀번호 확인 같은지 확인
		$(function(){
			$('#pw2').blur(function(){
				if($('#pw').val() != $('#pw2').val()){ //일치하지 않을 때
					var msg = $("#mif-pwChkMsg");
					msg.html('비밀번호가 일치하지 않습니다.');
					msg.css('color','red');
					$('#pw2').val(''); //비우고
					//$('#pw2').focus(); 
				//	if($('#pw2').val()!=""){ 
				//		msg.html('비밀번호 재입력을 입력해주세요.');
				//		msg.css('color','red');
				//		$('#pw2').val(''); //비우고
				//		$('#pw2').focus();
				//	}
				}else if($('#pw').val() == $('#pw2').val()){
					var msg = $("#mif-pwChkMsg");
					msg.html('비밀번호가 일치합니다.');
					msg.css('color','green');
				}else{
					var msg = $("#mif-pwChkMsg");
					msg.html('');
				}
			});
		});

</script>
</html>