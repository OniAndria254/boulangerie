
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.UniteMesure" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<UniteMesure> all = (List<UniteMesure>) request.getAttribute("all");
%>


<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Ingredient</h4>

        <form class="forms-sample" method="post" action="/ingredient/add">
          <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom">
          </div>

          <div class="mb-3">
            <label class="form-label">Unite de mesure</label>
            <select class="form-select mb-3" name="id_um">
              <%
                for (UniteMesure um : all) { %>
                  <option value="<%= um.getIdUniteMesure() %>"><%= um.getLibelle() %></option>
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
