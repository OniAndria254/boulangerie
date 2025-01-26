package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.CommissionConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CommissionConfigRepository extends JpaRepository<CommissionConfig, Integer> {

    // Trouver la configuration de commission en vigueur à une date donnée
    Optional<CommissionConfig> findFirstByDateConfigLessThanEqualOrderByDateConfigDesc(Date dateConfig);
}