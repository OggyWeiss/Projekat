<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="sr">
<head>
    <meta charset="UTF-8" />
    <title>Obriši događaje</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to bottom, #fab1a0, #ff7675);
            margin: 0;
            padding: 40px 20px;
            min-height: 100vh;
        }
        h1 {
            text-align: center;
            color: #2d3436;
            margin-bottom: 30px;
        }
        form {
            max-width: 900px;
            margin: 0 auto;
            background: white;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 25px;
        }
        th, td {
            padding: 12px 15px;
            border-bottom: 1px solid #dfe6e9;
            text-align: left;
        }
        th {
            background-color: #fd79a8;
            color: white;
        }
        tr:hover {
            background-color: #ffe6eb;
        }
        button {
            background-color: #d63031;
            color: white;
            border: none;
            padding: 14px 28px;
            font-size: 1.1rem;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: block;
            margin: 0 auto;
        }
        button:hover {
            background-color: #e17055;
        }
    </style>
</head>
<body>
    <h1>Obriši događaje</h1>

    <form action="/Dogadjaji/dogadjajController/obrisi" method="post">
        <table>
            <thead>
                <tr>
                    <th>Izaberi</th>
                    <th>Naziv</th>
                    <th>Opis</th>
                    <th>Datum</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dogadjaji}" var="d">
                    <tr>
                        <td><input type="checkbox" name="id" value="${d.idDogadjaj}" /></td>
                        <td>${d.naziv}</td>
                        <td>${d.opis}</td>
                        <td><fmt:formatDate value="${d.datum}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <button type="submit">Obriši selektovane</button>
    </form>
</body>
</html>
