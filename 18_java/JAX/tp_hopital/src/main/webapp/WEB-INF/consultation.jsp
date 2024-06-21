<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="jspImport" scope="request" type="java.lang.String" />
<html>
<head>
    <jsp:include page="imports/bootstrap_import.html" />
    <title>Patients</title>
</head>
<body class="h-100 container-fluid text-light bg-light bg-gradient text-light m-0 p-0">
<jsp:include page="imports/header.jsp"/>
<main class="w-100 d-flex align-center">
    <div class="container bg-body-tertiary mt-4 p-4 rounded border border-primary">
        <jsp:include page="imports/${jspImport}.jsp" />
    </div>
</main>
</body>
</html>
