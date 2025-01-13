package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Parfum;
import itu.p16.boulangerie.repository.ParfumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ParfumService {
    @Autowired
    private ParfumRepository parfumRepository;

    public Parfum save(Parfum parfum) {
        return parfumRepository.save(parfum);
    }

    public List<Parfum> getAll() {
        return parfumRepository.findAll();
    }

    public Optional<Parfum> getById(Integer id) { return parfumRepository.findById(id); }
}
