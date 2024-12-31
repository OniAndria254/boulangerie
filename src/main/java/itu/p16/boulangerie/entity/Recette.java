package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity

public class Recette {
    @EmbeddedId
    private RecettePK id;

    @Basic
    @Column(name = "quantite", nullable = false, precision = 2)
    private Double quantite;

    @ManyToOne
    @MapsId("idIngredient") // Correspond au champ idIngredient dans RecettePK
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient", nullable = false)
    private Ingredient ingredientByIdIngredient;

    @ManyToOne
    @MapsId("idProduit") // Correspond au champ idProduit dans RecettePK
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    public RecettePK getId() {
        return id;
    }

    public void setId(RecettePK id) {
        this.id = id;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Ingredient getIngredientByIdIngredient() {
        return ingredientByIdIngredient;
    }

    public void setIngredientByIdIngredient(Ingredient ingredientByIdIngredient) {
        this.ingredientByIdIngredient = ingredientByIdIngredient;
    }

    public Produit getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(Produit produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
