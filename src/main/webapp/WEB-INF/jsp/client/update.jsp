<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Parfum" %>
<%@ page import="itu.p16.boulangerie.entity.Client" %><%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 06/01/2025
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Client client  = (Client) request.getAttribute("client");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Modifier client</h4>

        <form class="forms-sample" method="post" action="/client/update">
          <input type="hidden" name="idClient" value="<%= client.getIdClient() %>">
          <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" value="<%= client.getNom() %>">
          </div>
          <div class="mb-3">
            <label for="prenom" class="form-label">Prénom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="<%= client.getPrenom() %>">
          </div>

          <div class="mb-3">
            <label for="dateNaissance" class="form-label">Date de naissance</label>
            <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" value="<%= client.getDateNaissance() %>">
          </div>



          <button type="submit" class="btn btn-primary">Mettre à jour</button>
        </form>

      </div>
    </div>
  </div>

</div>
