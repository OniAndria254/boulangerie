package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "parfum", schema = "public", catalog = "boulangerie")
public class Parfum {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_parfum", nullable = false)
    private Integer idParfum;
    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    public Integer getIdParfum() {
        return idParfum;
    }

    public void setIdParfum(Integer idParfum) {
        this.idParfum = idParfum;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
