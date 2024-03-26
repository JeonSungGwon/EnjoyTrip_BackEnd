<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

    <link href="resources/css/index.css" rel="stylesheet" />
    <link href="resources/css/mainpage.css" rel="stylesheet" />

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7725f9c52c11588d81633bf7a9f1723d&libraries=clusterer"></script>

    <script src="resources/js/mainpage.js" type="module" defer></script>
    <title>Enjoy Trip!</title>
  </head>
  <body>
    <%@ include file="components/header.jsp" %>
    
    <main>
      <section>
        <form class="search" id="search" action="post">
          <div class="selects" id="selects">
            <span>어디로 여행 가시나요?</span>
            <select name="location" id="location">
              <option value="">시, 도를 선택하세요.</option>
              <option value="1">서울</option>
              <option value="2">인천</option>
              <option value="3">대전</option>
              <option value="4">대구</option>
              <option value="5">광주</option>
              <option value="6">부산</option>
              <option value="7">울산</option>
              <option value="8">세종</option>
              <option value="31">경기</option>
              <option value="32">강원</option>
              <option value="33">충북</option>
              <option value="34">충남</option>
              <option value="35">경북</option>
              <option value="36">경남</option>
              <option value="37">전북</option>
              <option value="38">전남</option>
              <option value="39">제주</option>
            </select>
            <select id="subLocation">
              <option value="">시, 군, 구를 선택하세요.</option>
              <!-- 지역코드 조회 API 결과값 -->
            </select>
          </div>

          <div id="searchBar" class="searchbar">
            <input
              name="keyword"
              id="keyword"
              class="search-input"
              placeholder="여행지 이름, 위치 등 검색어를 입력해 주세요."
            />
            <button type="submit" id="searchButton">
              <span class="material-symbols-outlined">search</span>
            </button>
          </div>
        </form>
      </section>

      <section id="map" class="map"></section>

      <section id="result" class="result"></section>
    </main>

    <%@ include file="components/footer.jsp" %>
    <%@ include file="components/modal.jsp" %>
  
  </body>
</html>

