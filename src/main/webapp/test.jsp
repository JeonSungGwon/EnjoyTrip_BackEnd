<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enjoy Trip</title>
</head>
<body>
	<h1>Choose Sido and Gugun</h1>

	<form action="/map" method="get">
		<input type="hidden" name="action" value="sido"> <select
			name="sidoCode" id="sidoSelect" onchange="this.form.submit()">
			<option value="">Select Sido</option>
			<c:forEach items="${sidoList}" var="sido">
				<option value="${sido.code}">${sido.name}</option>
			</c:forEach>
		</select>
	</form>

	<form action="/map" method="get">
		<input type="hidden" name="action" value="gugun"> <select
			name="gugunCode" id="gugunSelect">
			<option value="">Select Gugun</option>
		</select>
	</form>

</body>
</html>
