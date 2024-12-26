package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Production {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_production", nullable = false)
    private Integer idProduction;
    @Basic
    @Column(name = "quantite_produite", nullable = false)
    private Integer quantiteProduite;
    @Basic
    @Column(name = "date_production", nullable = true)
    private Date dateProduction;
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    public Integer getIdProduction() {
        return idProduction;
    }

    public void setIdProduction(Integer idProduction) {
        this.idProduction = idProduction;
    }

    public Integer getQuantiteProduite() {
        return quantiteProduite;
    }

    public void setQuantiteProduite(Integer quantiteProduite) {
        this.quantiteProduite = quantiteProduite;
    }

    public Date getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(Date dateProduction) {
        this.dateProduction = dateProduction;
    }

    public Produit getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(Produit produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
