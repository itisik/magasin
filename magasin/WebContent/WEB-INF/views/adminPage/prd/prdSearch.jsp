<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript"
   src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <div class="searchmain">
              <i class="fas fa-list"></i><span> 상품 조회 및 수정/삭제</span>
              <br><br>
              <form name="prdSearch" method="post" action="prdSearch">
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
                  
              </div>
              <br>
              <div class="search2">
                  <div class="searchcategory">
                       <i class="far fa-plus-square"></i><span> 카테고리로 조회</span>
                  </div>
                  <div class="searchcategory2">
                      <select id="category1" name="category1">
                           <option selected="selected">-선택-</option>
                          <option value="top">상의</option>
                          <option value="bottom">하의</option>
                          <option value="outter">아우터</option>
                          <option value="dress">드레스</option>
                          <option value="shirts">셔츠</option>
                          <option value="other">기타</option>
                          
                      </select>
                  </div>
                  <div class="searchcategory3">
                      <span id="sebuspan">세부 카테고리 선택</span>
                      <select id="categorysemi1" name="categorysemi1">
                           <option selected="selected">-선택-</option>
                          <option value="cardigan" name="cardigan">가디건</option>
                          <option value="leatherjacket">가죽자켓</option>
                          <option value="mantoman">맨투맨</option>
                          <option value="jean">청바지</option>
                          <option value="skirt">스커트</option>
                          <option value="jean2">면바지</option>
                          <option value="jewerly">쥬얼리</option>
                          <option value="bag">가방</option>
                          <option value="shoes">신발</option>
                          <option value="acc">기타</option>
                             
                      </select>
                    
                  </div>  
              </div>
              <br>
              
              <div class="search3">
                  <i class="far fa-calendar-alt"></i><span> 상품등록일로 조회</span>
              
              <div class="searchbutton">
                   <input id="prddatesearch" name="prddate" type="hidden" />
                  <button type="button" value="today1">오늘</button>
                  <button type="button" value="onew1">1주일</button>
                  <button type="button" value="onem1">1개월</button>
                  <button type="button" value="threem1">3개월</button>
                  <button type="button" value="allday1">전체기간</button>
              </div>
              </div>
              <br>
              <div class="search4">
                  <button id="searchbtn"><i class="fas fa-search"></i></button>
              </div>
          </div>
          </form>
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
                          <th>상품 세부카테고리</th>
                          <th>상품 가격</th>
                          <th>상품 업로드일</th>
                          
                          <th>수정</th>
                          <th>삭제</th><!-- 버튼에다가 온클릭 걸어서 딜리트 프로덕트 아이디 넘겨서 삭제 ㅇㅋ? ㅇㅋ -->
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>1</td>
                          <td>맨투맨1</td>
                          <td>여</td>
                          <td>상의</td>
                          <td>맨투맨</td>
                          <td>24000</td>
                          <td>2019-10-18</td>
                          
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>2</td>
                          <td>맨투맨2</td>
                          <td>남</td>
                          <td>상의</td>
                          <td>맨투맨</td>
                          <td>24000</td>
                          <td>2019-10-22</td>
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>3</td>
                          <td>청바지1</td>
                          <td>여</td>
                          <td>하의</td>
                          <td>청바지</td>
                          <td>48000</td>
                          <td>2019-10-18</td>
                         
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>4</td>
                          <td>가디건1</td>
                          <td>남</td>
                          <td>상의</td>
                          <td>가디건</td>
                          <td>39000</td>
                          <td>2019-10-18</td>
                          
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                      <tr class="productlisttabletr2">
                          <td>5</td>
                          <td>청바지2</td>
                          <td>여</td>
                          <td>하의</td>
                          <td>가디건</td>
                          <td>19000</td>
                          <td>2019-10-18</td>
                        
                          <td><button class="prdModify" class="updatetete"  data-tab="tab-9">수정</button></td>
                          <td><button class="updatetete">삭제</button></td>
                      </tr>
                  </table>
              </div>
          </div>  
          
          
          <script>
          
             $("#category1").change(function(){
                var state = $('#category1 option:selected').val();
                $("#categorysemi1").show();
                
                if(state == 'top'){
                   $('#categorysemi1 >option').show();
                   $('#categorysemi1 option:eq(0)').prop("selected",true);
                   $('#categorysemi1 option:eq(4)').hide();
                   $('#categorysemi1 option:eq(5)').hide();
                   $('#categorysemi1 option:eq(6)').hide();
                   $('#categorysemi1 option:eq(7)').hide();
                   $('#categorysemi1 option:eq(8)').hide();
                   $('#categorysemi1 option:eq(9)').hide();
                   $('#categorysemi1 option:eq(10)').hide();
                   
                }else if(state == 'bottom'){
                   $('#categorysemi1 >option').show();
                   $('#categorysemi1 option:eq(0)').prop("selected",true);
                   $('#categorysemi1 option:eq(1)').hide();
                   $('#categorysemi1 option:eq(2)').hide();
                   $('#categorysemi1 option:eq(3)').hide();
                   $('#categorysemi1 option:eq(7)').hide();
                   $('#categorysemi1 option:eq(8)').hide();
                   $('#categorysemi1 option:eq(9)').hide();
                   $('#categorysemi1 option:eq(10)').hide();
                }else if(state == 'outter'){
                   $('#categorysemi1 >option').show();
                   $('#categorysemi1 option:eq(0)').prop("selected",true);
                   $('#categorysemi1 option:eq(3)').hide();
                   $('#categorysemi1 option:eq(4)').hide();
                   $('#categorysemi1 option:eq(5)').hide();
                   $('#categorysemi1 option:eq(6)').hide();
                   $('#categorysemi1 option:eq(7)').hide();
                   $('#categorysemi1 option:eq(8)').hide();
                   $('#categorysemi1 option:eq(9)').hide();
                   $('#categorysemi1 option:eq(10)').hide();
                }else if(state == 'dress'){
                   $('#categorysemi1 >option').show();
                   $('#categorysemi1 option:eq(0)').prop("selected",true);
                   $('#categorysemi1 option:eq(1)').hide();
                   $('#categorysemi1 option:eq(2)').hide();
                   $('#categorysemi1 option:eq(3)').hide();
                   $('#categorysemi1 option:eq(4)').hide();
                   $('#categorysemi1 option:eq(6)').hide();
                   $('#categorysemi1 option:eq(7)').hide();
                   $('#categorysemi1 option:eq(8)').hide();
                   $('#categorysemi1 option:eq(9)').hide();
                   $('#categorysemi1 option:eq(10)').hide();
                }else if(state == 'shirts'){
                   $('#categorysemi1 >option').show();
                   $('#categorysemi1 option:eq(0)').prop("selected",true);
                   $('#categorysemi1 option:eq(1)').hide();
                   $('#categorysemi1 option:eq(2)').hide();
                   $('#categorysemi1 option:eq(3)').hide();
                   $('#categorysemi1 option:eq(4)').hide();
                   $('#categorysemi1 option:eq(5)').hide();
                   $('#categorysemi1 option:eq(6)').hide();
                   $('#categorysemi1 option:eq(7)').hide();
                   $('#categorysemi1 option:eq(8)').hide();
                   $('#categorysemi1 option:eq(9)').hide();
                
                }else if(state == 'other'){
                   $('#categorysemi1 >option').show();
                   $('#categorysemi1 option:eq(0)').prop("selected",true);
                   $('#categorysemi1 option:eq(1)').hide();
                   $('#categorysemi1 option:eq(2)').hide();
                   $('#categorysemi1 option:eq(3)').hide();
                   $('#categorysemi1 option:eq(4)').hide();
                   $('#categorysemi1 option:eq(5)').hide();
                   $('#categorysemi1 option:eq(6)').hide();
                   
                }
             });    
             
             $(document).ready(function(){
                $("div.searchbutton button").click(function(){
                   $("div.searchbutton button").removeClass("ssidang3");
                   $(this).addClass("ssidang3");
                   $("#prddatesearch").val($(this).val());
                });
             });
          </script> 
          <style>
              #categorysemi1{
                display:none;
            }
            .searchbutton{
            padding-left: 5%;
         }
            
          </style>