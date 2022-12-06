<%--
  Created by IntelliJ IDEA.
  User: duarte
  Date: 06/12/2022
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Création de facture</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/bill/add">
    <label for="date">Date</label>
    <input id="date" name="date" type="date">
   <input type="hidden" name="customerId" value="${customerId}">
    <button id="add-button">Ajouter</button>
</form>

</body>
</html>
