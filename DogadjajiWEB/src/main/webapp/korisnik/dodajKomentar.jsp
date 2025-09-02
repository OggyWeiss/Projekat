<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="UTF-8">
<title>Dodaj komentar</title>
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

table {
    border-collapse: collapse;
    width: 80%;
    margin-bottom: 20px;
    background-color: white;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

th, td {
    border: 1px solid #ccc;
    padding: 12px;
    text-align: left;
}

th {
    background-color: #0984e3;
    color: white;
}

.btn {
    background-color: #0984e3;
    color: white;
    padding: 6px 15px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    text-decoration: none;
    font-size: 0.9rem;
}

.btn:hover {
    background-color: #0652dd;
}
</style>
</head>
<body>
    <h2>Dodaj komentar</h2>

    <table>
        <thead>
            <tr>
                <th>Naziv događaja</th>
                <th>Datum</th>
                <th>Akcija</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dogadjaj" items="${dogadjaji}">
                <tr>
                    <td>${dogadjaj.naziv}</td>
                    <td><fmt:formatDate value="${dogadjaj.datum}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <form action="/Dogadjaji/dogadjajController/sacuvajKomentar" method="get">
                            <input type="hidden" name="idDogadjaj" value="${dogadjaj.idDogadjaj}"/>
                            <input type="submit" class="btn" value="Dodaj komentar"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
