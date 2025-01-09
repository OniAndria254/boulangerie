package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.NatureProduit;
import itu.p16.boulangerie.repository.IngredientRepository;
import itu.p16.boulangerie.repository.NatureProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NatureProduitService {
    @Autowired
    private NatureProduitRepository natureProduitRepository;

    public NatureProduit save(NatureProduit natureProduit) {
        return natureProduitRepository.save(natureProduit);
    }

    public List<NatureProduit> getAll() {
        return natureProduitRepository.findAll();
    }

    public Optional<NatureProduit> getById(Integer id) { return natureProduitRepository.findById(id); }
}
