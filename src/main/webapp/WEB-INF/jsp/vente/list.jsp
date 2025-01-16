<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.*" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
  List<Vente> all = (List<Vente>) request.getAttribute("all");
  List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
  List<Parfum> parfums = (List<Parfum>) request.getAttribute("parfums");
%>


<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Filtrer les ventes</h6>
        <form method="get" action="/vente/listVente">
          <div class="row">
            <div class="col-md-3">
              <select name="idCategorie" class="form-control">
                <option value="">Toutes les catégories</option>
                <% for (Categorie categorie : categories) { %>
                <option value="<%= categorie.getIdCategorie() %>"
                        <%= (request.getParameter("idCategorie") != null &&
                                request.getParameter("idCategorie").equals(String.valueOf(categorie.getIdCategorie()))) ? "selected" : "" %>>
                  <%= categorie.getNom() %>
                </option>
                <% } %>
              </select>
            </div>

            <div class="col-md-3">
              <select name="idParfum" class="form-control">
                <option value="">Tous les parfums</option>
                <% for (Parfum parfum : parfums) { %>
                <option value="<%= parfum.getIdParfum() %>"
                        <%= (request.getParameter("idParfum") != null &&
                                request.getParameter("idParfum").equals(String.valueOf(parfum.getIdParfum()))) ? "selected" : "" %>>
                  <%= parfum.getNom() %>
                </option>
                <% } %>
              </select>
            </div>
            <div class="col-md-2">
              <button type="submit" class="btn btn-primary">Filtrer</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>


<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">Liste des ventes</h6>
        <div class="table-responsive pt-3">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>Produit</th>
              <th>Quantite</th>
              <th>Date</th>
              <th>Client</th>
            </tr>
            </thead>
            <tbody>
            <%
              for (Vente vt : all) {
            %>
            <tr>
              <td><%= vt.getProduitByIdProduit().getNom()%></td>
              <td><%= vt.getQuantite()%></td>
              <td><%= vt.getDateVente()%></td>
              <td><%= vt.getClientByIdClient().getPrenom()%></td>

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