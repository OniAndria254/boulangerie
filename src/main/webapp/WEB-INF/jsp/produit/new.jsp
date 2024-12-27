<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Produit</h4>

        <form class="forms-sample" method="post" action="/produit/add">
          <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom">
          </div>
          <div class="mb-3">
            <label for="prix_vente" class="form-label">Prix de vente</label>
            <input type="text" class="form-control" id="prix_vente" name="prix_vente">
          </div>

          <button type="submit" class="btn btn-primary me-2">Ajouter</button>
          <button class="btn btn-secondary">Cancel</button>
        </form>

      </div>
    </div>
  </div>

</div>
