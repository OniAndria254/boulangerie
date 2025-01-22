package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Vendeur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_vendeur", nullable = false)
    private Integer idVendeur;
    @Basic
    @Column(name = "nom", nullable = true, length = 50)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = true, length = 50)
    private String prenom;
    @Basic
    @Column(name = "salaire", nullable = true, precision = 2)
    private BigDecimal salaire;

    public Integer getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(Integer idVendeur) {
        this.idVendeur = idVendeur;
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

    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire(BigDecimal salaire) {
        this.salaire = salaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendeur vendeur = (Vendeur) o;
        return Objects.equals(idVendeur, vendeur.idVendeur) && Objects.equals(nom, vendeur.nom) && Objects.equals(prenom, vendeur.prenom) && Objects.equals(salaire, vendeur.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVendeur, nom, prenom, salaire);
    }
}
