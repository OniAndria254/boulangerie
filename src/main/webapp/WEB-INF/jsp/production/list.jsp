<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Production" %>
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
%>
<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Liste des productions</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Quantite Produite</th>
                            <th>Date de production</th>
                            <th>Produit</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Production pc : all) {
                        %>
                        <tr>
                            <td><%= pc.getIdProduction()%></td>
                            <td><%= pc.getQuantiteProduite()%></td>
                            <td><%= pc.getDateProduction()%></td>
                            <td><%= pc.getProduitByIdProduit().getNom()%></td>
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