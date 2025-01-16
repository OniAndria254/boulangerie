package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Client;
import itu.p16.boulangerie.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface VenteRepository extends JpaRepository<Vente, Integer> {
    @Query(value = """
        SELECT v.*\s
        FROM vente v
        JOIN produit p ON v.id_produit = p.id_produit
        WHERE (:idCategorie IS NULL OR p.id_categorie = :idCategorie)
          AND (:idParfum IS NULL OR p.id_parfum = :idParfum)
        """,
            nativeQuery = true)
    List<Vente> findByCriteria(@Param("idCategorie") Integer idCategorie,
                               @Param("idParfum") Integer idParfum);


    @Query(value = """
        SELECT c.Id_client, c.nom, c.prenom, p.nom AS produit, v.quantite, v.date_vente
        FROM client c
        JOIN vente v ON c.Id_client = v.Id_client
        JOIN produit p ON v.Id_produit = p.Id_produit
        WHERE (:dateAchat IS NULL OR v.date_vente = :dateAchat)
        """, nativeQuery = true)
    List<Object[]> findClientsWithAchatsAndDetails(@Param("dateAchat") Date dateAchat);
}
