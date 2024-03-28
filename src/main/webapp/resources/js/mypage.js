import { Card2, setCardWidthHeight } from "./components.js";
const myPage = async (app) => {
	const memberNo = app.getElementsByClassName("profile")[0].id.split("profile")[1];

	const editButton = app.getElementById("editProfile");
	const logoutButton = app.getElementById("logout");
	const leaveButton = app.getElementById("leave");
	const favoritesDiv = app.getElementById("favorites");
	const profileImage = app.getElementById("profileImage");

	let html = "";
	let favoriteList = [];
	try {
		const response = await fetch('favorite?action=list&memberNo=' + memberNo);
		favoriteList = await response.json();

		if (!Array.isArray(favoriteList)) {
			favoriteList = Object.values(favoriteList);
		}
	} catch (error) {
		console.error('Error fetching favorites:', error);
	}

	favoriteList[0].forEach((favorite) => {
		html += `
                ${Card2(
			favorite.contentId,
			favorite.image,
			favorite.title.split("(")[0],
			favorite.addr.split(" ")[0] + " " + favorite.addr.split(" ")[1],
			"30%"
		)}
                <img src="resources/images/full_star.svg" alt="star" id="star${favorite.contentId}" />
            </div>
        `;
	});

	favoritesDiv.innerHTML = html;


	favoriteList[0].forEach((favorite) => {
		const storeId = favorite.contentId;

		let starIcon = document.getElementById(`star${storeId}`);

		starIcon.addEventListener("click", (event) => {
			const storeId = event.target.id.replace("star", "");

			// Ajax 요청을 만듭니다.
			const xhr = new XMLHttpRequest();
			xhr.open("POST", "favorite?action=remove", true); // 여기에 서버의 경로를 정확히 지정해야 합니다.
			xhr.setRequestHeader
				("Content-Type", "application/x-www-form-urlencoded");

			// 서버로 보낼 데이터를 만듭니다.
			const data = `contentId=${storeId}`;

			xhr.onreadystatechange = function() {
				if (xhr.readyState === XMLHttpRequest.DONE) {
					if (xhr.status === 200) {
						// 서버에서의 응답을 처리합니다.
						const response = JSON.parse(xhr.responseText);
						if (response.success) {
							// 삭제가 성공하면 해당 아이콘을 숨깁니다.
							const favoriteElement = document.getElementById(`card${storeId}`);
							favoriteElement.style.display = "none";
							starIcon.style.display = "none";
						} else {
							// 실패 시 적절한 처리를 수행합니다.
							alert("Failed to remove favorite.");
						}
					} else {
						// 서버와의 통신 중 에러가 발생한 경우 처리합니다.
						alert("Error communicating with server.");
					}
				}
			};

			// 데이터를 서버로 보냅니다.
			xhr.send(data);
		});

		app.getElementById(`card${favorite.contentId}`).addEventListener("dblclick", () => {
			openModal(favorite);
		});
	});


	editButton.addEventListener("click", () => {
		const fileInput = document.createElement("input");
		fileInput.type = "file";
		fileInput.accept = "image/*";

		fileInput.onchange = (event) => {
			const file = event.target.files[0];
			const reader = new FileReader();
			let imageSrc = "";

			reader.onload = (e) => {
				imageSrc = e.target.result;
				profileImage.src = imageSrc; // 프로필 이미지 업데이트
			};

			let editForm = app.getElementById("profileEdit");
			let formData = new FormData(editForm);
			formData.append("profileImage", imageSrc);

			for (let x of formData) {
				console.log(x);
			}

			$.ajax({
				type: 'post',
				async: true,
				url: 'member?action=updateProfile&memberNo=' + memberNo,
				data: formData,
				dataType: 'json',
				processData: false,
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
			reader.readAsDataURL(file);
		};

		fileInput.click(); // 파일 선택 창 열기
	});

	logoutButton.addEventListener("click", () => { });

	leaveButton.addEventListener("click", () => { });

	const openModal = (store) => {
		let modalHtml = `
			<div>
				<div class="review-title">
					<label for="title">제목: </label>
		  			<input id="title" name="title" />
		  		</div>
	  			<label for="content">리뷰 내용: </label>
	  			<textarea id="content" name="content" cols="40" rows="10"></textarea>
		  		<button>저장</button>
	  		<div>
	    `;
		document.getElementById("modalBackground").style.display = "flex";
		document.getElementById("modal").innerHTML += modalHtml;
		document.getElementById("modalTitle").innerText = `${store.title}`;

		// 닫기
		document.getElementById("modalClose").addEventListener("click", (e) => {
			e.preventDefault();
			const modal = document.getElementById("modalBackground");
			modal.style.display = "none";
			document.getElementById("modal").innerHTML = `
    			<div class="modal-top">
					<h2 class="modal-title" id="modalTitle"></h2>
					<span class="material-symbols-outlined" id="modalClose">close</span>
				</div>		
    		`;
		});
	}
};


myPage(document);
