<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Lista događaja</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f6f8;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #004466;
            margin-top: 20px;
        }
        table {
            border-collapse: collapse;
            width: 85%;
            margin: 20px auto;
            background-color: white;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            border-radius: 6px;
            overflow: hidden;
        }
        th, td {
            padding: 10px 14px;
            text-align: left;
        }
        th {
            background-color: #007b9e;
            color: white;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f2fbfc;
        }
        tr:hover {
            background-color: #d8f4f8;
        }
        form {
            display: inline;
        }
        button {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 6px 12px;
            cursor: pointer;
            border-radius: 4px;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

<h2>📅 Lista događaja</h2>

<table>
    <thead>
        <tr>
            <th>Naziv</th>
            <th>Opis</th>
            <th>Datum</th>
            <th>Akcija</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="dogadjaj" items="${dogadjaji}">
            <tr>
                <td>${dogadjaj.naziv}</td>
                <td>${dogadjaj.opis}</td>
                <td><fmt:formatDate value="${dogadjaj.datum}" pattern="yyyy-MM-dd" /></td>
                <td>
                    <form action="/Dogadjaji/administratorController/obrisiDogadjaj" method="post">
                        <input type="hidden" name="idDogadjaja" value="${dogadjaj.idDogadjaj}">
                        <button type="submit">Obriši</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
