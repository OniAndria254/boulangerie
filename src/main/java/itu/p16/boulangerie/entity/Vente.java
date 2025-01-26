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
    @Column(name = "commission", nullable = false)
    private Double commission;
    @Basic
    @Column(name = "date_vente", nullable = true)
    private Date dateVente;
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", nullable = false)
    private Client clientByIdClient;

    @ManyToOne
    @JoinColumn(name = "id_vendeur", referencedColumnName = "id_vendeur", nullable = false)
    private Vendeur vendeurByIdVendeur;

    @ManyToOne
    @JoinColumn(name = "id_commission_config", referencedColumnName = "id_commission_config")
    private CommissionConfig commissionConfigByIdCommissionConfig;

    public CommissionConfig getCommissionConfigByIdCommissionConfig() {
        return commissionConfigByIdCommissionConfig;
    }

    public void setCommissionConfigByIdCommissionConfig(CommissionConfig commissionConfigByIdCommissionConfig) {
        this.commissionConfigByIdCommissionConfig = commissionConfigByIdCommissionConfig;
    }

    public Vendeur getVendeurByIdVendeur() {
        return vendeurByIdVendeur;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public void setVendeurByIdVendeur(Vendeur vendeurByIdVendeur) {
        this.vendeurByIdVendeur = vendeurByIdVendeur;
    }

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
