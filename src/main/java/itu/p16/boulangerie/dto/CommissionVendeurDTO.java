package itu.p16.boulangerie.dto;

import java.lang.Double;
import java.sql.Date;

public class CommissionVendeurDTO {
    private Integer idVendeur;
    private String nomVendeur;
    private String prenomVendeur;
    private Double commissionTotale;
    private Date dateDebut;
    private Date dateFin;

    // Constructeur
    public CommissionVendeurDTO(Integer idVendeur, String nomVendeur, String prenomVendeur, Double commissionTotale, Date dateDebut, Date dateFin) {
        this.idVendeur = idVendeur;
        this.nomVendeur = nomVendeur;
        this.prenomVendeur = prenomVendeur;
        this.commissionTotale = commissionTotale;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters et Setters
    public Integer getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(Integer idVendeur) {
        this.idVendeur = idVendeur;
    }

    public String getNomVendeur() {
        return nomVendeur;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

    public String getPrenomVendeur() {
        return prenomVendeur;
    }

    public void setPrenomVendeur(String prenomVendeur) {
        this.prenomVendeur = prenomVendeur;
    }

    public Double getCommissionTotale() {
        return commissionTotale;
    }

    public void setCommissionTotale(Double commissionTotale) {
        this.commissionTotale = commissionTotale;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}