
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Client</h4>

        <form class="forms-sample" method="post" action="/client/add">
          <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom">
          </div>

          <div class="mb-3">
            <label for="prenom" class="form-label">Prenom</label>
            <input type="text" class="form-control" id="prenom" name="prenom">
          </div>

          <div class="mb-3">
            <label for="date_naissance" class="form-label">Date de naissance</label>
            <input type="date" class="form-control" id="date_naissance" name="date_naissance">
          </div>

          <button type="submit" class="btn btn-primary me-2">Ajouter</button>
          <button class="btn btn-secondary">Annuler</button>
        </form>

      </div>
    </div>
  </div>

</div>
