<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duarte
  Date: 07/12/2022
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'un produit à la facture ${bill.billNumber}</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/bill/add-product" method="post">
  <input type="hidden" name="billId" value="${bill.id}">
  <label for="productId">Choisissez un produit :</label>

  <select name="productId" id="productId">
    <option value="" disabled selected>--Veuillez choisir un produit--</option>
<c:forEach var="product" items="${products}">
  <option value="${product.id}">${product.reference}</option>
</c:forEach>
    <input type="number" value="0" name="quantity">
    <button>Valider</button>
  </select>
</form>

</body>
</html>
