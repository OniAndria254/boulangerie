package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "nature_produit", schema = "public", catalog = "boulangerie")
public class NatureProduit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nature_produit", nullable = false)
    private Integer idNatureProduit;
    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    public Integer getIdNatureProduit() {
        return idNatureProduit;
    }

    public void setIdNatureProduit(Integer idNatureProduit) {
        this.idNatureProduit = idNatureProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatureProduit that = (NatureProduit) o;
        return Objects.equals(idNatureProduit, that.idNatureProduit) && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNatureProduit, nom);
    }
}
