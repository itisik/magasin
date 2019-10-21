<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet" href="/css/adminPage/adminPage.css" />
<link rel="stylesheet" href="/css/adminPage/adminPage-prd.css" />
<link rel="stylesheet" href="/css/adminPage/tab3.css" />
<link rel="stylesheet" href="/css/adminPage/tab4.css" />
<link rel="stylesheet" href="/css/adminPage/tab5.css" />
<link rel="stylesheet" href="/css/adminPage/tab7.css" />
<link rel="stylesheet" href="/css/adminPage/tab8.css" />

<!--폰트를 위한 링크-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&display=swap"
	rel="stylesheet" />

<!--아이콘을 위한 링크-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" />

<!--매출 그래프를 위한 링크-->
<link href="/js/c3-0.7.10/c3.css" rel="stylesheet">
<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="/js/c3-0.7.10/c3.min.js"></script>
<script src="/js/c3-0.7.10/c3.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

<!-- jQuery를 위한 스크립트-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>



<title>관리자 창</title>
</head>

<body>
	<div class="all-container">
		<div class="container">
			<ul class="tabs">
				<a href="/adminPageMain"> <img
					src="img/adminPage/manager-logo.png" alt="매거진" class="tabs-logo"
					width="143px" height="86px" /></a>
				<li class="tab-link current" data-tab="tab-1">메인 창</li>
				<li class="tab-link" data-tab="tab-2">상품조회</li>
				<li class="tab-link" data-tab="tab-3">상품등록</li>
				<li class="tab-link" data-tab="tab-4">고객조회</li>
				<li class="tab-link" data-tab="tab-5">주문조회</li>
				<li class="tab-link" data-tab="tab-6">답변관리</li>
				<li class="tab-link" data-tab="tab-7">매출조회</li>
				<li class="tab-link" data-tab="tab-8">등급관리</li>
			</ul>

			<!-- 아래 'tab-#'형으로 id를 갖는 div들 순서 바꾸지 말아주세요... 1, 2, 3,... 순으로 하면 깨져서 그래요!-->

			<div id="tab-7" class="tab-content current">

				<div class="tab7-window">
					<div class="chart-title">
						<i class="fas fa-chart-line"></i>&nbsp;&nbsp;&nbsp;매출조회
					</div>

					<div class="chart-search">
						<div class="search-top">
							<div class="top-title">조회기간</div>
							<div class="top-select">
								<select>
									<option>결제일</option>
									<option>구매확정일</option>
								</select>
							</div>
							<div class="top-date-select">
								<button>1주일</button>
								<button>2주일</button>
								<button>1달</button>
								<button>3달</button>
								<button>전체기간</button>
							</div>
						</div>

						<div class="search-bottom">
							<div class="bottom-title">상세조건</div>
							<div class="bottom-select">
								<select>
									<option>전체주문</option>
								</select>
							</div>
							<div class="bottom-input">
								<input type="text">
							</div>
						</div>
						<div class="search-btn">
							<button>검색</button>
						</div>
					</div>
					<div class="chart-top">
						<div class="top-canvas1" style="width: 70%; height: 300px;">
							주문금액 / 주문건수</div>
						<div class="top-canvas3" style="width: 30%; height: 300px;">
							성별별 구매비율</div>
					</div>

					<div class="chart-bottom">
						<div class="bottom-canvas2" style="width: 70%; height: 300px;">
							매 시간마다 주문건수</div>
						<div class="bottom-canvas4" style="width: 30%; height: 300px;">
							연령별 구매 비율</div>
					</div>
				</div>

			</div>

			<div id="tab-1" class="tab-content current">
				<%@include file="/WEB-INF/views/adminPage/main/adminMain.jsp"%>
			</div>

			<div id="tab-2" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/prd/prdSearch.jsp"%>
			</div>

			<div id="tab-3" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/prd/prdInsert.jsp"%>
			</div>

			<div id="tab-4" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/customer/customerSearch.jsp"%>
			</div>

			<div id="tab-5" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/order/orderSearch.jsp"%>
			</div>

			<div id="tab-6" class="tab-content">답변관리.</div>

			<div id="tab-8" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/grade/gradeChange.jsp"%>
			</div>

			<div id="tab-9" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/graph/graphPage.jsp"%>
			</div>
			
			<script type="text/javascript" src="/js/adminPage/adminPage.js"></script>
			<script type="text/javascript" src="/js/adminPage/adminPagePrd.js"></script>
			<script type="text/javascript" src="/js/adminPage/graph.js"></script>
</body>
</html>