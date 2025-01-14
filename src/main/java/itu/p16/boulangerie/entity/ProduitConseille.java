package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.Month;
import java.util.Objects;

@Entity
@Table(name = "produit_conseille", schema = "public", catalog = "boulangerie")
public class ProduitConseille {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produit_conseille", nullable = false)
    private Integer idProduitConseille;
    @Basic
    @Column(name = "daty", nullable = false)
    private Date daty;
    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", nullable = false)
    private Produit produitByIdProduit;

    public Integer getIdProduitConseille() {
        return idProduitConseille;
    }

    public void setIdProduitConseille(Integer idProduitConseille) {
        this.idProduitConseille = idProduitConseille;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public Produit getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(Produit produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }

    // Méthode pour obtenir le mois
    public int getMoisInt() {
        if (daty == null) {
            throw new IllegalStateException("La date (daty) ne peut pas être nulle.");
        }
        // Convertir java.sql.Date en java.util.Date pour utiliser les méthodes de LocalDate
        return daty.toLocalDate().getMonthValue();
    }

    // Méthode pour obtenir l'année
    public int getAnnee() {
        if (daty == null) {
            throw new IllegalStateException("La date (daty) ne peut pas être nulle.");
        }
        // Convertir java.sql.Date en java.util.Date pour utiliser les méthodes de LocalDate
        return daty.toLocalDate().getYear();
    }

    public String getMois() {
        if (daty == null) {
            throw new IllegalStateException("La date (daty) ne peut pas être nulle.");
        }

        // Tableau des mois en français
        String[] moisFrancais = {
                "Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
                "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
        };

        // Convertir java.sql.Date en java.time.LocalDate
        java.time.LocalDate localDate = daty.toLocalDate();

        // Récupérer le numéro du mois (1 pour janvier, 2 pour février, etc.)
        int mois = localDate.getMonthValue();

        // Retourner le mois en français
        return moisFrancais[mois - 1]; // -1 car les indices du tableau commencent à 0
    }
}
