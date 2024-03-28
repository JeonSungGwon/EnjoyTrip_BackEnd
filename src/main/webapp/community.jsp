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
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<link href="resources/css/index.css" rel="stylesheet" />
<link href="resources/css/community.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	type="text/javascript"></script>
<script src="resources/js/community.js" type="module"></script>

<title>Enjoy Trip!</title>
</head>
<body>
	<%@ include file="components/header.jsp"%>

	<main>
		<h1>🚘커뮤니티🚘</h1>
		<!-- 차후 디비에서 불러와서 가져올 예정 -->
		<section>
		
			<c:forEach items="${list}" var="review">
				<figure>
					<img
						src="${review.image}" />
					<div style="width: 90%; margin: auto">
						<span>${review.title}</span><span>✍🏻${review.writer}</span>
					</div>
				</figure>
			</c:forEach>

		</section>
	</main>

	<%@ include file="components/footer.jsp"%>
	<%@ include file="components/modal.jsp"%>
</body>
</html>

