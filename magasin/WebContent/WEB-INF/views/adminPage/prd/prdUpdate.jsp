<%@page import="kr.magasin.product.model.service.ProductService"%>
<%@page import="kr.magasin.productDtl.model.vo.ProductDtl"%>
<%@page import="kr.magasin.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Product pp = (Product) request.getAttribute("product");
	//ProductDtl pdtl = (ProductDtl)request.getAttribute("productdtl");
	ProductService pservice = new ProductService();
	Product p = pservice.searchOne(pp.getPrdId());
%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />


<link href="https://fonts.googleapis.com/css?family=Jua&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/css/adminPage/adminPage2.css" />
<link rel="stylesheet" href="/css/adminPage/adminPage-prd2.css" />

<!--폰트를 위한 링크-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&display=swap"
	rel="stylesheet" />

<!--아이콘을 위한 링크-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" />


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="/js/c3-0.7.10/c3.min.js"></script>
<script src="/js/c3-0.7.10/c3.js"></script>

<!--매출 그래프를 위한 링크-->
<link href="/js/c3-0.7.10/c3.css" rel="stylesheet">

<!-- jQuery를 위한 스크립트-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- 달력을 위한 로드 -->

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<title>관리자 창</title>

<style>
#categorysemi1 {
	display: none;
}

.searchbutton {
	padding-left: 5%;
}

.current3 {
	border: 0;
	background: #0b83e6;
	color: #fff;
}
</style>

</head>

