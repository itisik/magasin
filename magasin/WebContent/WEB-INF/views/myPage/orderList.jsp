<%@page import="kr.magasin.orderP.model.vo.OrderP2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.magasin.orderP.model.service.OrderPService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    OrderPService service = new OrderPService();
    ArrayList<OrderP2> lists = (ArrayList<OrderP2>)request.getAttribute("orderP2");
    %>
<!DOCTYPE html>
<html>
<head>
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

<% if( !lists.isEmpty() ) {%>
<h2 class="ol-wrapper-h2">주문내역조회 <span ><a href="/orderList2?orderUserId=<%=lists.get(0).getOrderUserId()%>">취소/반품/교환내역</a></span> </h2>
<% }%>
<h3 class="ol-wrapper-h3">주문내역</h3>
<table class="ol-table">
	<thead class ="ol-thead">
	<tr>
		<th>주문일자<br>[주문번호]</th>
        <th>이미지</th>
        <th>상품정보</th>
        <th>수량</th>
        <th>상품구매금액</th>
        <th>주문처리상태</th>
        <th>취소/반품</th>
	</tr>
	</thead>
	<tbody  class ="ol-tbody">
	
	<%for(OrderP2 oP : lists){ %>
		
	
	
	<tr>
		<td class="ol-list-1"><%= oP.getOrderDate() %><br>[<%=oP.getOrderNum() %>]</td>
        <td class="ol-list-2"><a href="#"><img src="/upload/photo/<%=oP.getPrdSnImgpath()%>"></a></td>
        <td class="ol-list-3">
        	<ul>
        		<li class="ol-list-3-li-1" ><strong><%=oP.getPrdName() %></strong></li>
        		<li class="ol-list-3-li-2" >[사이즈 :<%=oP.getPrdDtlSize() %>] [옵션 : <%=oP.getPrdDtlColor() %>]</li>
        	</ul>
        </td>
   
        <td class="ol-list-4"><%=oP.getOrderPrdCount() %>	</td>
        <td class="ol-list-5"><%=oP.getOrderMoney() %></td>
        
        <!-- 
        주문 완료 / 취소요청 가능 
   	배송완료/반품신청 OR 리뷰쓰기      
        
        -->
        <% String status = ""; %>
	   <% if(Integer.parseInt(oP.getOrderStatus())==4){ status="배송완료";%>        	
          <td class="ol-list-6"><%= status %><br>
          <a href="/reviewWrite?prdName=<%=oP.getPrdName()%>&prdSnImg=<%=oP.getPrdSnImgpath()%>">리뷰쓰기</a></td>
        <%}else{
        	switch((Integer.parseInt(oP.getOrderStatus()))){
            case 1:status="주문완료"; break;
            case 0:status="취소처리중"; break;
            case -1:status="취소"; break;
            case 2:status="배송준비중"; break;
            case 3:status="배송중"; break;
            case 4:status="배송완료"; break;
            case 5:status="반품처리중"; break;//반품신청
            case 6:status="반품처리중"; break;
            case 7:status="반품"; break;
            }
        	%>
          <td class="ol-list-6"><%=status%></td>
        <%} %>
         <%if(Integer.parseInt(oP.getOrderStatus())==1){  %>
         <td class="ol-list-7"><a href="/updateOrder?orderNum=<%=oP.getOrderNum() %>&orderUserId=<%=oP.getOrderUserId() %>" >주문취소</a></td>
            <%}else if(Integer.parseInt(oP.getOrderStatus())==4){ %>
                <td class="ol-list-7"><a href="/updateOrder1?orderNum=<%=oP.getOrderNum() %>&orderUserId=<%=oP.getOrderUserId() %>">반품신청</a></td>
                <%}else {%>
                  <td class="ol-list-7"></td>
                <%} %>
   
	</tr>
 
	<%} %>
	
	</tbody>
	</table>
		

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