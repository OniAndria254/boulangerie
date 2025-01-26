package itu.p16.boulangerie.entity;

import jakarta.persistence.*;

import java.lang.Double;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "commission_config", schema = "public", catalog = "boulangerie")
public class CommissionConfig {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_commission_config", nullable = false)
    private Integer idCommissionConfig;
    @Basic
    @Column(name = "taux_commission", nullable = false, precision = 2)
    private Double tauxCommission;
    @Basic
    @Column(name = "montant_min_commission", nullable = false, precision = 2)
    private Double montantMinCommission;
    @Basic
    @Column(name = "date_config", nullable = false)
    private Date dateConfig;

    public Integer getIdCommissionConfig() {
        return idCommissionConfig;
    }

    public void setIdCommissionConfig(Integer idCommissionConfig) {
        this.idCommissionConfig = idCommissionConfig;
    }

    public Double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(Double tauxCommission) {
        this.tauxCommission = tauxCommission;
    }

    public Double getMontantMinCommission() {
        return montantMinCommission;
    }

    public void setMontantMinCommission(Double montantMinCommission) {
        this.montantMinCommission = montantMinCommission;
    }

    public Date getDateConfig() {
        return dateConfig;
    }

    public void setDateConfig(Date dateConfig) {
        this.dateConfig = dateConfig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommissionConfig that = (CommissionConfig) o;
        return Objects.equals(idCommissionConfig, that.idCommissionConfig) && Objects.equals(tauxCommission, that.tauxCommission) && Objects.equals(montantMinCommission, that.montantMinCommission) && Objects.equals(dateConfig, that.dateConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommissionConfig, tauxCommission, montantMinCommission, dateConfig);
    }
}
