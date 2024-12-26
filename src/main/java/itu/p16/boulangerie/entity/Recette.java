package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@IdClass(RecettePK.class)
public class Recette {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ingredient", nullable = false)
    private Integer idIngredient;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produit", nullable = false)
    private Integer idProduit;
    @Basic
    @Column(name = "quantite", nullable = false, precision = 2)
    private BigDecimal quantite;
    @ManyToOne
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient", nullable = false)
    private Ingredient ingredientByIdIngredient;
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    public Integer getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recette recette = (Recette) o;

        if (idIngredient != null ? !idIngredient.equals(recette.idIngredient) : recette.idIngredient != null)
            return false;
        if (idProduit != null ? !idProduit.equals(recette.idProduit) : recette.idProduit != null) return false;
        if (quantite != null ? !quantite.equals(recette.quantite) : recette.quantite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idIngredient != null ? idIngredient.hashCode() : 0;
        result = 31 * result + (idProduit != null ? idProduit.hashCode() : 0);
        result = 31 * result + (quantite != null ? quantite.hashCode() : 0);
        return result;
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
