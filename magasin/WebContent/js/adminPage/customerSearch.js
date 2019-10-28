$(document).ready(function() {
	$("div.top-date-select button").click(function() {
		$("div.top-date-select button").removeClass("current3");
		$(this).addClass("current3");
		$("#dateSelect").val($(this).val());
	});
	
	$(".searchIndex").change(function() {
		if ($(".searchIndex:selected").val() == "purchaseDate"|| $(".searchIndex:selected").val() == "outDate") {
			alert("!!");
			$(".top-date-select").css("display").show();
		}
	});
});