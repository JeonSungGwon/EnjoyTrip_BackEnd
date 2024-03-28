const myPage = (app) => {
	const memberNo = app.getElementsByClassName("profile")[0].id.split("profile")[1];

	const editButton = app.getElementById("editProfile");
	const fileInput = app.getElementById("fileInput");
	const logoutButton = app.getElementById("logout");
	const leaveButton = app.getElementById("leave");

	const profileImage = app.getElementById("profileImage");
	
	editButton.addEventListener("click", () => {
		fileInput.onchange = (event) => {
			const file = event.target.files[0];
			const reader = new FileReader();

			reader.onload = (e) => {
				const imageSrc = e.target.result;
				profileImage.src = imageSrc; // 프로필 이미지 업데이트
				//fileInput.value = imageSrc;
			};

			reader.readAsDataURL(file);
		};

		fileInput.click(); // 파일 선택 창 열기
	})

	app.getElementById("fileInput").addEventListener("change", () => {
		$.ajax({
			type: 'post',
			url: `member?action=updateProfile&memberNo=${memberNo}`,
			data: fileInput.value,
			dataType: 'json',
			success: function(json) {
				if (json.success) alert("프로필 편집!");
			},
			error: function(xhr, status, error) {
				//오류 발생 시 처리
				//alert(error);
			},
			complete: function(data, textStatus) {
				//작업 완료 후 처리
			}
		});
	})

	logoutButton.addEventListener("click", () => { })

	leaveButton.addEventListener("click", () => { })
}

myPage(document);