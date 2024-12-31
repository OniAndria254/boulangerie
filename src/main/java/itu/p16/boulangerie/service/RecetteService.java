package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Recette;
import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.repository.RecetteRepository;
import itu.p16.boulangerie.repository.UniteMesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteService {
    @Autowired
    private RecetteRepository recetteRepository;

    public Recette save(Recette recette) {
        return recetteRepository.save(recette);
    }

    public List<Recette> getAll() {
        return recetteRepository.findAll();
    }
}
