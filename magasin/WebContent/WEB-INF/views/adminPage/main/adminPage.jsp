<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="/css/adminPage/adminPage.css" />
    <link rel="stylesheet" href="/css/adminPage/adminPage-prd.css" />
    <link rel="stylesheet" href="/css/adminPage/tab3.css" />
    <link rel="stylesheet" href="/css/adminPage/tab4.css" />
    <link rel="stylesheet" href="/css/adminPage/tab5.css" />
    <link rel="stylesheet" href="/css/adminPage/tab7.css" />
    <link rel="stylesheet" href="/css/adminPage/tab8.css" />

    <!--폰트를 위한 링크-->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800&display=swap"
      rel="stylesheet"
    />

    <!--아이콘을 위한 링크-->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"/>

    <!--매출 그래프를 위한 링크-->
    <link href="/js/c3-0.7.10/c3.css" rel="stylesheet">
    <script src="https://d3js.org/d3.v5.min.js"></script>
    <script src="/js/c3-0.7.10/c3.min.js"></script>
    <script src="/js/c3-0.7.10/c3.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

    <!-- jQuery를 위한 스크립트-->
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.4.1.min.js"
    ></script>


    
    <title>관리자 창</title>
  </head>

  <body>
    <div class="all-container">
      <div class="container">
        <ul class="tabs">
          <a href="adminPage.html">
            <img
            src="img/adminPage/manager-logo.png"
              alt="매거진"
              class="tabs-logo"
              width="143px"
              height="86px"
          /></a>
          <li class="tab-link current" data-tab="tab-1">메인 창</li>
          <li class="tab-link" data-tab="tab-2">상품조회</li>
          <li class="tab-link" data-tab="tab-3">상품등록</li>
          <li class="tab-link" data-tab="tab-4">고객조회</li>
          <li class="tab-link" data-tab="tab-5">주문조회</li>
          <li class="tab-link" data-tab="tab-6">답변관리</li>
          <li class="tab-link" data-tab="tab-7">매출조회</li>
          <li class="tab-link" data-tab="tab-8">등급관리</li>
        </ul>

        <!-- 아래 'tab-#'형으로 id를 갖는 div들 순서 바꾸지 말아주세요... 1, 2, 3,... 순으로 하면 깨져서 그래요!-->

        <div id="tab-7" class="tab-content current">
            
            <div class="tab7-window">
              <div class="chart-title">
                  <i class="fas fa-chart-line"></i>&nbsp;&nbsp;&nbsp;매출조회
              </div>
      
              <div class="chart-search">
                  <div class="search-top">
                      <div class="top-title">조회기간</div>
                      <div class="top-select">
                        <select>
                          <option>결제일</option>
                          <option>구매확정일</option>
                        </select>
                      </div>
                      <div class="top-date-select">
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
                          <option>전체주문</option>
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
              <div class="chart-top">
                <div class="top-canvas1" style="width: 70%; height: 300px;">
                  주문금액 / 주문건수
                </div>
                <div class="top-canvas3" style="width: 30%; height: 300px;">
                    성별별 구매비율
                </div>
              </div>
              
              <div class="chart-bottom">
                <div class="bottom-canvas2" style="width: 70%; height: 300px;">
                    매 시간마다 주문건수
                </div>
                <div class="bottom-canvas4" style="width: 30%; height: 300px;">
                    연령별 구매 비율
                </div>
              </div>
            </div>
      
        </div>
  
        <div id="tab-1" class="tab-content current">
          <div class="main">
            <div class="window1">
              <div class="order">
                <div class="text">
                  <div class="logo">
                    <i class="fas fa-box-open" style="color:#f43142;"></i> 신규주문
                  </div>
                  <div class="num"><span id="order">11</span>건</div>
                </div>
              </div>

              <div class="delivery">
                <div class="text">
                  <div class="logo"><i class="fas fa-truck"></i> 배송중</div>
                  <div class="num"><span id="delivery">20</span>건</div>
                </div>

                <div class="text">
                  <div class="logo">
                    <i class="fas fa-people-carry"></i> 배송완료
                  </div>
                  <div class="num"><span id="complete">32</span>건</div>
                </div>
              </div>

              <div class="account">
                <div class="text">
                  <div class="logo">
                    <i class="fas fa-won-sign"></i> 오늘 결제금액
                  </div>
                  <div class="num"><span id="todayAccount">310,000</span>원</div>
                </div>

                <div class="text">
                  <div class="logo">
                    <i class="fas fa-money-check-alt"></i> 이번주 결제금액
                  </div>
                  <div class="num"><span id="weekAccount">1,372,000</span>원</div>
                </div>
              </div>
            </div>
            <div class="window2">
              <div class="graph">
                <div class="text">
                  <div class="logo">
                    <i class="fas fa-chart-bar"></i> 매출 통계
                  </div>
                  <div class="chart">
                    <div class="container2">
                      <div class="window3">
                        <ul class="tabs2">
                          <li class="tab-link2" data-tab2="tab2-1">결제건수</li>
                          <li class="tab-link2 current2" data-tab2="tab2-2">
                            결제금액
                          </li>
                        </ul>
                      </div>
                      <div class="window4">
                        <div id="tab2-1" class="tab-content2 current2">
                          <canvas id="people" width="780px" height="450px">
                            결제건수
                          </canvas>
                        </div>
                        <div id="tab2-2" class="tab-content2">
                          <canvas id="money" width="780px" height="450px">
                            결제금액
                          </canvas>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="qna">
                <div class="text">
                  <div class="logo">
                    <i class="fas fa-question"></i> 미답변 문의
                  </div>
                  <div class="num"><span id="q">4</span>건</div>
                </div>
                <div class="preview">
                  <table>
                    <tbody>
                      <tr class="q-title">
                          <td>상품이 안 왔어요</td>
                      </tr>
                      <tr class="q-title">
                          <td>장사 이딴식으로 할거면 계속하세요.</td>
                      </tr>
                      <tr class="q-title">
                          <td>원래 배송이 이렇게 느렸나요?</td>
                      </tr>
                      <tr class="q-title">
                          <td>지난번에 구매했던 니트가 따뜻해요</td>
                      </tr>
                      </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
                
        <div id="tab-2" class="tab-content">
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
        </div>
  
        <div id="tab-3" class="tab-content">
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
                      <input type="file" name="filesumname" onchange="loadImg(this)"
                             id="estsetse">
                      <div id="img-viewer">
                  <img src="img/adminPage/ompang1.jpg"id="img-view" width="50" height="50">
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
                      <input type="file" name="filename" onchange="loadImg(this)">
                      <div id="img-viewer2">
                          <img src="/img/adminPage/ompang1.jpg" id="img-view2" width="50" height="50">
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
          </div>
          
        <div id="tab-4" class="tab-content">
          <div class="tab4-customer">
            <div class="customer-title">
              <i class="fas fa-users"></i>&nbsp;&nbsp;고객조회
            </div>
            <div class="customer-search">
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
                    <option>고객 이름</option>
                    <option>고객 아이디</option>
                    <option>상품 이름</option>
                    <option>상품 개수</option>
                  </select>
                </div>
                <div class="bottom-input">
                  <input type="text">
                </div>
              </div>
              <div class="bottom-btn">
                <button>검색</button>
              </div>
            </div>
            <div class="customer-bottom">
              <div class="bottom-title">목록 (총 <span>0</span>개)</div>
              <div class="bottom-list">
                <div class="list-title">
                  <table>
                    <tr>
                      <td>고객 아이디</td>
                      <td>고객 이름</td>
                      <td>상품 이름</td>
                      <td>상품 개수</td>
                      <td>결제일 | 발송일</td>
                    </tr>
                  </table>
                </div>
                <div class="list-content">
                  <table>
                    <tr>
                      <td>idid1</td>
                      <td>name1</td>
                      <td>pdt1</td>
                      <td>2</td>
                      <td>2019-10-15</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div id="tab-5" class="tab-content">
          <div class="tab5-order">
            <div class="order-top">
              <div class="top-title"><i class="fas fa-list"></i>&nbsp;&nbsp;&nbsp;주문조회</div>
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
                  <i class="fas fa-ban"></i>&nbsp;취소|<i class="fas fa-undo-alt"></i>환불요청&nbsp;<a href="#"><span>1</span></a>건
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
              <div class="bottom-title">목록 (총 <span>0</span>개)</div>
              <div class="bottom-list">
                <div class="list-title">
                  <table>
                    <tr>
                      <td><input type="checkbox" id="orderAll" class="orderCheckBox"></td>
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
        </div>

        <div id="tab-6" class="tab-content">
        </div>

        <div id="tab-8" class="tab-content">
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
                <input type="text"/>
              </div>
            </div>
            <div class="search-btn"><button>검색</button></div>
          </div>
          <div class="tab8-content">
                <div class="content-title">목록 (총 <span>0</span>개)</div>
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
        </div>

              
      <div id="tab-9" class="tab-content">
        <div class="tabupdate">
            <i class="fas fa-list"></i><span> 상품 수정 페이지</span>
        <br><br>
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
                                      fas fa-edit"></i><span>상품 성별 수정</span>
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
                            </select>
                            
                            <span id="sebuspan2">세부 카테고리 선택</span>
                                <select id="categorysemi">
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
                            <img src="img/adminPage/ompang1.jpg" id="img-view" width="50" height="50">
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
                            <img src="img/adminPage/ompang1.jpg" id="img-view2" width="50" height="50">
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
  </div>
    </div>
    <script type="text/javascript" src="/js/adminPage/adminPage.js"></script>
    <script type="text/javascript" src="/js/adminPage/adminPagePrd.js"></script>
    <script type="text/javascript" src="/js/adminPage/graph.js"></script>
  </body>
</html>