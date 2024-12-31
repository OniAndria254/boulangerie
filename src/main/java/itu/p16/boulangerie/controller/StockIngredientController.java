package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.dto.StockIngredientRequest;
import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.service.IngredientService;
import itu.p16.boulangerie.service.StockIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/stockIngredient")
public class StockIngredientController {
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private StockIngredientService stockIngredientService;

    @GetMapping("/add")
    public ModelAndView showSIForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Ingredient> all = ingredientService.getAll();
        mv.addObject("all", all);
        mv.addObject("page", "stockIngredient/new");
        return mv;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStock(@RequestBody StockIngredientRequest request) {
        try {
            stockIngredientService.saveStock(request.getDateAjout(), request.getIngredients());
            return ResponseEntity.ok("Stock ajouté avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur lors de l'ajout du stock : " + e.getMessage());
        }
    }
}
