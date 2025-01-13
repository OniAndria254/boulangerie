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
<%@ page import="itu.p16.boulangerie.entity.Parfum" %>
<%@ page import="itu.p16.boulangerie.entity.Parfum" %>
<%
    List<Parfum> parfums = (List<Parfum>) request.getAttribute("all");
%>


<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Liste des parfums</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Nom</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Parfum parfum : parfums) {
                        %>
                        <tr>
                            <td><%= parfum.getIdParfum()%></td>
                            <td><%= parfum.getNom()%></td>

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