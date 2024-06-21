<%@ page import="tp_hopital.shared.entity.Patient" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patientList" type="java.util.ArrayList<tp_hopital.shared.entity.Patient>" scope="request" />

<h4 class="p-4 bg-primary rounded text-bold text-light">Patients</h4>
<div class="m-auto text-primary-emphasis rounded bg-primary p-2">
    <table class="table table-primary table-striped table-hover text-light text-center border border-primary">
        <thead>
            <tr>
                <th></th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date de naissance</th>
                <th colspan="2">Actions</th>
            </tr>
        </thead>
        <tbody>
        <% for (Patient patient : patientList) { %>
            <tr>
                <td><img src="${pageContext.request.contextPath}<%= patient.getPhotoUrl() %>" height="50"  alt="<%= patient.getFirstname() + " " + patient.getLastname()%>"/></td>
                <td><%= patient.getLastname() %></td>
                <td><%= patient.getFirstname() %></td>
                <td><%= patient.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %></td>
<%--                <td>--%>
<%--                    <a class="btn btn-primary" >Consulter l'historique</a>--%>
<%--                </td>--%>
                <td>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/consultation/new?patient=<%= patient.getId() %>" >Ajouter une consultation</a>
                </td>
            </tr>
        <% } %>

        </tbody>

    </table>
</div>

<div class="container mt-2 rounded bg-primary px-4 py-3 d-flex justify-content-end">
    <a class="d-block btn btn-primary border border-light px-4 me-4"
       href="${pageContext.request.contextPath}/patient/new">
        <i class="bi bi-plus-circle"></i>
        Enregistrer un nouveau Patient
    </a>
</div>