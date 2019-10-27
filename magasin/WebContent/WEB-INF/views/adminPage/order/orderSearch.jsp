<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="tab5-order">
	<div class="order-top">
		<div class="top-title">
			<i class="fas fa-list"></i>&nbsp;&nbsp;&nbsp;주문조회
		</div>
	</div>

	<div class="order-view">
		<div class="view0-title">
			<i class="fas fa-store"></i>&nbsp;전체주문&nbsp;<a href="#"><span>64</span></a>건
		</div>
		<div class="view0-content"></div>
		<div class="view1-title">
			<i class="fas fa-box-open"></i>&nbsp;신규주문&nbsp;<a href="#"><span>11</span></a>건
		</div>
		<div class="view1-content"></div>
		<div class="view2-title">
			<i class="fas fa-shipping-fast"></i>&nbsp;배송중&nbsp;<a href="#"><span>20</span></a>건
		</div>
		<div class="view2-content"></div>
		<div class="view3-title">
			<i class="fas fa-people-carry"></i>&nbsp;배송완료&nbsp;<a href="#"><span>32</span></a>건
		</div>
		<div class="view3-content"></div>
		<div class="view4-title">
			<i class="fas fa-ban"></i>&nbsp;취소|<i class="fas fa-undo-alt"></i>환불요청&nbsp;<a
				href="#"><span>1</span></a>건
		</div>
		<div class="view4-content"></div>
	</div>

	<div class="order-search">
		<div style="text-align: right;"> ※ 배송완료된 주문건의 경우, 배송완료일로부터 14일간만 조회됩니다.</div>
		<div class="search-top">
			<div class="top-title">조회기간</div>
			<div class="top-select">
				<select name="timeIndex" class="timeIndex">
					<option value="none2">--선택--</option>
					<option value="all2">전체기간</option>
					<option value="purchaseDate2">결제일</option>
					<option value="outDate2">발송일</option>
				</select>
			</div>
			<div class="top-date-select" style="display: none;">
				<input id="dateSelect2" name="dateSelect2" class="dateSelect2" type="hidden" />
				<button value="7" type="button">1주일</button>
				<button value="14" type="button">2주일</button>
				<button value="30" type="button">1달</button>
				<button value="90" type="button">3달</button>
			</div>
		</div>

		<div class="search-bottom">
			<div class="bottom-title">상세조건</div>
			<div class="bottom-select">
				<select name="detailIndex">
					<option value = "allOrder">전체주문</option>
					<option value = "1">신규주문</option>
					<option value = "0">취소요청</option>
					<option value = "-1">주문취소완료</option>
					<option value = "2">배송준비중</option>
					<option value = "3">배송중</option>
					<option value = "4">배송완료</option>
					<option value = "5">반품신청</option>
					<option value = "6">반품중</option>
					<option value = "7">반품완료</option>
					<option value = "customerName2">고객 이름</option>
					<option value = "customerId2">고객 아이디</option>
					<option value = "prdName2">구매상품이름</option>
				</select>
			</div>
			<div class="bottom-input">
				<input name="order" type="text" />
			</div>
		</div>
		<div class="search-btn">
			<button id="orderSearchBtn">검색</button>
		</div>
	</div>

	<div class="order-bottom">
		<div class="bottom-title">
			<div>목록 (총 <span id="countList2">0</span>개)</div>
			<div>일괄처리</div>
		</div>
		<div class="bottom-list">
			<div class="list-title">
				<table>
					<tr>
						<td>
						<input type="checkbox" id="orderAll"
							class="orderCheckBox">
						</td>
						<td>고객아이디</td>
						<td>고객이름</td>
						<td>상품이름</td>
						<td>상품개수</td>
						<td>결제일시</td>
						<td>발송일시</td>
						<td>배송완료일시</td>
						<td>현재 상태</td>
					</tr>
				</table>
			</div>
			<div class="list-content">
				<table id="orderResult" >
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-08-09</td>
						<td>2019-08-10</td>
						<td>2019-08-19</td>
						<td><button class="status" value="">발주확인</button></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="/js/adminPage/orderAjax.js"></script>

<script>
	$(".timeIndex").change(function() {
		var isAll = $(".timeIndex>option:selected").val();
		if (isAll != "all2" && isAll != "none2") {
			$(".top-date-select").show();
		} else {
			$(".top-date-select").hide();
		}
	});
</script>