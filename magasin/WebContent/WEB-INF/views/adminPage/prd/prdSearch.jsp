<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    	
    </style>
<script type="text/javascript"
   src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <div class="searchmain">
              <i class="fas fa-list"></i><span> 상품 조회 및 수정/삭제</span>
              <br><br>
              
              <div class="searchmain1">
              <div class="search1">
                  
                  <div class="searchname">
                          <i class="far fa-plus-square"></i><span> 상품명으로 조회</span>
                  </div>  
                  <div class="searchname-1">
                      
                  </div>
                  <div class="searchname-2">
                      <input type="text" id="productnamesearch" name="productnamesearch">
                  </div>
                  
              </div>
              <br>
              <div class="search2">
                  <div class="searchcategory">
                       <i class="far fa-plus-square"></i><span> 카테고리로 조회</span>
                  </div>
                  <div class="searchcategory2">
                      <select id="category1" name="prdCtgr">
                      	  <option selected="selected">-선택-</option>                  
                          <option value="outer_w">여성 아우터</option>
                          <option value="outer_m">남성 아우터</option>
                          <option value="top_w">여성 상의</option>
                          <option value="top_m">남성 상의</option>
                          <option value="bottom_w">여성 하의</option>
                          <option value="bottom_m">남성 하의</option>
                          
                          <option value="dress">드레스</option>
                          <option value="bag">가방</option>
                          <option value="shoes">신발</option>
                          <option value="acc">악세사리</option>
                          
                          <option value="common">기타</option>
							
                      </select>
                  </div>
                  <div class="searchcategory3">
                      <span id="sebuspan">세부 카테고리 선택</span>
                      <select id="categorysemi1" name="prdSubCtrg">
                          <option selected="selected">-선택-</option>
                         <!-- outer -->
                          <option value="jacket">자켓</option>
                          <option value="coats">코트</option>
                          <option value="cardigan">가디건</option>
                          <option value="etc">기타</option>
                          <!-- woman top -->
                          <option value="t">티셔츠</option>

                          <option value="blouse">블라우스</option>
                          <option value="etc">etc</option>
                          <!-- man top -->
                          <option value="t">티셔츠</option>
                          <option value="shirts">셔츠</option>
                          <option value="etc">etc</option>
                          <!-- woman bottom -->
                          <option value="pants">여자바지</option>
                          <option value="skirt">스커트</option>
                          <option value="etc">etc</option>
                          <!-- man bottom -->
                          <option value="slacks">슬랙스</option>
                          <option value="jeans">청바지</option>

                          <option value="etc">etc</option>
                          <!-- common  -->
                          <option value="bag">가방</option>
                          <option value="shoes">신발</option>
                          <option value="acc">악세사리</option>
                          <!-- woman dress -->
                          <option value="dress">드레스</option>

                             
                      </select>
                    
                  </div>  
              </div>
              <br>
              
              <div class="search3">
                  <i class="far fa-calendar-alt"></i><span> 상품등록일로 조회</span>
              
              <div class="searchbutton">
                   <input id="prddatesearch" name="prddatesearch" type="hidden" />
                    <button value="7" type="button">1주일</button>
					<button value="14" type="button">2주일</button>
				    <button value="30" type="button">1달</button>
				    <button value="90" type="button">3달</button>
                    <button value="1000" type="button">전체기간</button>
              </div>
              </div>
              <br>
              <div class="search4">
                  <button id="searchbtn"><i class="fas fa-search"></i></button>
              </div>
          </div>
         
              <br>
              <div class="searchmain2">
                  <table class="productlisttable" >
                      <tr>
                          <th colspan="11" style="font-size:20px; font-weight:bold">상품 조회 테이블</th>
                      </tr>

                      <tr class="productlisttabletr">
                          <th style="width: 9%;">상품 번호</th>
                          <th style="width: 10%;">상품 이름</th>
                          <th style="width: 10%;">상품 성별</th>
                          <th style="width: 17%;">상품 카테고리</th>
                          <th style="width: 16%;">상품 세부카테고리</th>
                          <th style="width: 9%;">상품 가격</th>
                          <th style="width: 17%;">상품 업로드일</th>
                          <th style="width: 6%;">수정</th>
                          <th style="width: 6%;">삭제</th><!-- 버튼에다가 온클릭 걸어서 딜리트 프로덕트 아이디 넘겨서 삭제 ㅇㅋ? ㅇㅋ -->
                      </tr>        	  
                  </table>
                  
                  <table class="productlisttable" id = "prdresult">
                  	<tbody>
                  		
                  	</tbody>
                  </table>
              </div>
          </div> 
          
          
          
          <script>
          
             $("#category1").change(function(){
                var state = $('#category1 option:selected').val();
                $("#categorysemi1").show();
                if(state == 'outer_m'){
          			$('#categorysemi1 >option').show();
          			$('#categorysemi1 option:eq(0)').prop("selected",true);
          			$('#categorysemi1 option:eq(5)').hide();
          			$('#categorysemi1 option:eq(6)').hide();
          			$('#categorysemi1 option:eq(7)').hide();
          			$('#categorysemi1 option:eq(8)').hide();
          			$('#categorysemi1 option:eq(9)').hide();
          			$('#categorysemi1 option:eq(10)').hide();
          			$('#categorysemi1 option:eq(11)').hide();
          			$('#categorysemi1 option:eq(12)').hide();
          			$('#categorysemi1 option:eq(13)').hide();
          			$('#categorysemi1 option:eq(14)').hide();
          			$('#categorysemi1 option:eq(15)').hide();
          			$('#categorysemi1 option:eq(16)').hide();
          			$('#categorysemi1 option:eq(17)').hide();
          			$('#categorysemi1 option:eq(18)').hide();
          			$('#categorysemi1 option:eq(19)').hide();
          			$('#categorysemi1 option:eq(20)').hide();
          		}if(state == 'top_m'){
          			$('#categorysemi1 >option').show();
          			$('#categorysemi1 option:eq(0)').prop("selected",true);
          			$('#categorysemi1 option:eq(1)').hide();
          			$('#categorysemi1 option:eq(2)').hide();
          			$('#categorysemi1 option:eq(3)').hide();
          			$('#categorysemi1 option:eq(4)').hide();
          			$('#categorysemi1 option:eq(5)').hide();
          			$('#categorysemi1 option:eq(6)').hide();
          			$('#categorysemi1 option:eq(7)').hide();
          			$('#categorysemi1 option:eq(11)').hide();
          			$('#categorysemi1 option:eq(12)').hide();
          			$('#categorysemi1 option:eq(13)').hide();
          			$('#categorysemi1 option:eq(14)').hide();
          			$('#categorysemi1 option:eq(15)').hide();
          			$('#categorysemi1 option:eq(16)').hide();
          			$('#categorysemi1 option:eq(17)').hide();
          			$('#categorysemi1 option:eq(18)').hide();
          			$('#categorysemi1 option:eq(19)').hide();
          		}if(state == 'bottom_m'){
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
          			$('#categorysemi1 option:eq(10)').hide();
          			$('#categorysemi1 option:eq(11)').hide();
          			$('#categorysemi1 option:eq(12)').hide();
          			$('#categorysemi1 option:eq(13)').hide();
          			$('#categorysemi1 option:eq(17)').hide();
          			$('#categorysemi1 option:eq(18)').hide();
          			$('#categorysemi1 option:eq(19)').hide();
          			$('#categorysemi1 option:eq(20)').hide();
          		}if(state == 'bag'){
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
                    $('#categorysemi1 option:eq(10)').hide();
                    $('#categorysemi1 option:eq(11)').hide();
                    $('#categorysemi1 option:eq(12)').hide();
                    $('#categorysemi1 option:eq(13)').hide();
                    $('#categorysemi1 option:eq(14)').hide();
                    $('#categorysemi1 option:eq(15)').hide();
                    $('#categorysemi1 option:eq(16)').hide();
                    $('#categorysemi1 option:eq(18)').hide();
                    $('#categorysemi1 option:eq(19)').hide();   
                    $('#categorysemi1 option:eq(20)').hide();
                 }if(state == 'shoes'){
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
                    $('#categorysemi1 option:eq(10)').hide();
                    $('#categorysemi1 option:eq(11)').hide();
                    $('#categorysemi1 option:eq(12)').hide();
                    $('#categorysemi1 option:eq(13)').hide();
                    $('#categorysemi1 option:eq(14)').hide();
                    $('#categorysemi1 option:eq(15)').hide();
                    $('#categorysemi1 option:eq(16)').hide();
                    $('#categorysemi1 option:eq(17)').hide();
                    $('#categorysemi1 option:eq(19)').hide();   
                    $('#categorysemi1 option:eq(20)').hide();
                 }if(state == 'acc'){
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
                    $('#categorysemi1 option:eq(10)').hide();
                    $('#categorysemi1 option:eq(11)').hide();
                    $('#categorysemi1 option:eq(12)').hide();
                    $('#categorysemi1 option:eq(13)').hide();
                    $('#categorysemi1 option:eq(14)').hide();
                    $('#categorysemi1 option:eq(15)').hide();
                    $('#categorysemi1 option:eq(16)').hide();
                    $('#categorysemi1 option:eq(17)').hide();   
                    $('#categorysemi1 option:eq(18)').hide();
                    $('#categorysemi1 option:eq(20)').hide();
                 

                 }if(state == 'outer_w'){

                    $('#categorysemi1 >option').show();
                    $('#categorysemi1 option:eq(0)').prop("selected",true);
                    $('#categorysemi1 option:eq(5)').hide();
                    $('#categorysemi1 option:eq(6)').hide();
                    $('#categorysemi1 option:eq(7)').hide();
                    $('#categorysemi1 option:eq(8)').hide();
                    $('#categorysemi1 option:eq(9)').hide();
                    $('#categorysemi1 option:eq(10)').hide();
                    $('#categorysemi1 option:eq(11)').hide();
                    $('#categorysemi1 option:eq(12)').hide();
                    $('#categorysemi1 option:eq(13)').hide();
                    $('#categorysemi1 option:eq(14)').hide();
                    $('#categorysemi1 option:eq(15)').hide();
                    $('#categorysemi1 option:eq(16)').hide();
                    $('#categorysemi1 option:eq(17)').hide();
                    $('#categorysemi1 option:eq(18)').hide();
                    $('#categorysemi1 option:eq(19)').hide();   
                    $('#categorysemi1 option:eq(20)').hide();
                 }if(state == 'top_w'){
                    $('#categorysemi1 >option').show();
                    $('#categorysemi1 option:eq(0)').prop("selected",true);
                    $('#categorysemi1 option:eq(1)').hide();
                    $('#categorysemi1 option:eq(2)').hide();
                    $('#categorysemi1 option:eq(3)').hide();
                    $('#categorysemi1 option:eq(4)').hide();
                    $('#categorysemi1 option:eq(8)').hide();
                    $('#categorysemi1 option:eq(9)').hide();
                    $('#categorysemi1 option:eq(10)').hide();
                    $('#categorysemi1 option:eq(11)').hide();
                    $('#categorysemi1 option:eq(12)').hide();
                    $('#categorysemi1 option:eq(13)').hide();
                    $('#categorysemi1 option:eq(14)').hide();
                    $('#categorysemi1 option:eq(15)').hide();
                    $('#categorysemi1 option:eq(16)').hide();
                    $('#categorysemi1 option:eq(17)').hide();
                    $('#categorysemi1 option:eq(18)').hide();
                    $('#categorysemi1 option:eq(19)').hide();
                    $('#categorysemi1 option:eq(20)').hide();
                 }if(state == 'bottom_w'){
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
                    $('#categorysemi1 option:eq(10)').hide();
                    $('#categorysemi1 option:eq(14)').hide();
                    $('#categorysemi1 option:eq(15)').hide();
                    $('#categorysemi1 option:eq(16)').hide();
                    $('#categorysemi1 option:eq(17)').hide();
                    $('#categorysemi1 option:eq(18)').hide();
                    $('#categorysemi1 option:eq(19)').hide();
                    $('#categorysemi1 option:eq(20)').hide();
                 }if(state == 'dress'){
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
                    $('#categorysemi1 option:eq(10)').hide();
                    $('#categorysemi1 option:eq(11)').hide();
                    $('#categorysemi1 option:eq(12)').hide();
                    $('#categorysemi1 option:eq(13)').hide();
                    $('#categorysemi1 option:eq(14)').hide();
                    $('#categorysemi1 option:eq(15)').hide();
                    $('#categorysemi1 option:eq(16)').hide();
                    $('#categorysemi1 option:eq(17)').hide();
                    $('#categorysemi1 option:eq(18)').hide();
                    $('#categorysemi1 option:eq(19)').hide();
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
          <script type="text/javascript" src="/js/adminPage/prdSearch.js"></script>
          <style>
              #categorysemi1{
                display:none;
            }
            .searchbutton{
           		padding-left: 5%;
         	}
         	.ssidang3 {
			    border: 0;
			    background: #0b83e6;
			    color: #fff;
			}
            .searchbutton button{
				cursor: pointer;
				height: 30px;
			    border-radius: 4px;
			}
			#category1 {
			  height: 30px;
			  border-radius: 4px;
			}
			.searchbutton{
				padding-left: 10%;
			}
			.searchcategory2{
				padding-left: 11.5%;
			}
			.searchname-2{
				padding-left: 3%;
			}
			
          </style>