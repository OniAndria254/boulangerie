package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.*;
import itu.p16.boulangerie.service.ProduitConseilleService;
import itu.p16.boulangerie.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/produitConseille")
public class ProduitConseilleController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitConseilleService produitConseilleService;

    @GetMapping("/addProduitConseille")
    public ModelAndView showProductForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Produit> produits = produitService.getAll();

        mv.addObject("all", produits);
        mv.addObject("page", "produitConseille/new");
        return mv;
    }


    @PostMapping("/addProduitConseille")
    public ModelAndView addProduitConseille(
            @RequestParam("idProduitConseille") Integer idProduitConseille,
            @RequestParam("dateProduitConseille") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateProduitConseille
    ) {
        ProduitConseille produitConseille = new ProduitConseille();
        Produit produit = produitService.getById(idProduitConseille).orElseThrow();
        produitConseille.setProduitByIdProduit(produit);
        produitConseille.setDaty(Date.valueOf(dateProduitConseille));

        try{
            produitConseilleService.save(produitConseille);
        }
        catch (IllegalStateException e) {
            ModelAndView mv = new ModelAndView("layout");
            List<Produit> produits = produitService.getAll();
            mv.addObject("error", e.getMessage());
            mv.addObject("all", produits);
            mv.addObject("page", "produitConseille/new");
            return mv;
        }
        ModelAndView mv = new ModelAndView("layout");
        List<ProduitConseille> produitConseilles = produitConseilleService.getAll();
        mv.addObject("all", produitConseilles);
        mv.addObject("page", "produitConseille/list");
        return mv;
    }

    @GetMapping("/listConseille")
    public ModelAndView listProduitConseille(@RequestParam(required = false) Integer mois,
                                             @RequestParam(required = false) Integer annee) {
        List<ProduitConseille> produitConseilles = produitConseilleService.getProduitConseilleByCriteria(mois, annee);
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produitConseille/list");
        mv.addObject("all", produitConseilles);
        return mv;
    }
}
