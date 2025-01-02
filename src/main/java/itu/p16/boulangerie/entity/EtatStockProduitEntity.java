package itu.p16.boulangerie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etat_stock_produit") // Nom de la vue
@SqlResultSetMapping(
        name = "EtatStockProduitMapping",
        entities = {
                @EntityResult(
                        entityClass = EtatStockProduitEntity.class,
                        fields = {
                                @FieldResult(name = "produit", column = "produit"),
                                @FieldResult(name = "stockDisponible", column = "stock_disponible")
                        }
                )
        }
)
public class EtatStockProduitEntity {
    @Id
    private String produit;
    private Double stockDisponible;

    // Getters et Setters
    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Double getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(Double stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
}
