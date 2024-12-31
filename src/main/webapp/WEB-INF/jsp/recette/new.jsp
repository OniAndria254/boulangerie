
<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Ingredient" %>
<%@ page import="itu.p16.boulangerie.entity.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Ingredient> all = (List<Ingredient>) request.getAttribute("all");
  List<Produit> alls = (List<Produit>) request.getAttribute("alls");
%>

<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Recette</h4>

        <form id="recetteForm">
          <div class="mb-3">
            <label class="form-label">Produit</label>
            <select class="form-select mb-3" name="id_pt" required>
              <% for (Produit pt : alls) { %>
              <option value="<%= pt.getIdProduit() %>"><%= pt.getNom() %></option>
              <% } %>
            </select>
          </div>

          <div id="ingredients-container">
            <div class="mb-3 ingredient-row">
              <label class="form-label">Ingredient</label>
              <select class="form-select mb-3" name="ingredients[0].id_ig" required>
                <% for (Ingredient ig : all) { %>
                <option value="<%= ig.getIdIngredient() %>"><%= ig.getNom() %></option>
                <% } %>
              </select>
              <label for="quantite" class="form-label">Quantite</label>
              <input type="number" step="0.01" class="form-control mb-3" name="ingredients[0].quantite" required>
            </div>
          </div>

          <button type="button" class="btn btn-success" id="addIngredientBtn">Ajouter un autre ingrédient</button>
          <button type="button" class="btn btn-primary me-2" id="submitFormBtn">Ajouter</button>
          <button type="button" class="btn btn-secondary" onclick="window.location.href='/recette/list';">Annuler</button>
        </form>


      </div>
    </div>
  </div>
</div>
<script>
  let ingredientIndex = 1;

  // Ajouter un nouvel ingrédient
  document.getElementById('addIngredientBtn').addEventListener('click', function() {
    const container = document.getElementById('ingredients-container');
    const newRow = document.createElement('div');
    newRow.classList.add('mb-3', 'ingredient-row');
    newRow.innerHTML =
            '<label class="form-label">Ingredient</label>' +
            '<select class="form-select mb-3" name="ingredients[' + ingredientIndex + '].id_ig" required>' +
            '<% for (Ingredient ig : all) { %>' +
            '<option value="<%= ig.getIdIngredient() %>"><%= ig.getNom() %></option>' +
            '<% } %>' +
            '</select>' +
            '<label for="quantite" class="form-label">Quantite</label>' +
            '<input type="number" step="0.01" class="form-control mb-3" name="ingredients[' + ingredientIndex + '].quantite" required>';

    container.appendChild(newRow);
    ingredientIndex++;
  });

  // Soumettre le formulaire en JSON
  document.getElementById('submitFormBtn').addEventListener('click', function() {
    const formData = new FormData(document.getElementById('recetteForm'));
    const jsonData = {
      id_pt: parseInt(formData.get('id_pt')), // Convertir en nombre
      ingredients: []
    };

    for (let i = 0; i < ingredientIndex; i++) {
      const id_ig = parseInt(formData.get("ingredients[" + i + "].id_ig")); // Convertir en nombre
      const quantite = parseFloat(formData.get("ingredients[" + i + "].quantite"));
      if (id_ig && quantite) {
        jsonData.ingredients.push({ id_ig, quantite });
      }
    }

    console.log('Données envoyées:', JSON.stringify(jsonData));


    // Envoyer les données en JSON via AJAX
    fetch('/recette/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(jsonData)
    })
            .then(response => {
              if (response.ok) {
                alert('Recette ajoutée avec succès');
                window.location.href = '/recette/list';
              } else {
                response.json().then(err => console.error('Erreur:', err));
              }
            })
            .catch(error => console.error('Erreur réseau:', error));
  });
</script>
