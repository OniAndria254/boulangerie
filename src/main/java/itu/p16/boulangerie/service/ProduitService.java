package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Produit;
import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.repository.ProduitRepository;
import itu.p16.boulangerie.repository.UniteMesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getById(Integer id) {
        return produitRepository.findById(id);
    }

    public void deleteById(Integer id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    public List<Produit> findByCriteria(String nom, Double prixMin, Double prixMax, Integer idCategorie) {
        return produitRepository.findByCriteria(nom, prixMin, prixMax, idCategorie);
    }
}
