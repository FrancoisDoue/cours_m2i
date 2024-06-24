<%@ page import="tp_hopital.shared.entity.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patient" type="tp_hopital.shared.entity.Patient" scope="request" />
<jsp:useBean id="doctors" type="java.util.List<tp_hopital.shared.entity.Doctor>" scope="request" />
<h4 class="px-4 pb-4 border-bottom border-primary text-bold text-primary">
    Consultation pour <%= patient.getFirstname() + " " + patient.getLastname()%>
</h4>
<div class="w-50 m-auto text-primary-emphasis">
    <form method="post"
          action="${pageContext.request.contextPath}/consultation/create?patient=<%= patient.getId() %>"
    >
        <div class="d-flex flex-column px-2 my-4">
            <label class="text-center mb-2 fw-semibold" for="dateTime">Date:</label>
            <div class="input-group mb-3">
                <input class="form-control border border-primary" type="datetime-local" name="dateTime" id="dateTime" required />
            </div>
        </div>
        <div class="d-flex flex-column px-2 my-4">
            <label for="doctor" class="">Avec le docteur</label>
            <div class="input-group mb-3">
                <select class="form-select" name="doctor" id="doctor">
                    <% for (Doctor doc : doctors) { %>
                        <option value="<%= doc.getId() %>">
                            <%= doc.getSpeciality() + " - " + doc.getFirstname() + " " + doc.getLastname() %>
                        </option>
                    <% } %>
                </select>
            </div>
        </div>
        <div class="py-4 border-top border-light">
            <button class="btn btn-primary w-100" >
                Enregistrer
            </button>
        </div>
    </form>
</div>
