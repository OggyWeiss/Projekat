<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Sačuvaj komentar</title>
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

form {
    background: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    display: flex;
    flex-direction: column;
    gap: 15px;
    width: 300px;
}

textarea {
    resize: none;
    padding: 10px;
    font-size: 1rem;
    border-radius: 6px;
    border: 1px solid #ccc;
    min-height: 100px;
}

button {
    background-color: #0984e3;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
}

button:hover {
    background-color: #0652dd;
}
</style>
</head>
<body>
    <h2>Dodaj komentar za događaj: ${dogadjaj.naziv}</h2>

    <form action="/Dogadjaji/dogadjajController/sacuvajKomentar" method="post">
        <input type="hidden" name="idDogadjaj" value="${dogadjaj.idDogadjaj}"/>
        <textarea name="tekst" placeholder="Unesi komentar..." required></textarea>
        <button type="submit">Sačuvaj</button>
    </form>
</body>
</html>
