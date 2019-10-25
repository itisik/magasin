function loadImg(value) {
	if (value.files && value.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#img-view2').attr('src', e.target.result);

		}
		reader.readAsDataURL(value.files[0]);
	}
}

function loadImg2(value) {
	if (value.files && value.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#img-view').attr('src', e.target.result);

		}
		reader.readAsDataURL(value.files[0]);
	}
}