<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 보영 CSS -->
<link rel="stylesheet" href="/css/common_css/layout.css">

<!-- 경필 CSS -->
<!--test-->
<link rel="stylesheet" href="/css/prdPage/exdetail.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
				<div class="detailContainr">
					<p>
						<a href="#">home</a> / <a href="#">OUTER</a>
					</p>
					<div class="detailBorder">
						<div class="detailImg">
							<img src="/img/product/082a653adedb983a627445653600a6ad.jpg">
						</div>
						<div class="detailInfor">
							<div class="table-wrapper">
								<p>latte v-neck cable cardigan</p>
								<table class="table detail-table">
									<tr>
										<th>Price</th>
										<td><span>32,000</span>원</td>
										<!--sale가격에 대한 테이블삭제-->
									</tr>
									<tr>
										<td>color</td>
										<td class="color">
											<div class="color1"></div>
											<div class="color2"></div>
											<div class="color3"></div>
											<div class="color4"></div>
										</td>
									</tr>
									<tr>
										<th>size</th>
										<td><select>
												<option>-필수 옵션을 선택해주세요-</option>
												<!--필수옵션에 사이즈 상세추가함-->
												<option value="XS">XS</option>
                                                <option value="S">S</option>
                                                <option value="M">M</option>
                                                <option value="L">L</option>
                                                <option value="XL">XL</option>
                                                <option value="FreeSize">FreeSize</option>
										</select></td>
									</tr>
								</table>
								<div class="detailTotal">
									총 상품금액(수량): <span>0</span>개
								</div>
								<div class="detailBag">
									<a href="#"><img src="/img/product/topCartBtn.gif">ADD
										TO BAG</a> <a href="/views/prdPage/expays.jsp"><img
										src="/img/product/detailBuyBtn.gif">PRODUCT BUY NOW</a>
								</div>
                                    <!--상품문의하기 버튼과 배송비에관한 문구추가-->
								    <a href="/views/qProduct.jsp" class="btn btn-default qBtn">상품 문의하기</a>
                                  <div class="delivery"><div>Magasin 배송</div>
                               <div>100원을 사도 무료배송!!</div>
							</div>
						</div>
					</div>
					<div class="detailView">
						<p>DESIGN TIP</p>
						<p>꽈배기 짜임이 돋보이는 도톰한 니트 가디건. 여리여리한 무드를 자아내는 핏에, 단독으로 착용했을 때도
							스타일리쉬한 분위기가 나는 매력적인 니트.</p>
						<div class="detailAllImg">
							<img src="/img/product/082a653adedb983a627445653600a6ad.jpg">
							<img src="/img/product/082a653adedb983a627445653600a6ad.jpg">
							<img src="/img/product/082a653adedb983a627445653600a6ad.jpg">
							<img src="/img/product/082a653adedb983a627445653600a6ad.jpg">
							<img src="/img/product/082a653adedb983a627445653600a6ad.jpg">

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
</body>
</html>