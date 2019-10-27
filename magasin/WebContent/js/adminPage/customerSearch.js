$(document).ready(function() {
	$("div.top-date-select button").click(function() {
		$("div.top-date-select button").removeClass("current3");
		$(this).addClass("current3");
		$("#dateSelect").val($(this).val());
	});
});