package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Produit;
import itu.p16.boulangerie.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {
}