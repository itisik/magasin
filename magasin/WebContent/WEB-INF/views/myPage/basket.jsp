
<%@page import="kr.magasin.basket.model.vo.Basket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.magasin.basket.model.service.BasketService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    BasketService service = new BasketService();
    ArrayList<Basket> lists = (ArrayList<Basket>)request.getAttribute("basket");
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/myPage/basket.css"> 
<link rel="stylesheet" href="/css/common_css/layout.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
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


							<div class="bsk-wrapper">
							<h2 class="bsk-wrapper-h2">장바구니 <span ><a href="/views/preBasket.jsp">최근 본 상품</a></span> </h2>
							<h3 class="bsk-wrapper-h3">장바구니</h3>
							<table class="bkt-table">
								<thead class ="bkt-thead">
								<tr>
									<th><input type="checkbox" id="checkall"></th>
							        <th>이미지</th>
							        <th>상품정보</th>
							        <th>판매가</th>
							        <th>수량</th>
							        <th>합계</th>
							        <th>선택</th>
								</tr>
								</thead>
								
								<tbody  class ="bkt-tbody">
								<% int sum  = 0; %>
							
								<%for(Basket b2 : lists){ %>
								<tr>
								
									<td class="bkt-list-1">
										<input type="checkbox" name="chk">
										<input type="hidden" class="prdDtlId" value="<%=b2.getBasketPrdDtlId() %>" >
										<input type="hidden" class="prdDtlSize" value="<%=b2.getPrdDtlSize() %>" >
										<input type="hidden" class="prdDtlColor" value="<%=b2.getPrdDtlColor() %>" >
										<input type="hidden" class="prdCount" value="<%=b2.getBasketPrdCount() %>" >
										<input type="hidden" class="prdPrice" value="<%=b2.getPrdPrice() %>" >
										<input type="hidden" class="basketUserId" value="<%=b2.getBasketUserId() %>" >
										<input type="hidden" class="prdName" value="<%=b2.getPrdName()%>" >
										<input type="hidden" class="basketId" value="<%=b2.getBasketId()%>" >
										
										
							 		</td>
									
							        <td class="bkt-list-2"><a href="/locationPrd?prdDtlId=<%=b2.getBasketPrdDtlId()%>"><img src="/img/myPage/product1.jpg"></a></td>
							   
							        <td class="bkt-list-3">
							        	<ul>
							        		<li class="bkt-list-3-li-1" ><strong><%=b2.getPrdName() %></strong></li>
							        		<li class="bkt-list-3-li-2" >[사이즈 : <%=b2.getPrdDtlSize() %> / 컬러 : <%=b2.getPrdDtlColor() %>]</li>
							        		<!-- 창 하나 띄어서 처리할 것임  나중에 안바쁠떄 -->
							        	<!-- 	<li><a class="bkt-list-3-chg-btn" onclick="window.open('/views/join/joinSuceess/jsp','','width=430,height=300,location=no');">옵션변경</a></li> -->
							        	</ul>
							        </td>
							        <td class="bkt-list-4"><%=b2.getPrdPrice() %></td>
							        <td class="bkt-list-5">
										<ul>
											<li>
												<span class="bkt-list-5-span">
												<% int count =  Integer.parseInt(b2.getBasketPrdCount());%>
													<input type="hidden"  class="basketUserId" value="<%= b2.getBasketUserId() %>">
													<input type="hidden"  class="basketId" value="<%= b2.getBasketId() %>">
													<input size="2" class="numberUpDown"  placeholder="<%=count %>" type="number" min="1">
													
												</span>
											</li>
											<li class="bkt-list-5-li"><button class="countBtn" type="button" onclick="countBtn(this,'<%= b2.getBasketUserId() %>','<%= b2.getBasketId() %>');" >변경</button></li>
											
										</ul>
									</td>
									<% int price = Integer.parseInt(b2.getBasketPrdCount())*Integer.parseInt(b2.getPrdPrice()); %>
							        <td class="bkt-list-6"><%=price %></td>
							        <td class="bkt-list-7">
									<ul>
							            	
							            	<li class="bkt-list-7-li"> <a href="/deleteBasket?basketId=<%=b2.getBasketId()%>&basketUserId=<%=b2.getBasketUserId() %>" class="bkt-list-7-btn2">삭제</a></li>
							            </ul>
									</td>
								</tr>
								<% sum	+= price; %>
								
								
								<%} %>	
								</tbody>
								<tfoot class="bkt-tfoot">
								<tr class="bkt-foot-tr">
								<% if(sum != 0){%>
									<th colspan="7"><%=sum %></th>
									<%}else{ %>
									<th colspan="7">장바구니가 비었습니다.</th>
									<%} %>
								</tr>
								</tfoot>
							
							</table>
								<div class="bsk-m-div">
									<ul>
									
										<!--장바구니 비우기 눌렀을때 basketUserId 넘겨줘야함 -->
										<% if( !lists.isEmpty() ) {%>
							
										<li class="bsk-m-div-li-3"><a href ="/deleteAllBasket?basketUserId=<%=lists.get(0).getBasketUserId() %>" class="bsk-m-div-clr-btn">장바구니 비우기 </a></li>
									<%}%>
									</ul>
								
								
								</div>
								<div class="bsk-f-div">
									<table class="bsk-f-div-table">
									
											<tr>
												<th>결제예정금액</th>
											</tr>
										
										<tbody>
										<tr>
											<td><%=sum %></td>
										</tr>
										</tbody>
										
									</table>
									<ul class="bsk-f-ul">
										<li class="bsk-f-ul-li-1" ><button type="button" name="button"  onclick="tempBasketAll();">전체상품주문</button></li>
										<li class="bsk-f-ul-li-2" ><button type="button" onclick="tempBasket();">선택상품주문</button></li>
							
										<li class="bsk-f-ul-li-3" ><a href="#">쇼핑계속하기</a></li>
									</ul>
							
								</div>
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
<script type="text/javascript">
	
	function tempBasket(){
	
		var form =$("<form action='/addOrder' method='post'></form>");
	 	var last =  $("[name=chk]:checked").length;
	 	//alert(last);
		for(var i = 0;i<last;i++){
		//	alert($("[name=chk]:checked").length);

			var prdId = $("[name=chk]:checked").eq(i).siblings().eq(0).val();
		 	var size =  $("[name=chk]:checked").eq(i).siblings().eq(1).val();
		 	var color =  $("[name=chk]:checked").eq(i).siblings().eq(2).val();
		 	var count =  $("[name=chk]:checked").eq(i).siblings().eq(3).val();
		 	var price =  $("[name=chk]:checked").eq(i).siblings().eq(4).val();
		 	var userId =  $("[name=chk]:checked").eq(i).siblings().eq(5).val();
		 	var prdName = $("[name=chk]:checked").eq(i).siblings().eq(6).val();
		 	var basketId = $("[name=chk]:checked").eq(i).siblings().eq(7).val();
		 	
		 	//var url =prdId +"/"+size+"/"+color+"/"+count+"/"+price+"/"+userId+"/"+prdName+"/"+basketId ;
		 	//alert(url);
			form.append($("<input type='number' name='count' value='"+last+"'>"));//갯수
		 	form.append($("<input type='text' name='prdDtlId"+i+"' value='"+prdId+"'>"));
			form.append($("<input type='text' name='prdDtlSize"+i+"' value='"+size+"'>"));
			form.append($("<input type='text' name='prdDtlColor"+i+"' value='"+color+"'>"));
			form.append($("<input type='text' name='prdCount"+i+"' value='"+count+"'>"));
			form.append($("<input type='text' name='prdPrice"+i+"' value='"+price+"'>"));
			form.append($("<input type='text' name='basketUserId"+i+"' value='"+userId+"'>"));
			form.append($("<input type='text' name='prdName"+i+"' value='"+prdName+"'>"));
			form.append($("<input type='text' name='basketId"+i+"' value='"+basketId+"'>"));
		
	}
		$('.bsk-wrapper').append(form);
		form.submit();
	}
	
	
	function tempBasketAll(){
		
		var form =$("<form action='/addOrder' method='post'></form>");
	 	var last =  $("[name=chk]").length;
	 	//alert(last);
		for(var i = 0;i<last;i++){
		//	alert($("[name=chk]:checked").length);
			
			var prdId = $("[name=chk]:checked").eq(i).siblings().eq(0).val();
		 	var size =  $("[name=chk]:checked").eq(i).siblings().eq(1).val();
		 	var color =  $("[name=chk]:checked").eq(i).siblings().eq(2).val();
		 	var count =  $("[name=chk]:checked").eq(i).siblings().eq(3).val();
		 	var price =  $("[name=chk]:checked").eq(i).siblings().eq(4).val();
		 	var userId =  $("[name=chk]:checked").eq(i).siblings().eq(5).val();
		 	var prdName = $("[name=chk]:checked").eq(i).siblings().eq(6).val();
		 	var basketId = $("[name=chk]:checked").eq(i).siblings().eq(7).val();
		 	
		 	//var url =prdId +"/"+size+"/"+color+"/"+count+"/"+price+"/"+userId+"/"+prdName+"/"+basketId ;
		 	//alert(url);
			form.append($("<input type='number' name='count' value='"+last+"'>"));//갯수
		 	form.append($("<input type='text' name='prdDtlId"+i+"' value='"+prdId+"'>"));
			form.append($("<input type='text' name='prdDtlSize"+i+"' value='"+size+"'>"));
			form.append($("<input type='text' name='prdDtlColor"+i+"' value='"+color+"'>"));
			form.append($("<input type='text' name='prdCount"+i+"' value='"+count+"'>"));
			form.append($("<input type='text' name='prdPrice"+i+"' value='"+price+"'>"));
			form.append($("<input type='text' name='basketUserId"+i+"' value='"+userId+"'>"));
			form.append($("<input type='text' name='prdName"+i+"' value='"+prdName+"'>"));
			form.append($("<input type='text' name='basketId"+i+"' value='"+basketId+"'>"));
		
	}
		$('.bsk-wrapper').append(form);
		form.submit();
	}

	$(document).ready(function(){
	    //최상단 체크박스 클릭
	   
	    $("#checkall").click(function(){
	        if($("#checkall").prop("checked")){
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
	            $("input[name=chk]").prop("checked",true);
	            //클릭이 안되있으면
	            
	        }else{
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
	            $("input[name=chk]").prop("checked",false);
	        }
	    });
    
	});

	function countBtn(ej, basketUserId, basketId){
		var basketPrdCount = $(ej).parent().prev().children().children().last().val();
		//var url = "basketPrdCount: "+basketPrdCount+" basketUserId:"+ basketUserId+" basketId:"+ basketId;
		//alert(url);
		location.href ="/updateBasketCount?basketId="+basketId+"&basketUserId="+basketUserId+"&basketPrdCount="+basketPrdCount;
	}
</script>
</html>