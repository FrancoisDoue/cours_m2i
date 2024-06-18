<%@ page import="org.exo7.entity.Image" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 18/06/2024
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="images" type="java.util.ArrayList<org.exo7.entity.Image>" scope="request" />
<html>
<head>
    <jsp:include page="elements/bootstrap_import.html"/>
    <title>Gallerie</title>
</head>
<body class="h-100 container-fluid text-light bg-dark bg-gradient text-light m-0 p-0">

<header class="header bg-dark p-4 border-bottom border-light">
    <div class="container">
        <h3>Fichier pas exist</h3>
    </div>
</header>
<main class="w-100 d-flex align-center">
    <div class="container-fluid bg-dark m-4 p-4 pb-1 rounded border border-light d-flex" style="min-height: 80dvh" >
        <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/gallery/add" class="w-25">
            <div class="py-4">
                <label class="text-center mb-2 fw-semibold" for="img" >Ajouter une image</label>
                <input class="form-control bg-dark border border-light text-light rounded rounded-pill" name="img" type="file" id="img" />
            </div>
            <button class="btn btn-outline-light rounded rounded-pill w-100">Ajouter</button>
        </form>
        <div class="w-75 p-4 d-flex align-content-start flex-wrap">
            <% for (Image img : images) { %>
                <div class="position-relative">
                    <img src="<%= img.getFullPath() %>" height="150" class="rounded m-1 border border-light" alt="<%= img.getName() %>" />
                </div>
            <% } %>
        </div>

    </div>

</main>


</body>
</html>
