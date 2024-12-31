package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "stock_produit_mere", schema = "public", catalog = "boulangerie")
public class StockProduitMere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mere", nullable = false)
    private Integer idMere;
    @Basic
    @Column(name = "daty", nullable = true)
    private Date daty;
    @OneToMany(mappedBy = "stockProduitMereByIdMere")
    private List<StockProduitFille> stockProduitFillesByIdMere;

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
        StockProduitMere that = (StockProduitMere) o;
        return Objects.equals(idMere, that.idMere) && Objects.equals(daty, that.daty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMere, daty);
    }

    public List<StockProduitFille> getStockProduitFillesByIdMere() {
        return stockProduitFillesByIdMere;
    }

    public void setStockProduitFillesByIdMere(List<StockProduitFille> stockProduitFillesByIdMere) {
        this.stockProduitFillesByIdMere = stockProduitFillesByIdMere;
    }
}
