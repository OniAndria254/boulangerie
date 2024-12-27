package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Integer> {
}
