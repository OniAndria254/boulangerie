package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class IngredientService {
     @Autowired
    private IngredientRepository ingredientRepository;

     public Ingredient save(Ingredient ingredient) {
         return ingredientRepository.save(ingredient);
     }

    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}