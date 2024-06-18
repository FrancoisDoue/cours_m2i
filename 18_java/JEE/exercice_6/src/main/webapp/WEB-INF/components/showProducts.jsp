<%@ page import="org.exercices.entity.Product" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="products" scope="request" type="java.util.ArrayList<org.exercices.entity.Product>" />

<h4 class="px-4 pb-4 border-bottom border-light text-bold">Liste des produits</h4>
<% if (products == null || products.isEmpty()) { %>
    <h5 class="text-center p-4">Il n'y a pas de produit en base de données</h5>
<% } else { %>
    <table class="table table-dark table-striped text-light text-center">
        <thead >
            <tr>
                <th></th>
                <th>Marque</th>
                <th>Référence</th>
                <th>Prix</th>
                <th>Quantité</th>
                <th>Date d'achat</th>
                <th colspan="2">Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (Product product : products) { %>
                <tr >
                    <td>
                        <% if (product.getImageUrl() != null) { %>
                            <img src="<%= product.getImageUrl() %>" width="75" class="img-thumbnail">
                        <% } %>
                    </td>
                    <td><%= product.getBrand() %></td>
                    <td><%= product.getRef() %></td>
                    <td><%= product.getPrice() %> €</td>
                    <td><%= product.getQuantity() %></td>
                    <td><%= product.getBuyDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products/update?id=<%= product.getId() %>"
                            class="btn btn-outline-warning w-100">
                            <i class="bi bi-pencil-square"></i>
                            Modifier
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products/remove?id=<%= product.getId() %>"
                            class="btn btn-outline-danger w-100">
                            <i class="bi bi-x-circle"></i>
                            Supprimer
                        </a>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
<% } %>

<div class="container border-top border-light px-4 py-2 d-flex justify-content-end">
    <a class="d-block btn btn-outline-light px-4 me-4"
       href="${pageContext.request.contextPath}/products/add">
        <i class="bi bi-plus-circle"></i>
        Ajouter un produit
    </a>
</div>