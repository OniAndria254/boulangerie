package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.NatureProduit;
import itu.p16.boulangerie.entity.Production;
import itu.p16.boulangerie.entity.Vente;
import itu.p16.boulangerie.repository.NatureProduitRepository;
import itu.p16.boulangerie.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {
    @Autowired
    private VenteRepository venteRepository;

    public Vente save(Vente vente) {
        return venteRepository.save(vente);
    }

    public List<Vente> getAll() {
        return venteRepository.findAll();
    }

    public Optional<Vente> getById(Integer id) { return venteRepository.findById(id); }

    public List<Vente> findByCriteria(Integer idCategorie, Integer idNatureProduit) {
        return venteRepository.findByCriteria(idCategorie, idNatureProduit);
    }

}
