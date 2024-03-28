<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Enjoy Trip!</title>

<link href="resources/css/index.css" rel="stylesheet" />
<link href="resources/css/login.css" rel="stylesheet" />

<script type="module" src="resources/js/signpage.js" defer></script>
</head>

<body>
	<%
  		boolean isNotMember = false;
  		if(request.getAttribute("isNotMember") != null) {  			
  			isNotMember = (boolean)request.getAttribute("isNotMember");
  		}
  		if(isNotMember == true) {
  	%>
	<script>
  		let flag = window.confirm("회원 정보가 없습니다! 회원가입으로 이동하시겠어요?");
  		if(flag === true) window.location.href = "member?action=signup";
  	</script>
	<% } %>
	<button type="button" class="logo_btn">
		<img src="resources/images/logo.svg" alt="로고이미지" onclick="" />
	</button>

	<main id="signin" class="signin">
		<p class="title_text" id="title_text">
			바쁘고 지친 하루 하루, <br /> 아무런 걱정없이 <br />여행을 떠나보세요.
		</p>
		<div>
			<form id="signinForm" method="post" action="member">
				<input type="hidden" name="action" value="doLogin" /> <input
					id="id" name="id" type="email" placeholder="아이디(이메일)" /> <input
					id="password" name="password" type="password" placeholder="비밀번호" />
				<button type="submit">로그인</button>
				<p>
					회원이 아니신가요? <a href="member?action=signup">회원가입</a>
				</p>
			</form>
		</div>
	</main>
</body>
</html>

