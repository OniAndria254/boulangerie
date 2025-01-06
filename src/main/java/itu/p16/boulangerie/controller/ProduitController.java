package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Ingredient;
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
    public ModelAndView listProduits(
            @RequestParam(value = "nom", required = false) String nom,
            @RequestParam(value = "prixMin", required = false) Double prixMin,
            @RequestParam(value = "prixMax", required = false) Double prixMax) {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produit/list");

        List<Produit> produits = produitService.findProduitsByCriteria(nom, prixMin, prixMax);
        mv.addObject("all", produits);

        return mv;
    }


    @GetMapping("/update")
    public ModelAndView showUpdateForm(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produit/update");
        Produit produit = produitService.getById(id).orElseThrow();
        mv.addObject("produit", produit);
        return mv;
    }

    @GetMapping("/delete")
    public String deleteProduit(@RequestParam("id") Integer id) {
        try {
            produitService.deleteById(id);
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du produit : " + e.getMessage());
        }
        return "redirect:/produit/list";
    }


    @PostMapping("/update")
    public String updateProduit(
            @RequestParam("id") Integer id,
            @RequestParam("nom") String nom,
            @RequestParam("prix_vente") Double prix_vente) {
        Produit produit = produitService.getById(id).orElseThrow();
        produit.setNom(nom);
        produit.setPrixVente(prix_vente);
        produitService.save(produit);
        return "redirect:/produit/list";
    }
}
