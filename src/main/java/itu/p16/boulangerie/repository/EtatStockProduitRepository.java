package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.EtatStockProduitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EtatStockProduitRepository extends JpaRepository<EtatStockProduitEntity, String> {

    @Query(nativeQuery = true, value = "SELECT produit, stock_disponible " +
            "FROM etat_stock_produit " +
            "ORDER BY produit")
    List<EtatStockProduitEntity> findAllEtatStockProduit();
}
