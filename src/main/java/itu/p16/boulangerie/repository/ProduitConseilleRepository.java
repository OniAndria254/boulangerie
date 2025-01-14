package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.ProduitConseille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitConseilleRepository extends JpaRepository<ProduitConseille, Integer> {
    @Query(value = """
        SELECT *\s
        FROM produit_conseille pc\s
        WHERE (:mois IS NULL OR EXTRACT(MONTH FROM pc.daty) = :mois)
          AND (:annee IS NULL OR EXTRACT(YEAR FROM pc.daty) = :annee)
        ORDER BY pc.daty ASC
        """, nativeQuery = true)
    List<ProduitConseille> findByCriteria(
            @Param("mois") Integer mois,
            @Param("annee") Integer annee
    );

    @Query(value = """
        SELECT CASE WHEN COUNT(pc) > 0 THEN TRUE ELSE FALSE END
        FROM produit_conseille pc
        WHERE pc.id_produit = :idProduit
          AND EXTRACT(MONTH FROM pc.daty) = :mois
          AND EXTRACT(YEAR FROM pc.daty) = :annee
        """, nativeQuery = true)
    boolean existsByProduitAndMoisAndAnnee(
            @Param("idProduit") Integer idProduit,
            @Param("mois") int mois,
            @Param("annee") int annee
    );
}
