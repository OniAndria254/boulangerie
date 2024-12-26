package itu.p16.boulangerie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class RecettePK implements Serializable {
    @Column(name = "id_ingredient", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngredient;
    @Column(name = "id_produit", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecettePK recettePK = (RecettePK) o;

        if (idIngredient != null ? !idIngredient.equals(recettePK.idIngredient) : recettePK.idIngredient != null)
            return false;
        if (idProduit != null ? !idProduit.equals(recettePK.idProduit) : recettePK.idProduit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idIngredient != null ? idIngredient.hashCode() : 0;
        result = 31 * result + (idProduit != null ? idProduit.hashCode() : 0);
        return result;
    }
}
