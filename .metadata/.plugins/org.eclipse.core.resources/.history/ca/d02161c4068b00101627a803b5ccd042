<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dodaj kategoriju</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f8f8;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 350px;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

button {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: #45a049;
}

.error {
	color: red;
	font-size: 0.9rem;
	margin-top: -15px;
	margin-bottom: 15px;
	display: block;
}
</style>
</head>
<body>

	<form:form action="/Dogadjaji/dogadjajController/sacuvajKategoriju"
		method="post" modelAttribute="kategorijaDTO">
		<h1>Dodaj kategoriju</h1>

		<label for="naziv">Naziv kategorije</label>
		<form:input path="naziv" id="naziv"
			placeholder="Unesite naziv kategorije" />
		<form:errors path="naziv" cssClass="error" />

		<button type="submit">Sačuvaj</button>
	</form:form>


</body>
</html>
