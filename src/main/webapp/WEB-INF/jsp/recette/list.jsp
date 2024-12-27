<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Recette" %>

<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Recette> all = (List<Recette>) request.getAttribute("all");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Liste des recettes</h6>
        <div class="table-responsive pt-3">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>#</th>
              <th>Ingredient</th>
              <th>Produit</th>
              <th>Quantite</th>
            </tr>
            </thead>
            <tbody>
            <%
              for (Recette rc : all) {
            %>
            <tr>
              <td><%= rc.getIngredientByIdIngredient().getNom()%></td>
              <td><%= rc.getProduitByIdProduit().getNom()%></td>
              <td><%= rc.getQuantite()%></td>
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