package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Categorie;
import itu.p16.boulangerie.entity.EtatStockIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
