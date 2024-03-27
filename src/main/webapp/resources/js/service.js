const makeSubLocationURL = (areaCode) => {
	return `https://apis.data.go.kr/B551011/KorService1/areaCode1?numOfRows=100&MobileOS=ETC&MobileApp=%EC%97%AC%ED%96%89&areaCode=${areaCode}&_type=json&serviceKey=NHmBKryxoTzpzOQijbBqpbyIoX6HsTNr19mTO8DTHDk0VigM%2B2%2B4GDcFCg%2FBAzD1i3NTHd1H44D0gjLo5Elq%2Fw%3D%3D`;
}

const makeSearchURL = (location, subLocation, keyword) => {
	return `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?MobileOS=ETC&MobileApp=%EC%97%AC%ED%96%89&_type=json&arrange=O&keyword=`
	+`${keyword}&areaCode=${location}&sigunguCode=${subLocation ? subLocation : ""}`
	+`&serviceKey=NHmBKryxoTzpzOQijbBqpbyIoX6HsTNr19mTO8DTHDk0VigM%2B2%2B4GDcFCg%2FBAzD1i3NTHd1H44D0gjLo5Elq%2Fw%3D%3D`;
}

export const fetchSubLocationOptions = async (areaCode) => {
	const url = makeSubLocationURL(areaCode);
    try {
      const response = await fetch(url);
      const data = await response.json();
      return data.response.body.items.item;
    } catch (error) {
      console.error("Error fetching data when loading sub location:", error);
      return [];
    }
}

export const search = async (location, subLocation, keyword) => {
	const url = makeSearchURL(location, subLocation, keyword);
	try {
		const response = await fetch(url);
      	const data = await response.json();
      	console.log("검색 결과", data);
      	return data.response.body.items.item;
	} catch (error) {
		console.error("Error fetching data when searching:", error);
      	return [];
	}
}