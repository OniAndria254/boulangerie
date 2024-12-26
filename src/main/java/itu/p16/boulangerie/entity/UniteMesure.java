package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "unite_mesure", schema = "public", catalog = "boulangerie")
public class UniteMesure {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_unite_mesure", nullable = false)
    private Integer idUniteMesure;
    @Basic
    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    private String description;
    @OneToMany(mappedBy = "uniteMesureByIdUniteMesure")
    private List<Ingredient> ingredientsByIdUniteMesure;

    public Integer getIdUniteMesure() {
        return idUniteMesure;
    }

    public void setIdUniteMesure(Integer idUniteMesure) {
        this.idUniteMesure = idUniteMesure;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Ingredient> getIngredientsByIdUniteMesure() {
        return ingredientsByIdUniteMesure;
    }

    public void setIngredientsByIdUniteMesure(List<Ingredient> ingredientsByIdUniteMesure) {
        this.ingredientsByIdUniteMesure = ingredientsByIdUniteMesure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
