<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="isEdit" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="currentProduct" type="org.exercices.entity.Product" scope="request" />

<h4 class="px-4 pb-4 border-bottom border-light text-bold"><%= isEdit ? "Modifier" : "Ajouter" %> un produit</h4>
<div class="w-50 m-auto">

    <form method="post"
          id="main-form"
    <%--      enctype="multipart/form-data"--%>
          action="${pageContext.request.contextPath}/products<%= isEdit ? "?id=" + currentProduct.getId() : "" %>">
        <div class="d-flex flex-row mb-4">
            <div class="d-flex flex-column w-50">
                <div class="input-group mb-3 d-flex flex-column">
                    <label class="text-center mb-2 fw-semibold" for="brand">Marque </label>
                    <div class="input-group w-full px-2">
                        <input class="form-control bg-dark border border-light text-light" type="text" name="brand" id="brand" required
                                <% if (isEdit) { %>
                                    value="${currentProduct.brand}"
                                <% } %>/>
                    </div>
                </div>
            </div>
            <div class="d-flex flex-column w-50">
                <div class="input-group mb-3 d-flex flex-column">
                    <label class="text-center mb-2 fw-semibold" for="ref">Référence </label>
                    <div class="input-group w-full px-2">
                        <input class="form-control bg-dark border border-light text-light" type="text" name="ref" id="ref" required
                                <% if (isEdit) { %>
                                    value="${currentProduct.ref}"
                                <% } %>/>
                    </div>
                </div>
            </div>
        </div>

        <div class="d-flex flex-row mb-4">
            <div class="d-flex flex-column w-50">
                <div class="input-group mb-3 d-flex flex-column">
                    <label class="text-center mb-2 fw-semibold" for="price">Prix </label>
                    <div class="input-group w-full px-2">
                        <input class="form-control bg-dark border border-light text-light" type="number" step=".01" name="price" id="price" required
                                <% if (isEdit) { %>
                                    value="${currentProduct.price}"
                                <% } %>/>
                    </div>
                </div>
            </div>
            <div class="d-flex flex-column w-50">
                <div class="input-group mb-3 d-flex flex-column">
                    <label class="text-center mb-2 fw-semibold" for="quantity">Quantité </label>
                    <div class="input-group w-full px-2">
                        <input class="form-control bg-dark border border-light text-light" type="number" name="quantity" id="quantity" required
                                <% if (isEdit) { %>
                                    value="${currentProduct.quantity}"
                                <% } %>/>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex flex-column px-2 my-4">
            <label class="text-center mb-2 fw-semibold" for="buyDate">Date d'achat</label>
            <div class="input-group mb-3">
                <input class="form-control bg-dark border border-light text-light" type="date" name="buyDate" id="buyDate" required
                        value="<%= isEdit ? currentProduct.getBuyDate() : LocalDate.now() %>"/>
            </div>
        </div>
    </form>
</div>
<div class="w-50 m-auto" >
    <div class="d-flex flex-column px-2 my-4">
        <label class="text-center mb-2 fw-semibold" for="img">Image du produit : </label>
        <div class="input-group mb-3">
            <form method="post" id="file-form" enctype="multipart/form-data" action="${pageContext.request.contextPath}/products<%= isEdit ? "?id=" + currentProduct.getId() : "" %>"
                class="w-100">
                <input class="form-control bg-dark border border-light text-light" type="file" name="img" id="img" />
            </form>
        </div>
    </div>
</div>
<div class="py-4 border-top border-light">
    <button class="btn btn-light w-100" id="submit-form" >
        <%= isEdit ? "Modifier" : "Ajouter" %>
    </button>
</div>
<div class="container border-top border-light px-4 py-2 d-flex justify-content-end">
    <a class="d-block btn btn-outline-light px-4 me-4"
       href="${pageContext.request.contextPath}/products">
        <i class="bi bi-arrow-return-left"></i>
        Retour à la liste
    </a>
</div>
<script src="${pageContext.request.contextPath}/script/formProduct.js" type="module"></script>
