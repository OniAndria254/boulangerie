package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.dto.CommissionVendeurDTO;
import itu.p16.boulangerie.entity.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.List;

public interface CommissionRepository extends JpaRepository<Vendeur, Integer> {

    @Query(value = """
    SELECT
        v.Id_vendeur AS idVendeur,
        v.nom AS nomVendeur,
        v.prenom AS prenomVendeur,
        CAST(SUM(ve.commission) AS DOUBLE PRECISION) AS commissionTotale,
        MIN(ve.date_vente) AS dateDebut,
        MAX(ve.date_vente) AS dateFin
    FROM
        vendeur v
    JOIN
        vente ve ON v.Id_vendeur = ve.Id_vendeur
    WHERE
        ve.date_vente >= COALESCE(:startDate, ve.date_vente)
        AND ve.date_vente <= COALESCE(:endDate, ve.date_vente)
    GROUP BY
        v.Id_vendeur, v.nom, v.prenom
    """, nativeQuery = true)
    List<CommissionVendeurDTO> findCommissionsVendeursBetweenDates(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );
}