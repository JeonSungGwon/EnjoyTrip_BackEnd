<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<link href="resources/css/index.css" rel="stylesheet" />
<link href="resources/css/mainpage.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7725f9c52c11588d81633bf7a9f1723d&libraries=clusterer"></script>

<script src="resources/js/mainpage.js?t=<%System.currentTimeMillis();%>"
	type="module" defer></script>
<title>Enjoy Trip!</title>
</head>
<body>
	<%@ include file="components/header.jsp"%>

	<main>
		<section>
			<form class="search" id="search" action="post">
				<div class="selects" id="selects">
					<span>어디로 갈건데?</span> <select name="location" id="location">
						<option value="">시, 도를 선택하세요.</option>
						<c:forEach var="sido" items="${sidoList}">
							<option value="${sido.sidoCode}">${sido.sidoName}</option>
						</c:forEach>
					</select> <select id="subLocation">
						<option value="">시, 군, 구를 선택하세요.</option>

					</select>
				</div>

				<div id="searchBar" class="searchbar">
					<input name="keyword" id="keyword" class="search-input"
						placeholder="여행지 이름, 위치 등 검색어를 입력해 주세요." />
					<button type="submit" id="searchButton">
						<span class="material-symbols-outlined">search</span>
					</button>
				</div>
			</form>
		</section>

		<section id="map" class="map"></section>

		<section id="result" class="result">
			<h2 style="margin-bottom: 5rem">어디로 가고 싶으신가요? 😉</h2>
		</section>
	</main>

	<%@ include file="components/footer.jsp"%>
	<%@ include file="components/modal.jsp"%>
</body>
</html>

