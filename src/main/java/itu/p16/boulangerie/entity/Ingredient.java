package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ingredient", nullable = false)
    private Integer idIngredient;
    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @ManyToOne
    @JoinColumn(name = "id_unite_mesure", referencedColumnName = "id_unite_mesure", nullable = false)
    private UniteMesure uniteMesureByIdUniteMesure;
    @OneToMany(mappedBy = "ingredientByIdIngredient")
    private List<StockIngredientFille> stockIngredientFillesByIdIngredient;
    @OneToMany(mappedBy = "ingredientByIdIngredient")
    private List<Recette> recettesByIdIngredient;

    public Integer getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public UniteMesure getUniteMesureByIdUniteMesure() {
        return uniteMesureByIdUniteMesure;
    }

    public void setUniteMesureByIdUniteMesure(UniteMesure uniteMesureByIdUniteMesure) {
        this.uniteMesureByIdUniteMesure = uniteMesureByIdUniteMesure;
    }

    public List<StockIngredientFille> getMvtStockFillesByIdIngredient() {
        return stockIngredientFillesByIdIngredient;
    }

    public void setMvtStockFillesByIdIngredient(List<StockIngredientFille> stockIngredientFillesByIdIngredient) {
        this.stockIngredientFillesByIdIngredient = stockIngredientFillesByIdIngredient;
    }

    public List<Recette> getRecettesByIdIngredient() {
        return recettesByIdIngredient;
    }

    public void setRecettesByIdIngredient(List<Recette> recettesByIdIngredient) {
        this.recettesByIdIngredient = recettesByIdIngredient;
    }
}
