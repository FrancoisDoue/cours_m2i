<%@ page import="org.exercices.entity.Cat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cats" type="java.util.ArrayList<org.exercices.entity.Cat>" scope="request" />
<html>
<head>
    <%@include file="WEB-INF/bootstrap_import.html" %>
    <title>Liste des chats</title>
</head>
<body class="container-fluid text-light m-0 p-0">
    <header class="header bg-dark text-light p-4">
        <div class="container">
            <h2>La grande liste des chats</h2>
        </div>
    </header>
    <main>
        <div class="container bg-dark mt-4 p-4 rounded">

            <table class="table text-light text-center ">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Race</th>
                    <th>Plat favoris</th>
                    <th>Date de naissance</th>
                </tr>
                </thead>
                <tbody>
                <% for (Cat cat : cats) { %>
                    <tr>
                        <td><%= cat.getName() %></td>
                        <td><%= cat.getRace() %></td>
                        <td><%= cat.getFavouriteMeat() %></td>
                        <td><%= cat.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %></td>

                    </tr>
                <%} %>
                </tbody>
            </table>
        </div>
        <div class="container bg-dark mt-4 p-4 rounded">
            <form method="post" action="cat-list">
                <label class="text-center" for="name">Nom</label>
                <div class="input-group mb-3">
                    <input class="form-control" type="text" name="name" id="name" />
                </div>
                <label class="text-center" for="race">Race</label>
                <div class="input-group mb-3">
                    <input class="form-control" type="text" name="race" id="race" />
                </div>
                <label class="text-center" for="meat">Plat favoris</label>
                <div class="input-group mb-3">
                    <input class="form-control" type="text" name="meat" id="meat" />
                </div>
                <label class="text-center" for="birthday">Date de naissance </label>
                <div class="input-group mb-3">
                    <input class="form-control" type="date" name="birthday" id="birthday" />
                </div>
                <div class="container border border-light p-2 rounded rounded-sm d-flex justify-content-end">
                    <button class="d-block btn btn-outline-light px-4 me-4" >Ajouter un chat</button>
                </div>
            </form>
        </div>
    </main>

</body>
</html>
