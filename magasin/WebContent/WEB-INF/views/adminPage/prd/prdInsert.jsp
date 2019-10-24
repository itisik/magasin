<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<div class="enter1">
             <table class="producttable">
                 <legend><b>상품등록</b></legend>
              <tr>
                  <th>
                      <div class="thdiv">
                          <i class="far fa-plus-square"></i><span> 상품명</span>
                      </div>    
                  </th>
                 
                  <td>
                      <input type="text" id="product-input" class="productinput">
                  </td>
              </tr>    
              
              <tr>
              
                  <th>
                      <div class="thdiv">
                              <i class="fas fa-venus-mars"></i><span> 상품 성별</span>
                      </div>
                  </th>
                  <td>
                      <select id="gender">
                          <option>여자</option>
                          <option>남자</option>
                      </select>
                  </td>
              </tr> 
                 
              <tr>
                  <th>
                      <div class="thdiv">
                          <i class="fas fa-align-justify"></i><span>상품 카테고리 선택</span>
                      </div> 
                  </th> 
                  <td>
                      <select id="category">
                          <option>상의</option>
                          <option>하의</option>
                          <option>아우터</option>
                          <option>기타</option>
                      </select>
                      <div id="asdfasdfasdf">
                      <span id="sebuspan1">세부 카테고리 선택</span>
                      <select id="categorysemi2">
                          <option>123</option>
                          <option>456</option>
                          <option>789</option>
                          <option>125</option>     
                      </select>
                      </div>    
                  </td>
              </tr>
              <tr>
                  <th>
                      <div class="thdiv">
                          <i class="fas fa-won-sign"></i><span>상품 가격 설정</span>  
                      </div>
                  </th>   
                  <td>
                       <input type="text" id="priceinput" class="productinput">
                  </td>
              </tr>
              <div id="thumbnaildiv">
              <tr id="thumbnail">
                  <th id="thimg1">
                      <div class="thdiv">
                          <i class="fas fa-camera"></i><span>상품 썸네일 업로드</span>
                      </div>
                  </th>
                  <td id="tdimg1">
                      <input type="file" name="filesumname" onchange="loadImg2(this)"
                             id="estsetse">
                      <div id="img-viewer">
                  <img id="img-view" width="50" height="50">
                      </div>
                  </td>
              </tr>   
              </div>
              <div id="productpicturediv">
              <tr id="productpicture">
                  <th id="thimg2">
                      <div class="thdiv">
                          <i class="far fa-image" ></i><span>상품 사진 업로드</span>
                      </div>
                  </th> 
                  <td id="tdimg2">
                      <input type="file" name="filename" onchange="loadImg(this)" id="imgfile5">
                      <div id="img-viewer2">
                          <img id="img-view2" width="50" height="50">
                      </div>
                  </td>
              </tr>
              </div>    
  
              </table>
              
          </div>
          <div class="enter1">
              <table class="producttable">
                  <legend>상품 상세 등록</legend>
                  <tr name="addoptiontr">
                      <th id="thdiv1">
                          <div class="thdiv">
                          <i class="fas fa-cubes"></i><span>상품 옵션 입력</span>
                          </div>
                      </th>
                      <td>  
                          옵션명 : 
                          <input type="text" id="optioncolor" class="productinput" placeholder="예시 : 컬러" name="optioncolor">         
                          옵션값 : 
                          <input type="text" id="optionvalue" class="productinput" placeholder="예시 : 빨강,노랑 (,로 구분)" name="optionvalue">
                          <button name="addoption" id="addoption"> + </button>
                          <br>
                          
                          
                      </td> 
                     
                  </tr>
                 
                  <tr>
                      <th>
                      
                      </th>
                      <td>
                          <button name="activeoption" id="activeoption">옵션 목록으로 적용</button>
                      </td>    
                  </tr>
              </table>  
              
              <br>
              <div class="enter1" id="optiondiv">
              <table class="optiontable">
              <tr>
                  <th style='width: 5%' id="thoption1"><input type="checkbox"></th>
                  <th>Month</th>
                  <th style='width: 50%' id="thoption2">재고 수량 변경</th>
                  <th style='width: 5%'>삭제</th>
              </tr>
              <tr>
                  <td style="width: 5%" ><input type="checkbox"></td>
                  <td>January</td>
                  <td style='width: 50%'><input type="text" style="width: 99%; "></td>
                  <td style='width: 5%'>$50</td>
              </tr>
              
              </table>
              </div>
              
              
            </div>
            
            <script>
            	function loadImg(value){
            		if(value.files && value.files[0]){
            			var reader = new FileReader();
            			reader.onload = function(e){
            				$('#img-view2').attr('src',e.target.result);
            				
            			}
            			reader.readAsDataURL(value.files[0]);
            		}
            	}
            	
            	function loadImg2(value){
            		if(value.files && value.files[0]){
            			var reader = new FileReader();
            			reader.onload = function(e){
            				$('#img-view').attr('src',e.target.result);
            				
            			}
            			reader.readAsDataURL(value.files[0]);
            		}
            	}
            </script>