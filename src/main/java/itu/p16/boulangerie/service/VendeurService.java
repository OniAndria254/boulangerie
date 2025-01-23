package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Vendeur;
import itu.p16.boulangerie.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendeurService {

    @Autowired
    private VendeurRepository vendeurRepository;

    // Récupérer tous les vendeurs
    public List<Vendeur> getAllVendeurs() {
        return vendeurRepository.findAll();
    }

    // Récupérer un vendeur par son ID
    public Vendeur getVendeurById(Integer id) {
        return vendeurRepository.findById(id).orElse(null);
    }

    // Ajouter ou mettre à jour un vendeur
    public Vendeur saveVendeur(Vendeur vendeur) {
        return vendeurRepository.save(vendeur);
    }

    // Supprimer un vendeur par son ID
    public void deleteVendeur(Integer id) {
        vendeurRepository.deleteById(id);
    }
}