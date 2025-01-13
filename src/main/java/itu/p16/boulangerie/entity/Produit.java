package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.List;

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
    @JoinColumn(name = "id_parfum", referencedColumnName = "id_parfum", nullable = false)
    private Parfum parfumByIdParfum;

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

    public Parfum getParfumByIdParfum() {
        return parfumByIdParfum;
    }

    public void setParfumByIdParfum(Parfum parfumByIdParfum) {
        this.parfumByIdParfum = parfumByIdParfum;
    }

    public List<StockProduitFille> getStockProduitFillesByIdProduit() {
        return stockProduitFillesByIdProduit;
    }

    public void setStockProduitFillesByIdProduit(List<StockProduitFille> stockProduitFillesByIdProduit) {
        this.stockProduitFillesByIdProduit = stockProduitFillesByIdProduit;
    }

    public List<Vente> getVentesByIdProduit() {
        return ventesByIdProduit;
    }

    public void setVentesByIdProduit(List<Vente> ventesByIdProduit) {
        this.ventesByIdProduit = ventesByIdProduit;
    }
}
