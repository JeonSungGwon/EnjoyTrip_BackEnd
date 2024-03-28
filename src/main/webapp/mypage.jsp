<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Enjoy Trip!</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<link href="resources/css/index.css" rel="stylesheet" />
<link href="resources/css/mypage.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	type="text/javascript"></script>
<script src="resources/js/mypage.js" type="module"></script>
</head>
<body>
	<%@ include file="components/header.jsp"%>

	<main>
		<section>
			<form id="profileEdit" class="profile-edit">
				<img src="${member.profileImage}" id="profileImage" /> <input
					type="file" accept="image/*" id="fileInput" name="profileImage"
					style="display: none" />
				<h1>${member.nickname}</h1>
				<span class="material-symbols-outlined" id="editProfile">edit</span>
			</form>
			<div class="buttons">
				<a id="logout" class="logout">로그아웃</a> <a id="leave" class="leave">회원탈퇴</a>
			</div>
		</section>

		<section>
			<h1>⭐️ 즐겨찾기</h1>
			<p>나만의 여행 계획을 세워보세요.</p>
			<div id="favorites" class="favorites"></div>
		</section>
	</main>


	<%@ include file="components/footer.jsp"%>
	<%@ include file="components/modal.jsp"%>
</body>
</html>

