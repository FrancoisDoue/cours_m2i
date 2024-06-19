<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="importJsp" scope="request" type="java.lang.String" />
<%--<jsp:useBean id="isLogged" scope="request" type="java.lang.Boolean" />--%>
<html>
<head>
    <jsp:include page="imports/bootstrap_import.html" />
    <title>Liste des produits</title>
</head>
<body class="h-100 container-fluid text-light bg-dark bg-gradient text-light m-0 p-0">
<jsp:include page="imports/header_import.jsp" />
<main class="w-100 d-flex align-center">
    <div class="container bg-dark mt-4 p-4 pb-1 rounded border border-light">
<%--        <% if (isLogged) { %>--%>

        <jsp:include page="imports/productImport/${importJsp}.jsp" />

<%--        <% } else { %>--%>

<%--        <h4 class="text-center text-bold pb-3">Vous devez être connecté pour accéder aux services</h4>--%>

<%--        <% } %>--%>

    </div>
</main>
</body>
</html>