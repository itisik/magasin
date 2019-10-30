<%@page import="kr.magasin.product.model.vo.Product"%>
<%@page import="kr.magasin.product.model.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
	
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />

<style>
.tab8-search>.search-bottom>.bottom-input {
	display: flex;
	align-items: center;
	justify-content: center;
	
}
</style>

<link href="https://fonts.googleapis.com/css?family=Jua&display=swap"
	rel="stylesheet">
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

<script>
	var $j = jQuery.noConflict();
	$(function() {
		//input을 datepicker로 선언
		$j("#datepicker1, #datepicker2").datepicker(
				{
					dateFormat : 'yy-mm-dd' //Input Display Format 변경
					,
					showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
					,
					showMonthAfterYear : true //년도 먼저 나오고, 뒤에 월 표시
					,
					changeYear : true //콤보박스에서 년 선택 가능
					,
					changeMonth : true //콤보박스에서 월 선택 가능                
					,
					showOn : "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
					,
					buttonText : "날짜선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
					,
					yearSuffix : "년" //달력의 년도 부분 뒤에 붙는 텍스트
					,
					monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8',
							'9', '10', '11', '12' ] //달력의 월 부분 텍스트
					,
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 Tooltip 텍스트
					,
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] //달력의 요일 부분 텍스트
					,
					dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일',
							'토요일' ] //달력의 요일 부분 Tooltip 텍스트
					,
					minDate : "-3M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
					,
					maxDate : "+0D" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
				});
	});

	$(function() {
		$j("#datepicker1, #datepicker2").datepicker();
	});
</script>

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
	<div class="all-container">
		<div class="container">
			<ul class="tabs">
				<a href="/adminPageMain"> <img
					src="img/adminPage/manager-logo.png" alt="매거진" class="tabs-logo"
					width="143px" height="86px" />
				</a>
				<li class="tab-link current" data-tab="tab-1">메인 창</li>
				<li class="tab-link" data-tab="tab-2">상품조회</li>
				<li class="tab-link" data-tab="tab-3">상품등록</li>
				<li class="tab-link" data-tab="tab-4">고객조회</li>
				<li class="tab-link" data-tab="tab-5">주문조회</li>
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
								<select name="chartIndex" class="chartIndex">
									<option value="purchaseDate">결제일</option>
									<option value="completeDate">배송완료일</option>
								</select>
							</div>
							<div class="top-interval">
								<p>
									조회기간&nbsp;&nbsp;<input type="text" id="datepicker1"
										name="datepicker1" style="height: 21px; width: 100px;">
									~ <input type="text" id="datepicker2" name="datepicker2"
										style="height: 21px; width: 100px;">
								</p>
							</div>
						</div>
						<div class="search-btn">
							<button id="chartSearchBtn">검색</button>
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
				<script type="text/javascript" src="/js/adminPage/chartAjax.js"></script>

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
				<%@include
					file="/WEB-INF/views/adminPage/customer/customerSearch.jsp"%>
			</div>

			<div id="tab-5" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/order/orderSearch.jsp"%>
			</div>

			<div id="tab-6" class="tab-content">답변관리.</div>

			<div id="tab-8" class="tab-content">
				<%@include file="/WEB-INF/views/adminPage/grade/gradeChange.jsp"%>
			</div>

			<div id="tab-9" class="tab-content">
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/js/adminPage/adminPage.js"></script>
	<script type="text/javascript" src="/js/adminPage/adminPagePrd.js"></script>
	<script type="text/javascript" src="/js/adminPage/chart.js"></script>
	<script type="text/javascript" src="/js/adminPage/prdInsert.js"></script>
	<script type="text/javascript" src="/js/adminPage/customerSearch.js"></script>
</body>
</html>