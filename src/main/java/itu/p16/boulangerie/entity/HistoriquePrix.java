package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.lang.Double;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "historique_prix", schema = "public", catalog = "boulangerie")
public class HistoriquePrix {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_historique_prix", nullable = false)
    private Integer idHistoriquePrix;
    @Basic
    @Column(name = "daty", nullable = true)
    private Date daty;
    @Basic
    @Column(name = "prix", nullable = true, precision = 2)
    private Double prix;
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit")
    private Produit produitByIdProduit;

    public Integer getIdHistoriquePrix() {
        return idHistoriquePrix;
    }

    public void setIdHistoriquePrix(Integer idHistoriquePrix) {
        this.idHistoriquePrix = idHistoriquePrix;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Produit getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(Produit produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }

}
