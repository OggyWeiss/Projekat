<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Prijava na događaj</title>
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

h1 {
	color: white;
	margin-bottom: 30px;
}

form {
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 300px;
}

select, button {
	padding: 10px;
	font-size: 1rem;
	margin-top: 10px;
	width: 100%;
}

button {
	background-color: #0984e3;
	color: white;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

button:hover {
	background-color: #0652dd;
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
	display: inline-block;
	text-align: center;
	width: auto;
}
</style>
</head>
<body>
	<h1>Prijava na događaj</h1>

	<form action="/Dogadjaji/dogadjajController/prijavaNaDogadjaj" method="post">
		<label for="idDogadjaj">Izaberi događaj:</label> <br>
		<select name="idDogadjaj" id="idDogadjaj" required>
			<c:forEach var="d" items="${dogadjaji}">
				<option value="${d.idDogadjaj}">${d.naziv}</option>
			</c:forEach>
		</select> <br><br>
		<button type="submit">Prijavi se</button>
	</form>

	<a href="/Dogadjaji/dogadjajController/korisnikHome" class="btn">Nazad</a>
</body>
</html>
