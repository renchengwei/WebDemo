$(document).ready(function() {
	$("input:radio[name='type']").on('ifChecked', function(event) {
		if ($(this).val() == "0") {
			$("#menuURL_div").show();
			$("#parent_div").hide();
			$('#parent').attr('required', false);
			$('#menuURL').attr('required', false);
		} else if($(this).val() == "1"){
			$("#parent_div").show();
			$("#menuURL_div").show();
			$('#parent').attr('equired', true);
			$('#menuURL').attr('required', true);
		} else {
			$("#parent_div").hide();
			$("#menuURL_div").hide();
			$('#parent').attr('required', false);
			$('#menuURL').attr('required', false);
		}
	});
	
	$("#form").parsley();

	

});