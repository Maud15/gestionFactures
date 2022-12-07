<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zoran
  Date: 06/12/2022
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mise à jour de la facture</title>
</head>
<body>
<form action="<c:out value="${UpdateBillServlet.URL}"/>" method="post">
    <input type="hidden" name="id" value="${bill.id}">
    <label for="dateBill">Date de la facture</label>
    <input type="date" value="${bill.dateBill}" name="dateBill" id="dateBill">
    <input type="hidden" value="${bill.customer.id}" name="idClient" id="idClient">
<%--    <label for="amountTaxFree">Montant HT</label>--%>
<%--    <input type="text" value="${bill.amountTaxFree}" name="amountTaxFree" id="amountTaxFree">--%>
<%--    <label for="amountWithTax">Montant TTC</label>--%>
<%--    <input type="text" value="${bill.amountWithTax}" name="amountWithTax" id="amountWithTax">--%>
    <button>Valider</button>
</form>

</body>
</html>
