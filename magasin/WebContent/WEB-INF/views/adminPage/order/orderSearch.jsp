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
					<option>전체주문</option>
					<option>신규주문</option>
					<option>배송중</option>
					<option>배송완료</option>
					<option>취소 및 환불</option>
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

	<div class="order-bottom">
		<div class="bottom-title">
			목록 (총 <span>0</span>개)
		</div>
		<div class="bottom-list">
			<div class="list-title">
				<table>
					<tr>
						<td><input type="checkbox" id="orderAll"
							class="orderCheckBox"></td>
						<td>고객 아이디</td>
						<td>고객 이름</td>
						<td>상품 이름</td>
						<td>상품 개수</td>
						<td>주문 날짜</td>
						<td>현재 상태</td>
					</tr>
				</table>
			</div>
			<div class="list-content">
				<table>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-08-09</td>
						<td><button class="ready">발주확인</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid2</td>
						<td>name2</td>
						<td>pdt2</td>
						<td>3</td>
						<td>2019-08-09</td>
						<td><button class="ready">발주확인</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid3</td>
						<td>name3</td>
						<td>pdt3</td>
						<td>1</td>
						<td>2019-08-09</td>
						<td><button class="ready">발주확인</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-08-09</td>
						<td><button class="ready">발주확인</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid2</td>
						<td>name2</td>
						<td>pdt2</td>
						<td>3</td>
						<td>2019-08-09</td>
						<td><button class="ready">발주확인</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid3</td>
						<td>name3</td>
						<td>pdt3</td>
						<td>1</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid2</td>
						<td>name2</td>
						<td>pdt2</td>
						<td>3</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid3</td>
						<td>name3</td>
						<td>pdt3</td>
						<td>1</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid2</td>
						<td>name2</td>
						<td>pdt2</td>
						<td>3</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid3</td>
						<td>name3</td>
						<td>pdt3</td>
						<td>1</td>
						<td>2019-08-09</td>
						<td><button class="out">송장입력</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid2</td>
						<td>name2</td>
						<td>pdt2</td>
						<td>3</td>
						<td>2019-08-09</td>
						<td><button class="look">송장조회</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid3</td>
						<td>name3</td>
						<td>pdt3</td>
						<td>1</td>
						<td>2019-08-09</td>
						<td><button class="look">송장조회</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid1</td>
						<td>name1</td>
						<td>pdt1</td>
						<td>2</td>
						<td>2019-08-09</td>
						<td><button class="look">송장조회</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid2</td>
						<td>name2</td>
						<td>pdt2</td>
						<td>3</td>
						<td>2019-08-09</td>
						<td><button class="look">송장조회</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="orderCheckBox"></td>
						<td>idid3</td>
						<td>name3</td>
						<td>pdt3</td>
						<td>1</td>
						<td>2019-08-09</td>
						<td><button class="look">송장조회</button></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>