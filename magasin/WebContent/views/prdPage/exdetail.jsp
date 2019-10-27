
<%@page import="kr.magasin.productDtl.model.vo.ProductDtl"%>
<%@page import="java.util.ArrayList"%>

<%@page import="kr.magasin.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
			Product pdI = (Product)request.getAttribute("productId");

			ArrayList<ProductDtl> prdDtl = (ArrayList<ProductDtl>)request.getAttribute("prdCol");

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
							<img src="/img/product/<%=pdI.getPrdFilepath() %>">
						</div>
						<div class="detailInfor">	
						<form name="expSub" id="Sub" action="/productExpay?prdId=<%=pdI.getPrdId()%>" method="post">
							<div class="table-wrapper">
								<p><%=pdI.getPrdName()%></p>
								<table class="table detail-table">
									<tr>
										<th>Price</th>
										<td><span><%=pdI.getPrdPrice()%></span>원</td>
										<!--sale가격에 대한 테이블삭제-->
									</tr>
									<tr>
										<td>color</td>
										<td class="color">
										<%for( ProductDtl p : prdDtl ){ %>
											<%if(pdI.getPrdId()==p.getPrdId()){ %>
											<div class="color1" name = "color1" value="<%=p.getPrdDtlColor()%>"style="background-color:<%=p.getPrdDtlColor()%>;" onclick="btncolor();"></div>
											<%} 
									}%>
										</td>
									</tr>
									<tr>
										<th>size</th>
										<td><select id="sizes" name ="size">
												<option>-필수 옵션을 선택해주세요-</option>
									<%for(ProductDtl p : prdDtl) {%>
										<%if(pdI.getPrdId()==p.getPrdId()) {%>
												<!--필수옵션에 사이즈 상세추가함-->
												<option value="<%=p.getPrdDtlSize()%>"><%=p.getPrdDtlSize()%></option>
										<%} %>
									<%} %>
										</select>
										</td>
									</tr>
								</table>
								<div class="detailTotal">

									  총 상품금액(수량): <input id = "totals" type="number" name="total" min="1" value="1"  style="width:40px;"><span><%=pdI.getPrdPrice()%></span>(won)
								</div>
								<div class="detailBag">
									<div><a href="#"><img src="/img/product/topCartBtn.gif">ADD
										TO BAG</a></div>
										<!-- product buy now -> submit btn
											product add -> button type btn -->
										<div ><a href="/productExpay?prdId=<%=pdI.getPrdId()%>">
											<img src="/img/product/detailBuyBtn.gif">PRODUCT BUY NOW
										</a>
										</div>

								</div>
                                    <!--상품문의하기 버튼과 배송비에관한 문구추가-->
								    <a href="/qWrite?prdName=<%=pdI.getPrdName()%>&prdSnImg=<%=pdI.getPrdSnImgpath() %>" class="btn btn-default qBtn">상품 문의하기</a>
                                  <div class="delivery"><div>Magasin 배송</div>
                               <div>100원을 사도 무료배송!!</div>
							</div>
						</div>
							<div style="display:none;">
								<input type="submit">
							</div>
					   </form>
					</div>
				</div>
					<div class="detailView">

						<div class="detailAllImg">
							<img src="/img/product/<%=pdI.getPrdFilepath()%>">
						</div>
					</div>
					<div class="detailSize">
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
	
		<script>
	$(function(){
		var PIEKEDCOLOR = "piekedColor";
		
		$('.color1').click(function(){
			$(".color1").removeClass(PIEKEDCOLOR); <!-- 얇게 만드는과정  -->
			$(this).addClass(PIEKEDCOLOR);
			$(this).addValue();
		});
	});
	
	</script>
</body>
</html>