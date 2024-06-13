<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="products" scope="request" type="java.util.ArrayList<org.exercices.entity.Product>" />
<html>
<head>
    <jsp:include page="bootstrap_import.html" />
    <title>Liste des produits</title>
</head>
<body class="h-100 container-fluid text-light bg-dark bg-gradient text-light m-0 p-0">
<header class="header bg-dark p-4 border-bottom border-light">
    <div class="container">
        <h3>Trouver-un-nom.com</h3>
    </div>
</header>
<main class="w-100 d-flex align-center">
    <div class="container bg-dark mt-4 p-4 pb-1 rounded border border-light">
        <h4 class="px-4 pb-4 border-bottom border-light text-bold">Liste des produits</h4>

<%--        <% if (products == null || products.isEmpty()) { %>--%>
<%--            <h5 class="text-center p-4">Il n'y a pas de produit en base de données</h5>--%>
<%--        <% } else { %>--%>
<%--        <% } %>--%>
        <div class="container border-top border-light px-4 py-2 d-flex justify-content-end">
            <a class="d-block btn btn-outline-light px-4 me-4"
               href="${pageContext.request.contextPath}/products/add">
                <i class="bi bi-plus-circle"></i>
                Ajouter un produit
            </a>
        </div>
    </div>
</main>
</body>
</html>