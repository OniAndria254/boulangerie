<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 07/01/2025
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="itu.p16.boulangerie.entity.UniteMesure" %>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Categorie> all = (List<Categorie>) request.getAttribute("all");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Liste des catégories</h6>
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
              for (Categorie cat : all) {
            %>
            <tr>
              <td><%= cat.getIdCategorie()%></td>
              <td><%= cat.getNom()%></td>
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