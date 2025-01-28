<%@ page import="itu.p16.boulangerie.entity.HistoriquePrix" %>
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<HistoriquePrix> all = (List<HistoriquePrix>) request.getAttribute("all");

    // Regrouper les historiques par produit
    Map<String, List<HistoriquePrix>> historiquesParProduit = new LinkedHashMap<>();
    for (HistoriquePrix hp : all) {
        String produitNom = hp.getProduitByIdProduit().getNom();
        historiquesParProduit
                .computeIfAbsent(produitNom, k -> new java.util.ArrayList<>())
                .add(hp);
    }
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer par produit</h6>
                <form method="get" action="/produit/historique">
                    <div class="form-group">
                        <select class="form-control" name="produitId">
                            <option value="0">Tous les produits</option>
                            <%
                                List<Produit> produits = (List<Produit>) request.getAttribute("produits");
                                for (Produit produit : produits) {
                            %>
                            <option value="<%= produit.getIdProduit() %>"><%= produit.getNom() %></option>
                            <%
                                }
                            %>
                        </select>
                        <br>
                        <button type="submit" class="btn btn-primary">Filtrer</button>
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
                <h6 class="card-title">Historique des prix</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Produit</th>
                            <th>Prix</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Map.Entry<String, List<HistoriquePrix>> entry : historiquesParProduit.entrySet()) {
                                String produit = entry.getKey();
                                List<HistoriquePrix> historiques = entry.getValue();
                        %>
                        <tr>
                            <td rowspan="<%= historiques.size() %>"><strong><%= produit %></strong></td>
                            <td><%= historiques.get(0).getPrix() %></td>
                            <td><%= historiques.get(0).getDaty() %></td>
                        </tr>
                        <%
                            for (int i = 1; i < historiques.size(); i++) {
                                HistoriquePrix hp = historiques.get(i);
                        %>
                        <tr>
                            <td><%= hp.getPrix() %></td>
                            <td><%= hp.getDaty() %></td>
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