import { Card, setCardWidthHeight } from "./components.js";
import { initializeKakaoMap, makeMarker, setMarkers } from "./kakao.js";
import { fetchSubLocationOptions, search } from "./service.js";

const mainPage = (app) => {	
	// 지도 초기화
	let map = initializeKakaoMap();
	let clusterer = new kakao.maps.MarkerClusterer({
      map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
      averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
      minLevel: 5, // 클러스터 할 최소 지도 레벨
    });
    let markers = [];
    
	const locationSelect = app.getElementById("location");
	const subLocationSelect = app.getElementById("subLocation");	
	const keywordInput = app.getElementById("keyword");
	const searchButton = app.getElementById("searchButton");
	
	let carsdDiv = null;
	let cards = null;
	let results = [];
	
	// 검색 결과 부분
	const resultDiv = app.getElementById("result");
	
	// 지역 대분류 선택시 소분류 API 호출
	locationSelect.addEventListener("change", async () => {
		subLocationSelect.innerHTML = "<option value=\"\">불러오는 중..</option>";
		const subLocations = await fetchSubLocationOptions(locationSelect.value);
		subLocationSelect.innerHTML = "";
      	subLocations.forEach((location) => {
        	const option = document.createElement("option");
	    	option.value = location.code;
	    	option.textContent = location.name;
	    	subLocationSelect.appendChild(option);
	  	});
	});
	
	// 검색~
	searchButton.addEventListener("click", async (e) => {
		e.preventDefault();
		results = await search(locationSelect.value, subLocationSelect.value, keywordInput.value);
		
		if(results == null) {
			resultDiv.innerHTML = `<h2 style="margin-bottom: 5rem">검색 결과가 없습니다. 😢</h2>`;
		} else {
			resultDiv.innerHTML = `
		    	<h2 style="margin-bottom: 1rem">검색 결과 입니다! 😊</h2>
		        <div id="cards" class="cards"></div>
		    `;
		    
		   	let temp = setMarkers(clusterer, markers, results, map);
			markers = temp[0];
			clusterer = temp[1];
			
			let html = "";
			results.map((result) => {
				carsdDiv = app.getElementById("cards");
				html += Card(
		          			result.contentid,
	    	      			result.firstimage ? result.firstimage : "",
	          				result.title.split("(")[0],
	          				result.addr1.split(" ")[0] + " " + result.addr1.split(" ")[1],
	          				"18%"
	        			);
				});
				
				carsdDiv.innerHTML= html;
				cards = carsdDiv.querySelectorAll(".card");
				cards.forEach((card) => {
			    	setCardWidthHeight(card);
			
			    	card.addEventListener("click", (event) => {
			      		const cardId = event.currentTarget.id.replace("card", "");
			      		const clickedStore = results.find((store) => store.contentid === cardId);
			      		if (clickedStore) {
					        const position = new kakao.maps.LatLng(
					          parseFloat(clickedStore.mapy),
					          parseFloat(clickedStore.mapx)
					        );
					        map.setCenter(position);
				      	}
				    });
				});
				
				clickStar(results);
				// clickCard();
			}
	});
	// searchButton addEvent end
	
	const clickStar = (results) => {
		for (let i = 0; i < results.length; i++) {
			let starIcon = app.getElementById(`star${results[i].contentid}`);
      		starIcon.addEventListener("click", (e) => {
        		const storeId = e.target.id.replace("star", "");
        		const target = results.find((result) => result.contentid === storeId);

        		// 즐겨찾기 삭제
        		if (starIcon.getAttribute("src") === "resources/images/full_star.svg") {
          			starIcon.setAttribute("src", "resources/images/empty_star.svg");
          			makeMarker(markers, target, clusterer, null);
		        }
		        // 즐겨찾기 추가 
		        else {
					let memberNo = app.getElementsByClassName("profile")[0].id.split("profile")[1];
					console.log(target);
				 	window.location.href = "favorite?action=add&memberNo=" + `${memberNo}` + "&contentId=" + `${target.contentid}` + "&addr=" + `${target.addr1 ? target.addr1 : target.addr2}` 
				 		+ "&title=" + `${target.title}` + "&image=" + `${target.firstimage}`;
					starIcon.setAttribute("src", "resources/images/full_star.svg");
					let markerImage = new kakao.maps.MarkerImage(
											"https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png",
											new kakao.maps.Size(25, 40),
						                	{ offset: new kakao.maps.Point(13, 37)}	
						                );
					makeMarker(markers, target, clusterer, markerImage);
        		}
      		});
    	}
	}	
}

mainPage(document);