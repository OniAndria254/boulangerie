package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.EtatStockIngredientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EtatStockIngredientRepository extends JpaRepository<EtatStockIngredientEntity, String> {

    @Query(nativeQuery = true, value = "SELECT ingredient, unite_mesure, stock_disponible " +
            "FROM etat_stock_ingredient " +
            "ORDER BY ingredient")
    List<EtatStockIngredientEntity> findAllEtatStockIngredient();

}
