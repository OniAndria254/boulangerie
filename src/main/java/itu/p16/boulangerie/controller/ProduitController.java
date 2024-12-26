package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Produit;
import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.service.ProduitService;
import itu.p16.boulangerie.service.UniteMesureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/add")
    public ModelAndView showProductForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produit/new");
        return mv;
    }

    @PostMapping("/add")
    public String addProduct(
            @RequestParam("nom") String nom,
            @RequestParam("prix_vente") Double prix_vente
    ) {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setPrixVente(prix_vente);
        produitService.save(produit);
        return "redirect:/produit/list";
    }

    @GetMapping("/list")
    public ModelAndView showAllProducts() {
        ModelAndView mv = new ModelAndView("layout");
        List<Produit> produits = produitService.getAll();
        mv.addObject("all", produits);
        mv.addObject("page", "produit/list");
        return mv;
    }
}
