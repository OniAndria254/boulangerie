package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "stock_produit_fille", schema = "public", catalog = "boulangerie")
public class StockProduitFille {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fille", nullable = false)
    private Integer idFille;
    @Basic
    @Column(name = "entree", nullable = true)
    private Integer entree;
    @Basic
    @Column(name = "sortie", nullable = true)
    private Integer sortie;
    @ManyToOne
    @JoinColumn(name = "id_mere", referencedColumnName = "id_mere", nullable = false)
    private StockProduitMere stockProduitMereByIdMere;
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    public Integer getIdFille() {
        return idFille;
    }

    public void setIdFille(Integer idFille) {
        this.idFille = idFille;
    }

    public Integer getEntree() {
        return entree;
    }

    public void setEntree(Integer entree) {
        this.entree = entree;
    }

    public Integer getSortie() {
        return sortie;
    }

    public void setSortie(Integer sortie) {
        this.sortie = sortie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockProduitFille that = (StockProduitFille) o;
        return Objects.equals(idFille, that.idFille) && Objects.equals(entree, that.entree) && Objects.equals(sortie, that.sortie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFille, entree, sortie);
    }

    public StockProduitMere getStockProduitMereByIdMere() {
        return stockProduitMereByIdMere;
    }

    public void setStockProduitMereByIdMere(StockProduitMere stockProduitMereByIdMere) {
        this.stockProduitMereByIdMere = stockProduitMereByIdMere;
    }

    public Produit getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(Produit produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