<body>
			<ul class="tabs">
				<a href="/adminPageMain"> <img
					src="img/adminPage/manager-logo.png" alt="매거진" class="tabs-logo"
					width="143px" height="86px" />
				</a>
				<a href="/adminPageMain" style="text-align: center;"><li
					class="tab-link" data-tab="backToPage" style="text-align: center;">뒤로가기</li></a>
				<li class="tab-link current" data-tab="prdUpdate">상품수정</li>
			</ul>

			<!-- 아래 'tab-#'형으로 id를 갖는 div들 순서 바꾸지 말아주세요... 1, 2, 3,... 순으로 하면 깨져서 그래요!-->

			<div class="current">
				<!-- 이곳이 상품 수정 페이지에 대한 내용 -->
				<form action="/prdUpdateEnd" method="post"
					enctype="multipart/form-data">
					<div class="tabupdate current">
						<input type="hidden" name="prdId" value="<%=pp.getPrdId()%>">
						<i class="fas fa-list"></i><span> 상품 수정 페이지</span> <br> <br>
						<div class="updatemain">
							<div class="updatemain1">

								<div class="updatecon1">
									<div class="updatecon1-1">
										<i class="fas fa-edit"></i><span>상품 이름</span>
									</div>
									<div class="updatecon1-2">
										<input type="text" name="prdName" value="<%=pp.getPrdName()%>">
									</div>
								</div>
								<div class="updatecon1">
									<div class="updatecon2-1">
										<i class="fas fa-edit"></i><span>상품 성별</span>
									</div>
									<div class="updatecon2-2">
										<span><%=pp.getPrdGender()%></span>
									</div>
								</div>

								<div class="updatecon1">
									<div class="updatecon3-1">
										<i class="fas fa-edit"></i><span>상품 카테고리</span>
									</div>

									<div class="updatecon3-2">
										<span><%=pp.getPrdCtgr()%></span>
									</div>
								</div>


								<div class="updatecon1">
									<div class="updatecon4-1">
										<i class="fas fa-edit"></i><span>상품 상세 카테고리</span>
									</div>

									<div class="updatecon4-2">
										<span><%=pp.getPrdSubCtrg()%></span>
									</div>
								</div>

								<div class="updatecon1">
									<div class="updatecon6-1">
										<i class="fas fa-edit"></i><span>상품 썸네일</span>
									</div>
									<div class="updatecon6-2">
										<img id="img-view3" width="50" height="50" class="delFile2"
											src="/upload/photo/<%=pp.getPrdSnImgpath()%>">
									</div>

									<div class="updatecon6-3" id="img-viewer5">
										<input type="hidden" id="psimgstatus2" name="psimgstatus2"
											value="stay">
										<%
											if (pp.getPrdSnImgname() != null) {
										%>
										<input type="hidden" name="oldFilename2"
											value="<%=pp.getPrdSnImgname()%>"> <input
											type="hidden" name="oldFilepath2"
											value="<%=pp.getPrdSnImgpath()%>"> <span
											class="delFile2"><%=pp.getPrdSnImgname()%></span>

										<button type="button" id="fileDelBtn2">삭제</button>
										<input type="file" name="updatepicturesum2" id="file2"
											style="display: none;">
										<%
											} else {
										%>
										<input type="file" name="prdSnImgname"
											onchange="loadImg3(this)" id="awefawef">
										<%
											}
										%>
										<img id="img-view3" width="50" height="50">
									</div>

								</div>


								<div class="updatecon1">
									<div class="updatecon7-1">
										<i class="fas fa-edit"></i><span>상품 이미지</span>
									</div>
									<div class="updatecon7-2">
										<img id="img-view4" width="50" height="50" class="delFile"
											src="/upload/photo/<%=pp.getPrdFilepath()%>">
									</div>
									<div class="updatecon7-3" id="img-viewer6">
										<input type="hidden" id="pimgstatus" name="pimgstatus"
											value="stay">
										<%
											if (pp.getPrdFilename() != null) {
										%>
										<input type="hidden" name="oldFilename"
											value="<%=pp.getPrdFilename()%>"> <input
											type="hidden" name="oldFilepath"
											value="<%=pp.getPrdFilepath()%>"> <span
											class="delFile"><%=pp.getPrdFilename()%></span>
										<button type="button" id="fileDelBtn">삭제</button>
										<input type="file" name="updatepicture" id="file"
											style="display: none;">

										<%
											} else {
										%>
										<input type="file" name="prdFilename"
											onchange="loadImg4(this)" id="astasdtz">
										<%
											}
										%>
										<img id="img-view4" width="50" height="50">
									</div>
								</div>
								<div class="updatecon1">
									<div class="updatecon8-1">
										<i class="fas fa-edit"></i><span>상품 가격</span>
									</div>
									<div class="updatecon8-2">
										<input name="prdPrice" value="<%=pp.getPrdPrice()%>">
									</div>

								</div>
								<div></div>
								<br>
								<div class="updatecon1">
									<div class="updatecon9-1">
										<button>수정하기</button>
										<button>목록으로</button>
									</div>
								</div>
							</div>
						</div>

					</div>
				</form>
			</div>
</body>
<script>
	function loadImg3(value) {
		if (value.files && value.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#img-view3').attr('src', e.target.result);

			}
			reader.readAsDataURL(value.files[0]);
		}
	}

	function loadImg4(value) {
		if (value.files && value.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#img-view4').attr('src', e.target.result);

			}
			reader.readAsDataURL(value.files[0]);
		}
	}
	$(document).ready(function() {
		$("#fileDelBtn").click(function() {
			if (confirm("상품사진 삭제하시겠습니까?")) {
				$(".delFile").hide();
				$("#file").show();
				$("#pimgstatus").val("delete");
			}
		});
	});

	$(document).ready(function() {
		$("#fileDelBtn2").click(function() {
			if (confirm("상품사진 삭제하시겠습니까?")) {
				$(".delFile2").hide();
				$("#file2").show();
				$("#psimgstatus2").val("delete");
			}
		});
	});

	function loadImg(value) {
		if (value.files && value.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#img-view2').attr('src', e.target.result);

			}
			reader.readAsDataURL(value.files[0]);
		}
	}

	function loadImg2(value) {
		if (value.files && value.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#img-view').attr('src', e.target.result);

			}
			reader.readAsDataURL(value.files[0]);
		}
	}
</script>
</html>