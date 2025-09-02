<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Slanje poruke</title>
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
	width: 70%;
	margin-bottom: 20px;
	background-color: white;
	border-radius: 8px;
	overflow: hidden;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

th, td {
	border: 1px solid #ccc;
	padding: 12px;
	text-align: center;
}

th {
	background-color: #0984e3;
	color: white;
}

button {
	background-color: #0984e3;
	color: white;
	border: none;
	padding: 8px 15px;
	border-radius: 6px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

button:hover {
	background-color: #0652dd;
}

.btn {
	background-color: #636e72;
	color: white;
	padding: 10px 20px;
	border-radius: 6px;
	text-decoration: none;
	font-size: 1rem;
	margin-top: 20px;
}
</style>
</head>
<body>
	<h2>Lista korisnika</h2>

	<table>
		<thead>
			<tr>
				<th>Korisničko ime</th>
				<th>Akcija</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="korisnik" items="${korisnici}">
				<c:if test="${korisnik.idKorisnik != ulogovani.idKorisnik}">
					<tr>
						<td>${korisnik.ime}</td>
						<td>
							<form action="/Dogadjaji/porukaController/chat" method="get">
								<input type="hidden" name="idPrimaoca" value="${korisnik.idKorisnik}">
								<button type="submit">Pošalji poruku</button>
							</form>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>

	<a href="/Dogadjaji/dogadjajController/korisnikHome" class="btn">Nazad</a>
</body>
</html>
