
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Ingredient" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Ingredient> all = (List<Ingredient>) request.getAttribute("all");
  List<Produit> alls = (List<Produit>) request.getAttribute("alls");
%>


<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Recette</h4>

        <form class="forms-sample" method="post" action="/recette/add">
          <div class="mb-3">
            <label class="form-label">Ingredients</label>
            <select class="form-select mb-3" name="id_ig">
              <%
                for (Ingredient ig : all) { %>
              <option value="<%= ig.getIdIngredient() %>"><%= ig.getNom() %></option>
              <%}
              %>
            </select>
          </div>

          <div class="mb-3">
            <label class="form-label">Produit</label>
            <select class="form-select mb-3" name="id_pt">
              <%
                for (Produit pt : alls) { %>
              <option value="<%= pt.getIdProduit() %>"><%= pt.getNom() %></option>
              <%}
              %>
            </select>
          </div>

          <div class="mb-3">
            <label for="quantite" class="form-label">Quantite</label>
            <input type="number" class="form-control" id="quantite" name="quantite">
          </div>

          <button type="submit" class="btn btn-primary me-2">Ajouter</button>
          <button class="btn btn-secondary">Cancel</button>
        </form>

      </div>
    </div>
  </div>

</div>
