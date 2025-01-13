package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.dto.IngredientDTO;
import itu.p16.boulangerie.dto.RecetteDTO;
import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.Produit;
import itu.p16.boulangerie.entity.Recette;
import itu.p16.boulangerie.entity.RecettePK;
import itu.p16.boulangerie.service.IngredientService;
import itu.p16.boulangerie.service.ProduitService;
import itu.p16.boulangerie.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/recette")
public class RecetteController {
    @Autowired
    private RecetteService recetteService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/addRecette")
    public ModelAndView showRecetteForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Ingredient> all = ingredientService.getAll();
        List<Produit> alls = produitService.getAll();
        mv.addObject("all", all);
        mv.addObject("alls", alls);
        mv.addObject("page", "recette/new");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView addRecette(@RequestBody RecetteDTO recetteDTO) {
//        System.out.println("Produit ID: " + recetteDTO.getIdPt());
        for (IngredientDTO ingredient : recetteDTO.getIngredients()) {
            RecettePK recettePK = new RecettePK(ingredient.getIdIg(), recetteDTO.getIdPt());
            Recette recette = new Recette();
            recette.setId(recettePK);
            recette.setProduitByIdProduit(produitService.getById(recetteDTO.getIdPt()).orElseThrow());
            recette.setIngredientByIdIngredient(ingredientService.getById(ingredient.getIdIg()).orElseThrow());
            recette.setQuantite(ingredient.getQuantite());
            recetteService.save(recette);
        }
        ModelAndView mv = new ModelAndView("layout");
        List<Recette> recettes = recetteService.getAll();
        mv.addObject("all", recettes);
        mv.addObject("page", "recette/list");
        return mv;
    }

    @GetMapping("/listRecette")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("layout");
        List<Recette> recettes = recetteService.getAll();
        mv.addObject("all", recettes);
        mv.addObject("page", "recette/list");
        return mv;
    }
}
