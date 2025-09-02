<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Dogadjaji na kojima učestvuješ</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to bottom, #74b9ff, #a29bfe);
	margin: 0;
	padding: 40px 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
	min-height: 100vh;
}

h2 {
	color: white;
	margin-bottom: 30px;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin-bottom: 20px;
	background-color: white;
	border-radius: 8px;
	overflow: hidden;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

th, td {
	border: 1px solid #ccc;
	padding: 12px;
	text-align: left;
}

th {
	background-color: #0984e3;
	color: white;
}

.btn {
	background-color: #0984e3;
	color: white;
	padding: 12px 25px;
	border: none;
	border-radius: 8px;
	text-decoration: none;
	font-size: 1rem;
	cursor: pointer;
	transition: background-color 0.3s ease;
	margin-top: 15px;
}

.btn:hover {
	background-color: #0652dd;
}
</style>
</head>
<body>
	<h2>Dogadjaji na kojima učestvuješ</h2>

	<table>
		<thead>
			<tr>
				<th>Naziv događaja</th>
				<th>Datum</th>
				<th>Opis</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dogadjaj" items="${dogadjaji}">
				<tr>
					<td>${dogadjaj.naziv}</td>
					<td><fmt:formatDate value="${dogadjaj.datum}" pattern="yyyy-MM-dd" /></td>
					<td>${dogadjaj.opis}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="/Dogadjaji/dogadjajController/korisnikHome" class="btn">Nazad</a>

</body>
</html>
