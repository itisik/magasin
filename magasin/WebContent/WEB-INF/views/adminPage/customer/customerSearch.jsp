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
					<option>---선택---</option>
					<option value="none">전체기간</option>
					<option value="purchaseDate">결제일</option>
					<option value="outDate">발송일</option>
				</select>
			</div>
			<div class="top-date-select" style="display: none;">
				<input id="dateSelect" name="dateSelect" class="dateSelect"
					type="hidden" />
				<button value="99999" type="button">전체기간</button>
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
			목록 (총 <span>0</span>개)
		</div>
		<div class="bottom-list">
			<div class="list-title">
				<table>
					<thead>
						<tr>
							<td><input type="checkbox"></td>
							<td>고객 아이디</td>
							<td>고객 이름</td>
							<td>상품 이름</td>
							<td>상품 개수</td>
							<td>결제일</td>
							<td>발송일</td>
							<td>배송완료일</td>
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
