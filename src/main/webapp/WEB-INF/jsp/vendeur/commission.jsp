<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Production" %>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page import="itu.p16.boulangerie.entity.Ingredient" %>
<%@ page import="itu.p16.boulangerie.entity.Vendeur" %>
<%@ page import="itu.p16.boulangerie.dto.CommissionVendeurDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    List<CommissionVendeurDTO> commissionDTOS = (List<CommissionVendeurDTO>) request.getAttribute("all");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer les vendeurs</h6>
                <form method="get" action="/commissions">
                    <div class="mb-3">
                        <label for="date_debut" class="form-label">Date entre</label>
                        <input type="date" class="form-control form-control-sm" id="date_debut" name="date_debut" style="max-width: 150px;"value="<%= request.getParameter("date_debut") != null ? request.getParameter("date_debut") : "" %>">
                    </div>

                    <div class="mb-3">
                        <label for="date_fin" class="form-label">Et</label>
                        <input type="date" class="form-control form-control-sm" id="date_fin" name="date_fin" style="max-width: 150px;" value="<%= request.getParameter("date_fin") != null ? request.getParameter("date_fin") : "" %>">
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-primary btn-sm">Filtrer</button>
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
                <h6 class="card-title">Liste des commissions</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Vendeur</th>
                            <th>Montant</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (CommissionVendeurDTO com : commissionDTOS) {
                        %>
                        <tr>
                            <td><%= com.getNomVendeur() + " " + com.getPrenomVendeur()%></td>
                            <td><%= com.getCommissionTotale()%></td>
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