<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="sr">
<head>
    <meta charset="UTF-8" />
    <title>Izmeni događaj</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background: #f5f7fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background: white;
            padding: 40px 50px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.1);
            width: 380px;
        }
        h1 {
            margin-bottom: 30px;
            font-weight: 600;
            font-size: 28px;
            color: #222f3e;
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #57606f;
            font-size: 14px;
        }
        input[type="text"],
        textarea,
        input[type="date"] {
            width: 100%;
            padding: 12px 14px;
            border: 1.8px solid #ced6e0;
            border-radius: 8px;
            font-size: 15px;
            margin-bottom: 20px;
            transition: border-color 0.3s ease;
        }
        input[type="text"]:focus,
        textarea:focus,
        input[type="date"]:focus {
            outline: none;
            border-color: #3742fa;
            box-shadow: 0 0 8px rgba(55, 66, 250, 0.3);
        }
        textarea {
            resize: vertical;
            min-height: 90px;
        }
        button {
            width: 100%;
            padding: 14px 0;
            background: #3742fa;
            border: none;
            border-radius: 10px;
            color: white;
            font-size: 17px;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.25s ease;
        }
        button:hover {
            background: #2f37e6;
        }
    </style>
</head>
<body>
    <form action="/Dogadjaji/dogadjajController/izmeniSacuvaj" method="post">
        <h1>Izmeni događaj</h1>

        <!-- Sakriveno polje za ID događaja -->
        <input type="hidden" name="idDogadjaj" value="${dogadjaj.idDogadjaj}" />

        <label for="naziv">Naziv događaja</label>
        <input type="text" id="naziv" name="naziv" required value="${dogadjaj.naziv}" />

        <label for="opis">Opis događaja</label>
        <textarea id="opis" name="opis" required>${dogadjaj.opis}</textarea>

        <label for="datum">Datum održavanja</label>
        <input type="date" id="datum" name="datum" required 
            value="<fmt:formatDate value='${dogadjaj.datum}' pattern='yyyy-MM-dd'/>" />

        <button type="submit">Sačuvaj izmene</button>
    </form>
</body>
</html>
