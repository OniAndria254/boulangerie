<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Unité de mesure</h4>

        <form class="forms-sample" method="post" action="/uniteMesure/add">
          <div class="mb-3">
            <label for="libelle" class="form-label">Libellé</label>
            <input type="text" class="form-control" id="libelle" name="libelle">
          </div>
          <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" class="form-control" id="description" name="description">
          </div>

          <button type="submit" class="btn btn-primary me-2">Ajouter</button>
          <button class="btn btn-secondary">Cancel</button>
        </form>

      </div>
    </div>
  </div>

</div>
