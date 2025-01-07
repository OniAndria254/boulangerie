<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Production" %>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page import="itu.p16.boulangerie.entity.Ingredient" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    List<Production> all = (List<Production>) request.getAttribute("all");
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
    List<Ingredient> ingredients = (List<Ingredient>) request.getAttribute("ingredients");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer les productions</h6>
                <form method="get" action="/production/list">
                    <div class="row">
                        <div class="col-md-3">
                            <select name="idCategorie" class="form-control">
                                <option value="">Toutes les catégories</option>
                                <% for (Categorie categorie : categories) { %>
                                <option value="<%= categorie.getIdCategorie() %>"
                                        <%= (request.getParameter("idCategorie") != null &&
                                                request.getParameter("idCategorie").equals(String.valueOf(categorie.getIdCategorie()))) ? "selected" : "" %>>
                                    <%= categorie.getNom() %>
                                </option>
                                <% } %>
                            </select>
                        </div>

                        <div class="col-md-3">
                            <select name="idIngredient" class="form-control">
                                <option value="">Toutes les ingredients</option>
                                <% for (Ingredient ingredient : ingredients) { %>
                                <option value="<%= ingredient.getIdIngredient() %>"
                                        <%= (request.getParameter("idIngredient") != null &&
                                                request.getParameter("idIngredient").equals(String.valueOf(ingredient.getIdIngredient()))) ? "selected" : "" %>>
                                    <%= ingredient.getNom() %>
                                </option>
                                <% } %>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-primary">Filtrer</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Liste des productions</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Quantite Produite</th>
                            <th>Date de production</th>
                            <th>Produit</th>
                            <th>Catégorie</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Production pc : all) {
                        %>
                        <tr>
                            <td><%= pc.getQuantiteProduite()%></td>
                            <td><%= pc.getDateProduction()%></td>
                            <td><%= pc.getProduitByIdProduit().getNom()%></td>
                            <td><%= pc.getProduitByIdProduit().getCategorieByIdCategorie().getNom()%></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>