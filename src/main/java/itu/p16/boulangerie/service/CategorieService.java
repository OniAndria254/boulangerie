package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Categorie;
import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.repository.CategorieRepository;
import itu.p16.boulangerie.repository.UniteMesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getById(Integer id) {
        return categorieRepository.findById(id);
    }
}
