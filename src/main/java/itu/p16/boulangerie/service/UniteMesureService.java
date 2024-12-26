package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.repository.UniteMesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniteMesureService {
    @Autowired
    private UniteMesureRepository uniteMesureRepository;

    public UniteMesure save(UniteMesure uniteMesure) {
        return uniteMesureRepository.save(uniteMesure);
    }

    public List<UniteMesure> getAll() {
        return uniteMesureRepository.findAll();
    }

    public Optional<UniteMesure> getById(Integer id) {
        return uniteMesureRepository.findById(id);
    }
}
