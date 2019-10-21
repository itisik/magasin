<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <div class="searchmain">
              <i class="fas fa-list"></i><span> 상품 조회 및 수정/삭제</span>
              <br><br>
              <div class="searchmain1">
              <div class="search1">
                  
                  <div class="searchname">
                          <i class="far fa-plus-square"></i><span> 상품으로 조회</span>
                  </div>  
                  <div class="searchname-1">
                      <select>
                          <option>상품명으로 조회</option>
                          <option>상품번호로 조회</option>
                      </select>
                  </div>
                  <div class="searchname-2">
                      <input type="text">
                  </div>
                  <div class="searchname-3">
                      <button>검색</button>
                  </div>
              </div>
              <br>
              <div class="search2">
                  <div class="searchcategory">
                       <i class="far fa-plus-square"></i><span> 카테고리로 조회</span>
                  </div>
                  <div class="searchcategory2">
                      <select id="category1">
                          <option>상의</option>
                          <option>하의</option>
                          <option>아우터</option>
                          <option>기타</option>
                      </select>
                  </div>
                  <div class="searchcategory3">
                      <span id="sebuspan">세부 카테고리 선택</span>
                      <select id="categorysemi1">
                          <option>123</option>
                          <option>456</option>
                          <option>789</option>
                          <option>125</option>     
                      </select>
                  </div>  
              </div>
              <br>
              
              <div class="search3">
                  <i class="far fa-calendar-alt"></i><span> 기간으로 조회</span>
              
              <div class="searchcal">
                  <select id="cal">
                      <option>상품등록일</option>
                  </select>
              </div>
              <div class="searchbutton">
                  <button>오늘</button>
                  <button>1주일</button>
                  <button>1개월</button>
                  <button>3개월</button>
                  <button>전체기간</button>
              </div>
              </div>
              <br>
              <div class="search4">
                  <button id="searchbtn"><i class="fas fa-search"></i></button>
              </div>
          </div>
              <br>
              <div class="searchmain2">
                  <table class="productlisttable">
                      <tr>
                          <th colspan="11" style="font-size:20px; font-weight:bold">상품 조회 테이블</th>
                      </tr>
                      <tr class="productlisttabletr">
                          <th>상품 번호</th>
                          <th>상품 이름</th>
                          <th>상품 성별</th>
                          <th>상품 카테고리</th>
                          <th>상품 가격</th>
                          <th>상품 업로드일</th>
                          <th>상품 재고</th>
                          <th>상품 사이즈</th>
                          <th>상품 색상</th>
                          <th>수정</th>
                          <th>삭제</th>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>1</td>
                          <td>맨투맨1</td>
                          <td>여</td>
                          <td>상의</td>
                          <td>24000</td>
                          <td>2019-10-18</td>
                          <td>24</td>
                          <td>M</td>
                          <td>빨강</td>
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>2</td>
                          <td>맨투맨2</td>
                          <td>남</td>
                          <td>상의</td>
                          <td>24000</td>
                          <td>2019-10-18</td>
                          <td>24</td>
                          <td>M</td>
                          <td>노랑</td>
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>3</td>
                          <td>청바지1</td>
                          <td>여</td>
                          <td>하의</td>
                          <td>48000</td>
                          <td>2019-10-18</td>
                          <td>10</td>
                          <td>L</td>
                          <td>파랑</td>
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>4</td>
                          <td>가디건1</td>
                          <td>남</td>
                          <td>상의</td>
                          <td>39000</td>
                          <td>2019-10-18</td>
                          <td>50</td>
                          <td>XL</td>
                          <td>검정</td>
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>5</td>
                          <td>청바지2</td>
                          <td>여</td>
                          <td>하의</td>
                          <td>19000</td>
                          <td>2019-10-18</td>
                          <td>20</td>
                          <td>M</td>
                          <td>빨강</td>
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                  </table>
              </div>
          </div>   