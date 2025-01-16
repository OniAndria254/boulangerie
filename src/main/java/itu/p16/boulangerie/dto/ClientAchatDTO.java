package itu.p16.boulangerie.dto;

import java.sql.Date;
import java.time.LocalDate;

public class ClientAchatDTO {
    private Integer idClient;
    private String nom;
    private String prenom;
    private String produit;
    private Integer quantite;
    private LocalDate dateVente;

    // Constructeur
    public ClientAchatDTO(Integer idClient, String nom, String prenom, String produit, Integer quantite, LocalDate dateVente) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.produit = produit;
        this.quantite = quantite;
        this.dateVente = dateVente;
    }

    // Getters et Setters
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }
}