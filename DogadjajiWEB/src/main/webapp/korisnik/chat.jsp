<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Chat</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to bottom, #74b9ff, #a29bfe);
	margin: 0;
	padding: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
	min-height: 100vh;
}

h2 {
	color: white;
	margin-bottom: 20px;
}

.chat-box {
	width: 70%;
	max-width: 800px;
	background: white;
	border-radius: 8px;
	padding: 20px;
	box-shadow: 0 4px 8px rgba(0,0,0,0.2);
	display: flex;
	flex-direction: column;
	overflow-y: auto;
	max-height: 60vh;
}

.message {
	margin: 10px 0;
	padding: 10px 15px;
	border-radius: 8px;
	max-width: 60%;
	word-wrap: break-word;
}

.message.sent {
	background-color: #0984e3;
	color: white;
	align-self: flex-end;
}

.message.received {
	background-color: #dfe6e9;
	color: black;
	align-self: flex-start;
}

form {
	margin-top: 20px;
	width: 70%;
	max-width: 800px;
	display: flex;
}

input[type="text"] {
	flex: 1;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 1rem;
}

button {
	background-color: #0984e3;
	color: white;
	border: none;
	padding: 10px 20px;
	margin-left: 10px;
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
	<h2>Razgovor sa ${primalac.ime}</h2>

	<div class="chat-box">
		<c:forEach var="poruka" items="${poruke}">
			<div class="message ${poruka.korisnik1.idKorisnik == ulogovani.idKorisnik ? 'sent' : 'received'}">
				${poruka.tekst}
			</div>
		</c:forEach>
	</div>

	<form action="/Dogadjaji/porukaController/posalji" method="post">
		<input type="hidden" name="idPrimaoca" value="${primalac.idKorisnik}">
		<input type="text" name="tekst" placeholder="Unesite poruku..." required>
		<button type="submit">Pošalji</button>
	</form>

	<a href="/Dogadjaji/porukaController/listaKorisnika" class="btn">Nazad</a>
</body>
</html>
