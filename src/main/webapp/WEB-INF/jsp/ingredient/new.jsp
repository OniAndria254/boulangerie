<%@ page import="itu.p16.boulangerie.entity.UniteMesure" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<UniteMesure> all = (List<UniteMesure>) request.getAttribute("all");
%>


<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Ingredient</h4>

        <form class="forms-sample" method="post" action="/uniteMesure/add">
          <div class="mb-3">
            <label for="libelle" class="form-label">Nom</label>
            <input type="text" class="form-control" id="libelle" name="libelle">
          </div>

          <div class="mb-3">
            <label class="form-label">Default</label>
            <select class="form-select mb-3">
              <%
                for (UniteMesure um : all) { %>
                  <option value="<%= um.getIdUniteMesure() %>"><%= um.getLibelle() %></option>
                <%}
              %>
            </select>
          </div>

          <button type="submit" class="btn btn-primary me-2">Ajouter</button>
          <button class="btn btn-secondary">Cancel</button>
        </form>

      </div>
    </div>
  </div>

</div>
