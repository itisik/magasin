<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <div>
   <form method="post" action="/prdInsert" enctype="multipart/form-data" name="myForm">
   <div class="enter1">

         <style>
         .producttable{
            background-color: white;
         }
         #categorysemi2 {
           height: 30px;
           border-radius: 4px;
         }
         #legendenter ,#optionenterspan{ 
            font-size: 20px;
             font-weight: bold;
         }
         #btn1{
            height: 30px;
            width: 150px;
              border-radius: 4px;
              background-color: #4c4c4e;
              color:white;
         }
         #prdinsert{
            height: 30px;
            width: 150px;
              border-radius: 4px;
              background-color: #4c4c4e;
              color:white;
         }
         #input1,#input2{
             height: 30px;
              border-radius: 4px;
         }
         .cntinput{
            height: 20px;
             border-radius: 4px;
             background-color: #ababab;
             color : white;
         }
         .tdsize{
            padding-left: 30px;   
            color : #5D5D5D;      
         }
         .tdcolor{
            padding-left: 30px;   
            
         }
         .enter2 {
           border: 1px solid #ababab;
           width: 100%;
           background-color: white;
           padding-top: 20px;
           padding-bottom: 20px;
         }
         </style>
             <table class="producttable">
                 <legend id="legendenter"> <i class="fas fa-list"></i><b>상품등록</b></legend>
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
                    <option selected="selected">-선택-</option>
                          <option value="w">여자</option>
                          <option value="m">남자</option>
                          <option value="c">공통</option>

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
                          <option value="outer_w">아우터</option>
                          <option value="outer_m">아우터</option>
                          <option value="top_w">상의</option>
                          <option value="top_m">상의</option>
                          <option value="bottom_w">하의</option>
                          <option value="bottom_m">하의</option>
                          
                          <option value="dress">드레스</option>
                          <option value="bag">가방</option>
                          <option value="shoes">신발</option>
                          <option value="acc">악세사리</option>
                          
                          <option value="common">기타</option>
                          
                          


                      </select>
                      
                      <span id="sebuspan1">세부 카테고리 선택</span>
                      <select id="categorysemi2" name="prdSubCtrg">
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
          <br>
          <i class="fas fa-list"><span id="optionenterspan"> 상품 옵션 등록</span></i>
          <div class="enter2">
          

             <div>
                <input type="text" name="size" id="input1" placeholder="상품 사이즈 입력 ex) S,M,L" style="width:300px;">
                <input type="text" name="color" id="input2" placeholder="상품 컬러 입력 ex) red,black,white" style="width:300px;">
                <button id="btn1" type="button">상품 재고 입력하기</button>

                <button id="prdinsert">상품 최종 등록하기</button>

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

                         var input2 = $("<input type='text' class='cntinput' name='count"+ index1 +"' placeholder ='재고입력'>");
                        if(j==0){ 
                           //첫번째 출력은 tr을 추가할 필요가 없는데  두번째 세번째부턴 tr을 추가해야된다. 그래서 첫번째랑 두번째랑 나눈 것
                           var td2=$("<td class='tdsize'>");
                           td2.append(textArr2[j]);
                           var td3=$("<td class='tdcolor'>");                           
                           td3.append(sizeHidden).append(colorHidden).append(input2);
                           tr.append("사이즈").append(td2).append(td3);

                           $("#tbl>tbody").append(tr);
                        }else{
                           
                           var tr1=$("<tr>");

                           var td2=$("<td class='tdsize'>");
                           td2.append(textArr2[j]);
                           var td3=$("<td class='tdcolor'>");                           
                           td3.append(sizeHidden).append(colorHidden).append(input2);
                           tr1.append("사이즈").append(td2).append(td3);

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

               $("#gender").change(function(){
                  var state2 = $('#gender option:selected').val();
                  $("#category").show();
                  
                  if(state2 == 'w'){
                     $('#category >option').show();
                     $("#category option:eq(0)").prop("selected",true);
                     $("#category option:eq(2)").hide();
                     $("#category option:eq(4)").hide();
                     $("#category option:eq(6)").hide();
                     
                  }else if(state2 =='m'){
                     $('#category >option').show();
                     $("#category option:eq(0)").prop("selected",true);
                     $("#category option:eq(1)").hide();
                     $("#category option:eq(3)").hide();
                     $("#category option:eq(5)").hide();
                     $("#category option:eq(7)").hide();
               
                  }else if(state2 =='c'){
                     $('#category >option').show();
                     $("#category option:eq(0)").prop("selected",true);
                     $("#category option:eq(1)").hide();
                     $("#category option:eq(2)").hide();
                     $("#category option:eq(3)").hide();
                     $("#category option:eq(4)").hide();
                     $("#category option:eq(5)").hide();
                     $("#category option:eq(6)").hide();
                     $("#category option:eq(7)").hide();
                  }
               });
               
               $("#category").change(function(){
                    var state = $('#category option:selected').val();
                    $("#categorysemi2").show();
                    
                    if(state == 'outer_m'){
                       $('#categorysemi2 >option').show();
                       $('#categorysemi2 option:eq(0)').prop("selected",true);
                       $('#categorysemi2 option:eq(5)').hide();
                       $('#categorysemi2 option:eq(6)').hide();
                       $('#categorysemi2 option:eq(7)').hide();
                       $('#categorysemi2 option:eq(8)').hide();
                       $('#categorysemi2 option:eq(9)').hide();
                       $('#categorysemi2 option:eq(10)').hide();
                       $('#categorysemi2 option:eq(11)').hide();
                       $('#categorysemi2 option:eq(12)').hide();
                       $('#categorysemi2 option:eq(13)').hide();
                       $('#categorysemi2 option:eq(14)').hide();
                       $('#categorysemi2 option:eq(15)').hide();
                       $('#categorysemi2 option:eq(16)').hide();
                       $('#categorysemi2 option:eq(17)').hide();
                       $('#categorysemi2 option:eq(18)').hide();
                       $('#categorysemi2 option:eq(19)').hide();
                       $('#categorysemi2 option:eq(20)').hide();
                    }if(state == 'top_m'){
                       $('#categorysemi2 >option').show();
                       $('#categorysemi2 option:eq(0)').prop("selected",true);
                       $('#categorysemi2 option:eq(1)').hide();
                       $('#categorysemi2 option:eq(2)').hide();
                       $('#categorysemi2 option:eq(3)').hide();
                       $('#categorysemi2 option:eq(4)').hide();
                       $('#categorysemi2 option:eq(5)').hide();
                       $('#categorysemi2 option:eq(6)').hide();
                       $('#categorysemi2 option:eq(7)').hide();
                       $('#categorysemi2 option:eq(11)').hide();
                       $('#categorysemi2 option:eq(12)').hide();
                       $('#categorysemi2 option:eq(13)').hide();
                       $('#categorysemi2 option:eq(14)').hide();
                       $('#categorysemi2 option:eq(15)').hide();
                       $('#categorysemi2 option:eq(16)').hide();
                       $('#categorysemi2 option:eq(17)').hide();
                       $('#categorysemi2 option:eq(18)').hide();
                       $('#categorysemi2 option:eq(19)').hide();
                    }if(state == 'bottom_m'){
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
                       $('#categorysemi2 option:eq(10)').hide();
                       $('#categorysemi2 option:eq(11)').hide();
                       $('#categorysemi2 option:eq(12)').hide();
                       $('#categorysemi2 option:eq(13)').hide();
                       $('#categorysemi2 option:eq(17)').hide();
                       $('#categorysemi2 option:eq(18)').hide();
                       $('#categorysemi2 option:eq(19)').hide();
                       $('#categorysemi2 option:eq(20)').hide();
                    }if(state == 'bag'){
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
                        $('#categorysemi2 option:eq(10)').hide();
                        $('#categorysemi2 option:eq(11)').hide();
                        $('#categorysemi2 option:eq(12)').hide();
                        $('#categorysemi2 option:eq(13)').hide();
                        $('#categorysemi2 option:eq(14)').hide();
                        $('#categorysemi2 option:eq(15)').hide();
                        $('#categorysemi2 option:eq(16)').hide();
                        $('#categorysemi2 option:eq(18)').hide();
                        $('#categorysemi2 option:eq(19)').hide();   
                        $('#categorysemi2 option:eq(20)').hide();
                     }if(state == 'shoes'){
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
                        $('#categorysemi2 option:eq(10)').hide();
                        $('#categorysemi2 option:eq(11)').hide();
                        $('#categorysemi2 option:eq(12)').hide();
                        $('#categorysemi2 option:eq(13)').hide();
                        $('#categorysemi2 option:eq(14)').hide();
                        $('#categorysemi2 option:eq(15)').hide();
                        $('#categorysemi2 option:eq(16)').hide();
                        $('#categorysemi2 option:eq(17)').hide();
                        $('#categorysemi2 option:eq(19)').hide();   
                        $('#categorysemi2 option:eq(20)').hide();
                     }if(state == 'acc'){
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
                        $('#categorysemi2 option:eq(10)').hide();
                        $('#categorysemi2 option:eq(11)').hide();
                        $('#categorysemi2 option:eq(12)').hide();
                        $('#categorysemi2 option:eq(13)').hide();
                        $('#categorysemi2 option:eq(14)').hide();
                        $('#categorysemi2 option:eq(15)').hide();
                        $('#categorysemi2 option:eq(16)').hide();
                        $('#categorysemi2 option:eq(17)').hide();   
                        $('#categorysemi2 option:eq(18)').hide();
                        $('#categorysemi2 option:eq(20)').hide();
                     

                     }if(state == 'outer_w'){

                        $('#categorysemi2 >option').show();
                        $('#categorysemi2 option:eq(0)').prop("selected",true);
                        $('#categorysemi2 option:eq(5)').hide();
                        $('#categorysemi2 option:eq(6)').hide();
                        $('#categorysemi2 option:eq(7)').hide();
                        $('#categorysemi2 option:eq(8)').hide();
                        $('#categorysemi2 option:eq(9)').hide();
                        $('#categorysemi2 option:eq(10)').hide();
                        $('#categorysemi2 option:eq(11)').hide();
                        $('#categorysemi2 option:eq(12)').hide();
                        $('#categorysemi2 option:eq(13)').hide();
                        $('#categorysemi2 option:eq(14)').hide();
                        $('#categorysemi2 option:eq(15)').hide();
                        $('#categorysemi2 option:eq(16)').hide();
                        $('#categorysemi2 option:eq(17)').hide();
                        $('#categorysemi2 option:eq(18)').hide();
                        $('#categorysemi2 option:eq(19)').hide();   
                        $('#categorysemi2 option:eq(20)').hide();
                     }if(state == 'top_w'){
                        $('#categorysemi2 >option').show();
                        $('#categorysemi2 option:eq(0)').prop("selected",true);
                        $('#categorysemi2 option:eq(1)').hide();
                        $('#categorysemi2 option:eq(2)').hide();
                        $('#categorysemi2 option:eq(3)').hide();
                        $('#categorysemi2 option:eq(4)').hide();
                        $('#categorysemi2 option:eq(8)').hide();
                        $('#categorysemi2 option:eq(9)').hide();
                        $('#categorysemi2 option:eq(10)').hide();
                        $('#categorysemi2 option:eq(11)').hide();
                        $('#categorysemi2 option:eq(12)').hide();
                        $('#categorysemi2 option:eq(13)').hide();
                        $('#categorysemi2 option:eq(14)').hide();
                        $('#categorysemi2 option:eq(15)').hide();
                        $('#categorysemi2 option:eq(16)').hide();
                        $('#categorysemi2 option:eq(17)').hide();
                        $('#categorysemi2 option:eq(18)').hide();
                        $('#categorysemi2 option:eq(19)').hide();
                        $('#categorysemi2 option:eq(20)').hide();
                     }if(state == 'bottom_w'){
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
                        $('#categorysemi2 option:eq(10)').hide();
                        $('#categorysemi2 option:eq(14)').hide();
                        $('#categorysemi2 option:eq(15)').hide();
                        $('#categorysemi2 option:eq(16)').hide();
                        $('#categorysemi2 option:eq(17)').hide();
                        $('#categorysemi2 option:eq(18)').hide();
                        $('#categorysemi2 option:eq(19)').hide();
                        $('#categorysemi2 option:eq(20)').hide();
                     }if(state == 'dress'){
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
                        $('#categorysemi2 option:eq(10)').hide();
                        $('#categorysemi2 option:eq(11)').hide();
                        $('#categorysemi2 option:eq(12)').hide();
                        $('#categorysemi2 option:eq(13)').hide();
                        $('#categorysemi2 option:eq(14)').hide();
                        $('#categorysemi2 option:eq(15)').hide();
                        $('#categorysemi2 option:eq(16)').hide();
                        $('#categorysemi2 option:eq(17)').hide();
                        $('#categorysemi2 option:eq(18)').hide();
                        $('#categorysemi2 option:eq(19)').hide();
                     }

                 });    
               
            </script>
            
             <style>
              #categorysemi2{
                display:none;
            }

            #category{
               display:none;
            }
            </style>