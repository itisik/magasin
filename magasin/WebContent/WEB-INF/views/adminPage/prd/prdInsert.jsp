<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    <script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<div>
	<form method="post" action="/prdInsert" enctype="multipart/form-data" name="myForm">
	<div class="enter1">
			
             <table class="producttable">
                 <legend> <i class="fas fa-list"></i><b>상품등록</b></legend>
              <tr>
                  <th>
                      <div class="thdiv">
                          <i class="far fa-plus-square"></i><span> 상품명</span>
                      </div>    
                  </th>
                 
                  <td>
                      <input type="text" id="product-input" class="productinput" name="prdName">
                  </td>
              </tr>    
              
              <tr>
              
                  <th>
                      <div class="thdiv">
                              <i class="fas fa-venus-mars"></i><span> 상품 성별</span>
                      </div>
                  </th>
                  <td>
                      <select id="gender" name="prdGender">
                          <option value="여">여자</option>
                          <option value="남">남자</option>
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
                      <select id="category" name="prdCtgr">
                          <option selected="selected">-선택-</option>
                          <option value="상의">상의</option>
                          <option value="하의">하의</option>
                          <option value="아우터">아우터</option>
                          <option value="드레스">드레스</option>
                          <option value="셔츠">셔츠</option>
                          <option value="기타">기타</option>
                      </select>
                      
                      <span id="sebuspan1">세부 카테고리 선택</span>
                      <select id="categorysemi2" name="prdSubCtrg">
                          <option selected="selected">-선택-</option>
                          <option value="가디건" name="cardigan">가디건</option>
                          <option value="가죽자켓">가죽자켓</option>
                          <option value="맨투맨">맨투맨</option>
                          <option value="청바지">청바지</option>
                          <option value="스커트">스커트</option>
                          <option value="면바지">면바지</option>
                          <option value="쥬얼리">쥬얼리</option>
                          <option value="가방">가방</option>
                          <option value="신발">신발</option>
                          <option value="기타">기타</option>
                      </select>
                      
                  </td>
              </tr>
              <tr>
                  <th>
                      <div class="thdiv">
                          <i class="fas fa-won-sign"></i><span>상품 가격 설정</span>  
                      </div>
                  </th>   
                  <td>
                       <input type="text" id="priceinput" class="productinput" name="prdPrice">
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
                      <input type="file" name="prdSnImgname" onchange="loadImg2(this)"
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
                      <input type="file" name="prdImgname" onchange="loadImg(this)" id="imgfile5">
                      <div id="img-viewer2">
                          <img id="img-view2" width="50" height="50">
                      </div>
                  </td>
              </tr>
              </div>    
  
              </table>
              
          </div>
          <div class="enter1">
           <i class="fas fa-list"></i><span> 상품 옵션 등록</span>
          	<div>
          		<input type="text" name="size" id="input1" placeholder="상품 사이즈 입력 ex) S,M,L" style="width:300px;">
          		<input type="text" name="color" id="input2" placeholder="상품 컬러 입력 ex) red,black,white" style="width:300px;">
          		<button id="btn1" type="button">상품 재고 입력하기</button>
          		<button id="prdinsert">상품등록하기!!!!</button>
          		<table id="tbl" border="1">
          		
          			<tbody>
          				
          			</tbody>
          		
          		</table>
          	</div>   
          </div>
          <input type="hidden" name="length1" id="length1" class="length1">
          <input type="hidden" name="length2" id="length2" class="length2">
            </form>
            </div>
            
            <script>
            	$("#btn1").click(function(){
            		var text1 = $("#input1").val();
            		var text2 = $("#input2").val();
            		
            		var textArr1 = text1.split(",");
            		var textArr2 = text2.split(",");

            		$(".length1").val(textArr1.length);
            		//val()
            		$(".length2").val(textArr2.length);
            		//val()
            		
            		var length = $("#length").val();
            		
            		var index1 = 0;
            		var index2 = 0;
            		var index3 = 0;
            		for(var i=0; i<textArr1.length; i++){
            			
            			var tr=$("<tr>");
            			var td=$("<td rowspan='"+textArr2.length+"'>");
            			td.html(textArr1[i]);
            			tr.append(td);
            			
            			//td1.html(textArr2[i]);
            			
            			$("#tbl>tbody").append(tr);
            			for(var j=0;j<textArr2.length;j++){
            				var sizeHidden = ("<input type='hidden'  name='sizee"+index1 +"' value='"+textArr1[i]+"'>");
                			var colorHidden = ("<input type='hidden'  name='colorr"+index1 +"' value='"+textArr2[j]+"'>");
                			var input2 = $("<input type='text' name='count"+ index1 +"' placeholder ='재고입력'>");
            				if(j==0){ 
            					//첫번째 출력은 tr을 추가할 필요가 없는데  두번째 세번째부턴 tr을 추가해야된다. 그래서 첫번째랑 두번째랑 나눈 것
            					var td2=$("<td>");
            					td2.append(textArr2[j]);
            					var td3=$("<td>");            					
            					td3.append(sizeHidden).append(colorHidden).append(input2);
            					tr.append(td2).append(td3);
            					$("#tbl>tbody").append(tr);
            				}else{
            					
            					var tr1=$("<tr>");
            					var td2=$("<td>");
            					td2.append(textArr2[j]);
            					var td3=$("<td>");            					
            					td3.append(sizeHidden).append(colorHidden).append(input2);
            					tr1.append(td2).append(td3);
            					$("#tbl>tbody").append(tr1);
            				}
            				
            				
            				index1++;
            			}
            		}
            		console.log(index1);
            		console.log(index2);
            		console.log(index3);
            		
            	});	
            
            	function mySubmit(index){
            		if(index==1){
            			document.myForm.action='/prdInsert';
            		}
            		if(index==2){
            			document.myForm.action='/prddtlInsert';
            		}
            		document.myForm.submit();
            	}
            	
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
            	
            	$("#category").change(function(){
              		var state = $('#category option:selected').val();
              		$("#categorysemi2").show();
              		
              		if(state == '상의'){
              			$('#categorysemi2 >option').show();
              			$('#categorysemi2 option:eq(0)').prop("selected",true);
              			$('#categorysemi2 option:eq(4)').hide();
              			$('#categorysemi2 option:eq(5)').hide();
              			$('#categorysemi2 option:eq(6)').hide();
              			$('#categorysemi2 option:eq(7)').hide();
              			$('#categorysemi2 option:eq(8)').hide();
              			$('#categorysemi2 option:eq(9)').hide();
              			$('#categorysemi2 option:eq(10)').hide();
              			
              		}else if(state == '하의'){
              			$('#categorysemi2 >option').show();
              			$('#categorysemi2 option:eq(0)').prop("selected",true);
              			$('#categorysemi2 option:eq(1)').hide();
              			$('#categorysemi2 option:eq(2)').hide();
              			$('#categorysemi2 option:eq(3)').hide();
              			$('#categorysemi2 option:eq(7)').hide();
              			$('#categorysemi2 option:eq(8)').hide();
              			$('#categorysemi2 option:eq(9)').hide();
              			$('#categorysemi2 option:eq(10)').hide();
              		}else if(state == '아우터'){
              			$('#categorysemi2 >option').show();
              			$('#categorysemi2 option:eq(0)').prop("selected",true);
              			$('#categorysemi2 option:eq(3)').hide();
              			$('#categorysemi2 option:eq(4)').hide();
              			$('#categorysemi2 option:eq(5)').hide();
              			$('#categorysemi2 option:eq(6)').hide();
              			$('#categorysemi2 option:eq(7)').hide();
              			$('#categorysemi2 option:eq(8)').hide();
              			$('#categorysemi2 option:eq(9)').hide();
              			$('#categorysemi2 option:eq(10)').hide();
              		}else if(state == '드레스'){
              			$('#categorysemi2 >option').show();
              			$('#categorysemi2 option:eq(0)').prop("selected",true);
              			$('#categorysemi2 option:eq(1)').hide();
              			$('#categorysemi2 option:eq(2)').hide();
              			$('#categorysemi2 option:eq(3)').hide();
              			$('#categorysemi2 option:eq(4)').hide();
              			$('#categorysemi2 option:eq(6)').hide();
              			$('#categorysemi2 option:eq(7)').hide();
              			$('#categorysemi2 option:eq(8)').hide();
              			$('#categorysemi2 option:eq(9)').hide();
              			$('#categorysemi2 option:eq(10)').hide();
              		}else if(state == '셔츠'){
              			$('#categorysemi2 >option').show();
              			$('#categorysemi2 option:eq(0)').prop("selected",true);
              			$('#categorysemi2 option:eq(1)').hide();
              			$('#categorysemi2 option:eq(2)').hide();
              			$('#categorysemi2 option:eq(3)').hide();
              			$('#categorysemi2 option:eq(4)').hide();
              			$('#categorysemi2 option:eq(5)').hide();
              			$('#categorysemi2 option:eq(6)').hide();
              			$('#categorysemi2 option:eq(7)').hide();
              			$('#categorysemi2 option:eq(8)').hide();
              			$('#categorysemi2 option:eq(9)').hide();
              		
              		}else if(state == '기타'){
              			$('#categorysemi2 >option').show();
              			$('#categorysemi2 option:eq(0)').prop("selected",true);
              			$('#categorysemi2 option:eq(1)').hide();
              			$('#categorysemi2 option:eq(2)').hide();
              			$('#categorysemi2 option:eq(3)').hide();
              			$('#categorysemi2 option:eq(4)').hide();
              			$('#categorysemi2 option:eq(5)').hide();
              			$('#categorysemi2 option:eq(6)').hide();
              			
              		}
              	});    
            </script>
            
             <style>
           	#categorysemi2{
          		display:none;
            }
            </style>

