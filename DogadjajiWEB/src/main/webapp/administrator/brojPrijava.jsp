<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8" />
<title>Broj prijava</title>
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
}

h1 {
	color: white;
	margin-bottom: 40px;
}

form {
	background-color: rgba(255, 255, 255, 0.9);
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.25);
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 20px;
}

select {
	padding: 10px;
	font-size: 1rem;
	border: 1px solid #ccc;
	border-radius: 5px;
	min-width: 220px;
}

.btn {
	background-color: #d63031;
	color: white;
	padding: 10px 25px;
	border: none;
	border-radius: 8px;
	text-decoration: none;
	font-size: 1.1rem;
	cursor: pointer;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.25);
	transition: background-color 0.3s ease;
}

.btn:hover {
	background-color: #e17055;
}
</style>
</head>
<body>
	<h1>Broj prijavljenih</h1>
	<form
		action="/Dogadjaji/administratorController/stampajBrojPrijavljenih"
		method="get">
		<label for="idDogadjaj">Izaberite događaj:</label> <select
			name="idDogadjaj" id="idDogadjaj" required>
			<c:forEach var="d" items="${dogadjaji}">
				<option value="${d.idDogadjaj}">${d.naziv}(${d.datum})</option>
			</c:forEach>
		</select>
		<button type="submit" class="btn">Štampaj</button>
	</form>

	<div style="margin-top: 20px;">
		<form action="/Dogadjaji/administratorController/administratorHome"
			method="get">
			<button type="submit" class="btn" style="background-color: #0984e3;">Nazad
				na početnu</button>
		</form>
	</div>
</body>
</html>
