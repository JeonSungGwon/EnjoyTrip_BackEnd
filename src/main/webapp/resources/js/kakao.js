
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

export function setMarkers(clusterer, markers, stores, map) {
	// 기존 마커 제거
	clusterer.clear();
	markers = [];

	stores.forEach((store) => {
		const markerPosition = new kakao.maps.LatLng(
			parseFloat(store.latitude),
			parseFloat(store.longitude)
		);

		const marker = new kakao.maps.Marker({
			position: markerPosition,
			title: store.title,
		});

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

	return [markers, clusterer];
}

export function makeMarker(markers, target, clusterer, markerImage) {
	console.log(target);
	const clickedMarker = markers.find((marker) => marker.getTitle() === target.title);
	if (clickedMarker !== undefined) {
		// 기존의 마커를 제거합니다.
		clusterer.removeMarker(clickedMarker); // 클러스터에서도 제거합니다.
		markers = markers.filter((marker) => marker !== clickedMarker);

		// 새로운 마커를 생성하여 클러스터에 추가합니다.
		const markerPosition = new kakao.maps.LatLng(
			parseFloat(target.latitude),
			parseFloat(target.longitude)
		);

		const newMarker = markerImage ? new kakao.maps.Marker({
			position: markerPosition,
			title: target.title,
			image: markerImage
		}) : new kakao.maps.Marker({
			position: markerPosition,
			title: target.title
		});

		markers.push(newMarker);
		clusterer.addMarker(newMarker);
	}
}