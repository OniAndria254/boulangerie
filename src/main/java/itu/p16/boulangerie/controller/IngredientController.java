package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.service.IngredientService;
import itu.p16.boulangerie.service.UniteMesureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private UniteMesureService uniteMesureService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/add")
    public ModelAndView showUMForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<UniteMesure> list = uniteMesureService.getAll();
        mv.addObject("all", list);
        mv.addObject("page", "ingredient/new");
        return mv;
    }

    @PostMapping("/add")
    public String addIngredient(
            @RequestParam("nom") String nom,
            @RequestParam("id_um") String id_um
    ) {
        // Récupérer l'unité de mesure via son ID
        Optional<UniteMesure> uniteMesureOptional = uniteMesureService.getById(Integer.parseInt(id_um));

        if (uniteMesureOptional.isPresent()) {
            // Créer un nouvel ingrédient et définir ses propriétés
            Ingredient ingredient = new Ingredient();
            ingredient.setNom(nom);
            ingredient.setUniteMesureByIdUniteMesure(uniteMesureOptional.get());

            // Sauvegarder l'ingrédient dans la base (ajouter un service pour cela)
            ingredientService.save(ingredient);

            return "redirect:/ingredient/list"; // Redirige vers la liste des ingrédients
        } else {
            // Gérer le cas où l'unité de mesure n'existe pas
            return "redirect:/ingredient/add?error=unite_mesure_not_found";
        }
    }

    @GetMapping("/list")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("layout");
        List<Ingredient> ingredients = ingredientService.getAll();
        mv.addObject("all", ingredients);
        mv.addObject("page", "ingredient/list");
        return mv;
    }
}
