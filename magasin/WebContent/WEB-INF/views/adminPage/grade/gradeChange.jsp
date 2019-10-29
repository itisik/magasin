<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="tab8-title">
	<i class="fas fa-medal"></i>&nbsp;&nbsp;등급관리
</div>
<div class="tab8-search">
	<div class="search-top">
	</div>
	<div class="search-bottom">
		<div class="bottom-title">검색조건</div>
		<div class="bottom-select">
			<select name = "memberCondition" class = "memberCondition">
				<option value = "none">--선택--</option>
				<option value = "customerName">고객이름</option>
				<option value = "customerId">고객아이디</option>
				<option value = "totalMoney">총구매금액</option>
				<option value = "totalCount">총구매횟수</option>
			</select>
		</div>
		<div class="bottom-input">
			<input name = "memberKeyword" id="memberKeyword" type="text" />
			<div class="upCon" style = "display: none;">&nbsp;&nbsp;이상</div>
		</div>
	</div>
	<div class="search-btn">
		<button id="memberSearchBtn" type="submit">검색</button>
	</div>
</div>
<div class="tab8-content">
	<div class="content-title">
		목록 (총 <span id="memberList">0</span>개)
	</div>
	<div class="content-list">
		<div class="list-title">
			<table>
				<tr>
					<td>고객 아이디</td>
					<td>고객 이름</td>
					<td>총 구매금액</td>
					<td>총 구매횟수</td>
					<td>회원가입일</td>
					<td>최근결제일</td>
					<td>등급</td>
					<td>등급변경</td>
				</tr>
			</table>
		</div>
		<div class="list-content">
			<table id="memberResult">
				<tr>
					<td>idid1</td>
					<td>name1</td>
					<td>238000</td>
					<td>3</td>
					<td>2019-10-01</td>
					<td>2019-10-15</td>
					<td>
					<select name = "memberGrade" class = "memberGrade">
						<option value = "none">--선택--</option>
						<option value = "admin">admin</option>
						<option value = "member">member</option>
					</select>
					</td>
					<td><button>등급변경</button></td>
				</tr>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript" src="/js/adminPage/memberAjax.js"></script>

<script>
	$(".memberCondition").change(function() {
		var isUp = $(".memberCondition>option:selected").val();
		if (isUp == "totalMoney" || isUp == "totalCount") {
			$(".upCon").show();
		} else {
			$(".upCon").hide();
		}
	});
</script>