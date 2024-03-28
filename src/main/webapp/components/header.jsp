<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<img class="logo" id="logo" src="resources/images/logo.svg" />
	<nav>
		<a href="community?action=list">🔥커뮤니티</a>
		<div id="profile${member.no}" class="profile" style="cursor: pointer">
			<img class="image" src="${member.profileImage}" />
			<p>${member.nickname}</p>
		</div>
	</nav>
	<script>
		document.getElementsByTagName("div")[0].addEventListener("click", ()=> {
			window.location.href = "member?action=mypage";
		});
		
		document.getElementById("logo").addEventListener("click", ()=> {
			window.location.href = "member?action=home";
		});
	</script>
</header>