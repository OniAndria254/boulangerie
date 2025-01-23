<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.*" %><%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 06/01/2025
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Vendeur vendeur = (Vendeur) request.getAttribute("vendeur");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Modifier vendeur</h4>

        <form class="forms-sample" method="post" action="/vendeur/update">
          <input type="hidden" name="idVendeur" value="<%= vendeur.getIdVendeur() %>">
          <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" value="<%= vendeur.getNom() %>">
          </div>
          <div class="mb-3">
            <label for="prenom" class="form-label">Prénom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="<%= vendeur.getPrenom() %>">
          </div>

          <div class="mb-3">
            <label for="salaire" class="form-label">Salaire</label>
            <input type="number" class="form-control" id="salaire" name="salaire" value="<%= vendeur.getSalaire() %>">
          </div>



          <button type="submit" class="btn btn-primary">Mettre à jour</button>
        </form>

      </div>
    </div>
  </div>

</div>
