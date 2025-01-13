<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 09/01/2025
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion de nouveau parfum</h4>

        <form class="forms-sample" method="post" action="/parfum/add">
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


</body>
</html>
