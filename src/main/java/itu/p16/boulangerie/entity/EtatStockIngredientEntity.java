package itu.p16.boulangerie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etat_stock_ingredient") // Nom de la vue
@SqlResultSetMapping(
        name = "EtatStockIngredientMapping",
        entities = {
                @EntityResult(
                        entityClass = EtatStockIngredientEntity.class,
                        fields = {
                                @FieldResult(name = "ingredient", column = "ingredient"),
                                @FieldResult(name = "uniteMesure", column = "unite_mesure"),
                                @FieldResult(name = "stockDisponible", column = "stock_disponible")
                        }
                )
        }
)
public class EtatStockIngredientEntity {
    @Id
    private String ingredient;
    private String uniteMesure;
    private Double stockDisponible;

    // Getters et Setters
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getUniteMesure() {
        return uniteMesure;
    }

    public void setUniteMesure(String uniteMesure) {
        this.uniteMesure = uniteMesure;
    }

    public Double getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(Double stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
}
