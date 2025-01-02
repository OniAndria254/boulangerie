<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page import="itu.p16.boulangerie.entity.EtatStockProduitEntity" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<EtatStockProduitEntity> all = (List<EtatStockProduitEntity>) request.getAttribute("stockProduits");
%>
<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Stock actuel de produits</h6>
        <div class="table-responsive pt-3">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>Produit</th>
              <th>Stock disponible</th>
            </tr>
            </thead>
            <tbody>
            <%
              for (EtatStockProduitEntity etatStockProduitEntity : all) {
            %>
            <tr>
              <td><%= etatStockProduitEntity.getProduit()%></td>
              <td><%= etatStockProduitEntity.getStockDisponible()%></td>
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