<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="tabupdate">
	<i class="fas fa-list"></i><span> 상품 수정 페이지</span> <br> <br>
	<div class="updatemain">
		<div class="updatemain1">

			<div class="updatecon1">
				<div class="updatecon1-1">
					<i class="fas fa-edit"></i><span>상품 이름 수정</span>
				</div>
				<div class="updatecon1-2">
					<input type="text">
				</div>
			</div>
			<div class="updatecon1">
				<div class="updatecon2-1">
					<i class="
                                      fas fa-edit"></i><span>상품
						성별 수정</span>
				</div>
				<div class="updatecon2-2">
					<select id="gender2">
						<option>여자</option>
						<option>남자</option>
					</select>
				</div>
			</div>

			<div class="updatecon1">
				<div class="updatecon3-1">
					<i class="fas fa-edit"></i><span>상품 카테고리 수정</span>
				</div>

				<div class="updatecon3-2">
					<select id="category2">
						<option>상의</option>
						<option>하의</option>
						<option>아우터</option>
						<option>기타</option>
					</select> <span id="sebuspan2">세부 카테고리 선택</span> <select id="categorysemi">
						<option>123</option>
						<option>456</option>
						<option>789</option>
						<option>125</option>
					</select>
				</div>
			</div>

			<div class="updatecon1">
				<div class="updatecon4-1">
					<i class="fas fa-edit"></i><span>상품 사이즈 수정</span>
				</div>
				<div class="updatecon4-2">
					<input type="text" id="updateinput1">
				</div>
			</div>

			<div class="updatecon1">
				<div class="updatecon5-1">
					<i class="fas fa-edit"></i><span>상품 재고 수정</span>
				</div>
				<div class="updatecon5-2">
					<input type="text">
				</div>
			</div>

			<div class="updatecon1">
				<div class="updatecon8-1">
					<i class="fas fa-edit"></i><span>상품 색상 수정</span>
				</div>
				<div class="updatecon8-2">
					<input type="text">
				</div>
			</div>

			<div class="updatecon1">
				<div class="updatecon6-1">
					<i class="fas fa-edit"></i><span>상품 썸네일 수정</span>
				</div>
				<div class="updatecon6-2">
					<img src="img/adminPage/ompang1.jpg" id="img-view" width="50"
						height="50">
				</div>
				<div class="updatecon6-3" id="img-viewer5">
					<input type="file">

				</div>

			</div>


			<div class="updatecon1">
				<div class="updatecon7-1">
					<i class="fas fa-edit"></i><span>상품 이미지 수정</span>
				</div>
				<div class="updatecon7-2">
					<img src="img/adminPage/ompang1.jpg" id="img-view2" width="50"
						height="50">
				</div>
				<div class="updatecon7-3" id="img-viewer6">
					<input type="file">
				</div>
			</div>


			<br>
			<div class="updatecon1">
				<div class="updatecon9-1">
					<button>수정하기</button>
					<button>목록으로</button>
				</div>
			</div>
		</div>
	</div>
</div>