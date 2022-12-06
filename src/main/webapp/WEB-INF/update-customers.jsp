<%--
  Created by IntelliJ IDEA.
  User: duarte
  Date: 06/12/2022
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mise à jour client</title>
</head>
<body>
  <form action="<c:out value="${UpdateCustomer.URL}"/>" method="post">
    <input type="hidden" name="id" value="${customer.id}">
    <label for="designation">Désignation</label>
    <input type="text" value="${customer.designation}" name="designation" id="designation">
    <label for="address">Adresse</label>
    <input type="text" value="${customer.address}" name="address" id="address">
    <label for="postCode">Code postal</label>
    <input type="text" value="${customer.postCode}" name="postCode" id="postCode">
    <label for="city">Ville</label>
    <input type="text" value="${customer.city}" name="city" id="city">
    <label for="phoneNumber">Numéro de téléphone</label>
    <input type="text" value="${customer.phoneNumber}" name="phoneNumber" id="phoneNumber">
    <label for="email">Email</label>
    <input type="text" value="${customer.email}" name="email" id="email">
    <button>Valider</button>
  </form>

</body>
</html>
