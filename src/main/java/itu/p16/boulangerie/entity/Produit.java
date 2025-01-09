package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
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
    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie", nullable = false)
    private Categorie categorieByIdCategorie;
    @ManyToOne
    @JoinColumn(name = "id_nature_produit", referencedColumnName = "id_nature_produit", nullable = false)
    private NatureProduit natureProduitByIdNatureProduit;
    @Basic
    @Column(name = "id_nature_produit", nullable = false)
    private Integer idNatureProduit;
    @Basic
    @Column(name = "id_categorie", nullable = false)
    private Integer idCategorie;
    @OneToMany(mappedBy = "produitByIdProduit")
    private List<Vente> ventesByIdProduit;

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

    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }

    public NatureProduit getNatureProduitByIdNatureProduit() {
        return natureProduitByIdNatureProduit;
    }

    public void setNatureProduitByIdNatureProduit(NatureProduit natureProduitByIdNatureProduit) {
        this.natureProduitByIdNatureProduit = natureProduitByIdNatureProduit;
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

    public Integer getIdNatureProduit() {
        return idNatureProduit;
    }

    public void setIdNatureProduit(Integer idNatureProduit) {
        this.idNatureProduit = idNatureProduit;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public List<Vente> getVentesByIdProduit() {
        return ventesByIdProduit;
    }

    public void setVentesByIdProduit(Collection<Vente> ventesByIdProduit) {
        this.ventesByIdProduit = ventesByIdProduit;
    }
}
