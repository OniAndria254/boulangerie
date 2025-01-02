package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.StockIngredientFille;
import itu.p16.boulangerie.entity.StockIngredientMere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockIngredientMereRepository extends JpaRepository<StockIngredientMere, Integer> {
}
