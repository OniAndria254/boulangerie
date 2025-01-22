<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="itu.p16.boulangerie.entity.Vendeur" %>


<%
    List<Vendeur> vendeurs = (List<Vendeur>) request.getAttribute("all");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Liste des vendeurs</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Salaire</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Vendeur vd : vendeurs) {
                        %>
                        <tr>
                            <td><%= vd.getIdVendeur()%></td>
                            <td><%= vd.getNom()%></td>
                            <td><%= vd.getPrenom()%></td>
                            <td><%= vd.getSalaire()%></td>

                            <td>
                                <a href="/vendeur/update?id=<%= vd.getIdVendeur() %>" class="btn btn-warning btn-sm">Modifier</a>
                                <a href="/vendeur/delete?id=<%= vd.getIdVendeur() %>"
                                   class="btn btn-danger"
                                   onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce vendeur ?')">
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