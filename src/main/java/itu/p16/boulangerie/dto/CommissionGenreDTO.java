package itu.p16.boulangerie.dto;

import java.sql.Date;

public class CommissionGenreDTO {
    private Integer idGenre;
    private String nomGenre;
    private Double commissionTotale;
    private Date dateDebut;
    private Date dateFin;

    // Constructeur
    public CommissionGenreDTO(Integer idGenre, String nomGenre, Double commissionTotale, Date dateDebut, Date dateFin) {
        this.idGenre = idGenre;
        this.nomGenre = nomGenre;
        this.commissionTotale = commissionTotale;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters et Setters
    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
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