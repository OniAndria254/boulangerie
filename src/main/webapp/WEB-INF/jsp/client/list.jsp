<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page import="itu.p16.boulangerie.entity.Client" %>
<%
    List<Client> clients = (List<Client>) request.getAttribute("all");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Liste des clients</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Date de naissance</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Client cl : clients) {
                        %>
                        <tr>
                            <td><%= cl.getIdClient()%></td>
                            <td><%= cl.getNom()%></td>
                            <td><%= cl.getPrenom()%></td>
                            <td><%= cl.getDateNaissance()%></td>

                            <td>
                                <a href="/client/update?id=<%= cl.getIdClient() %>" class="btn btn-warning btn-sm">Modifier</a>
                                <a href="/client/delete?id=<%= cl.getIdClient() %>"
                                   class="btn btn-danger"
                                   onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce client ?')">
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