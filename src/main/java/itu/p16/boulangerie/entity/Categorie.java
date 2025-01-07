package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categorie", nullable = false)
    private Integer idCategorie;
    @Basic
    @Column(name = "nom", nullable = true, length = 50)
    private String nom;

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
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
        Categorie categorie = (Categorie) o;
        return Objects.equals(idCategorie, categorie.idCategorie) && Objects.equals(nom, categorie.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, nom);
    }
}
