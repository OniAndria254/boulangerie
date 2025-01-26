
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Genre" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Genre> genres = (List<Genre>) request.getAttribute("genres");
%>
<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">

                <h4 class="card-title">Insertion Vendeur</h4>

                <form class="forms-sample" method="post" action="/vendeur/add">
                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom">
                    </div>

                    <div class="mb-3">
                        <label for="prenom" class="form-label">Prenom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom">
                    </div>

                    <div class="mb-3">
                        <label for="salaire" class="form-label">Salaire</label>
                        <input type="number" class="form-control" id="salaire" name="salaire">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Genre</label>
                        <select class="form-select mb-3" name="idGenre" required>
                            <% for (Genre g : genres) { %>
                            <option value="<%= g.getIdGenre() %>"><%= g.getNom() %></option>
                            <% } %>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-primary me-2">Ajouter</button>
                    <button class="btn btn-secondary">Annuler</button>
                </form>

            </div>
        </div>
    </div>

</div>
