<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Categorie> all = (List<Categorie>) request.getAttribute("all");
%>
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
            <input type="number" class="form-control" id="prix_vente" name="prix_vente">
          </div>

          <div class="mb-3">
            <label class="form-label">Categorie</label>
            <select class="form-select mb-3" name="categorie">
              <%
                for (Categorie cat : all) { %>
              <option value="<%= cat.getIdCategorie() %>"><%= cat.getNom() %></option>
              <%}
              %>
            </select>
          </div>

          <button type="submit" class="btn btn-primary me-2">Ajouter</button>
          <button class="btn btn-secondary">Annuler</button>
        </form>

      </div>
    </div>
  </div>

</div>
