<%--Created by : User: maud_  --  Date: 06/12/2022  --  Time: 15:21
  (To change : File | Settings | File Templates)--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Détails facture : ${bill.billNumber}</title>
</head>
<body>
<main>
<h1>Contenu de la facture : ${bill.billNumber} du client ${customer.name}</h1>
<table>
    <thead>
    <tr>
        <th>Numéro de facture</th>
        <th>Date de la facture</th>
        <th>Cout HT</th>
        <th>Cout TTC</th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${bill.billNumber}"/></td>
        <td><c:out value="${bill.dateBill}"/></td>
        <td>${amountTaxFree} €</td>
        <td>${amountWithTax} €</td>
        <%--<td><form action="/customers/update" method="get"><input type="hidden" name="id" value="${customer.id}"><button>Modifier</button></form></td>
        <td><form action="/customers/delete" method="post"><input type="hidden" name="id" value="${customer.id}"><button>Supprimer</button></form></td>--%>
    </tr>
    </tbody>
</table>
<h2>Produits</h2>
<table>
    <thead>
    <tr>
        <th>Référence</th>
        <th>Description</th>
        <th>Quantité</th>
        <th>Unité</th>
        <th>Prix HT</th>
        <th>Taux de TVA</th>
        <th>Prix TTC</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="productBill" items="${bill.productsBillsList}">
        <tr>
            <td><c:out value="${productBill.product.reference}"/></td>
            <td><c:out value="${productBill.product.description}"/></td>
            <td><c:out value="${quantities.get(productBill.product)}"/></td>
            <td><c:out value="${productBill.product.unit}"/></td>
            <td><c:out value="${productBill.product.priceTaxFree} €"/></td>
            <td><c:out value="${productBill.product.taxRate}"/></td>
            <td><c:out value="${productBill.product.getPriceWithTax()} €"/></td>
            <td>
                <form action="/bill/changeQuantity" method="get">
                    <input type="hidden" name="productId" value="${productBill.product.id}">
                    <input type="hidden" name="billId" value="${bill.id}">
                    <input type="hidden" name="quantity" value="${quantities.get(productBill.product)}">
                    <button>Modifier quantité</button>
                </form>
            </td>
            <td>
                <form action="/bill/removeProduct" method="post">
                    <input type="hidden" name="billId" value="${bill.id}">
                    <input type="hidden" name="productId" value="${productBill.product.id}">
                    <button>Supprimer</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/bill/add-product?billId=${bill.id}">Ajouter un produit</a>
</main>
</body>
</html>
