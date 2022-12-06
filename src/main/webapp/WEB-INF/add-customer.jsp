<%--Created by : User: maud_  --  Date: 05/12/2022  --  Time: 16:50
  (To change : File | Settings | File Templates)--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajout client</title>
</head>
<body>
    <h1>Ajouter un nouveau client</h1>

    <form method="post" action="#">
        <label for="designation">Raison sociale</label>
        <input id="designation" name="designation">
        <label for="address">Adresse</label>
        <input id="address" name="address">
        <label for="postCode">Code postal</label>
        <input id="postCode" name="postCode">
        <label for="city">Ville</label>
        <input id="city" name="city">
        <label for="phoneNumber">Numéro de téléphone</label>
        <input id="phoneNumber" name="phoneNumber">
        <label for="email">E-mail</label>
        <input id="email" name="email">

        <button id="add-button">Ajouter</button>
    </form>
</body>
</html>
