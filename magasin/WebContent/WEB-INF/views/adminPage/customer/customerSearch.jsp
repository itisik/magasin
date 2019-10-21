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
				<select>
					<option>결제일</option>
					<option>발송일</option>
				</select>
			</div>
			<div class="top-date-select">
				<button>1주일</button>
				<button>2주일</button>
				<button>1달</button>
				<button>3달</button>
			</div>
		</div>
		<div class="search-bottom">
			<div class="bottom-title">상세조건</div>
			<div class="bottom-select">
				<select>
					<option>고객 이름</option>
					<option>고객 아이디</option>
					<option>상품 이름</option>
					<option>상품 개수</option>
				</select>
			</div>
			<div class="bottom-input">
				<input type="text">
			</div>
		</div>
		<div class="bottom-btn">
			<button>검색</button>
		</div>
	</div>
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