package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.EtatStockIngredientEntity;
import itu.p16.boulangerie.entity.NatureProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureProduitRepository extends JpaRepository<NatureProduit, Integer> {
}
