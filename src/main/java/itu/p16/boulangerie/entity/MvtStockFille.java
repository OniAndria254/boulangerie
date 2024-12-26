package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mvt_stock_fille", schema = "public", catalog = "boulangerie")
public class MvtStockFille {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fille", nullable = false)
    private Integer idFille;

    @ManyToOne
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient", nullable = false)
    private Ingredient ingredientByIdIngredient;
    @ManyToOne
    @JoinColumn(name = "id_mere", referencedColumnName = "id_mere", nullable = false)
    private MvtStockMere mvtStockMereByIdMere;

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

    public MvtStockMere getMvtStockMereByIdMere() {
        return mvtStockMereByIdMere;
    }

    public void setMvtStockMereByIdMere(MvtStockMere mvtStockMereByIdMere) {
        this.mvtStockMereByIdMere = mvtStockMereByIdMere;
    }
}
