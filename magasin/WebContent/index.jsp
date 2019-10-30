
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAGASIN</title>
<link href="https://fonts.googleapis.com/css?family=Rajdhani&display=swap" rel="stylesheet">

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
								<img src="/img/common_img/main_img1.jpg" width="100%" height="100%">
							</div>
							<div class="slider__item">
								<img src="/img/common_img/main_img2.jpg" width="100%" height="100%">
							</div>
							<div class="slider__item">
								<img src="/img/common_img/main_img3.jpg" width="100%" height="100%">
							</div>
							 <div class="slider__item">
								<img src="/img/common_img/main_img4.png" width="100%" height="100%">
							</div>
							<div class="slider__item">
								<img src="/img/common_img/main_img5.png" width="100%" height="100%">
							</div> 
						</div>

						<div class="mainContent-product" style="margin-top : 50px;">
							<div class="main-product-link" style="margin-right:20px;">
							<a href="/productPage?ctgr=outer_w&gender=w"><img src="/img/common_img/outer_w.jpg" width="470px" height="600px"></a>
							<span style="font-size:16px;"> WOMAN OUTER </span>
							</div>
							<div class="main-product-link">
							<a href="/productPage?ctgr=top_w&gender=w"><img src="/img/common_img/top_w.jpg" width="470px" height="600px"></a>
							<span style="font-size:16px;"> WOMAN TOP </span>
							</div>
						</div>
						<div class="mainContent-product" style="margin-top : 50px;">
							<div class="main-product-link" style="margin-right:20px;"><a href="/productPage?ctgr=top_m&gender=m"><img src="/img/common_img/top_m1.png" width="470px" height="600px"></a>
							<br><span style="font-size:16px;"> MAN TOP </span>
							</div>
							 <div class="main-product-link">
							<div class="main-product-link"><a href="/productPage?ctgr=outer_m&gender=m"><img src="/img/common_img/outer_m.png" width="470px" height="600px"></a>
							<br><span style="font-size:16px;"> MAN OUTER </span>
							</div>
							</div> 
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