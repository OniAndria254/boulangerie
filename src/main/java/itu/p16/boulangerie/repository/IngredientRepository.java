package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.EtatStockIngredientEntity;
import itu.p16.boulangerie.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientRepository  extends JpaRepository<Ingredient, Integer> {
    @Query(value = "SELECT i.nom AS ingredient, um.libelle AS uniteMesure, " +
            "COALESCE(SUM(sif.entree), 0) - COALESCE(SUM(sif.sortie), 0) AS stockDisponible " +
            "FROM ingredient i " +
            "LEFT JOIN stock_ingredient_fille sif ON i.Id_ingredient = sif.Id_ingredient " +
            "LEFT JOIN unite_mesure um ON i.Id_unite_mesure = um.Id_unite_mesure " +
            "GROUP BY i.nom, um.libelle ORDER BY i.nom", nativeQuery = true)
    List<EtatStockIngredientEntity> findEtatStockIngredient();
}
