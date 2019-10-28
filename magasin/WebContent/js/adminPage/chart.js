function loadImg3(value) {
	if (value.files && value.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#img-view3').attr('src', e.target.result);

		}
		reader.readAsDataURL(value.files[0]);
	}
}

function loadImg4(value) {
	if (value.files && value.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#img-view4').attr('src', e.target.result);

		}
		reader.readAsDataURL(value.files[0]);
	}
}