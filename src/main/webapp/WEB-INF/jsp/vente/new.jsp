<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Client" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 09/01/2025
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Produit> all = (List<Produit>) request.getAttribute("all");
  List<Client> clients = (List<Client>) request.getAttribute("clients");

  String error = (String) request.getAttribute("error");
  if(error != null)
  {
%>
<div class="alert alert-danger" role="alert"><%= error%></div>
<%
  }
%>

<html>
<body>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Vente</h4>

        <form class="forms-sample" method="post" action="/vente/add">
          <div class="mb-3">
            <label class="form-label">Produit</label>
            <select class="form-select mb-3" name="id_produit">
              <%
                for (Produit pt : all) { %>
              <option value="<%= pt.getIdProduit() %>"><%= pt.getNom() %></option>
              <%}
              %>
            </select>
          </div>

          <div class="mb-3">
            <label for="quantite_vendu" class="form-label">Quantite vendu</label>
            <input type="number" class="form-control" id="quantite_vendu" name="quantite_vendu">
          </div>

          <div class="mb-3">
            <label for="date_vente" class="form-label">Date de vente</label>
            <input type="date" class="form-control" id="date_vente" name="date_vente">
          </div>

          <div class="mb-3">
            <label class="form-label">Client</label>
            <select class="form-select mb-3" name="id_client">
              <%
                for (Client cl : clients) { %>
              <option value="<%= cl.getIdClient() %>"><%= cl.getPrenom() %></option>
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

</body>
</html>
