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
    List<Client> all = (List<Client>) request.getAttribute("all");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer les clients</h6>
                <form method="get" action="/client/listClient">
                    <div class="row">
                        <div class="col-md-3">
                            <input type="date" name="date_achat" class="form-control" placeholder="Date d'achat"
                                   value="<%= request.getParameter("date_achat") != null ? request.getParameter("date_achat") : "" %>">
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
                <h6 class="card-title">Liste des Clients</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Produit</th>
                            <th>Quantite</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Client cl : all) {
                        %>
                        <tr>
                            <td><%= cl.getNom()%></td>
                            <td><%= cl.getPrenom()%></td>
                            <td><%= cl.getProduitByIdProduit().getNom()%></td>
                            <td><%= cl.%></td>
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