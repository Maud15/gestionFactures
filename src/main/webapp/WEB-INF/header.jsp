<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Created by : User: maud_  --  Date: 07/12/2022  --  Time: 10:20--%>

<head>
    <%@ page contentType="text/html;charset=UTF-8"%>
    <link href="../style/main.css" rel="stylesheet" type="text/css">
</head>
<header>
    <h1>Gestion des factures</h1>
    <div class="log">
    <a href="${pageContext.request.contextPath}/login"></a>
    <a href="${pageContext.request.contextPath}/logout"></a>
        <c:choose>
            <c:when test="${not empty sessionScope.username}">
                <form method="post" action="${pageContext.request.contextPath}/logout">
                    <input type="submit" value="Déconnexion">
                </form>
            </c:when>

            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login">Sign In</a>
            </c:otherwise>

        </c:choose>
    </div>
    <div class="menu">
        <div class="displayActions">
            <form method="get" action="${pageContext.request.contextPath}/customers"><button class="withTag">Afficher les clients</button></form>
            <form method="get" action="${pageContext.request.contextPath}/products"><button class="withTag">Afficher les produits</button></form>
        </div>

        <div class="addActions">
            <form method="get" action="${pageContext.request.contextPath}/customers/add"><button class="withTag">Nouveau client</button></form>
            <form method="get" action="${pageContext.request.contextPath}/products/add"><button class="withTag">Nouveau produit</button></form>
        </div>
    </div>
</header>

<c:choose>
    <c:when test="${not empty param.errorMsg}">
        <div class="error-message">
            <p><c:out value="${param.errorMsg}"/></p>
        </div>
    </c:when>
</c:choose>