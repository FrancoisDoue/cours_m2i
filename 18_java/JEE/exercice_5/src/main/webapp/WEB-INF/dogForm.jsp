<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentDog" scope="request" type="org.exercices.entity.Dog"/>
<jsp:useBean id="isReadonly" scope="request" type="java.lang.Boolean" />
<html>
<head>
    <%@include file="bootstrap_import.html"%>
    <title>Title</title>
</head>
<body class="container-fluid text-light m-0 p-0">
    <header class="header bg-dark text-light p-4">
        <div class="container">
            <h3><%= isReadonly ? currentDog.getName() : "Ajouter un doggo"%></h3>
        </div>
    </header>

    <main>
        <div class="container bg-dark mt-4 p-4 rounded">
            <form method="post" action="${pageContext.request.contextPath}/dogs">
                <label class="text-center" for="name">Nom</label>
                <div class="input-group mb-3">
                    <input class="form-control" type="text" name="name" id="name"
                           value="<%= isReadonly ? currentDog.getName() : ""%>"
                           required <%=isReadonly ? "readonly" : "" %>/>
                </div>
                <label class="text-center" for="breed">Race</label>
                <div class="input-group mb-3">
                    <input class="form-control" type="text" name="breed" id="breed"
                           value="<%= isReadonly ? currentDog.getBreed() : ""%>"
                           required <%=isReadonly ? "readonly" : "" %>/>
                </div>
                <label class="text-center" for="birthday">Date de naissance </label>
                <div class="input-group mb-3">
                    <input class="form-control" type="date" name="birthday" id="birthday"
                           value="<%= isReadonly ?
                           currentDog.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : ""%>"
                           required <%=isReadonly ? "readonly" : "" %>/>
                </div>
                <div class="container border border-light p-2 rounded rounded-sm d-flex justify-content-end">
                    <% if (!isReadonly) { %>
                        <button class="d-block btn btn-outline-success px-4 me-4" >
                            <i class="bi bi-plus-circle"></i>
                            Ajouter le doggo
                        </button>
                    <% } else { %>
                        <a class="d-block btn btn-outline-light px-4 me-4" href="${pageContext.request.contextPath}/dogs">
                            <i class="bi bi-arrow-return-left"></i>
                            Retour à la liste
                        </a>
                    <% } %>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
