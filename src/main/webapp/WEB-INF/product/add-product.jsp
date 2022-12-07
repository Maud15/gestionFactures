<%--
  Created by IntelliJ IDEA.
  User: duarte
  Date: 07/12/2022
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout de produit</title>
</head>
<body>
<h1>Ajout d'un nouveau produit</h1>

<form method="post" action="${pageContext.request.contextPath}/products/add">
    <label for="reference">Référence</label>
    <input id="reference" name="reference">
    <label for="description">Description</label>
    <input id="description" name="description">
    <label for="unit">Unité</label>
    <input id="unit" name="unit">
    <label for="priceTaxFree">Prix HT</label>
    <input id="priceTaxFree" name="priceTaxFree">
    <label for="taxRate">Taux de TVA</label>
    <input id="taxRate" name="taxRate">
    <button id="add-button">Ajouter</button>
</form>

</body>
</html>
