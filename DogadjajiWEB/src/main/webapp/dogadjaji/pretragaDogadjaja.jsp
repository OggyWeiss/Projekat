<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="sr">
<head>
    <meta charset="UTF-8">
    <title>Pretraga događaja</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to bottom, #a1c4fd, #c2e9fb);
            padding: 20px;
            margin: 0;
            min-height: 100vh;
        }
        h1 {
            text-align: center;
            color: white;
            margin-bottom: 30px;
        }
        form {
            background: white;
            padding: 20px;
            max-width: 600px;
            margin: 0 auto 30px auto;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.1);
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #0984e3;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0652dd;
        }
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
            overflow: hidden;
        }
        th, td {
            border: 1px solid #dfe6e9;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #0984e3;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f1f2f6;
        }
        .back-btn-container {
            text-align: center;
            margin-top: 20px;
        }
        .back-btn {
            display: inline-block;
            background-color: #0984e3;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }
        .back-btn:hover {
            background-color: #0652dd;
        }
    </style>
</head>
<body>
    <h1>Pretraga događaja</h1>

    <!-- Forma za pretragu -->
    <form action="/Dogadjaji/dogadjajController/pretraga" method="get"> 
        Naziv dogadjaja:
        <input type="text" id="naziv" name="naziv">

        Datum: (opciono)
        <input type="date" id="datum" name="datum">

        <button type="submit">Pretraži</button>
    </form>

    <!-- Tabela sa rezultatima -->
    <table>
        <thead>
            <tr>
                <th>Naziv</th>
                <th>Opis</th>
                <th>Datum</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${rezultati}" var="d">
                <tr>
                    <td>${d.naziv}</td>
                    <td>${d.opis}</td>
                    <td><fmt:formatDate value="${d.datum}" pattern="yyyy-MM-dd" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Dugme za povratak -->
    <div class="back-btn-container">
        <a href="/Dogadjaji" class="back-btn">Nazad na početnu</a>
    </div>

</body>
</html>
