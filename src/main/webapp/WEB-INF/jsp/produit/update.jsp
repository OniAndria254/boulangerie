<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page import="itu.p16.boulangerie.entity.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Parfum" %><%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 06/01/2025
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Produit produit = (Produit) request.getAttribute("produit");
    List<Categorie> all = (List<Categorie>) request.getAttribute("all");
    List<Parfum> parfums = (List<Parfum>) request.getAttribute("parfums");
%>
<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">

                <h4 class="card-title">Modifier Produit</h4>

                <form class="forms-sample" method="post" action="/produit/update">
                    <input type="hidden" name="id" value="<%= produit.getIdProduit() %>">
                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" value="<%= produit.getNom() %>">
                    </div>
                    <div class="mb-3">
                        <label for="prix_vente" class="form-label">Prix de vente</label>
                        <input type="number" class="form-control" id="prix_vente" name="prix_vente" value="<%= produit.getPrixVente() %>">
                    </div>

                    <div class="mb-3">
                        <label for="idCategorie" class="form-label">Catégorie</label>
                        <select class="form-control" id="idCategorie" name="idCategorie">
                            <%
                                for (Categorie cat : all) {
                                    boolean isSelected = produit.getCategorieByIdCategorie().getIdCategorie().equals(cat.getIdCategorie());
                            %>
                            <option value="<%= cat.getIdCategorie() %>" <%= isSelected ? "selected" : "" %>>
                                <%= cat.getNom() %>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="idParfum" class="form-label">Parfum</label>
                        <select class="form-control" id="idParfum" name="idParfum">
                            <%
                                for (Parfum p : parfums) {
                                    boolean isSelected = produit.getParfumByIdParfum().getIdParfum().equals(p.getIdParfum());
                            %>
                            <option value="<%= p.getIdParfum() %>" <%= isSelected ? "selected" : "" %>>
                                <%= p.getNom() %>
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
