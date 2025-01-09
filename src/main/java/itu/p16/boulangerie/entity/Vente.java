package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Vente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_vente", nullable = false)
    private Integer idVente;
    @Basic
    @Column(name = "quantite", nullable = false)
    private Integer quantite;
    @Basic
    @Column(name = "date_vente", nullable = true)
    private Date dateVente;
    @Basic
    @Column(name = "id_produit", nullable = false)
    private Integer idProduit;
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    public Integer getIdVente() {
        return idVente;
    }

    public void setIdVente(Integer idVente) {
        this.idVente = idVente;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
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
        Vente vente = (Vente) o;
        return Objects.equals(idVente, vente.idVente) && Objects.equals(quantite, vente.quantite) && Objects.equals(dateVente, vente.dateVente) && Objects.equals(idProduit, vente.idProduit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVente, quantite, dateVente, idProduit);
    }

    public Produit getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(Produit produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
