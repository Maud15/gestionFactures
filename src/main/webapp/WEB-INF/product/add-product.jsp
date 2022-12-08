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
<jsp:include page="../header.jsp"><jsp:param name="errorMsg" value="${error}"/></jsp:include>
    <main>
        <h2>Ajout d'un nouveau produit</h2>

        <form class="addForm" method="post" action="${pageContext.request.contextPath}/products/add">
            <div class="formLabels">
                <label for="reference">Référence</label>
                <label for="description">Description</label>
                <label for="unit">Unité</label>
                <label for="priceTaxFree">Prix HT</label>
                <label for="taxRate">Taux de TVA</label>
            </div>
            <div class="formInputs">
                <input id="reference" name="reference">
                <input id="description" name="description">
                <input id="unit" name="unit">
                <input id="priceTaxFree" name="priceTaxFree">
                <input id="taxRate" name="taxRate">
            </div>
            <button class="addButton" id="add-button">Ajouter</button>
        </form>
    </main>
</body>
</html>
