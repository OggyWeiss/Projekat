<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8" />
<title>Lista korisnika</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to bottom, #636e72, #b2bec3);
	margin: 0;
	padding: 40px 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
	min-height: 100vh;
	color: white;
}

h1 {
	margin-bottom: 30px;
}

table {
	border-collapse: collapse;
	background-color: rgba(255, 255, 255, 0.1);
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.25);
	width: 80%;
	max-width: 1000px;
}

th, td {
	padding: 12px 15px;
	text-align: left;
}

th {
	background-color: rgba(0, 0, 0, 0.2);
}

tr:nth-child(even) {
	background-color: rgba(255, 255, 255, 0.05);
}

tr:hover {
	background-color: rgba(255, 255, 255, 0.15);
}

.btn-delete {
	background-color: #d63031;
	color: white;
	padding: 8px 14px;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	font-size: 0.9rem;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.25);
	transition: background-color 0.3s ease;
}

.btn-delete:hover {
	background-color: #e17055;
}

.back-btn {
	margin-top: 20px;
	padding: 10px 20px;
	background-color: #6c757d;
	color: white;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s ease;
}

.back-btn:hover {
	background-color: #5a6268;
}

form {
	margin: 0;
}
</style>
</head>
<body>
	<h1>Lista korisnika</h1>
	<table>
		<thead>
			<tr>
				<th>Ime</th>
				<th>Prezime</th>
				<th>Email</th>
				<th>Lozinka</th>
				<th>Akcija</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="korisnik" items="${korisnici}">
				<tr>
					<td><c:out value="${korisnik.ime}" /></td>
					<td><c:out value="${korisnik.prezime}" /></td>
					<td><c:out value="${korisnik.email}" /></td>
					<td><c:out value="${korisnik.lozinka}" /></td>
					<td>
						<form action="/Dogadjaji/administratorController/obrisiKorisnika"
							method="post">
							<input type="hidden" name="id" value="${korisnik.idKorisnik}" />
							<button type="submit" class="btn-delete">Obriši</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${empty korisnici}">
				<tr>
					<td colspan="5" style="text-align: center;">Nema korisnika u
						bazi.</td>
				</tr>
			</c:if>
		</tbody>
	</table>


	<form action="/Dogadjaji/administratorController/administratorHome"
		method="get">
		<button type="submit" class="back-btn">Nazad na početnu</button>
	</form>

</body>
</html>
