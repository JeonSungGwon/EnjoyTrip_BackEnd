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

<style>
/* 모달 스타일 */
.logout-modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
}

.logout-model>div {
	background-color: #fefefe;
	margin: 15% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>

</head>
<body>
	<%@ include file="components/header.jsp"%>

	<main>
		<section>
			<form id="profileEdit" class="profile-edit">
				<img src="${member.profileImage}" id="profileImage" />
				<h1>${member.nickname}</h1>
				<span class="material-symbols-outlined" id="editProfile">edit</span>
			</form>
			<div class="buttons">
				<a id="logout" class="logout"
					href="/enjoytrip_backend-master/member?action=doLogout">로그아웃</a> <a
					id="leave" class="leave" href="#" onclick="openModal()">회원탈퇴</a>
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

	<div id="logoutModal" class="logout-modal">
		<div class="modal-content">
			<span class="close" id="closeModal">&times;</span>
			<h2>비밀번호 확인</h2>
			<input type="password" id="password" placeholder="비밀번호 입력">
			<button id="confirmPassword">확인</button>
			<p id="errorMessage" style="color: red;"></p>
		</div>
	</div>

	<script>
        function openModal() {
            document.getElementById("logoutModal").style.display = "block";
        }

        function closeModal() {
            document.getElementById("logoutModal").style.display = "none";
        }

        // 모달 닫기 이벤트 처리
        document.getElementById("closeModal").addEventListener("click", () => {
            closeModal();
        });

        // 비밀번호 확인 및 회원 탈퇴 요청
        document.getElementById("confirmPassword").addEventListener("click", () => {
            const password = document.getElementById("password").value;
			if(password == ${member.password}){
				window.location.href = '/enjoytrip_backend-master/member?action=remove&no=${member.no}'
			}else {
                // 비밀번호가 일치하지 않는 경우 알림 표시
                $('#errorMessage').text('비밀번호가 일치하지 않습니다.');
            }
        });
    </script>
</body>
</html>
