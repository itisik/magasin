<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.current3 {
	border: 0;
	background: #0b83e6;
	color: #fff;
}
</style>
<div class="tab4-customer">
	<div class="customer-title">
		<i class="fas fa-users"></i>&nbsp;&nbsp;고객조회
	</div>
	<form name="customerSearch" method="post" action="customerSearch">
		<div class="customer-search">
			<div class="search-top">
				<div class="top-title">조회기간</div>
				<div class="top-select">
					<select name="searchIndex">
						<option value="none">전체기간</option>
						<option value="purchaseDate">결제일</option>
						<option value="outDate">발송일</option>
					</select>
				</div>
				<div class="top-date-select">
					<input id="dateSelect" name="dateSelect" class="dateSelect" type="hidden" />
					<button value="1w" type="button">1주일</button>
					<button value="2w" type="button">2주일</button>
					<button value="1m" type="button">1달</button>
					<button value="3m" type="button">3달</button>
				</div>
			</div>
			<div class="search-bottom">
				<div class="bottom-title">상세조건</div>
				<div class="bottom-select">
					<select name="selectIndex">
						<option value="customerName">고객 이름</option>
						<option value="customerId">고객 아이디</option>
						<option value="prdName">상품 이름</option>
						<option value="prdCount">상품 개수</option>
					</select>
				</div>
				<div class="bottom-input">
					<input name="customer" type="text">
				</div>
			</div>
			<div class="bottom-btn">
				<button type="submit">검색</button>
			</div>
		</div>
	</form>
	<div class="customer-bottom">
		<div class="bottom-title">
			목록 (총 <span>0</span>개)
		</div>
		<div class="bottom-list">
			<div class="list-title">
				<table>
					<tr>
						<td>고객 아이디</td>
						<td>고객 이름</td>
						<td>상품 이름</td>
						<td>상품 개수</td>
						<td>결제일 | 발송일</td>
					</tr>
				</table>
			</div>
			<div class="list-content">
				<table>
					<tr>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-10-15</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>