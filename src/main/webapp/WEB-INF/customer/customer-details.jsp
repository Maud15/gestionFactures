<%--
  Created by IntelliJ IDEA.
  User: duarte
  Date: 06/12/2022
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Détails client : ${customer.designation}</title>
</head>

<body>
    <jsp:include page="../header.jsp"><jsp:param name="errorMsg" value="${error}"/></jsp:include>

    <main>
        <h2>Informations client</h2>
        <table>
            <thead>
            <tr>
                <th>Numéro de client</th>
                <th>Désignation</th>
                <th>Adresse</th>
                <th>Numéro de téléphone</th>
                <th>Email</th>

            </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${customer.customerNumber}"/></td>
                    <td><c:out value="${customer.designation}"/></td>
                    <td><c:out value="${customer.address}  ${customer.postCode}  ${customer.city}"/></td>
                    <td><c:out value="${customer.phoneNumber}"/></td>
                    <td><c:out value="${customer.email}"/></td>
                    <%--<td><form action="/customers/update" method="get"><input type="hidden" name="id" value="${customer.id}"><button>Modifier</button></form></td>
                    <td><form action="/customers/delete" method="post"><input type="hidden" name="id" value="${customer.id}"><button>Supprimer</button></form></td>--%>
                </tr>
            </tbody>
        </table>
        <h3>Factures</h3>
        <table>
            <thead>
            <tr>
                <th>Numéro de facture</th>
                <th>Date</th>
                <th>Montant HT</th>
                <th>Montant TTC</th>
                <th colspan=3>Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="bill" items="${customer.billList}">
    <tr>
        <td><c:out value="${bill.billNumber}"/></td>
        <td><c:out value="${bill.dateBill}"/></td>
        <td><c:out value="${withoutTax.get(bill)}"/></td>
        <td><c:out value="${withtax.get(bill)}"/></td>
        <td class="contain-button">
            <form action="${pageContext.request.contextPath}/bill/update" method="get">
                <input type="hidden" name="id" value="${bill.id}">
                <button>Modifier</button>
            </form>
        </td>
        <td class="contain-button">
            <form action="${pageContext.request.contextPath}/bill/delete" method="post">
                <input type="hidden" name="id" value="${bill.id}">
                <button>Supprimer</button>
            </form>
        </td>
        <td class="contain-button">
            <form action="${pageContext.request.contextPath}/bill/details" method="get">
                <input type="hidden" name="billId" value="${bill.id}">
                <button>Voir en détails</button>
            </form>
        </td>

            </tr>
            </c:forEach>
            </tbody>

        </table>
        <a href="${pageContext.request.contextPath}/bill/add?customerId=${customer.id}">Saisir une nouvelle facture</a>
    </main>
</body>
</html>
