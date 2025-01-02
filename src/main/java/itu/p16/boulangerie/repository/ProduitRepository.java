package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.EtatStockProduitEntity;
import itu.p16.boulangerie.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository  extends JpaRepository<Produit, Integer> {
    @Query(value = "SELECT p.nom AS produit, " +
            "COALESCE(SUM(spf.entree), 0) - COALESCE(SUM(spf.sortie), 0) AS stockDisponible " +
            "FROM produit p " +
            "LEFT JOIN stock_produit_fille spf ON p.Id_produit = spf.Id_produit " +
            "GROUP BY p.nom ORDER BY p.nom", nativeQuery = true)
    List<EtatStockProduitEntity> findEtatStockProduit();
}
