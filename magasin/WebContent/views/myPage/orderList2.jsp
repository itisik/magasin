
<%@page import="kr.magasin.orderP.model.vo.OrderP2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.magasin.orderP.model.service.OrderPService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% 
    OrderPService service = new OrderPService();
    ArrayList<OrderP2> list = (ArrayList<OrderP2>)request.getAttribute("orderP2");
    %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/myPage/orderList.css"> 
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
	<div class="myPage-main">
	<div class="mainContent">
		<div class="myp-wrapper">
<div class="ol-wrapper">

<h2 class="ol-wrapper-h2">주문내역조회</h2>
<h3 class="ol-wrapper-h3">취소내역</h3>
<table class="ol-table">
	<thead class ="ol-thead">
	<tr>
		<th>주문일자<br>[주문번호]</th>
        <th>이미지</th>
        <th>상품정보</th>
        <th>수량</th>
        <th>상품구매금액</th>
        <th>취소/반품</th>
	</tr>
	</thead>
	<tbody  class ="ol-tbody">
	
	<%for(OrderP2 oP : list){ %>
 <%
 String status = "";
 if(Integer.parseInt(oP.getOrderStatus())== 7 ||Integer.parseInt(oP.getOrderStatus())==-1 ){
 	if(Integer.parseInt(oP.getOrderStatus())== 7 ){
 		status = "반품";
 	}else{
 		status = "취소";
 	}
 %>
	
	
	<tr>
		<td class="ol-list-1"><%= oP.getOrderDate() %><br>[<%=oP.getOrderNum() %>]</td>
        <td class="ol-list-2"><a href="#"><img src="/img/myPage/product1.jpg"></a></td>
        <td class="ol-list-3">
        	<ul>
        		<li class="ol-list-3-li-1" ><strong><%=oP.getPrdName() %></strong></li>
        		<li class="ol-list-3-li-2" >[사이즈 :<%=oP.getPrdDtlSize() %>] [옵션 : <%=oP.getPrdDtlColor() %>]</li>
        	</ul>
        </td>
   
        <td class="ol-list-4"><%=oP.getOrderPrdCount() %>	</td>
        <td class="ol-list-5"><%=oP.getOrderMoney() %></td>
        
          <td class="ol-list-7"><%= status  %></td>
      <%} %>
   
	</tr>
	<%} %>
	</tbody>
	</table>
		<div class ="ol-pageNavi">
		<a href="#"><img src="/img/myPage/pn_btn_page_first.gif"></a>
		<a href="#"><img src="/img/myPage/pn_btn_page_prev.gif"></a>
		<ul class="ol-navi-ul"><li><a href="#">1</a></li></ul>
		<a href="#"><img src="/img/myPage/pn_btn_page_next.gif"></a>
		<a href="#"><img src="/img/myPage/pn_btn_page_last.gif"></a>
		
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