<%@page import="kr.magasin.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 Member member  = (Member)request.getAttribute("member");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/myPage/myPage.css"> 

</head>
<body>
<div class="myp-wrapper">
	<div class="myp-div1">
	<span><%= member.getName() %></span> 님은<span>[VVIP]</span>  회원이십니다.
	</div>

	<div  class="myp-div2">
		<div class="myp-div2-d1">
		<h3>나의 주문처리 현황</h3>
			</div>
			<div class="myp-div2-d2">
				<ul class="myp-div2-d2-ul1">
				<li><strong>배송준비중</strong><br><a>0</a></li>
				<li><strong>배송중</strong><br><a>0</a> </li>
				<li><strong>배송완료</strong><br><a>0</a></li>
				</ul>
				<ul  class="myp-div2-d2-ul2">
					<li>취소 : <a>0</a></li>
					<li>반품 : <a>0</a></li>
				</ul>
			</div>
	</div>
	<div  class="myp-div3">
		<ul class="myp-div3-ul">
			<li class="myp-div3-ul-li1">
			<h3>
				<img src="/img/myPage/myp-order.png">
				<a href="/views/myPage/orderList.jsp">Order</a>
			</h3>
			<pre>주문내역 조회</pre>
			<p>고객님께서 주문하신 상품의<br>주문내역을 확인하실 수 있습니다.</p>
			</li>
			<li class="myp-div3-ul-li2">
			<h3>
			<img src="/img/myPage/myp-profile.png">
			<a href="/views/myPage/myInfoUpdate.jsp">Profile</a>
			</h3>
				<pre>회원 정보</pre>
			<p>고객님의 개인정보를 <br>관리하는 공간 입니다.</p>
			</li>
			<li class="myp-div3-ul-li3">
			<h3>
			<img src="/img/myPage/myp-cart1.png">
			<a href="/views/myPage/basket.jsp">Basket</a></h3>
				<pre>장바 구니</pre>
			<p>장바구니에 등록하신 <br>상품 목록을 보여드립니다.</p>	
			</li>	
			<li class="myp-div3-ul-li4">
			<h3>
			<img src="/img/myPage/myp-order.png">
			<a href="#">Board</a></h3>
				<pre>게시물 관리</pre>
			<p>고객님께서 작성하신 게시물을 <br>관리하는 공간입니다.</p>	
			</li>
			
		</ul>
	</div>
</div>
</body>
</html>