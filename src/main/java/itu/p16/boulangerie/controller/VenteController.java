package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.*;
import itu.p16.boulangerie.service.*;
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
import java.util.Optional;

@Controller
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    private ProductionService productionService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private VenteService venteService;
    @Autowired
    private NatureProduitService natureProduitService;

    @GetMapping("/add")
    public ModelAndView showVenteForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Produit> produits = produitService.getAll();
        mv.addObject("all", produits);
        mv.addObject("page", "vente/new");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView addVente(
            @RequestParam("quantite_vendu") Integer quantiteVendu,
            @RequestParam("date_vente") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateVente,
            @RequestParam("id_produit") Integer idProduit
    ) {
        Vente vente = new Vente();
        vente.setDateVente(Date.valueOf(dateVente));
        Produit p = produitService.getById(idProduit).orElseThrow();

        vente.setProduitByIdProduit(p);
        try {
            venteService.save(vente);
        }
        catch (Exception e) {
            ModelAndView mv = new ModelAndView("layout");

            List<Produit> produits = produitService.getAll();
            mv.addObject("all", produits);
            mv.addObject("error", e.getMessage());
            mv.addObject("page", "vente/new");
            return mv;
        }
        ModelAndView mv = new ModelAndView("layout");

        List<Vente> ventes = venteService.getAll();
        List<Categorie> categories = categorieService.getAll();
        List<NatureProduit> natureProduits =natureProduitService.getAll();
        mv.addObject("categories", categories);
        mv.addObject("natureProduits", natureProduits);
        mv.addObject("all", ventes);
        mv.addObject("page", "vente/list");
        return mv;
    }


    @GetMapping("/list")
    public ModelAndView showVente(@RequestParam(required = false) Integer idCategorie,
                                          @RequestParam(required = false) Integer idNatureProduit) {
        ModelAndView mv = new ModelAndView("layout");
        List<Categorie> categories = categorieService.getAll();
        List<NatureProduit> natureProduits = natureProduitService.getAll();
        mv.addObject("categories", categories);
        mv.addObject("natureProduits", natureProduits);
        List<Vente> ventes = venteService.findByCriteria(idCategorie, idNatureProduit);
        mv.addObject("all", ventes);
        mv.addObject("page", "vente/list");
        return mv;
    }
}
