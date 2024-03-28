import { Card, setCardWidthHeight } from "./components.js";
import { changeMarker, initializeKakaoMap, setSearchedMap, } from "./kakaomap.js";

const mainPage = (app) => {
	const memberNo = app.getElementsByClassName("profile")[0].id.split("profile")[1];

	const locationSelect = app.getElementById("location");
	const subLocationSelect = app.getElementById("subLocation");
	const keywordInput = app.getElementById("keyword");
	const searchButton = app.getElementById("searchButton");
	const resultDiv = app.getElementById("result");

	// 지도 초기화
	let map = initializeKakaoMap();
	let clusterer = new kakao.maps.MarkerClusterer({
		map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
		averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
		minLevel: 5, // 클러스터 할 최소 지도 레벨
	});
	let markers = [];
	let favoriteList = []
	let carsdDiv = null;
	let cards = null;
	let results = [];

	// 지역 선택 시작
	locationSelect.addEventListener("change", async () => {
		subLocationSelect.innerHTML = "<option value=\"\">불러오는 중..</option>";

		try {
			const response = await fetch('/enjoytrip_backend-master/map?action=gugun&sidoCode=' + locationSelect.value);
			const gugunList = await response.json();

			subLocationSelect.innerHTML = "";

			gugunList.forEach((gugun) => {
				const option = document.createElement("option");
				option.value = gugun.gugunCode;
				option.textContent = gugun.gugunName;
				subLocationSelect.appendChild(option);
			});
		} catch (error) {
			console.error('Error fetching sub locations:', error);
		}
	});
	// 지역 선택 끝!

	// 검색 버튼 클릭 시작
	searchButton.addEventListener("click", async (e) => {
		e.preventDefault();

		try {
			const response = await fetch('/enjoytrip_backend-master/map?action=info&sidoCode=' + locationSelect.value +
				'&gugunCode=' + subLocationSelect.value + '&title=' + keywordInput.value);
			results = await response.json();
		} catch (error) {
			console.error('Error fetching sub locations:', error);
		}
		
		try {
			const response = await fetch('/enjoytrip_backend-master/favorite?action=list&memberNo='+ memberNo);
			favoriteList = await response.json();
			if (!Array.isArray(favoriteList)) {
   			 	// favoriteList가 배열이 아닌 경우, 배열로 변환
    			favoriteList = Object.values(favoriteList);
			}
		} catch (error) {
			console.error('Error fetching sub locations:', error);
		}

		// 검색 결과
		if (results == null) {
			resultDiv.innerHTML = `<h2 style="margin-bottom: 5rem">검색 결과가 없습니다. 😢</h2>`;
		} else {
			resultDiv.innerHTML = `
		    	<h2 style="margin-bottom: 1rem">검색 결과 입니다! 😊</h2>
		        <div id="cards" class="cards"></div>
		    `;

			[clusterer, markers] = setSearchedMap(clusterer, markers, results, map, favoriteList, memberNo);

			let html = "";
			results.map((result) => {
				console.log("ㅁㄴㅇㅁㄴ",favoriteList[0][0]);
				const isFavorite = favoriteList[0].find((favorite) => favorite.memberNo == memberNo && favorite.contentId == result.contentId);
				carsdDiv = app.getElementById("cards");
				html += Card(
					memberNo,
					result.contentId,
					result.firstImage ? result.firstImage : "",
					result.title.split("(")[0],
					result.addr1.split(" ")[0] + " " + result.addr1.split(" ")[1],
					"18%",
					isFavorite
				);
			});
			
			carsdDiv.innerHTML = html;
			cards = carsdDiv.querySelectorAll(".card");
			cards.forEach((card) => {
				setCardWidthHeight(card);
				
				card.addEventListener("click", (event) => {
					
					const id = event.currentTarget.id.replace("card", "");
					const clickedStore = results.find((ele) => ele.contentId == id);
					if (clickedStore) {
						const position = new kakao.maps.LatLng(
							parseFloat(clickedStore.latitude),
							parseFloat(clickedStore.longitude)
						);
						map.setCenter(position);
					}
				});
				
				card.addEventListener("dblclick", (event) => { 
					console.log("모달창 열어라!");
					const id = event.currentTarget.id.replace("card", "");
					const dbClickedStore = results.find((ele) => ele.contentId == id);
					
					if(dbClickedStore)
						openModal(dbClickedStore);
				});
			});

			addClickEventonStars(results);
		}
	});
	// 검색 버튼 클릭 끝!

	// 별 클릭 했을 때 즐겨찾기 등록
	const addClickEventonStars = (results) => {
		results.forEach((result) => {
			let starIcon = app.getElementById(`star${result.contentId}`);
			starIcon.addEventListener("click", (e) => {
				// 즐겨찾기 삭제
				if (starIcon.getAttribute("src") === "resources/images/full_star.svg") {
					starIcon.setAttribute("src", "resources/images/empty_star.svg");
					[clusterer, markers] = changeMarker(markers, result, clusterer, null);
					
					$.ajax({
						type: 'post',
						url: `favorite?action=remove&contentId=${result.contentId}`,
						dataType: 'json',
						success: function(json) {
							if(json.success) alert("즐겨찾기 삭제!");
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
				// 즐겨찾기 추가 
				else {
					starIcon.setAttribute("src", "resources/images/full_star.svg");
					let markerImage = new kakao.maps.MarkerImage(
						"https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png",
						new kakao.maps.Size(25, 40),
						{ offset: new kakao.maps.Point(13, 37) }
					);

					[clusterer, markers] = changeMarker(markers, result, clusterer, markerImage);

					const cardId = e.target.id.replace("star", "card");
					let favoriteValues = $(`#${cardId}`).serialize();
					$.ajax({
						type: 'post',
						url: 'favorite?action=add',
						data: favoriteValues,
						dataType: 'json',
						success: function(json) {
							if(json.success) alert("즐겨찾기 추가!");
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
			});
		});
	}
	
	const openModal = (store) => {
		console.log(store);
		let addr = store.addr1 ? store.addr1 : "(없음)";
		let tel = store.tel ? store.tel : "(없음)";
		let modalHtml = `
	  		<h3>📌주소 : ${addr}</h3>
	  		<h3>📞전화번호 : ${tel}</h3>
	  		<hr />
	  		<h1>✨장소에 등록 된 리뷰✨</h1>
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
}

mainPage(document);