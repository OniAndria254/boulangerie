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
                <h6 class="card-title">Liste des produits</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Nom</th>
                            <th>Prix de vente</th>
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