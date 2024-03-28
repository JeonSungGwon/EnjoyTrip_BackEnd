// kakao 맵 초기화
export const initializeKakaoMap = () => {
	const mapContainer = document.getElementById("map"); // 지도를 표시할 div
	const mapOption = {
		center: new kakao.maps.LatLng(36.355453, 127.297992), // 초기 지도의 중심좌표
		level: 3, // 지도의 확대 레벨
	};
	return new kakao.maps.Map(mapContainer, mapOption);
}

// 인포윈도우를 표시하는 클로저를 만드는 함수
function makeOverListener(map, marker, infowindow) {
	return function() {
		infowindow.open(map, marker);
	};
}

// 인포윈도우를 닫는 클로저를 만드는 함수
function makeOutListener(infowindow) {
	return function() {
		infowindow.close();
	};
}

export function setSearchedMap(clusterer, markers, stores, map, favoriteList, memberNo) {
	// 기존 마커 제거
	clusterer.clear();
	markers = [];

	stores.forEach((store) => {
		//alert(memberNo);
		const isFavorite = favoriteList[0].find((favorite) => favorite.memberNo == memberNo && favorite.contentId == store.contentId);
		let marker; // let으로 선언

		const markerPosition = new kakao.maps.LatLng(
			parseFloat(store.latitude),
			parseFloat(store.longitude)
		);
		if(isFavorite){
			marker = new kakao.maps.Marker({ // const -> let으로 변경
			position: markerPosition,
			title: store.title,
			image: new kakao.maps.MarkerImage(
                "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png",
                new kakao.maps.Size(25, 40),
                { offset: new kakao.maps.Point(13, 37) }
              ),
			});
		}else{
			marker = new kakao.maps.Marker({ // const -> let으로 변경
			position: markerPosition,
			title: store.title,
			});
		}

		const infowindow = new kakao.maps.InfoWindow({
			content:
				'<div style="padding:5px;font-size:12px;">' +
				store.title +
				"</div>",
		});

		markers.push(marker);

		kakao.maps.event.addListener(
			marker,
			"mouseover",
			makeOverListener(map, marker, infowindow)
		);

		kakao.maps.event.addListener(
			marker,
			"mouseout",
			makeOutListener(infowindow)
		);
	});

	// 클러스터에 마커 추가
	clusterer.addMarkers(markers);

	// 중심 좌표 변경
	const firstStore = stores[0]; // 첫 번째 상점의 좌표를 기준으로 설정

	const center = new kakao.maps.LatLng(
		parseFloat(firstStore.latitude),
		parseFloat(firstStore.longitude)
	);
	map.setCenter(center);
	return [clusterer, markers];
}

export function changeMarker(markers, target, clusterer, markerImage) {
	const clickedMarker = markers.find((marker) => marker.getTitle() === target.title);
	if (clickedMarker !== undefined) {
		// 기존의 마커를 제거합니다.
		clusterer.removeMarker(clickedMarker);
		markers = markers.filter((marker) => marker !== clickedMarker);

		// 새로운 마커를 생성하여 클러스터에 추가합니다.
		const markerPosition = new kakao.maps.LatLng(
			parseFloat(target.latitude),
			parseFloat(target.longitude)
		);

		let newMarker; // let으로 선언
		if (markerImage) {
			newMarker = new kakao.maps.Marker({
				position: markerPosition,
				title: target.title,
				image: markerImage
			});
		} else {
			newMarker = new kakao.maps.Marker({
				position: markerPosition,
				title: target.title
			});
		}

		markers.push(newMarker);
		clusterer.addMarker(newMarker);
	}

	return [clusterer, markers];
}
