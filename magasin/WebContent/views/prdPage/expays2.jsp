<%@page import="kr.magasin.prdPaging.model.vo.ProductAll"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.magasin.member.model.vo.Member"%>
<%@page import="kr.magasin.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%

	 Member member = (Member)request.getAttribute("member");
     ArrayList<ProductAll> list  = ( ArrayList<ProductAll>)request.getAttribute("ProductAll");
 

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <!-- 보영 CSS -->
    <link rel="stylesheet" href="/css/common_css/layout.css">
    
    <!-- 경필 CSS -->
    <link rel="stylesheet" href="/css/prdPage/expays.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <title>Insert title here</title>
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
					<!-- 만드신 콘텐츠 넣으세요!!!!!!!!!!!!!!!!width 반드시 943!!!!!!!!!!!!!!!!!!!!!!!!!! -->
		
    <div class="orderContainer">
        <div class="orderText">
            <p><a href="#">home</a>> order start</p>
            <h3>order start</h3>
        </div>
        <div class="order-wrapper">
        <% int sum=0; %>
            <table class="order-table">
                <thead class="order-thead">
                    <tr>
                        <th>이미지</th>
                        <th>상품정보</th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>배송비</th>
                        <th>합계</th>
                    </tr>
                </thead>
                <%for(ProductAll pay : list){ %> 
                <tbody class="order-tbody">
                
             
                    <tr>
                        <td class="order-list-1"><a href="#"><img src="/img/product/<%=pay.getPrdSnImgpath()%>"></a></td>
                        <td class="order-list-2">
                            <ul>
                                <li class="order-list-2-li-1"><strong><%=pay.getPrdName() %></strong></li>
                                <li class="order-list-2-li-2">[옵션:<span><%=pay.getPrdDtlColor() %></span>/<span><%=pay.getPrdDtlSize() %></span>]</li>
                            </ul>
                        </td>
                        <td class="order-list-3"><span><%=pay.getPrdPrice() %></span></td>
                        <td class="order-list-4"><span><%= pay.getCount() %></span></td>
                        <td class="order-list-5">[무료]</td>
                        <% int tempSum = 0;
                        tempSum = pay.getPrdPrice()* pay.getCount();
                        %>
                        <td class="order-list-6"><span><%= tempSum %></span></td>
                    </tr>
                     <% sum += pay.getCount()*pay.getPrdPrice(); %>
                    <%} %>
                </tbody>
            </table>
            <tfoot class="order-tfoot">
                <tr>
                    <th colspan="7">
                   
                        <p class="order-foot">상품구매금액&nbsp;<span><b><%=sum %>&nbsp;</b></span>
                            배송비&nbsp;<b>0</b>
                            (무료)=합계&nbsp;&nbsp;<span><b><%=sum %></b></span></p>
                    </th>
                </tr>
            </tfoot>
        </div>
        <div class="orderInfor">
            <div class="ordertext">
                <p>주문자 정보</p>
                <p><img src="/img/product/ico_required.gif">필수입력사항</p>
            </div>
            <table class="table-bordered orderorder">
                <tr>
                    <td>주문하시는분<img src="/img/product/ico_required.gif"></td>
                    <td><input type="text" name="name1" value=""></td>
                </tr>
                <tr>
                    <td>주소<img src="/img/product/ico_required.gif"></td>

                             <td>
                                <input type="text" name="addr1" > <br>
                                <input  type="text" name="addr2" ><br>
                                <input  type="text" name="addr3"><br>
                                <input  type="text" name="addr4">
                            </td>

                </tr>
                <tr>
                    <td>휴대전화<img src="/img/product/ico_required.gif"></td>
                    <td><input type="text" name="phone1" value=""></td>
                </tr>
                <tr>
                    <td>이메일<img src="/img/product/ico_required.gif"></td>
                    <td><input type="email" name="email" value=""></td>
                </tr>
            </table>
        </div>
        <div class="orderaddr">
            <p>배송지 정보</p>
            <p><img src="/img/product/ico_required.gif">필수 입력사항</p>
        </div>
        <table class="table-bordered addrInfor">
            <tr>
                <td>배송지 선택</td>
                <td><input type="radio" name="addr5" checked="checked" value="oldA" >주문자 정보와동일
                    <input type="radio" name="addr5" value="newA" >새로운 배송지
                </td>
            </tr>
            <tr>
                <td>받으시는 분<img src="/img/product/ico_required.gif"></td>
                <td><input  type="text" name="name2" value=""></td>
            </tr>
            <tr>
                <td>주소<img src="/img/product/ico_required.gif"></td>
               <td>
                                <input type="text" name="addr7" id='postCode'  placeholder="우편번호" readonly="readonly">
                                <button id="addrSearchBtn" onclick="addrSearch();" class="btn" type="button">우편번호</button><br>
                                <input id="roadAddr" type="text" name="addr8" placeholder="기본 도로명 주소"><br>
                                <input id="jibunAddr" type="text" name="addr9" placeholder="상세주소"><br>
                                <input id="addr_extraAddress" type="text" name="addr10" placeholder="참고항목">
                            </td>
            </tr>
            <tr>
                <td>휴대전화</td>
                <td><input type="text" name="phone2" value=""></td>
            </tr>
        </table>
        <div class="orderpay">
            <p>결제 예정금액</p>
        </div>
        <table class="table-bordered order-pay">
            <tr>
                <td>총 주문 금액</td>
                <td>총 주문금액+배송비[무료]</td>
                <td>총 결제 내역</td>
            </tr>
            <tr>
                <td><span><%=sum %></span></td>
                <td><span><%=sum %></span> + <span>0</span></td>
                <td><span><%=sum %></span></td>
            </tr>
        </table>
        <div class="orderpays">
            <p>결제수단</p>
        </div>
        <table class="table-bordered order-pays">
            <tr id="payy" >
                <th><label><input type="radio" value="<%=sum %>"></label>카드결제</th>
                <td rowspan="3"><p>카드결제 최종금액</p>
                                <span></span><br>
                                <button class="btn" >결제하기</button><br>
                                <p id="payResult"></p>
                </td>
            </tr>
                <td>magasin은 카드결제만 가능한점을 양해바랍니다.</td>
            <tr>
                <td>단, 배송비는 100원을 사도 무료!!!</td>
            </tr>
            <tr>
                
            </tr>
        </table>
    </div>
	</div>
