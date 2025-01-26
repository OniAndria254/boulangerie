package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.CommissionConfig;
import itu.p16.boulangerie.repository.CommissionConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CommissionConfigService {

    @Autowired
    private CommissionConfigRepository commissionConfigRepository;

    // Ajouter une nouvelle configuration de commission
    public CommissionConfig addCommissionConfig(CommissionConfig commissionConfig) {
        return commissionConfigRepository.save(commissionConfig);
    }

    // Récupérer la configuration de commission en vigueur à une date donnée
    public Optional<CommissionConfig> getCommissionConfigByDate(Date date) {
        return commissionConfigRepository.findFirstByDateConfigLessThanEqualOrderByDateConfigDesc(date);
    }

    // Mettre à jour une configuration de commission existante
    public CommissionConfig updateCommissionConfig(Integer id, CommissionConfig updatedConfig) {
        return commissionConfigRepository.findById(id)
                .map(config -> {
                    config.setTauxCommission(updatedConfig.getTauxCommission());
                    config.setMontantMinCommission(updatedConfig.getMontantMinCommission());
                    config.setDateConfig(updatedConfig.getDateConfig());
                    return commissionConfigRepository.save(config);
                })
                .orElseThrow(() -> new RuntimeException("Configuration de commission non trouvée"));
    }

    // Supprimer une configuration de commission
    public void deleteCommissionConfig(Integer id) {
        commissionConfigRepository.deleteById(id);
    }
}