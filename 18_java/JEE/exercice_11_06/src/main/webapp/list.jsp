<%@ page import="org.exercices.entity.Person" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="persons" type="java.util.ArrayList<org.exercices.entity.Person>" scope="request" />
<%--<jsp:useBean id="p" type="org.exercices.entity.Person" scope="request" />--%>
<html>
<head>
    <%@include file="WEB-INF/bootstrap_import.html"%>
    <title>list</title>
</head>
<body class="container-fluid m-0 p-0">
    <header class="header bg-primary text-light p-4">
        <div class="container">
            <h2>Liste d'utilisateurs</h2>
        </div>
    </header>
    <main class="container mt-4">
        <table class="table">
            <thead>
                <tr>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
            <% for(Person p :persons) { %>
                <tr>
                    <td><%=p.getFirstname() %></td>
                    <td><%=p.getLastname() %></td>
                    <td><%=p.getAge() %></td>
                </tr>
            <%} %>
            </tbody>

        </table>
    </main>

</body>
</html>
