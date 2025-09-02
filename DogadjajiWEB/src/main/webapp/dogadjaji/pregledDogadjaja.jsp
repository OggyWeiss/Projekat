<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Pregled događaja</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to bottom, #e66465, #9198e5);
	padding: 20px;
	margin: 0;
	min-height: 100vh;
}

h1 {
	text-align: center;
	color: white;
	margin-bottom: 30px;
}

table {
	width: 80%;
	margin: 0 auto;
	border-collapse: collapse;
	background: white;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	overflow: hidden;
}

th, td {
	border: 1px solid #dfe6e9;
	padding: 12px;
	text-align: left;
}

th {
	background-color: #e66465;
	color: white;
}

tr:nth-child(even) {
	background-color: #f1f2f6;
}

.back-btn-container {
	text-align: center;
	margin-top: 20px;
}

.back-btn {
	display: inline-block;
	background-color: #0984e3;
	color: white;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 6px;
	transition: background-color 0.3s ease;
}

.back-btn:hover {
	background-color: #0652dd;
}
</style>
</head>
<body>
	<h1>Lista događaja</h1>

	<table>
		<thead>
			<tr>
				<th>Naziv</th>
				<th>Opis</th>
				<th>Datum</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dogadjaji}" var="d">
				<tr>
					<td>${d.naziv}</td>
					<td>${d.opis}</td>
					<td><fmt:formatDate value="${d.datum}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="back-btn-container">
		<a href="/Dogadjaji" class="back-btn">Nazad na početnu</a>
	</div>

</body>
</html>
