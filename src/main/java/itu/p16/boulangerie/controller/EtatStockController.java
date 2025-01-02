package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.EtatStockIngredientEntity;
import itu.p16.boulangerie.entity.EtatStockProduitEntity;
import itu.p16.boulangerie.repository.EtatStockIngredientRepository;
import itu.p16.boulangerie.repository.EtatStockProduitRepository;
import itu.p16.boulangerie.repository.IngredientRepository;
import itu.p16.boulangerie.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/etatStock")
public class EtatStockController {
    @Autowired
    private EtatStockProduitRepository etatStockProduitRepository;
    @Autowired
    private EtatStockIngredientRepository etatStockIngredientRepository;

    @GetMapping("/ingredientStock")
    public ModelAndView showStockIngredient() {
        ModelAndView mv = new ModelAndView("layout");
        List<EtatStockIngredientEntity> stockIngredients = etatStockIngredientRepository.findAllEtatStockIngredient();
        mv.addObject("stockIngredients", stockIngredients);
        mv.addObject("page", "etatStock/ingredient");
        return mv;
    }

    @GetMapping("/produitStock")
    public ModelAndView showStockProduit() {
        ModelAndView mv = new ModelAndView("layout");
        List<EtatStockProduitEntity> stockProduits = etatStockProduitRepository.findAllEtatStockProduit();
        mv.addObject("stockProduits", stockProduits);
        mv.addObject("page", "etatStock/produit");
        return mv;
    }
}
