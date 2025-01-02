package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "stock_ingredient_mere", schema = "public", catalog = "boulangerie")
public class StockIngredientMere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mere", nullable = false)
    private Integer idMere;
    @Basic
    @Column(name = "daty", nullable = true)
    private Date daty;
    @OneToMany(mappedBy = "stockIngredientMereByIdMere")
    private List<StockIngredientFille> stockIngredientFillesByIdMere;

    public Integer getIdMere() {
        return idMere;
    }

    public void setIdMere(Integer idMere) {
        this.idMere = idMere;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public List<StockIngredientFille> getMvtStockFillesByIdMere() {
        return stockIngredientFillesByIdMere;
    }

    public void setMvtStockFillesByIdMere(List<StockIngredientFille> stockIngredientFillesByIdMere) {
        this.stockIngredientFillesByIdMere = stockIngredientFillesByIdMere;
    }
}
