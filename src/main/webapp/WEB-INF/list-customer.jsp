<%--
  Created by IntelliJ IDEA.
  User: duarte
  Date: 06/12/2022
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des clients</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Numéro de client</th>
        <th>Désignation</th>
        <th>Adresse</th>
        <th>Numéro de téléphone</th>
        <th>Email</th>
        <th colspan=3>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
    <tr>
        <td><c:out value="${customer.customerNumber}"/></td>
        <td><c:out value="${customer.designation}"/></td>
        <td><c:out value="${customer.address}  ${customer.postCode}  ${customer.city}"/></td>
        <td><c:out value="${customer.phoneNumber}"/></td>
        <td><c:out value="${customer.email}"/></td>
        <!--<td><form action="=request.getContextPath()%>/games/update" method="get"><input type="hidden" name="id" value="=games.get(i).getId()%>"><button>Modifier</button></form></td>
        <td><form action="=request.getContextPath()%>/games/delete" method="post"><input type="hidden" name="id" value="=games.get(i).getId()%>"><button>Supprimer</button></form></td>
        <td><form action="=request.getContextPath()%>/games/details" method="get"><input type="hidden" name="id" value="=games.get(i).getId()%>"><button>Voir en détails</button></form></td>-->
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
