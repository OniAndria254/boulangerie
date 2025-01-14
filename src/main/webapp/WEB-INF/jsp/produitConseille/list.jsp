<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.ProduitConseille" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    List<ProduitConseille> all = (List<ProduitConseille>) request.getAttribute("all");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer les produits conseillés</h6>
                <form method="get" action="/produitConseille/listConseille">
                    <div class="row">
                        <!-- Filtre Mois -->
                        <div class="col-md-3">
                            <select name="mois" class="form-control">
                                <option value="">Tous les mois</option>
                                <%
                                    String[] moisFrancais = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
                                    for (int i = 0; i < moisFrancais.length; i++) {
                                        String selected = (request.getParameter("mois") != null && request.getParameter("mois").equals(String.valueOf(i + 1))) ? "selected" : "";
                                %>
                                <option value="<%= i + 1 %>" <%= selected %>>
                                    <%= moisFrancais[i] %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <!-- Filtre Année -->
                        <div class="col-md-3">
                            <select name="annee" class="form-control">
                                <option value="">Toutes les années</option>
                                <%
                                    int anneeActuelle = java.time.Year.now().getValue();
                                    for (int annee = anneeActuelle; annee >= anneeActuelle - 5; annee--) {
                                        String selected = (request.getParameter("annee") != null && request.getParameter("annee").equals(String.valueOf(annee))) ? "selected" : "";
                                %>
                                <option value="<%= annee %>" <%= selected %>>
                                    <%= annee %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <!-- Bouton de filtre -->
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
                <h6 class="card-title">Liste des produits conseillés</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Produit</th>
                            <th>Mois</th>
                            <th>Annee</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (ProduitConseille pc : all) {
                        %>
                        <tr>
                            <td><%= pc.getProduitByIdProduit().getNom()%></td>
                            <td><%= pc.getMois()%></td>
                            <td><%= pc.getAnnee()%></td>
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