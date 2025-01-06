<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>

<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Produit> all = (List<Produit>) request.getAttribute("all");
%>
<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer les produits</h6>
                <form method="get" action="/produit/list">
                    <div class="row">
                        <div class="col-md-4">
                            <input type="text" name="nom" class="form-control" placeholder="Nom du produit"
                                   value="<%= request.getParameter("nom") != null ? request.getParameter("nom") : "" %>">
                        </div>
                        <div class="col-md-3">
                            <input type="number" name="prixMin" step="0.01" class="form-control"
                                   placeholder="Prix Min"
                                   value="<%= request.getParameter("prixMin") != null ? request.getParameter("prixMin") : "" %>">
                        </div>
                        <div class="col-md-3">
                            <input type="number" name="prixMax" step="0.01" class="form-control"
                                   placeholder="Prix Max"
                                   value="<%= request.getParameter("prixMax") != null ? request.getParameter("prixMax") : "" %>">
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
                <h6 class="card-title">Liste des produits</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Nom</th>
                            <th>Prix de vente</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Produit pt : all) {
                        %>
                        <tr>
                            <td><%= pt.getIdProduit()%></td>
                            <td><%= pt.getNom()%></td>
                            <td><%= pt.getPrixVente()%></td>
                            <td>
                                <a href="/produit/update?id=<%= pt.getIdProduit() %>" class="btn btn-warning btn-sm">Modifier</a>
                                <a href="/produit/delete?id=<%= pt.getIdProduit() %>"
                                   class="btn btn-danger"
                                   onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?')">
                                    Supprimer
                                </a>
                            </td>
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