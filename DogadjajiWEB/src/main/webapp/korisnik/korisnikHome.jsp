<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="sr">
<head>
    <meta charset="UTF-8">
    <title>Početna stranica - korisnik</title>
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
        h1 {
            color: white;
            margin-bottom: 40px;
        }
        .btn-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            max-width: 700px;
            width: 100%;
        }
        .btn {
            background-color: #0984e3;
            color: white;
            padding: 15px 25px;
            border: none;
            border-radius: 8px;
            text-decoration: none;
            font-size: 1.1rem;
            cursor: pointer;
            text-align: center;
            flex: 1 1 250px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #0652dd;
        }
    </style>
</head>
<body>
    <h1>Dobrodošli, ${ulogovaniKorisnik.ime}!</h1>

    <div class="btn-container">
        <a href="/Dogadjaji/dogadjajController/dodajDogadjaj" class="btn">Dodaj događaj</a>
        <a href="/Dogadjaji/dogadjajController/obrisiDogadjaj" class="btn">Obriši događaj</a>
        <a href="/Dogadjaji/dogadjajController/izmeniDogadjaj" class="btn">Izmeni događaj</a>
        <a href="/Dogadjaji/dogadjajController/prijavaNaDogadjaj" class="btn">Prijava na događaj</a>
        <a href="/Dogadjaji/dogadjajController/odjavaSaDogadjaja" class="btn">Odjava sa događaja</a>
        <a href="/Dogadjaji/dogadjajController/ucestvuje" class="btn">Pregled na kojima učestvuješ</a>
        <a href="/Dogadjaji/porukaController/slanjePoruke" class="btn">Slanje poruka</a>
        <a href="/Dogadjaji/dogadjajController/dodajKomentar" class="btn">Dodaj komentar</a>
    </div>
</body>
</html>
