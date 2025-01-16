<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.dto.ClientAchatDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<ClientAchatDTO> all = (List<ClientAchatDTO>) request.getAttribute("all");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer les clients</h6>
                <form method="get" action="/client/clientsAvecAchats">
                    <div class="row">
                        <div class="col-md-3">
                            <input type="date" name="dateAchat" class="form-control" placeholder="Date d'achat"
                                   value="<%= request.getParameter("dateAchat") != null ? request.getParameter("dateAchat") : "" %>">
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
                <h6 class="card-title">Liste des Clients avec Achats</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Produit</th>
                            <th>Quantité</th>
                            <th>Date d'achat</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (ClientAchatDTO dto : all) {
                        %>
                        <tr>
                            <td><%= dto.getNom() %></td>
                            <td><%= dto.getPrenom() %></td>
                            <td><%= dto.getProduit() %></td>
                            <td><%= dto.getQuantite() %></td>
                            <td><%= dto.getDateVente() %></td>
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