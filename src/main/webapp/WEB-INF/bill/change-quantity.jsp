<%--
  Created by IntelliJ IDEA.
  User: duarte
  Date: 07/12/2022
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modification quantité ${product.reference} </title>
</head>
<body>
<form action="/bill/changeQuantity" method="post">
    <input type="hidden" name="billId" value="${billId}">
    <input type="hidden" name="productId" value="${product.id}">
    <label for="quantity">Quantité</label>
    <input type="number" name="quantity" value="${quantity}" id="quantity">
    <button>Valider</button>
</form>

</body>
</html>
