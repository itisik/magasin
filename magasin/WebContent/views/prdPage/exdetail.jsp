
<%@page import="kr.magasin.productDtl.model.vo.ProductDtl"%>
<%@page import="java.util.ArrayList"%>

<%@page import="kr.magasin.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
			Product pdI = (Product)request.getAttribute("productId");
			ArrayList<String> colors =(ArrayList<String>)request.getAttribute("colors");
			ArrayList<String> sizes = (ArrayList<String>)request.getAttribute("sizes");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 보영 CSS -->
<link rel="stylesheet" href="/css/common_css/layout.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<!-- 경필 CSS -->
<!--test-->
<link rel="stylesheet" href="/css/prdPage/exdetail.css">
</head>
<body id="body1">
	<div class="wrapper">
	
		<header>
		<div class="header">
			<%@include file="/WEB-INF/views/common/header.jsp"%>
		</div>
		 <%if(m!=null){ %>
		<input type="hidden" class="memberId" value="<%=m.getId()%>" >
		<%} %>
		</header>
		<section>
		<div class="mainContainer">
			<div class="side-nav">
				<%@include file="/WEB-INF/views/common/nav.html"%>
			</div>
			<div class="mainContent" style="width: 943px;">

				<div class="detailContainr">			

					<div class="detailBorder">
						<div class="detailImg">
							<img src="/upload/photo/<%=pdI.getPrdSnImgpath() %>">
						</div>
						<div class="detailInfor">	

						<form id="Sub" action="/productExpay" method="post">

							<div class="table-wrapper">
								<p><%=pdI.getPrdName()%></p>
								 <input type="hidden" class="prdId" name="prdId" value="<%=pdI.getPrdId()%>">
								 <input type="hidden" class="prdName" name="prdName" value="<%=pdI.getPrdName()%>">	
								<table class="table detail-table">
									<tr>
										<th>Price</th>
										<td><span><%=pdI.getPrdPrice()%></span>원</td>
										<input type="hidden" class="prdPrice"name="prdPrice" value="<%=pdI.getPrdPrice()%>">
										<!--sale가격에 대한 테이블삭제-->
									</tr>
									<tr>
										<td>color</td>
										<td class="color">
										<%for( String color : colors ){ %>

											<div class="color1" name ="color1" value="<%=color%>"style="background-color:<%=color%>;"></div>
											<input type="hidden" class="prdDtlColor" name="prdDtlColor" value="<%=color%>">

											<%
									}%>
										</td>
									</tr>
									<tr>
										<th>size</th>
										<td><select id="sizes" name ="size">
												<option value="no">-필수 옵션을 선택해주세요-</option>
									<%for(String size : sizes) {%>
										
												<!--필수옵션에 사이즈 상세추가함-->
												<option value="<%=size%>"><%=size%></option>
												
												
										<% %>
									<%} %>
										</select>
										</td>
									</tr>
								</table>
								<div class="detailTotal">


									  총 상품금액(수량): <input class="amount" id = "amount" type="number" name="total" min="1" value="1" style="width:40px;"><span id="total"><%=pdI.getPrdPrice()%></span>(won)

								</div>
								<script>
									$("#amount").change(function(){
										console.log($("#amount").val());
										$("#total").text($("#amount").val()*<%=pdI.getPrdPrice()%>);
									});
								</script>
								<div class="detailBag">
									<div><button type="button" name="button"  onclick="goToBasket();"><img src="/img/product/topCartBtn.gif">ADD
										TO BAG</button></div>
										<!-- product buy now -> submit btn
											product add -> button type btn -->
											
										<div ><button type="submit" id="pay-btn" style="border:none; background:none;">
											<img src="/img/product/detailBuyBtn.gif">PRODUCT BUY NOW
										</button>
										</div>

								</div>
                                    <!--상품문의하기 버튼과 배송비에관한 문구추가-->
								    <a href="/qWrite?prdName=<%=pdI.getPrdName()%>&prdSnImg=<%=pdI.getPrdSnImgpath() %>" class="btn btn-default qBtn">상품 문의하기</a>
                                  <div class="delivery"><div>Magasin 배송</div>
                               <div>100원을 사도 무료배송!!</div>
							</div>
						</div>

					   </form>
					</div>
				</div>
					<div class="detailView">

						<div class="detailAllImg" style="width:100%;">
							<img src="/upload/photo/<%=pdI.getPrdFilepath()%>" width="100%;">
						</div>
					</div>
					<!-- <div class="detailSize">
						<div class="detailBorderSize">
							<table class="table detail-Size">
								<tr>
									<th></th>
									<th>XS</th>
									<th>S</th>
									<th>M</th>
									<th>L</th>
									<th>XL</th>
									<th>FreeSize</th>
								</tr>
								<tr>
									<th>Size</th>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</div>
					</div> -->
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
	<script>
	
	/* 시작 은지 장바구니에 담는 로직   */
	function goToBasket(){
		var form =$("<form action='/goToBasket' method='post'></form>");
		
		var userId =  $('.memberId').val()
		var prdId = $('.prdId').val();
		var prdName = $('.prdName').val()
		var price = $('.prdPrice').val()
	 	var size =  $('.prdDtlSize').val();
	 	var color =   $('.prdDtlColor').val()
	 	var count =   $('.amount').val()
	 	
	 	
	 	var url = prdId+"/"+prdName+"/"+prdPrice+"/"+prdDtlSize+"/"+prdDtlColor+"/"+prdCount+"/"+userId ; 
	 	alert(url);
	 	
	 	form.append($("<input type='text' name='prdDtlSize' value='"+size+"'>"));
	 	form.append($("<input type='text' name='prdDtlColor' value='"+color+"'>"));
		form.append($("<input type='text' name='basketUserId' value='"+userId+"'>"));
		form.append($("<input type='text' name='prdName' value='"+prdName+"'>"));
		form.append($("<input type='number' name='prdCount' value='"+count+"'>"));
		form.append($("<input type='number' name='prdPrice' value='"+price+"'>"));		
	 	form.append($("<input type='number' name='prdId' value='"+prdId+"'>"));
	 	
		$('.wrapper').append(form);
		form.submit(); 
	}
	

	/*은지 장바구니에 담는 로직  끝  */
	
	
		$(document).ready(function(){
			var index = -1 ;
			
			$("#pay-btn").click(function(){
				if(index == -1){
					alert("색상을 선택하세요");
					return false;
				}else if($("#sizes").val()=='no'){
					alert("사이즈를 선택하세요");
					return false;	
				}
				
			});
		
				
		var PIEKEDCOLOR = "piekedColor";
		
		$('.color1').click(function(){
			$(".color1").removeClass(PIEKEDCOLOR); 
			$(this).addClass(PIEKEDCOLOR);

			/* $(this).addValue(); */
			index = $(".color1").index(this);
			console.log(index);

			});
		});

	
	</script>
</body>
</html>