<script>
	// 주소 처리 모듈
	function addrSearch(){
		new daum.Postcode({
			oncomplete:function(data){
				$("#postCode").val(data.zonecode);
				$("#roadAddr").val(data.roadAddress);
				$("#jibunAddr").val(data.jibunAddress);
				$("#addr_extraAddress").val(data.addr_extraAddress);
			}
		}).open();
	}
	
	
	// 결제 처리 모듈
	$(document).ready(function(){
		var totalPay=0;
		$("#payy input").change(function(){
			if($(this).is(":checked")){
				totalPay += (Number)($(this).val());
			}else{
				totalPay -= (Number)($(this).val());
			}
			$("#payy span").html(totalPay);
		});
		$("#payy button").click(function(){
			var price = $("#payy span").html();
			
			//상품명 현재시간
			var d = new Date();
			var date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();
			IMP.init('imp11221274');
			IMP.request_pay({
				merchant_uid : '상품명_'+date,
				name : '결제테스트',
				amount : price,
				buyer_email : 'kyoung_pil@naver.com',
				buyer_name : '구매자',
				buyer_tel : '010-1234-4567',
				buyer_addr : '안양시 만안구',
				buyer_postcode : '123-456',
			}, function(rsp){
				if(rsp.success){
					var msg='결제가 완료되었습니다.';
					var r1 = '고유아이디: ' +rsp.imp_uid;
					var r2 = '상점 거래 아이디 :' +rsp.merchant_uid;
					var r3 = '결제 금액 :' +rsp.paid_amout;
					var r4 = '카드 승인 번호' +rsp.apply_num;
					alert(msg);
					//location.href="/" 결제가 승인된후 count 갯수 줄여야함
					$("#payResult").html(r1+"<br>"+r2+"<br>"+r3+"<br>"+r4);
				}else{
					$("#payResult").html('결제실패<br>'+'에러내용: '+rsp.error);
			    }
			});
		});
	});
</script>
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
