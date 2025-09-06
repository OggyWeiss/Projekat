<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Registracija - EventHub</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to bottom, #74b9ff, #a29bfe);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.container {
	background-color: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
	width: 350px;
	text-align: center;
}

input, select {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button {
	background-color: #0984e3;
	color: white;
	padding: 10px;
	width: 100%;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

button:hover {
	background-color: #0652dd;
}

.error {
	color: red;
	margin-top: 10px;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Registracija</h2>

		<c:if test="${not empty greska}">
			<div class="error">${greska}</div>
		</c:if>

		<form:form method="post" modelAttribute="korisnikDTO"
			action="/Dogadjaji/registracijaController/registracija">

			<form:input path="ime" placeholder="Ime" />
			<form:errors path="ime" cssClass="error" />

			<form:input path="prezime" placeholder="Prezime" />
			<form:errors path="prezime" cssClass="error" />

			<form:input path="email" type="email" placeholder="Email"/>
			<form:errors path="email" cssClass="error" />

			<form:password path="lozinka" placeholder="Lozinka" />
			<form:errors path="lozinka" cssClass="error" />

			<form:select path="uloga">
				<form:option value="KORISNIK" label="Korisnik" />
				<form:option value="ADMIN" label="Administrator" />
			</form:select>
			<form:errors path="uloga" cssClass="error" />

			<button type="submit">Registruj se</button>
		</form:form>

		<div style="margin-top: 10px;">
			<a href="/Dogadjaji/loginController/prikazLogina">Već imate
				nalog? Prijavite se</a>
		</div>
	</div>
</body>
</html>
