package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Production;
import itu.p16.boulangerie.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/production")
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    @GetMapping("/add")
    public ModelAndView showProductionForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "production/new");
        return mv;
    }

    @PostMapping("/add")
    public String addProduction(
            @RequestParam("quantite_produite") Integer quantite_produite,
            @RequestParam("date_production") Date date_production,
            @RequestParam("id_produit") Integer id_produit
            ) {
        Production production = new Production();
        production.setQuantiteProduite(quantite_produite);
        production.setDateProduction((java.sql.Date) date_production);
        production.setProduitByIdProduit(id_produit);
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
