package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.*;
import itu.p16.boulangerie.exception.InsufficientStockException;
import itu.p16.boulangerie.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductionService {

    @Autowired
    private ProductionRepository productionRepository;


    @Autowired
    private RecetteRepository recetteRepository;

    @Autowired
    private StockIngredientFilleRepository stockIngredientFilleRepository;

    @Autowired
    private StockIngredientMereRepository stockIngredientMereRepository;

    @Autowired
    private StockProduitMereRepository stockProduitMereRepository;

    @Autowired
    private StockProduitFilleRepository stockProduitFilleRepository;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private IngredientService ingredientService;

    @Transactional
    public Production save(Production production) {
        // Obtenir les recettes liées au produit à produire
        Produit p = produitService.getById(production.getProduitByIdProduit().getIdProduit()).orElseThrow();
        List<Recette> recettes = recetteRepository.findByProduitByIdProduit(p);

        if (recettes.isEmpty()) {
            throw new IllegalArgumentException("Aucune recette trouvée pour le produit: " + production.getProduitByIdProduit().getNom());
        }

        // Vérifier le stock pour chaque ingrédient nécessaire
        for (Recette recette : recettes) {
            Integer idIngredient = recette.getIngredientByIdIngredient().getIdIngredient();
            Double quantiteNecessaire = recette.getQuantite() * production.getQuantiteProduite();

            // Calculer le stock disponible pour l'ingrédient
            Double stockDisponible = stockIngredientFilleRepository.calculateStockForIngredient(idIngredient);

            if (stockDisponible == null || stockDisponible < quantiteNecessaire) {
                throw new InsufficientStockException("Stock insuffisant pour l'ingrédient: " + recette.getIngredientByIdIngredient().getNom());
            }
        }

        // Mettre à jour le stock des ingrédients consommés
        for (Recette recette : recettes) {
            Integer idIngredient = recette.getIngredientByIdIngredient().getIdIngredient();
            Double quantiteNecessaire = recette.getQuantite() * production.getQuantiteProduite();

            StockIngredientFille sortieStock = new StockIngredientFille();
            sortieStock.setSortie(quantiteNecessaire);
            sortieStock.setIngredientByIdIngredient(ingredientService.getById(idIngredient).orElseThrow());
            sortieStock.setStockIngredientMereByIdMere(stockIngredientMereRepository.findById(production.getProduitByIdProduit().getIdProduit()).orElseThrow());
            stockIngredientFilleRepository.save(sortieStock);
        }

        // Mettre à jour le stock des produits finis
        Integer quantiteProduit = production.getQuantiteProduite();

        StockProduitMere stockProduitMere = new StockProduitMere();
        stockProduitMere.setDaty(production.getDateProduction());
        stockProduitMere = stockProduitMereRepository.save(stockProduitMere);

        StockProduitFille stockProduitFille = new StockProduitFille();
        stockProduitFille.setEntree(quantiteProduit); // On ajoute la quantité produite en entrée
        stockProduitFille.setSortie(0);
        stockProduitFille.setStockProduitMereByIdMere(stockProduitMere);
        stockProduitFille.setProduitByIdProduit(produitService.getById(production.getProduitByIdProduit().getIdProduit()).orElseThrow());
        stockProduitFilleRepository.save(stockProduitFille); // Enregistrer la sortie dans stock_produit_fille

        // Enregistrer la production
        return productionRepository.save(production);
    }

    public List<Production> getAll() {
        return productionRepository.findAll();
    }
}
