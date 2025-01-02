package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Recette;
import itu.p16.boulangerie.entity.StockIngredientFille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockIngredientFilleRepository extends JpaRepository<StockIngredientFille, Integer> {
    @Query("SELECT COALESCE(SUM(s.entree) - SUM(s.sortie), 0) FROM StockIngredientFille s WHERE s.ingredientByIdIngredient.idIngredient = :idIngredient")
    Double calculateStockForIngredient(@Param("idIngredient") Integer idIngredient);
}
