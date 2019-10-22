$(document).ready(function() {
  $("ul.tabs li").click(function() {
    var tab_id = $(this).attr("data-tab");

    $("ul.tabs li").removeClass("current");
    $(".tab-content").removeClass("current");

    $(this).addClass("current");
    $("#" + tab_id).addClass("current");
  });
});

$(document).ready(function() {
  $("ul.tabs2 li").click(function() {
    var tab_id = $(this).attr("data-tab2");

    $("ul.tabs2 li").removeClass("current2");
    $(".tab-content2").removeClass("current2");

    $(this).addClass("current2");
    $("#" + tab_id).addClass("current2");
  });
});

const order = document.querySelector("#order");
const delivery = document.querySelector("#delivery");
const complete = document.querySelector("#complete");
//신규 주문, 배송중, 배송완료 건수

const todayAccount = document.querySelector("#todayAccount");
// 오늘 결제 금액
const weekAccount = document.querySelector("#weekAccount");
// 이번주 결제 금액

const q = document.querySelector("#q");

const CLICKED_NUMBER = "current";
// 추가하거나 제거할 클래스 이름

const mainTab = document.querySelector("#tab-1");
// 메인 탭
const orderTab = document.querySelector("#tab-5");
// 주문 탭
const qTab = document.querySelector("#tab-6");
// 답변 탭
const accountTab = document.querySelector("#tab-7");
// 매출 탭
const content = document.querySelectorAll(".tabs>li");
// 컨텐츠들

function quickMove1() {
  content[0].classList.remove(CLICKED_NUMBER);
  mainTab.classList.remove(CLICKED_NUMBER);

  content[4].classList.add(CLICKED_NUMBER);
  orderTab.classList.add(CLICKED_NUMBER);
}

function quickMove2() {
  content[0].classList.remove(CLICKED_NUMBER);
  mainTab.classList.remove(CLICKED_NUMBER);

  content[6].classList.add(CLICKED_NUMBER);
  accountTab.classList.add(CLICKED_NUMBER);
}

function quickMove3() {
  content[0].classList.remove(CLICKED_NUMBER);
  mainTab.classList.remove(CLICKED_NUMBER);

  content[5].classList.add(CLICKED_NUMBER);
  qTab.classList.add(CLICKED_NUMBER);
}

function waitClick() {
  order.addEventListener("click", quickMove1);
  delivery.addEventListener("click", quickMove1);
  complete.addEventListener("click", quickMove1);

  todayAccount.addEventListener("click", quickMove2);
  weekAccount.addEventListener("click", quickMove2);

  q.addEventListener("click", quickMove3);
}

/* 발주확인 -> 송장입력 -> 송장조회 */
var orderChange1 = $(".ready");
var orderChange2 = $(".out");

function orderChangeFunc1() {
  this.classList.remove("ready");
  this.classList.add("out");
  orderChange1 = $(".ready");
  orderChange2 = $(".out");
}

function orderChangeFunc2() {
  this.classList.remove("out");
  this.classList.add("look");
  orderChange1 = $(".ready");
  orderChange2 = $(".out");
}

function waitClick2() {
  orderChange1.click(orderChangeFunc1);
  orderChange2.click(orderChangeFunc2);
}

waitClick();
waitClick2();
