package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Categorie;
import itu.p16.boulangerie.entity.Ingredient;
import itu.p16.boulangerie.entity.Production;
import itu.p16.boulangerie.entity.Produit;
import itu.p16.boulangerie.service.CategorieService;
import itu.p16.boulangerie.service.IngredientService;
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
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/add")
    public ModelAndView showProductionForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Produit> produits = produitService.getAll();
        mv.addObject("all", produits);
        mv.addObject("page", "production/new");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView addProduction(
            @RequestParam("quantite_produite") Integer quantiteProduite,
            @RequestParam("date_production") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateProduction,
            @RequestParam("id_produit") Integer idProduit
    ) {
        Production production = new Production();
        production.setQuantiteProduite(quantiteProduite);
        production.setDateProduction(java.sql.Date.valueOf(dateProduction));
        production.setProduitByIdProduit(produitService.getById(idProduit).orElseThrow(() -> new RuntimeException("Produit non trouvé")));
        try {
            productionService.save(production);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            ModelAndView mv = new ModelAndView("layout");
            List<Produit> produits = produitService.getAll();
            mv.addObject("all", produits);
            mv.addObject("error", e.getMessage());
            mv.addObject("page", "production/new");
            return mv;
        }
        ModelAndView mv = new ModelAndView("layout");
        List<Production> productions = productionService.getAll();
        List<Categorie> categories = categorieService.getAll();
        List<Ingredient> ingredients = ingredientService.getAll();
        mv.addObject("categories", categories);
        mv.addObject("ingredients", ingredients);
        mv.addObject("all", productions);
        mv.addObject("page", "production/list");
        return mv;
    }


    @GetMapping("/list")
    public ModelAndView showAllProduction(@RequestParam(required = false) Integer idIngredient,
                                          @RequestParam(required = false) Integer idCategorie) {
        ModelAndView mv = new ModelAndView("layout");
        List<Categorie> categories = categorieService.getAll();
        List<Ingredient> ingredients = ingredientService.getAll();
        mv.addObject("categories", categories);
        mv.addObject("ingredients", ingredients);
        List<Production> productions = productionService.findByCriteria(idIngredient, idCategorie);
        mv.addObject("all", productions);
        mv.addObject("page", "production/list");
        return mv;
    }
}
