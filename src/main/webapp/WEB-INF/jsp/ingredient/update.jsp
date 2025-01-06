<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 06/01/2025
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="itu.p16.boulangerie.entity.Ingredient" %>
<%@ page import="itu.p16.boulangerie.entity.UniteMesure" %>
<%@ page import="java.util.List" %>
<%
  List<UniteMesure> uniteMesures = (List<UniteMesure>) request.getAttribute("uniteMesures");
  Ingredient ingredient = (Ingredient) request.getAttribute("ingredient");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Modifier ingredient</h6>
          <form action="/ingredient/update" method="post">
            <input type="hidden" name="id" value="<%= ingredient.getIdIngredient() %>">
            <div class="mb-3">
              <label for="nom" class="form-label">Nom de l'ingrédient</label>
              <input type="text" class="form-control" id="nom" name="nom" value="<%= ingredient.getNom() %>" required>
            </div>
            <div class="mb-3">
              <label for="idUniteMesure" class="form-label">Unité de mesure</label>
              <select class="form-control" id="idUniteMesure" name="idUniteMesure">
                <%
                  for (UniteMesure um : uniteMesures) {
                    boolean isSelected = ingredient.getUniteMesureByIdUniteMesure().getIdUniteMesure().equals(um.getIdUniteMesure());
                %>
                <option value="<%= um.getIdUniteMesure() %>" <%= isSelected ? "selected" : "" %>>
                  <%= um.getLibelle() %>
                </option>
                <%
                  }
                %>
              </select>
            </div>
            <button type="submit" class="btn btn-primary">Mettre à jour</button>
          </form>
      </div>
    </div>
  </div>
</div>
