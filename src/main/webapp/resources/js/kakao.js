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
  return function () {
    infowindow.open(map, marker);
  };
}

// 인포윈도우를 닫는 클로저를 만드는 함수
function makeOutListener(infowindow) {
  return function () {
    infowindow.close();
  };
}

export function setMarkers(clusterer, markers, stores, map) {
	// 기존 마커 제거
    clusterer.clear();
    markers = [];

    stores.forEach((store) => {
      const markerPosition = new kakao.maps.LatLng(
        parseFloat(store.mapy),
        parseFloat(store.mapx)
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
      parseFloat(firstStore.mapy),
      parseFloat(firstStore.mapx)
    );
   
	map.setCenter(center);
}