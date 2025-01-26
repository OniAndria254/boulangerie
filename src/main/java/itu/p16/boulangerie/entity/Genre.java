package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_genre", nullable = false)
    private Integer idGenre;
    @Basic
    @Column(name = "nom", nullable = true, length = 50)
    private String nom;

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
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
        Genre genre = (Genre) o;
        return Objects.equals(idGenre, genre.idGenre) && Objects.equals(nom, genre.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenre, nom);
    }
}
