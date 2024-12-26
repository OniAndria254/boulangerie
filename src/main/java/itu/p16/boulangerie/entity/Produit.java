package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produit", nullable = false)
    private Integer idProduit;
    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Basic
    @Column(name = "prix_vente", nullable = false, precision = 2)
    private BigDecimal prixVente;
    @OneToMany(mappedBy = "produitByIdProduit")
    private Collection<Production> productionsByIdProduit;
    @OneToMany(mappedBy = "produitByIdProduit")
    private Collection<Recette> recettesByIdProduit;

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (idProduit != null ? !idProduit.equals(produit.idProduit) : produit.idProduit != null) return false;
        if (nom != null ? !nom.equals(produit.nom) : produit.nom != null) return false;
        if (prixVente != null ? !prixVente.equals(produit.prixVente) : produit.prixVente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduit != null ? idProduit.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prixVente != null ? prixVente.hashCode() : 0);
        return result;
    }

    public Collection<Production> getProductionsByIdProduit() {
        return productionsByIdProduit;
    }

    public void setProductionsByIdProduit(Collection<Production> productionsByIdProduit) {
        this.productionsByIdProduit = productionsByIdProduit;
    }

    public Collection<Recette> getRecettesByIdProduit() {
        return recettesByIdProduit;
    }

    public void setRecettesByIdProduit(Collection<Recette> recettesByIdProduit) {
        this.recettesByIdProduit = recettesByIdProduit;
    }
}
