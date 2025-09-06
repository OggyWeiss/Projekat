<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8" />
<title>Administrator - Početna stranica</title>
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

.btn-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 25px;
	max-width: 500px;
	width: 100%;
}

.btn {
	background-color: #d63031;
	color: white;
	padding: 15px 30px;
	border: none;
	border-radius: 8px;
	text-decoration: none;
	font-size: 1.2rem;
	cursor: pointer;
	text-align: center;
	flex: 1 1 200px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.25);
	transition: background-color 0.3s ease;
	display: flex;
	align-items: center;
	justify-content: center;
}

.btn:hover {
	background-color: #e17055;
}

.logout-btn {
	background-color: black;
}
.logout-btn:hover {
	background-color: #333;
}
</style>
</head>
<body>
	<h1>Dobrodošli, ${ulogovaniKorisnik.ime}!</h1>
	<div class="btn-container">
		<a href="/Dogadjaji/administratorController/pregledKorisnika" class="btn">Pregled korisnika</a> 
		<a href="/Dogadjaji/administratorController/pregledDogadjaja" class="btn">Pregled događaja</a> 
		<a href="/Dogadjaji/administratorController/brojDogadjaja" class="btn">Broj događaja - izveštaj</a> 
		<a href="/Dogadjaji/administratorController/brojPrijava" class="btn">Broj korisnika prijavljenih na događaj - izveštaj</a>
	</div>

	
	<div class="btn-container" style="margin-top: 30px;">
		<form action="/Dogadjaji/loginController/odjava" method="get" style="width: 100%; display: flex; justify-content: center;">
			<button type="submit" class="btn logout-btn">Logout</button>
		</form>
	</div>
</body>
</html>
