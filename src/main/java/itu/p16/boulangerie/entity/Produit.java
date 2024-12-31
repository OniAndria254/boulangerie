package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.List;
import java.util.Objects;

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
    private Double prixVente;
    @OneToMany(mappedBy = "produitByIdProduit")
    private List<Production> productionsByIdProduit;
    @OneToMany(mappedBy = "produitByIdProduit")
    private List<Recette> recettesByIdProduit;
    @OneToMany(mappedBy = "produitByIdProduit")
    private List<StockProduitFille> stockProduitFillesByIdProduit;

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

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }
    public List<Production> getProductionsByIdProduit() {
        return productionsByIdProduit;
    }

    public void setProductionsByIdProduit(List<Production> productionsByIdProduit) {
        this.productionsByIdProduit = productionsByIdProduit;
    }

    public List<Recette> getRecettesByIdProduit() {
        return recettesByIdProduit;
    }

    public void setRecettesByIdProduit(List<Recette> recettesByIdProduit) {
        this.recettesByIdProduit = recettesByIdProduit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(idProduit, produit.idProduit) && Objects.equals(nom, produit.nom) && Objects.equals(prixVente, produit.prixVente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduit, nom, prixVente);
    }

    public List<StockProduitFille> getStockProduitFillesByIdProduit() {
        return stockProduitFillesByIdProduit;
    }

    public void setStockProduitFillesByIdProduit(List<StockProduitFille> stockProduitFillesByIdProduit) {
        this.stockProduitFillesByIdProduit = stockProduitFillesByIdProduit;
    }
}
