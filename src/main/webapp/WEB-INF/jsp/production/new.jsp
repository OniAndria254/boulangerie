
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Produit> all = (List<Produit>) request.getAttribute("all");
%>


<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Production</h4>

        <form class="forms-sample" method="post" action="/production/add">
          <div class="mb-3">
            <label for="quantite_produite" class="form-label">Quantite produite</label>
            <input type="text" class="form-control" id="quantite_produite" name="quantite_produite">
          </div>

          <div class="card-body">
              <label for="date_production" class="form-label">Date de production</label>
              <input type="text" class="form-control" id="date_production" name="date_production">
              <span class="input-group-text input-group-addon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-calendar"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg></span>
            </div>

          <div class="mb-3">
            <label class="form-label">Produit</label>
            <select class="form-select mb-3" name="id_pt">
              <%
                for (Produit pt : all) { %>
              <option value="<%= pt.getIdProduit() %>"><%= pt.getNom() %></option>
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
