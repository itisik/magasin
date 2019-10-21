<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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