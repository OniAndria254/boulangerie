package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendeurRepository extends JpaRepository<Vendeur, Integer> {
}