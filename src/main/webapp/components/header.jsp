<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<header>
	<img class="logo" id="logo" src="resources/images/logo.svg" />
    <div id="profileBtn" class="profile" style="cursor: pointer">
        <img class="profile-image" src=`${member.profileImage}` />
        <p>${member.nickname}</p>
    </div>
</header>