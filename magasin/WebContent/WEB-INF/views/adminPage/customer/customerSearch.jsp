<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tab4-customer">
	<div class="customer-title">
		<i class="fas fa-users"></i>&nbsp;&nbsp;고객조회
	</div>
	<div class="customer-search">
		<div class="search-top">
			<div class="top-title">조회기간</div>
			<div class="top-select">
				<select name="searchIndex" class="searchIndex">
					<option value="none">--선택--</option>
					<option value="all">전체기간</option>
					<option value="purchaseDate">결제일</option>
					<option value="outDate">발송일</option>
				</select>
			</div>
			
			<div class="top-date-select" style="display: none;">
				<input id="dateSelect" name="dateSelect" class="dateSelect" type="hidden" />
				<button value="7" type="button">1주일</button>
				<button value="14" type="button">2주일</button>
				<button value="30" type="button">1달</button>
				<button value="90" type="button">3달</button>
			</div>
		</div>
		<div class="search-bottom">
			<div class="bottom-title">상세조건</div>
			<div class="bottom-select">
				<select name="selectIndex">
					<option value="customerName">고객 이름</option>
					<option value="customerId">고객 아이디</option>
					<option value="prdName">구매상품이름</option>
				</select>
			</div>
			<div class="bottom-input">
				<input name="customer" type="text" />
			</div>
		</div>
		<div class="bottom-btn">
			<button id="customerSearchBtn" type="submit">검색</button>
		</div>
		
	</div>
	<div class="customer-bottom">
		<div class="bottom-title">
			<div>목록 (총 <span id="countList">0</span>개)</div>
		</div>
		<div class="bottom-list">
			<div class="list-title">
				<table>
					<thead>
						<tr>
							<td style='width: 10%;'>고객아이디</td>
							<td style='width: 10%;'>고객이름</td>
							<td style='width: 10%;'>고객성별</td>
							<td style='width: 30%;'>고객주소</td>
							<td style='width: 10%;'>연락처</td>
							<td style='width: 10%;'>생년월일</td>
							<td style='width: 20%;'>이메일</td>
						</tr>
					</thead>
				</table>
			</div>
			<div class="list-content">
				<table id="customersResult">
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="/js/adminPage/customerAjax.js"></script>

<script>
	$(".searchIndex").change(function() {
		var isAll = $(".searchIndex>option:selected").val();
		if (isAll != "all" && isAll != "none") {
			$(".top-date-select").show();
		} else {
			$(".top-date-select").hide();
		}
	});
</script>