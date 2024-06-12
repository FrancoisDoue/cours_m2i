<%@ page import="org.exercices.entity.Dog" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2024
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dogList" type="java.util.ArrayList<org.exercices.entity.Dog>" scope="request"/>
<html>
<head>
    <%@include file="bootstrap_import.html"%>
    <title>Liste des doggos</title>
</head>
<body class="container-fluid text-light m-0 p-0">
    <header class="header bg-dark text-light p-4">
        <div class="container">
            <h2>La grande liste des doggos</h2>
        </div>
    </header>

    <main>
        <div class="container bg-dark mt-4 p-4 rounded">
            <% if (dogList.isEmpty()) { %>
                <p>Il n'y a pas de doggo :'(</p>
            <% } else { %>
            <table class="table text-light text-center ">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Race</th>
                    <th>Date de naissance</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <% for (Dog dog : dogList) { %>
                    <tr>
                        <td><%= dog.getName() %></td>
                        <td><%= dog.getBreed() %></td>
                        <td><%= dog.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %></td>
                        <td>
                            <a href="#">Détail</a>
                        </td>
                    </tr>
                <%} %>
                </tbody>
            </table>
            <% } %>
            <div class="container border border-light p-2 rounded rounded-sm d-flex justify-content-end">
                <a class="d-block btn btn-outline-light px-4 me-4"
                   href="${pageContext.request.contextPath}/dogs/add">
                    <i class="bi bi-plus-circle"></i>
                    Ajouter un doggo
                </a>
            </div>
        </div>

    </main>

</body>
</html>
