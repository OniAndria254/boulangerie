<%@ page import="java.util.List" %>
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
  List<Ingredient> all = (List<Ingredient>) request.getAttribute("all");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Liste des ingredients</h6>
        <div class="table-responsive pt-3">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>#</th>
              <th>Nom</th>
              <th>Unite de mesure</th>
              <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
              for (Ingredient ig : all) {
            %>
            <tr>
              <td><%= ig.getIdIngredient() %></td>
              <td><%= ig.getNom() %></td>
              <td><%= ig.getUniteMesureByIdUniteMesure().getLibelle() %></td>
              <td>
                <a href="/ingredient/update?id=<%= ig.getIdIngredient() %>" class="btn btn-warning btn-sm">Modifier</a>
                <a href="/ingredient/delete?id=<%= ig.getIdIngredient() %>"
                   class="btn btn-danger"
                   onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet ingrédient ?')">
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