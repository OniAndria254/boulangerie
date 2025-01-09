package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.NatureProduit;
import itu.p16.boulangerie.entity.Production;
import itu.p16.boulangerie.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenteRepository extends JpaRepository<Vente, Integer> {
    @Query(value = """
        SELECT v.*\s
        FROM vente v
        JOIN produit p ON v.id_produit = p.id_produit
        WHERE (:idCategorie IS NULL OR p.id_categorie = :idCategorie)
          AND (:idNatureProduit IS NULL OR p.id_nature_produit = :idNatureProduit)
        """,
            nativeQuery = true)
    List<Vente> findByCriteria(@Param("idCategorie") Integer idCategorie,
                               @Param("idNatureProduit") Integer idNatureProduit);
}
