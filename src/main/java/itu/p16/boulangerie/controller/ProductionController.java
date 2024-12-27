package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Production;
import itu.p16.boulangerie.entity.Produit;
import itu.p16.boulangerie.service.ProductionService;
import itu.p16.boulangerie.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/production")
public class ProductionController {

    @Autowired
    private ProductionService productionService;
    @Autowired
    private ProduitService produitService;

    @GetMapping("/add")
    public ModelAndView showProductionForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Produit> produits = produitService.getAll();
        mv.addObject("all", produits);
        mv.addObject("page", "production/new");
        return mv;
    }

    @PostMapping("/add")
    public String addProduction(
            @RequestParam("quantite_produite") Integer quantiteProduite,
            @RequestParam("date_production") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateProduction,
            @RequestParam("id_produit") Integer idProduit
    ) {
        Production production = new Production();
        production.setQuantiteProduite(quantiteProduite);
        production.setDateProduction(java.sql.Date.valueOf(dateProduction));
        production.setProduitByIdProduit(produitService.getById(idProduit).orElseThrow(() -> new RuntimeException("Produit non trouvé")));
        productionService.save(production);
        return "redirect:/produit/list";
    }


    @GetMapping("/list")
    public ModelAndView showAllProduction() {
        ModelAndView mv = new ModelAndView("layout");
        List<Production> production = productionService.getAll();
        mv.addObject("all", production);
        mv.addObject("page", "production/list");
        return mv;
    }
}
