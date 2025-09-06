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
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            padding: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #4a90e2;
            color: white;
        }
        tr:hover {
            background-color: #f1f7ff;
        }
        .btn-izmeni {
            background-color: #1e90ff;
            color: white;
            border: none;
            padding: 8px 14px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-weight: 600;
        }
        .btn-izmeni:hover {
            background-color: #0d6efd;
        }
    </style>
</head>
<body>
    <h1>Izmeni događaj</h1>

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
            <c:forEach var="d" items="${dogadjaji}">
                <tr>
                    <td>${d.naziv}</td>
                    <td>${d.opis}</td>
                    <td><fmt:formatDate value="${d.datum}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <form action="/Dogadjaji/dogadjajController/izmeniStranica" method="get" style="margin:0;">
                            <input type="hidden" name="id" value="${d.idDogadjaj}" />
                            <button type="submit" class="btn-izmeni">Izmeni</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
