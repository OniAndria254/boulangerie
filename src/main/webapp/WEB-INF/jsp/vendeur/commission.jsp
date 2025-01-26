<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.dto.CommissionVendeurDTO" %>
<%@ page import="itu.p16.boulangerie.dto.CommissionGenreDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: onian
  Date: 25/12/2024
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<CommissionVendeurDTO> commissionDTOS = (List<CommissionVendeurDTO>) request.getAttribute("all");
    List<CommissionGenreDTO> commissionGenreDTOS = (List<CommissionGenreDTO>) request.getAttribute("parGenre");
%>

<div class="row">
    <div class="col-md-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Filtrer les commissions</h6>
                <form method="get" action="/commissions">
                    <div class="row">
                        <div class="col-md-3">
                            <label for="date_debut" class="form-label">Date entre</label>
                            <input type="date" class="form-control form-control-sm" id="date_debut" name="date_debut"
                                   value="<%= request.getParameter("date_debut") != null ? request.getParameter("date_debut") : "" %>">
                        </div>
                        <div class="col-md-3">
                            <label for="date_fin" class="form-label">Et</label>
                            <input type="date" class="form-control form-control-sm" id="date_fin" name="date_fin"
                                   value="<%= request.getParameter("date_fin") != null ? request.getParameter("date_fin") : "" %>">
                        </div>
                        <div class="col-md-2 align-self-end">
                            <button type="submit" class="btn btn-primary btn-sm">Filtrer</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-6 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Liste des commissions par Vendeur</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Vendeur</th>
                            <th>Montant</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (CommissionVendeurDTO com : commissionDTOS) {
                        %>
                        <tr>
                            <td><%= com.getNomVendeur() + " " + com.getPrenomVendeur() %></td>
                            <td><%= com.getCommissionTotale() %></td>
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

    <div class="col-md-6 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h6 class="card-title">Liste des commissions par Genre</h6>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Genre</th>
                            <th>Montant</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (CommissionGenreDTO cg : commissionGenreDTOS) {
                        %>
                        <tr>
                            <td><%= cg.getNomGenre() %></td>
                            <td><%= cg.getCommissionTotale() %></td>
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

    <div class="col-md-6 grid-margin">
        <div class="card">
            <div class="card-body">
                <canvas id="commissionChart" width="400" height="200"></canvas>
            </div>
        </div>
    </div>
</div>


<script>
    // Préparer les données
    var genreLabels = [];
    var commissionData = [];
    var dateDebutLabels = [];
    var dateFinLabels = [];

    <%
        for (CommissionGenreDTO dto : commissionGenreDTOS) {
    %>
    genreLabels.push('<%= dto.getNomGenre() %>');
    commissionData.push(<%= dto.getCommissionTotale() %>);
    dateDebutLabels.push('<%= dto.getDateDebut() %>');
    dateFinLabels.push('<%= dto.getDateFin() %>');
    <%
        }
    %>

    let genres = ['Homme', 'Femme']; // Étiquettes des genres
    let colors = genres.map(genre => {
        return genre === 'Homme'
            ? 'rgba(54, 162, 235, 0.5)' // Bleu pour Homme
            : 'rgba(255, 99, 132, 0.5)'; // Rose pour Femme
    });

    let commissionChartConfig = {
        type: 'bar',
        data: {
            labels: genreLabels, // Utilisation des labels dynamiques
            datasets: [{
                label: 'Commission Totale',
                data: commissionData, // Utilisation des données dynamiques
                backgroundColor: genreLabels.map(label => {
                    return label === 'Homme'
                        ? 'rgba(54, 162, 235, 0.5)' // Bleu pour Homme
                        : 'rgba(255, 99, 132, 0.5)'; // Rose pour Femme
                }),
                borderColor: genreLabels.map(label => {
                    return label === 'Homme'
                        ? 'rgba(54, 162, 235, 1)' // Bordure bleue pour Homme
                        : 'rgba(255, 99, 132, 1)'; // Bordure rose pour Femme
                }),
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: { display: true },
                tooltip: { enabled: true }
            },
            scales: {
                y: {
                    beginAtZero: true,
                    title: { display: true, text: 'Montant' }
                },
                x: {
                    title: { display: true, text: 'Genres' }
                }
            }
        }
    };

    // let commissionChartConfig = {
    //     type: 'pie', // Type de graphique
    //     data: {
    //         labels: genreLabels, // Utilisation des labels dynamiques (Homme, Femme)
    //         datasets: [{
    //             label: 'Répartition des commissions',
    //             data: commissionData, // Données dynamiques
    //             backgroundColor: genreLabels.map(label => {
    //                 return label === 'Homme'
    //                     ? 'rgba(54, 162, 235, 0.5)' // Bleu pour Homme
    //                     : 'rgba(255, 99, 132, 0.5)'; // Rose pour Femme
    //             }),
    //             borderColor: genreLabels.map(label => {
    //                 return label === 'Homme'
    //                     ? 'rgba(54, 162, 235, 1)' // Bordure bleue pour Homme
    //                     : 'rgba(255, 99, 132, 1)'; // Bordure rose pour Femme
    //             }),
    //             borderWidth: 1
    //         }]
    //     },
    //     options: {
    //         responsive: true, // Adapter la taille au conteneur
    //         plugins: {
    //             legend: { display: true }, // Afficher la légende
    //             tooltip: { enabled: true } // Activer les tooltips
    //         }
    //     }
    // };



    // Initialiser le graphique
    let commissionCanvas = document.getElementById("commissionChart").getContext('2d');
    new Chart(commissionCanvas, commissionChartConfig);
</script>