<%--Created by : User: maud_  --  Date: 05/12/2022  --  Time: 16:50--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajout client</title>
</head>

<body>
    <jsp:include page="../header.jsp"><jsp:param name="errorMsg" value="${error}"/></jsp:include>

    <main>
        <h2>Ajouter un nouveau client</h2>

        <form class="addForm" method="post" action="${pageContext.request.contextPath}/customers/add">
            <div class="formLabels">
                <label for="designation">Raison sociale</label>
                <label for="address">Adresse</label>
                <label for="postCode">Code postal</label>
                <label for="city">Ville</label>
                <label for="phoneNumber">Numéro de téléphone</label>
                <label for="email">E-mail</label>
            </div>
            <div class="formInputs">
                <input id="designation" name="designation">
                <input id="address" name="address">
                <input id="postCode" name="postCode">
                <input id="city" name="city">
                <input id="phoneNumber" name="phoneNumber">
                <input id="email" name="email">
            </div>
            <button id="add-button">Ajouter</button>
        </form>
    </main>
</body>
</html>
