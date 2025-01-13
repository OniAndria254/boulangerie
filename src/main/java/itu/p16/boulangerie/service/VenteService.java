package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.*;
import itu.p16.boulangerie.repository.StockProduitFilleRepository;
import itu.p16.boulangerie.repository.StockProduitMereRepository;
import itu.p16.boulangerie.repository.VenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private StockProduitFilleRepository stockProduitFilleRepository;
    @Autowired
    private StockProduitMereRepository stockProduitMereRepository;
    @Autowired
    private ProduitService produitService;

    @Transactional
    public Vente save(Vente vente) {
        // Vérifier le stock disponible pour le produit
        Integer stockDisponible = stockProduitFilleRepository.getStockDisponible(vente.getProduitByIdProduit().getIdProduit());

        // Vérifier si la quantité de la vente peut être déduite du stock
        if (stockDisponible == null || stockDisponible < vente.getQuantite()) {
            throw new IllegalArgumentException("Stock insuffisant pour le produit : " + vente.getProduitByIdProduit().getNom());
        }

        // Insérer une sortie dans stock_produit_fille
        StockProduitMere stockProduitMere = new StockProduitMere();
        stockProduitMere = stockProduitMereRepository.save(stockProduitMere);

        StockProduitFille sortieStock = new StockProduitFille();
        sortieStock.setEntree(0); // Pas d'entrée
        sortieStock.setSortie(vente.getQuantite()); // Sortie correspondant à la vente
        Produit produit = produitService.getById(vente.getProduitByIdProduit().getIdProduit()).orElseThrow();
        sortieStock.setProduitByIdProduit(produit);
        sortieStock.setStockProduitMereByIdMere(stockProduitMere);
        stockProduitFilleRepository.save(sortieStock);

        // Enregistrer la vente
        return venteRepository.save(vente);
    }


    public List<Vente> getAll() {
        return venteRepository.findAll();
    }

    public Optional<Vente> getById(Integer id) { return venteRepository.findById(id); }

    public List<Vente> findByCriteria(Integer idCategorie, Integer idParfum) {
        return venteRepository.findByCriteria(idCategorie, idParfum);
    }

}
