<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Recette" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Recette> all = (List<Recette>) request.getAttribute("all");

  // Regrouper les recettes par produit
  Map<String, List<Recette>> recettesParProduit = new LinkedHashMap<>();
  for (Recette rc : all) {
    String produitNom = rc.getProduitByIdProduit().getNom();
    recettesParProduit
            .computeIfAbsent(produitNom, k -> new java.util.ArrayList<>())
            .add(rc);
  }
%>

<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Liste des recettes</h6>
        <div class="table-responsive pt-3">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>Produit</th>
              <th>Ingredient</th>
              <th>Quantite</th>
            </tr>
            </thead>
            <tbody>
            <%
              for (Map.Entry<String, List<Recette>> entry : recettesParProduit.entrySet()) {
                String produit = entry.getKey();
                List<Recette> recettes = entry.getValue();
            %>
            <tr>
              <td rowspan="<%= recettes.size() %>"><strong><%= produit %></strong></td>
              <td><%= recettes.get(0).getIngredientByIdIngredient().getNom() %></td>
              <td><%= recettes.get(0).getQuantite() %> (<%= recettes.get(0).getIngredientByIdIngredient().getUniteMesureByIdUniteMesure().getLibelle()%>)</td>
            </tr>
            <%
              for (int i = 1; i < recettes.size(); i++) {
                Recette rc = recettes.get(i);
            %>
            <tr>
              <td><%= rc.getIngredientByIdIngredient().getNom() %></td>
              <td><%= rc.getQuantite() %> (<%= rc.getIngredientByIdIngredient().getUniteMesureByIdUniteMesure().getLibelle()%>)</td>
            </tr>
            <%
                }
              }
            %>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
