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


var ctx = document.getElementById("money").getContext("2d");
/*
- Chart를 생성하면서, 
- ctx를 첫번째 argument로 넘겨주고, 
- 두번째 argument로 그림을 그릴때 필요한 요소들을 모두 넘겨줍니다. 
*/
var myChart = new Chart(ctx, {
  type: "bar",
  data: {
    labels: ["10.08", "10.09", "10.10", "10.11", "10.12.", "10.13."],
    datasets: [
      {
        label: "단위 (만원)",
        data: [12, 19, 3, 5, 2, 3],
        backgroundColor: [
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 99, 132, 0.2)",
          "rgba(255, 99, 132, 0.2)"
        ],
        borderColor: [
          "rgba(255,99,132,1)",
          "rgba(255,99,132,1)",
          "rgba(255,99,132,1)",
          "rgba(255,99,132,1)",
          "rgba(255,99,132,1)",
          "rgba(255,99,132,1)"
        ],
        borderWidth: 1
      }
    ]
  },
  options: {
    maintainAspectRatio: true, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true
          }
        }
      ]
    }
  }
});


$("#addoption").click(function(){
   var addoption =   '<tr name="addoptiontr">'+
                    '<th id="thdiv1">'+
                        '<div class="thdiv1">'+
                        '<i class="fas fa-angle-double-right"></i><span>상품 옵션 계속입력</span>'+
                        '</div>'+
                    '</th>'+
                    '<td>'+
                        '옵션명 : <input type="text" id="optioncolor1" class="productinput" placeholder="예시 : 컬러" name="optioncolor">'+        
                        ' 옵션값 : <input type="text" id="optionvalue1" class="productinput" placeholder="예시 : 빨강,노랑 (,로 구분)" name="optionvalue">'+
                        ' <button name="deleteoption" id="deleteoption"> - </button>'+      
                    '</td>'+  
                '</tr>';
    var trHtml = $("tr[name=addoptiontr]:last");
    
    trHtml.after(addoption);
});


$(document).on("click","button[name=deleteoption]",function(){
   var trHtml = $(this).parent().parent();
    trHtml.remove();
    
});

$("#activeoption").click(function(){
   var optionNameTmp = $('input[name=optioncolor]').val();
   var optionName = '';
   for(i =0; i<optioncolor.length; i++){
	   optionName += '<th>' + optionNameTmp[i] + '<th>';
   };
   var optionValueTmp = $('input[name=optionvalue]').val();
   		optionValueTmp = optionValueTmp.split(',');    
   var optionValue = '';
   for(i=0; i<optionvalue.length; i++){
	   optionValue += '<td>' + optionValueTmp[i] + '<td>';
   } 
    
   var optionNameTmp2 = $("#optioncolor1").val();
   var optionName2 = '';
    for(i=0; i<optioncolor2.length; i++){
    	optionName2 += '<th>' + optionNameTmp2[i] + '<th>';
    };
    
    var optionValueTmp2 = $("#optionvalue1").val();
    	optionValueTmp2 = optionValueTmp2.split(',');
    	
    var optionValue2 = '';
    for(i=0; i<optionvalue2.length;i++){
    	optionValue2 += '<td>' + optionValue2[i] + '</td>';
    }
    
   document.getElementById("optiondiv").innerHTML =
       
        '<table class="optiontable">'+
	        '<tr>'+
	        	'<th id="thoption1"><input type="checkbox"></th>'+
	        		optioncolor1 + optioncolor3 +
	        		'<th id="thoption2">재고 수량 변경</th><th id="thoption3">삭제</th></tr>'+
	        '<tr><td id="thoption4"><input type="checkbox"></td>' + optionvalue1 + '<td>' + optionvalue3 + '</td><td id="thoption5"><input type="text" id="thoption6"></td><td id="thoption7">$50</td></tr>' +
        '</table>';
        
    
});







