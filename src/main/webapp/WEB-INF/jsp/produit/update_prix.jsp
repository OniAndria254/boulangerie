
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Produit> all = (List<Produit>) request.getAttribute("all");
    String error = (String) request.getAttribute("error");
    if(error != null)
    {
%>
<div class="alert alert-danger" role="alert"><%= error%></div>
<%
    }
%>


<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">

                <h4 class="card-title">Modification prix de produit</h4>

                <form class="forms-sample" method="post" action="/produit/updatePrix">

                    <div class="mb-3">
                        <label class="form-label">Produit</label>
                        <select class="form-select mb-3" name="id" id="produitSelect" onchange="updatePrixAndDate()">
                            <%
                                for (Produit pt : all) { %>
                            <option value="<%= pt.getIdProduit() %>" data-prix="<%= pt.getPrixVente() %>"><%= pt.getNom() %></option>
                            <%}
                            %>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="prix" class="form-label">Prix</label>
                        <input type="number" class="form-control" id="prix" name="prix">
                    </div>

                    <div class="mb-3">
                        <label for="daty" class="form-label">Date</label>
                        <input type="date" class="form-control" id="daty" name="daty">
                    </div>

                    <button type="submit" class="btn btn-primary me-2">Valider</button>
                    <button class="btn btn-secondary">Annuler</button>
                </form>

            </div>
        </div>
    </div>
</div>

<script>
    // Fonction pour mettre à jour le prix et la date
    function updatePrixAndDate() {
        // Récupérer l'élément sélectionné
        const select = document.getElementById("produitSelect");
        const selectedOption = select.options[select.selectedIndex];

        // Mettre à jour le champ "prix" avec la valeur de l'attribut data-prix
        const prixInput = document.getElementById("prix");
        prixInput.value = selectedOption.getAttribute("data-prix");

        // Mettre à jour le champ "daty" avec la date actuelle
        const datyInput = document.getElementById("daty");
        const today = new Date().toISOString().split('T')[0]; // Format YYYY-MM-DD
        datyInput.value = today;
    }

    // Appeler la fonction au chargement de la page pour initialiser les valeurs
    window.onload = function() {
        updatePrixAndDate();
    };
</script>
