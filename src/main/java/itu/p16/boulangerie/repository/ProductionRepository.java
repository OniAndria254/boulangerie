package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.Production;
import itu.p16.boulangerie.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductionRepository extends JpaRepository<Production, Integer> {
    @Query(value = """
    SELECT DISTINCT p.*\s
    FROM production p
    JOIN produit pr ON p.Id_produit = pr.Id_produit
    LEFT JOIN recette r ON pr.Id_produit = r.Id_produit
    WHERE (:idIngredient IS NULL OR r.Id_ingredient = :idIngredient)
      AND (:idCategorie IS NULL OR pr.Id_categorie = :idCategorie)
    """, nativeQuery = true)
    List<Production> findByCriteria(@Param("idIngredient") Integer idIngredient,
                                    @Param("idCategorie") Integer idCategorie);

}
