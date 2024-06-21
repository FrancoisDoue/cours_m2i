<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header bg-primary p-4">
    <div class="container">
        <div class="row" >
            <div class="col-8">
                <h3 class="text-light">TPHopital</h3>
            </div>
            <div class="col-4" >
<%--                <a class="btn btn-primary px-4" href="${pageContext.request.contextPath}/auth/logout">Médecin</a>--%>
                <a class="btn btn-primary px-4" href="${pageContext.request.contextPath}/patient">Patients</a>

                <a class="btn btn-light px-4" href="${pageContext.request.contextPath}/auth/logout">Déconnexion</a>
            </div>
        </div>
    </div>
</header>
