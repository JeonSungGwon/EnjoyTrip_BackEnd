<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String imageUrl = "https://bot-log-product.s3.ap-northeast-2.amazonaws.com/product/tving/still/P001588024-%ED%95%91%EA%B5%AC6.jpeg";
%>

<header>
	<img class="logo" id="logo" src="resources/images/logo.svg" />
    <div id="profileBtn" class="profile" style="cursor: pointer">
        <img class="profile-image" src=<%= imageUrl %> />
        <p>핑구 성권</p>
    </div>
</header>