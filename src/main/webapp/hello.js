$(function() {

	var hello = function() {
		var firstName = $('#firstName').val();
		var lastName = $('#lastName').val();
		$.ajax({
			url: 's/HelloJSON',
			type: 'POST', 
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify({
				firstName: firstName,
				lastName: lastName}),
			processData: false,
			async: false, cache: false,
			success: function(res) {
				$('#firstName').val(res.firstName);
				$('#lastName').val(res.lastName);
			}
		});
	};

	$('#saveChanges').click(hello);

	hello();
});