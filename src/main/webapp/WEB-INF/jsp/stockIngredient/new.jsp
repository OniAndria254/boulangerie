<%@ page import="java.util.List" %>
<%@ page import="itu.p16.boulangerie.entity.Ingredient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Ingredient> all = (List<Ingredient>) request.getAttribute("all");
%>

<div class="row">
  <div class="col-md-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">

        <h4 class="card-title">Insertion Stock d'Ingrédients</h4>

        <form id="stockForm">
          <div id="ingredients-container">

            <div class="mb-3">
              <label for="date_ajout" class="form-label">Date d'ajout</label>
              <input type="date" class="form-control" id="date_ajout" name="date_ajout" required>
            </div>

            <div class="mb-3 ingredient-row">
              <label class="form-label">Ingrédient</label>
              <select class="form-select mb-3" name="ingredients[0].id_ingredient" required>
                <% for (Ingredient ig : all) { %>
                <option value="<%= ig.getIdIngredient() %>"><%= ig.getNom() %></option>
                <% } %>
              </select>
              <label for="entree_0" class="form-label">Entrée</label>
              <input type="number" step="0.01" class="form-control mb-3" name="ingredients[0].entree" required>
            </div>
          </div>

          <button type="button" class="btn btn-success" id="addIngredientBtn">Ajouter un autre ingrédient</button>
          <button type="button" class="btn btn-primary me-2" id="submitFormBtn">Enregistrer</button>
          <button type="button" class="btn btn-secondary" onclick="window.location.href='/etatStock/ingredientStock';">Annuler</button>
        </form>

      </div>
    </div>
  </div>
</div>

<script>
  let ingredientIndex = 1;

  // Ajouter un nouvel ingrédient
  document.getElementById('addIngredientBtn').addEventListener('click', function () {
    const container = document.getElementById('ingredients-container');
    const newRow = document.createElement('div');
    newRow.classList.add('mb-3', 'ingredient-row');
    newRow.innerHTML =
            '<label class="form-label">Ingrédient</label>' +
            '<select class="form-select mb-3" name="ingredients[' + ingredientIndex + '].id_ingredient" required>' +
            '<% for (Ingredient ig : all) { %>' +
            '<option value="<%= ig.getIdIngredient() %>"><%= ig.getNom() %></option>' +
            '<% } %>' +
            '</select>' +
            '<label for="entree_' + ingredientIndex + '" class="form-label">Entrée</label>' +
            '<input type="number" step="0.01" class="form-control mb-3" name="ingredients[' + ingredientIndex + '].entree" required>';

    container.appendChild(newRow);
    ingredientIndex++;
  });

  // Soumettre le formulaire en JSON
  document.getElementById('submitFormBtn').addEventListener('click', function () {
    const formData = new FormData(document.getElementById('stockForm'));
    const jsonData = {
      ingredients: [],
      dateAjout: formData.get('date_ajout')  // Récupérer la valeur de la date
    };

    for (let i = 0; i < ingredientIndex; i++) {
      const id_ingredient = parseInt(formData.get("ingredients[" + i + "].id_ingredient")); // Convertir en nombre
      const entree = parseFloat(formData.get("ingredients[" + i + "].entree"));
      if (id_ingredient && entree) {
        jsonData.ingredients.push({ id_ingredient, entree });
      }
    }

    console.log('Données envoyées:', JSON.stringify(jsonData));

    // Envoyer les données en JSON via AJAX
    fetch('/stockIngredient/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(jsonData)
    })
            .then(response => {
              if (response.ok) {
                alert('Stock ajouté avec succès');
                window.location.href = '/etatStock/ingredientStock';
              } else {
                response.text().then(text => {
                  try {
                    const err = JSON.parse(text); // Essayer de parser en JSON
                    console.error('Erreur (JSON):', err);
                  } catch (e) {
                    console.error('Erreur (texte):', text); // Sinon, affichez le texte brut
                  }
                });

              }
            })
            .catch(error => console.error('Erreur réseau:', error));
  });
</script>
