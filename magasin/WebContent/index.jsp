
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**INCLUDE 틀**</title>
<link rel="stylesheet" href="/css/common_css/layout.css">
<link rel="stylesheet" href="/css/common_css/slideShow.css">
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
						<div id="slider">
							<div class="slider__item">
								<h1>사진1</h1>
							</div>
							<div class="slider__item">
								<h1>사진2</h1>
							</div>
							<div class="slider__item">
								<h1>사진3</h1>
							</div>
							<div class="slider__item">
								<h1>사진4</h1>
							</div>
							<div class="slider__item">
								<h1>사진5</h1>
							</div>
						</div>
						<div class="mainContent-product">
							<div>첫번째 상품</div>
							<div>두번째 상품</div>
							<div>세번째 상품</div>
							<div>네번째 상품</div>
						</div>
					</div>
				</div>
			</section>
			<footer>
				<div class="footer" id="main-footer">
					<%@include file="/WEB-INF/views/common/footer.jsp"%>
				</div>
			</footer>
		</div>

</body>
<!-- 슬라이드 쇼를 위한 스크립트 -->
<script>
const SHOWING_CLASS = "showing";
const firstSlide = document.querySelector(".slider__item:first-child");
function slide() {
  const currentSlide = document.querySelector('.showing');
  if (currentSlide) {
    currentSlide.classList.remove(SHOWING_CLASS);
    const nextSlide = currentSlide.nextElementSibling;
    if (nextSlide) {
      nextSlide.classList.add(SHOWING_CLASS);
    } else {
      firstSlide.classList.add(SHOWING_CLASS);
    }
  } else {
    firstSlide.classList.add(SHOWING_CLASS);
  }
}
slide();
setInterval(slide, 2000);
</script>
</html>