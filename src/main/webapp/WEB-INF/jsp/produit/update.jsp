<%@ page import="itu.p16.boulangerie.entity.Produit" %><%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 06/01/2025
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Produit produit = (Produit) request.getAttribute("produit");
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

                    <button type="submit" class="btn btn-primary">Mettre à jour</button>
                </form>

            </div>
        </div>
    </div>

</div>
