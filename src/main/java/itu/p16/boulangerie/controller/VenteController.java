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
    private ParfumService parfumService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/addVente")
    public ModelAndView showVenteForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Client> clients = clientService.getAll();
        mv.addObject("clients", clients);
        List<Produit> produits = produitService.getAll();
        mv.addObject("all", produits);
        mv.addObject("page", "vente/new");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView addVente(
            @RequestParam("id_produit") Integer idProduit,
            @RequestParam("quantite_vendu") Integer quantiteVendu,
            @RequestParam("date_vente") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateVente,
            @RequestParam("id_client") Integer id_client
    ) {
        Vente vente = new Vente();
        vente.setDateVente(Date.valueOf(dateVente));
        vente.setQuantite(quantiteVendu);
        Client client = clientService.getById(id_client);
        Produit p = produitService.getById(idProduit).orElseThrow();
        vente.setClientByIdClient(client);

        vente.setProduitByIdProduit(p);
        try {
            venteService.save(vente);
        }
        catch (Exception e) {
            ModelAndView mv = new ModelAndView("layout");

            List<Produit> produits = produitService.getAll();
            mv.addObject("all", produits);
            mv.addObject("error", e.getMessage());
            List<Client> clients = clientService.getAll();
            mv.addObject("clients", clients);
            mv.addObject("page", "vente/new");
            return mv;
        }
        ModelAndView mv = new ModelAndView("layout");

        List<Vente> ventes = venteService.getAll();
        List<Categorie> categories = categorieService.getAll();
        List<Parfum> parfums = parfumService.getAll();
        mv.addObject("categories", categories);
        mv.addObject("parfums", parfums);
        mv.addObject("all", ventes);
        mv.addObject("page", "vente/list");
        return mv;
    }


    @GetMapping("/listVente")
    public ModelAndView showVente(@RequestParam(required = false) Integer idCategorie,
                                          @RequestParam(required = false) Integer idParfum) {
        ModelAndView mv = new ModelAndView("layout");
        List<Categorie> categories = categorieService.getAll();
        List<Parfum> parfums = parfumService.getAll();
        mv.addObject("categories", categories);
        mv.addObject("parfums", parfums);
        List<Vente> ventes = venteService.findByCriteria(idCategorie, idParfum);
        mv.addObject("all", ventes);
        mv.addObject("page", "vente/list");
        return mv;
    }
}
