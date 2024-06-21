<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4 class="px-4 pb-4 border-bottom border-primary text-bold text-primary">Nouveau patient</h4>
<div class="w-50 m-auto text-primary-emphasis">
<form method="post"
      id="main-form"
      enctype="multipart/form-data"
      action="${pageContext.request.contextPath}/patient/create"
<%--      action="${pageContext.request.contextPath}/products<%= isEdit ? "?id=" + currentProduct.getId() : "" %>">--%>
    >
    <div class="d-flex flex-row mb-4">
        <div class="d-flex flex-column w-50">
            <div class="input-group mb-3 d-flex flex-column">
                <label class="text-center mb-2 fw-semibold" for="lastname">Nom </label>
                <div class="input-group w-full px-2">
                    <input class="form-control border border-primary" type="text" name="lastname" id="lastname" required />
                </div>
            </div>
        </div>
        <div class="d-flex flex-column w-50">
            <div class="input-group mb-3 d-flex flex-column">
                <label class="text-center mb-2 fw-semibold" for="firstname">Prénom </label>
                <div class="input-group w-full px-2">
                    <input class="form-control border border-primary" type="text" name="firstname" id="firstname" required />
                </div>
            </div>
        </div>
    </div>
    <div class="d-flex flex-column px-2 my-4">
        <label class="text-center mb-2 fw-semibold" for="dateOfBirth">Date de naissance</label>
        <div class="input-group mb-3">
            <input class="form-control border border-primary" type="date" name="dateOfBirth" id="dateOfBirth" required />
        </div>
    </div>
    <div class="d-flex flex-column px-2 my-4">
        <label class="text-center mb-2 fw-semibold" for="img">Photo du patient </label>
        <div class="input-group mb-3">
            <input class="form-control border border-primary" type="file" name="img" id="img" required />
        </div>
    </div>
    <div class="py-4 border-top border-light">
        <button class="btn btn-primary w-100" >
            Enregistrer
        </button>
    </div>
</form>
</div>