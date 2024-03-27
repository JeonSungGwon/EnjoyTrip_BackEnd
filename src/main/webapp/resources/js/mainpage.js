import { fetchSubLocationOptions, initializeKakaoMap, search } from "./service.js";

const mainPage = (app) => {	
	const locationSelect = app.getElementById("location");
	const subLocationSelect = app.getElementById("subLocation");	
	const keywordInput = app.getElementById("keyword");
	const searchButton = app.getElementById("searchButton");
	
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
		const results = await search(locationSelect.value, subLocationSelect.value, keywordInput.value);
		// 이 함수에 지도 표시 할 코드 작성할 것임
		// setSearchMap();
		
		console.log(results);
		if(results.length) {
			resultDiv.innerHTML = `<h2 style="margin-bottom: 50px">😢 검색 결과가 없습니다.</h2>`;
		} else {
			resultDiv.innerHTML = `
		    	<h2>검색 결과 입니다😊</h2>
		        <div id="cards" class="cards"></div>
		    `;
		}
		
		setCardDiv(results);
	});
	
	const setCardDiv = (results) => {
		const cardsDiv = app.getElementById("cards");
		results.map((result) => {
			html += Card(
	          result.contentid,
    	      result.firstimage
        	    ? result.firstimage
            	: "../../assets/images/noimage.svg",
          	result.title.split("(")[0],
          result.addr1.split(" ")[0] + " " + result.addr1.split(" ")[1],
          "18%"
        );
		})
	}
	
	// 지도 관련
	const map = initializeKakaoMap();
	const clusterer = new kakao.maps.MarkerClusterer({
      map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
      averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
      minLevel: 5, // 클러스터 할 최소 지도 레벨
    });

}

mainPage(document);