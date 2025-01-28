package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.HistoriquePrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoriquePrixRepository extends JpaRepository<HistoriquePrix, Integer> {

    // Trouver tous les historiques de prix pour un produit donné
    List<HistoriquePrix> findByProduitByIdProduit_IdProduit(Integer idProduit);

    // Trouver l'historique de prix en vigueur à une date donnée pour un produit donné
    HistoriquePrix findFirstByProduitByIdProduit_IdProduitAndDatyLessThanEqualOrderByDatyDesc(Integer idProduit, Date date);

    // Trouver tous les historiques de prix triés par date
    List<HistoriquePrix> findAllByOrderByDatyDesc();
}
