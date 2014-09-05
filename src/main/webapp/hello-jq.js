$(function() {

	$('#firstName').val('');
	$('#lastName').val('');

	$('#saveChanges').click(function() {
		var firstName = $('#firstName').val();
		var lastName = $('#lastName').val();
		$.ajax({
			url: 's/HelloJSON',
			type: 'POST', 
			contentType: 'application/json',
			data: JSON.stringify({
				firstName: firstName,
				lastName: lastName}),
			processData: false,
			async: false, cache: false,
			success: function(data) {
				console.log(data);
				$('#firstName').val(data.firstName);
				$('#lastName').val(data.lastName);
			}
		} );
	} );

});