<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="tab8-title">
	<i class="fas fa-medal"></i>&nbsp;&nbsp;등급관리
</div>
<div class="tab8-search">
	<div class="search-top">
		<div class="top-title">조회기간</div>
		<div class="top-select">
			<select>
				<option>전체기간</option>
				<option>회원가입일</option>
				<option>최근결제일</option>
				<option>첫결제일</option>
			</select>
		</div>
		<div class="top-btn">
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
				<option>고객이름</option>
				<option>고객아이디</option>
				<option>구매상품</option>
				<option>총구매금액</option>
				<option>총구매횟수</option>
			</select>
		</div>
		<div class="bottom-input">
			<input type="text" />
		</div>
	</div>
	<div class="search-btn">
		<button>검색</button>
	</div>
</div>
<div class="tab8-content">
	<div class="content-title">
		목록 (총 <span>0</span>개)
	</div>
	<div class="content-list">
		<div class="list-title">
			<table>
				<tr>
					<td><input type="checkbox"></td>
					<td>고객 아이디</td>
					<td>고객 이름</td>
					<td>총 구매금액</td>
					<td>총 구매횟수</td>
					<td>최초결제일</td>
					<td>최근결제일</td>
					<td>등급</td>
				</tr>
			</table>
		</div>
		<div class="list-content">
			<table>
				<tr>
					<td><input type="checkbox"></td>
					<td>idid1</td>
					<td>name1</td>
					<td>238000</td>
					<td>3</td>
					<td>2019-01-15</td>
					<td>2019-10-15</td>
					<td>member</td>
				</tr>
			</table>
		</div>
	</div>
</div>