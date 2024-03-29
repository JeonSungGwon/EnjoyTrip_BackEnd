class ajax {
	constructor(type, async, url, data, message) {
		$.ajax({
			type: type,
			async: async,
			url: url,
			data: data,
			dataType: 'json',
			success: function(json) {
				if (json.success) alert(message);
			},
			error: function(xhr, status, error) {
				//오류 발생 시 처리
				//alert(error);
			},
			complete: function(data, textStatus) {
				//작업 완료 후 처리
			}
		});
	}
}