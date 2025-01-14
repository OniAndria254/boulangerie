package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.ProduitConseille;
import itu.p16.boulangerie.repository.ProduitConseilleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitConseilleService {
    @Autowired
    private ProduitConseilleRepository produitConseilleRepository;

    @Transactional
    public ProduitConseille save(ProduitConseille produitConseille) {
        // Extraire le mois et l'année de la date
        LocalDate date = produitConseille.getDaty().toLocalDate();
        int mois = date.getMonthValue();
        int annee = date.getYear();

        // Vérifier si un ProduitConseille existe déjà pour le même produit, mois et année
        boolean existeDeja = produitConseilleRepository.existsByProduitAndMoisAndAnnee(
                produitConseille.getProduitByIdProduit().getIdProduit(),
                mois,
                annee
        );

        if (existeDeja) {
            throw new IllegalStateException("Ce produit est déjà conseillé ce mois et cette année.");
        }

        // Si aucun enregistrement n'existe, sauvegarder le nouveau ProduitConseille
        return produitConseilleRepository.save(produitConseille);
    }
    public List<ProduitConseille> getAll() {
        // Trier les résultats par la colonne `daty` en ordre croissant (ASC)
        return produitConseilleRepository.findAll(Sort.by(Sort.Direction.ASC, "daty"));
    }
    public Optional<ProduitConseille> getById(Integer id) {
        return produitConseilleRepository.findById(id);
    }

    public void deleteById(Integer id) {
        if (produitConseilleRepository.existsById(id)) {
            produitConseilleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    public List<ProduitConseille> getProduitConseilleByCriteria(Integer mois, Integer annee) {
        return produitConseilleRepository.findByCriteria(mois, annee);
    }
}
