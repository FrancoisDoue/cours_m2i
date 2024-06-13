<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<% request.getRequestDispatcher("register.jsp").forward(request, response); %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/user/register">Hello Servlet</a>
</body>
</html>