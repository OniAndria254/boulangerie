package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Production;
import itu.p16.boulangerie.repository.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class ProductionService {

    @Autowired
    private ProductionRepository productionRepository;

    public Production  save(Production production) {
        return productionRepository.save(production);
    }

    public List<Production> getAll() {
        return productionRepository.findAll();
    }
}
