$('input[type="color"]').change(function() {
	$(this).closest('form').submit();
});