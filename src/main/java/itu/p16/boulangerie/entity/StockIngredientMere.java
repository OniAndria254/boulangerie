package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

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
    @OneToMany(mappedBy = "mvtStockMereByIdMere")
    private Collection<StockIngredientFille> stockIngredientFillesByIdMere;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockIngredientMere that = (StockIngredientMere) o;

        if (idMere != null ? !idMere.equals(that.idMere) : that.idMere != null) return false;
        if (daty != null ? !daty.equals(that.daty) : that.daty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMere != null ? idMere.hashCode() : 0;
        result = 31 * result + (daty != null ? daty.hashCode() : 0);
        return result;
    }

    public Collection<StockIngredientFille> getMvtStockFillesByIdMere() {
        return stockIngredientFillesByIdMere;
    }

    public void setMvtStockFillesByIdMere(Collection<StockIngredientFille> stockIngredientFillesByIdMere) {
        this.stockIngredientFillesByIdMere = stockIngredientFillesByIdMere;
    }
}
