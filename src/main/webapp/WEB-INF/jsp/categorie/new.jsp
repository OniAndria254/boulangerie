<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 07/01/2025
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.UniteMesure" %>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Categorie</h4>

        <form class="forms-sample" method="post" action="/categorie/add">
          <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom">
          </div>

          <button type="submit" class="btn btn-primary me-2">Ajouter</button>
          <button class="btn btn-secondary">Annuler</button>
        </form>

      </div>
    </div>
  </div>

</div>
