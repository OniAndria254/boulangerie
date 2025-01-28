package itu.p16.boulangerie.service;
import itu.p16.boulangerie.entity.HistoriquePrix;
import itu.p16.boulangerie.repository.HistoriquePrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriquePrixService {

    @Autowired
    private HistoriquePrixRepository historiquePrixRepository;

    // Ajouter un nouvel historique de prix
    public HistoriquePrix addHistoriquePrix(HistoriquePrix historiquePrix) {
        return historiquePrixRepository.save(historiquePrix);
    }

    // Récupérer tous les historiques de prix pour un produit donné
    public List<HistoriquePrix> getHistoriquePrixByProduit(Integer idProduit) {
        return historiquePrixRepository.findByProduitByIdProduit_IdProduit(idProduit);
    }

    // Récupérer l'historique de prix en vigueur à une date donnée pour un produit donné
    public Optional<HistoriquePrix> getPrixByDateAndProduit(Integer idProduit, Date date) {
        return Optional.ofNullable(historiquePrixRepository.findFirstByProduitByIdProduit_IdProduitAndDatyLessThanEqualOrderByDatyDesc(idProduit, date));
    }

    // Récupérer tous les historiques de prix triés par date
    public List<HistoriquePrix> getAllHistoriquePrix() {
        return historiquePrixRepository.findAllByOrderByDatyDesc();
    }

    // Mettre à jour un historique de prix existant
    public HistoriquePrix updateHistoriquePrix(Integer id, HistoriquePrix updatedHistoriquePrix) {
        return historiquePrixRepository.findById(id)
                .map(historiquePrix -> {
                    historiquePrix.setDaty(updatedHistoriquePrix.getDaty());
                    historiquePrix.setPrix(updatedHistoriquePrix.getPrix());
                    historiquePrix.setProduitByIdProduit(updatedHistoriquePrix.getProduitByIdProduit());
                    return historiquePrixRepository.save(historiquePrix);
                })
                .orElseThrow(() -> new RuntimeException("Historique de prix non trouvé"));
    }

    // Supprimer un historique de prix
    public void deleteHistoriquePrix(Integer id) {
        historiquePrixRepository.deleteById(id);
    }
}