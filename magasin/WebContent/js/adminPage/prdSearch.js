$("#category1").change(function() {
	var state = $('#category1 option:selected').val();
	$("#categorysemi1").show();

	if (state == 'top') {
		$('#categorysemi1 >option').show();
		$('#categorysemi1 option:eq(0)').prop("selected", true);
		$('#categorysemi1 option:eq(4)').hide();
		$('#categorysemi1 option:eq(5)').hide();
		$('#categorysemi1 option:eq(6)').hide();
		$('#categorysemi1 option:eq(7)').hide();
		$('#categorysemi1 option:eq(8)').hide();
		$('#categorysemi1 option:eq(9)').hide();
		$('#categorysemi1 option:eq(10)').hide();

	} else if (state == 'bottom') {
		$('#categorysemi1 >option').show();
		$('#categorysemi1 option:eq(0)').prop("selected", true);
		$('#categorysemi1 option:eq(1)').hide();
		$('#categorysemi1 option:eq(2)').hide();
		$('#categorysemi1 option:eq(3)').hide();
		$('#categorysemi1 option:eq(7)').hide();
		$('#categorysemi1 option:eq(8)').hide();
		$('#categorysemi1 option:eq(9)').hide();
		$('#categorysemi1 option:eq(10)').hide();
	} else if (state == 'outter') {
		$('#categorysemi1 >option').show();
		$('#categorysemi1 option:eq(0)').prop("selected", true);
		$('#categorysemi1 option:eq(3)').hide();
		$('#categorysemi1 option:eq(4)').hide();
		$('#categorysemi1 option:eq(5)').hide();
		$('#categorysemi1 option:eq(6)').hide();
		$('#categorysemi1 option:eq(7)').hide();
		$('#categorysemi1 option:eq(8)').hide();
		$('#categorysemi1 option:eq(9)').hide();
		$('#categorysemi1 option:eq(10)').hide();
	} else if (state == 'dress') {
		$('#categorysemi1 >option').show();
		$('#categorysemi1 option:eq(0)').prop("selected", true);
		$('#categorysemi1 option:eq(1)').hide();
		$('#categorysemi1 option:eq(2)').hide();
		$('#categorysemi1 option:eq(3)').hide();
		$('#categorysemi1 option:eq(4)').hide();
		$('#categorysemi1 option:eq(6)').hide();
		$('#categorysemi1 option:eq(7)').hide();
		$('#categorysemi1 option:eq(8)').hide();
		$('#categorysemi1 option:eq(9)').hide();
		$('#categorysemi1 option:eq(10)').hide();
	} else if (state == 'shirts') {
		$('#categorysemi1 >option').show();
		$('#categorysemi1 option:eq(0)').prop("selected", true);
		$('#categorysemi1 option:eq(1)').hide();
		$('#categorysemi1 option:eq(2)').hide();
		$('#categorysemi1 option:eq(3)').hide();
		$('#categorysemi1 option:eq(4)').hide();
		$('#categorysemi1 option:eq(5)').hide();
		$('#categorysemi1 option:eq(6)').hide();
		$('#categorysemi1 option:eq(7)').hide();
		$('#categorysemi1 option:eq(8)').hide();
		$('#categorysemi1 option:eq(9)').hide();

	} else if (state == 'other') {
		$('#categorysemi1 >option').show();
		$('#categorysemi1 option:eq(0)').prop("selected", true);
		$('#categorysemi1 option:eq(1)').hide();
		$('#categorysemi1 option:eq(2)').hide();
		$('#categorysemi1 option:eq(3)').hide();
		$('#categorysemi1 option:eq(4)').hide();
		$('#categorysemi1 option:eq(5)').hide();
		$('#categorysemi1 option:eq(6)').hide();

	}
});

$(document).ready(function() {
	$("div.searchbutton button").click(function() {
		$("div.searchbutton button").removeClass("ssidang3");
		$(this).addClass("ssidang3");
		$("#prddatesearch").val($(this).val());
	});
});