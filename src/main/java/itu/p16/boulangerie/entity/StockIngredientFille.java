package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stock_ingredient_fille", schema = "public", catalog = "boulangerie")
public class StockIngredientFille {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fille", nullable = false)
    private Integer idFille;

    @Basic
    @Column(name = "entree", nullable = true)
    private Double entree;
    @Basic
    @Column(name = "sortie", nullable = true)
    private Double sortie;

    @ManyToOne
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient", nullable = false)
    private Ingredient ingredientByIdIngredient;
    @ManyToOne
    @JoinColumn(name = "id_mere", referencedColumnName = "id_mere", nullable = false)
    private StockIngredientMere stockIngredientMereByIdMere;

    public Integer getIdFille() {
        return idFille;
    }

    public void setIdFille(Integer idFille) {
        this.idFille = idFille;
    }

    public Ingredient getIngredientByIdIngredient() {
        return ingredientByIdIngredient;
    }

    public void setIngredientByIdIngredient(Ingredient ingredientByIdIngredient) {
        this.ingredientByIdIngredient = ingredientByIdIngredient;
    }

    public StockIngredientMere getStockIngredientMereByIdMere() {
        return stockIngredientMereByIdMere;
    }

    public void setStockIngredientMereByIdMere(StockIngredientMere stockMereByIdIngredientMere) {
        this.stockIngredientMereByIdMere = stockMereByIdIngredientMere;
    }

    public Double getEntree() {
        return entree;
    }

    public void setEntree(Double entree) {
        this.entree = entree;
    }

    public Double getSortie() {
        return sortie;
    }

    public void setSortie(Double sortie) {
        this.sortie = sortie;
    }
}
