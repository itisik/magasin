//상품 옵션 테이블 CSS
/*
$('.optiontable').css({
    border: 1px solid #0B080F;
            width: 100%;
});
$('.optiontable tr').css({
    border: 1px solid #0B080F;
});
$('.optiontable th').css({
    border: 1px solid #0B080F;
});
$('.optiontable td').css({
    border: 1px solid #0B080F;
    text-align: center;
});
$('#thoption1').css({
    width: 5%;
});
$('#thoption2').css({
    width: 50%; 
});

$('#thoption3').css({
    width: 5%; 
});
$("#thoption4").css({
    width: 5%;
});
$("#thoption5").css({
    width : 50%;
});
$("#thoption6").css({
    width: 99%; 
});
$("#thoption7").css({
    width: 5%;
});
*/

$(document).ready(function() {
  $(".prdModify").click(function() {
    var tab_id = $(this).attr("data-tab");

    $("ul.tabs2 li").removeClass("current2");
    $(".tab-content").removeClass("current");

    $(this).addClass("current");
    $("#" + tab_id).addClass("current");
  });
});
///////////////////////////////////////////////////////////////////////////////////////
const activeBtn = document.querySelector("#activeOption");

function myFunc() {
  console.log("!!!!");
}

function init() {
  activeBtn.addEventListener("click", myFunc());
}

init();
