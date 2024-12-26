package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository  extends JpaRepository<Produit, Integer> {
}
