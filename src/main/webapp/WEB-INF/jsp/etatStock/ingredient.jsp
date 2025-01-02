<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page import="itu.p16.boulangerie.entity.EtatStockIngredientEntity" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<EtatStockIngredientEntity> all = (List<EtatStockIngredientEntity>) request.getAttribute("stockIngredients");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Stock actuel d'ingrédients</h6>
        <div class="table-responsive pt-3">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>Ingredient</th>
              <th>Unité de mesure</th>
              <th>Stock disponible</th>
            </tr>
            </thead>
            <tbody>
            <%
              for (EtatStockIngredientEntity etatStockIngredientEntity : all) {
            %>
            <tr>
              <td><%= etatStockIngredientEntity.getIngredient()%></td>
              <td><%= etatStockIngredientEntity.getUniteMesure()%></td>
              <td><%= etatStockIngredientEntity.getStockDisponible()%></td>
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