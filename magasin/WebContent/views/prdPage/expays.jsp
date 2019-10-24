<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <!-- 보영 CSS -->
    <link rel="stylesheet" href="/css/common_css/layout.css">
    
    <!-- 경필 CSS -->
    <link rel="stylesheet" href="/css/prdPage/expays.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Insert title here</title>
</head>

<body>
    <div class="orderContainer">
        <div class="orderText">
            <p><a href="#">home</a>> order start</p>
            <h3>order start</h3>
        </div>
        <div class="order-wrapper">
            <table class="order-table">
                <thead class="order-thead">
                    <tr>
                        <th>이미지</th>
                        <th>상품정보</th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>배송비</th>
                        <th>합계</th>
                    </tr>
                </thead>
                <tbody class="order-tbody">
                    <tr>
                        <td class="order-list-1"><a href="#"><img src="/img/product/ce9e802569fa63290620bdc2f1b87615.jpg"></a></td>
                        <td class="order-list-2">
                            <ul>
                                <li class="order-list-2-li-1"><strong>베이직 미니 가디건</strong></li>
                                <li class="order-list-2-li-2">[옵션:아이보리]</li>
                            </ul>
                        </td>
                        <td class="order-list-3">39,000</td>
                        <td class="order-list-4"><span>1</span></td>
                        <td class="order-list-5">[무료]</td>
                        <td class="order-list-6"><span>39,000</span></td>
                    </tr>
                </tbody>
            </table>
            <tfoot class="order-tfoot">
                <tr>
                    <th colspan="7">
                        <p class="order-foot">상품구매금액&nbsp;<span><b>39,000&nbsp;</b></span>
                            배송비&nbsp;<span><b>0</b></span>
                            (무료)=합계&nbsp;&nbsp;<span><b>39,000</b></span></p>
                    </th>
                </tr>
            </tfoot>
        </div>
        <div class="orderInfor">
            <div class="ordertext">
                <p>주문자 정보</p>
                <p><img src="/img/product/ico_required.gif">필수입력사항</p>
            </div>
            <table class="table-bordered orderorder">
                <tr>
                    <td>주문하시는분<img src="/img/product/ico_required.gif"></td>
                    <td><input type="text" name="name1" value=""></td>
                </tr>
                <tr>
                    <td>주소<img src="/img/product/ico_required.gif"></td>
                    <td><input type="text" name="addr1" value="">
                        <button class="btn" type="button">우편번호</button><br><br>
                        <input type="text" name="addr2" value="">
                        나머지주소
                        <input type="text" name="addr_1" id="addr_address" placeholder="기본 도로명 주소"><br>
                                <input type="text" name="addr_2" id="addr_detailAddress" placeholder="상세주소">
                                <input type="text" name="addr_3" id="addr_extraAddress" placeholder="참고항목">
                        
                        </td>
                </tr>
                <tr>
                    <td>휴대전화<img src="/img/product/ico_required.gif"></td>
                    <td><input type="text" name="phone1" value=""></td>
                </tr>
                <tr>
                    <td>이메일<img src="/img/product/ico_required.gif"></td>
                    <td><input type="email" name="email" value=""></td>
                </tr>
            </table>
        </div>
        <div class="orderaddr">
            <p>배송지 정보</p>
            <p><img src="/img/product/ico_required.gif">필수 입력사항</p>
        </div>
        <table class="table-bordered addrInfor">
            <tr>
                <td>배송지 선택</td>
                <td><input type="radio" name="addr3" value="주문자 정보 동일">주문자 정보와동일
                    <input type="radio" name="addr4" value="새로운 배송지">새로운 배송지
                </td>
            </tr>
            <tr>
                <td>받으시는 분<img src="/img/product/ico_required.gif"></td>
                <td><input  type="text" name="name2" value=""></td>
            </tr>
            <tr>
                <td>주소<img src="/img/product/ico_required.gif"></td>
                <td><input  height="1px" type="text" name="addr5" value="">
                    <button class="btn" type="button">우편번호</button><br><br>
                    <input type="text" name="addr6" value="">
                    나머지주소</td>
            </tr>
            <tr>
                <td>휴대전화</td>
                <td><input type="text" name="phone2" value=""></td>
            </tr>
        </table>
        <div class="orderpay">
            <p>결제 예정금액</p>
        </div>
        <table class="table-bordered order-pay">
            <tr>
                <td>총 주문 금액</td>
                <td>총 주문금액+배송비[무료]</td>
                <td>총 결제 내역</td>
            </tr>
            <tr>
                <td><span>39,000</span></td>
                <td><span>39,000</span> + <span>0</span></td>
                <td><span>39,000</span></td>
            </tr>
        </table>
        <div class="orderpays">
            <p>결제수단</p>
        </div>
        <table class="table-bordered order-pays">
            <tr>
                <th><input type=radio name="pay" value="카드결제">카드결제</th>
                <td rowspan="3"><p>카드결제 최종금액</p>
                                <span>39,000</span><br>
                                <button class="btn" type="button">결제하기</button><br>
                </td>
            </tr>
                <td>magasin은 카드결제만 가능한점을 양해바랍니다.</td>
            <tr>
                <td>단, 배송비는 100원을 사도 무료!!!</td>
            </tr>
            <tr>
                
            </tr>
        </table>
    </div>
</body>

</html>
