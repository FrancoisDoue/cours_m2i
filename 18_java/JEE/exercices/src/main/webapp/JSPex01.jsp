<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 10/06/2024
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="message" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="WEB-INF/bootstrap_link.html"%>
    <title>JSP page</title>
</head>
<body class="container-fluid p-0 m-0">
    <header class="bg-gradient bg-dark text-light p-4">
        <div class="container">
            <h1>${ message }</h1>
            <h5>Et avec bootstrap</h5>
            <h6 class="small">(Et un p'tit gradient)</h6>
        </div>
<%--        <div>--%>
<%--            <% for (int i = 0; i < 10; i++) { %>--%>
<%--                <p><%= i %></p>--%>
<%--            <% } %>--%>
<%--        </div>--%>
    </header>
</body>
</html>