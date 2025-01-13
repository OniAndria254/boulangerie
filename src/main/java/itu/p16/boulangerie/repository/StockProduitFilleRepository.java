package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.StockProduitFille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockProduitFilleRepository extends JpaRepository<StockProduitFille, Integer> {
    @Query(value = """
        SELECT\s
            COALESCE(SUM(entree), 0) - COALESCE(SUM(sortie), 0) AS stock_disponible
        FROM\s
            stock_produit_fille
        WHERE\s
            Id_produit = :idProduit
        """, nativeQuery = true)
    Integer getStockDisponible(@Param("idProduit") Integer idProduit);
}
