package itu.p16.boulangerie.service;

import itu.p16.boulangerie.dto.StockIngredientRequest;
import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.StockIngredientFille;
import itu.p16.boulangerie.entity.StockIngredientMere;
import itu.p16.boulangerie.repository.StockIngredientFilleRepository;
import itu.p16.boulangerie.repository.StockIngredientMereRepository;
import itu.p16.boulangerie.repository.StockProduitMereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockIngredientService {
    @Autowired
    StockIngredientMereRepository stockIngredientMereRepository;
    @Autowired
    StockIngredientFilleRepository stockIngredientFilleRepository;
    @Autowired
    IngredientService ingredientService;

    public void saveStock(LocalDate daty, List<StockIngredientRequest.IngredientEntry> ingredients) {
        StockIngredientMere stockIngredientMere = new StockIngredientMere();
        stockIngredientMere.setDaty(Date.valueOf(daty));
        stockIngredientMere = stockIngredientMereRepository.save(stockIngredientMere);
        for (StockIngredientRequest.IngredientEntry entry : ingredients) {
            System.out.println(entry.getIdIngredient());
            StockIngredientFille stock = new StockIngredientFille();
            stock.setStockIngredientMereByIdMere(stockIngredientMere);
            Ingredient ingredient = ingredientService.getById(entry.getIdIngredient()).orElseThrow();
            stock.setIngredientByIdIngredient(ingredient);
            stock.setEntree(entry.getEntree());
            stock.setSortie(0.0); // Valeur par défaut
            stockIngredientFilleRepository.save(stock);
        }
    }
}
