<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Login - EventHub</title>
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

.login-container {
	background-color: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
	width: 300px;
	text-align: center;
}

h2 {
	margin-bottom: 20px;
	color: #2d3436;
}

input {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
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
	<div class="login-container">
		<h2>Uloguj se</h2>
		<form action="/Dogadjaji/loginController/login" method="post">
			<input type="text" name="email" placeholder="Email" required>
			<input type="password" name="lozinka" placeholder="Lozinka" required>
			<button type="submit">Uloguj se</button>
		</form>


		<c:if test="${not empty greska}">
			<div class="error">${greska}</div>
		</c:if>

		<div style="margin-top: 10px;">
			<a href="/Dogadjaji/registracijaController/registracija">Nemate
				nalog? Registrujte se</a>
		</div>
	</div>
</body>
</html>
