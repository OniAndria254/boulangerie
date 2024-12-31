package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.StockProduitMere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockProduitMereRepository extends JpaRepository<StockProduitMere, Integer> {
}
