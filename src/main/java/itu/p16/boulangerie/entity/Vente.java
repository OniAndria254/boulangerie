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
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", nullable = false)
    private Client clientByIdClient;

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

    public Client getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(Client clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    public Produit getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(Produit produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
