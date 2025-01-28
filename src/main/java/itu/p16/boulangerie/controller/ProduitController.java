package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.*;
import itu.p16.boulangerie.service.CategorieService;
import itu.p16.boulangerie.service.HistoriquePrixService;
import itu.p16.boulangerie.service.ParfumService;
import itu.p16.boulangerie.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ParfumService parfumService;
    @Autowired
    private HistoriquePrixService historiquePrixService;

    @GetMapping("/addProduit")
    public ModelAndView showProductForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<Parfum> parfums = parfumService.getAll();

        List<Categorie> all = categorieService.getAll();
        mv.addObject("parfums", parfums);
        mv.addObject("all", all);
        mv.addObject("page", "produit/new");
        return mv;
    }

    @PostMapping("/add")
    public String addProduct(
            @RequestParam("nom") String nom,
            @RequestParam("prix_vente") Double prix_vente,
            @RequestParam("categorie") Integer id_categorie,
            @RequestParam("parfum") Integer id_parfum
    ) {
        Parfum parfum = parfumService.getById(id_parfum).orElseThrow();
        Produit produit = new Produit();
        Categorie categorie = categorieService.getById(id_categorie).orElseThrow();
        produit.setCategorieByIdCategorie(categorie);
        produit.setParfumByIdParfum(parfum);
        produit.setNom(nom);
        produit.setPrixVente(prix_vente);
        Produit p1 = produitService.save(produit);
        HistoriquePrix historiquePrix = new HistoriquePrix();
        historiquePrix.setPrix(p1.getPrixVente());
        historiquePrix.setDaty(Date.valueOf(LocalDate.now()));

        historiquePrix.setProduitByIdProduit(produit);
        historiquePrixService.addHistoriquePrix(historiquePrix);
        return "redirect:/produit/listProduit";
    }

    @GetMapping("/listProduit")
    public ModelAndView listProduits(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) Double prixMin,
            @RequestParam(required = false) Double prixMax,
            @RequestParam(required = false) Integer idCategorie) {
        List<Produit> produits = produitService.findByCriteria(nom, prixMin, prixMax, idCategorie);
        List<Categorie> categories = categorieService.getAll();

        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produit/list");
        mv.addObject("produits", produits);
        mv.addObject("categories", categories);
        return mv;
    }



    @GetMapping("/update")
    public ModelAndView showUpdateForm(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produit/update");
        List<Parfum> parfums = parfumService.getAll();
        List<Categorie> categories = categorieService.getAll();
        mv.addObject("all", categories);
        mv.addObject("parfums", parfums);
        Produit produit = produitService.getById(id).orElseThrow();
        mv.addObject("produit", produit);
        return mv;
    }

    @GetMapping("/updatePrix")
    public ModelAndView showUpdatePrixForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produit/update_prix");
        List<Produit> produits = produitService.getAll();
        mv.addObject("all", produits);
        return mv;
    }

    @PostMapping("/updatePrix")
    public String updatePrixProduit(
            @RequestParam("id") Integer id,
            @RequestParam("prix") Double prix,
            @RequestParam("daty") LocalDate daty) {
        Produit produit = produitService.getById(id).orElseThrow();
        produit.setPrixVente(prix);

        HistoriquePrix historiquePrix = new HistoriquePrix();
        historiquePrix.setPrix(prix);
        historiquePrix.setDaty(Date.valueOf(daty));

        historiquePrix.setProduitByIdProduit(produit);
        historiquePrixService.addHistoriquePrix(historiquePrix);
        produitService.save(produit);

        return "redirect:/produit/historique";
    }

    @GetMapping("/historique")
    public ModelAndView showHisto(@RequestParam(name = "produitId", required = false) Integer produitId) {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "produit/list_historique_prix");

        // Récupérer tous les produits pour le filtre
        List<Produit> produits = produitService.getAll();
        mv.addObject("produits", produits);

        // Récupérer l'historique des prix en fonction du filtre
        List<HistoriquePrix> historiquePrix;
        if (produitId != null && produitId > 0) {
            historiquePrix = historiquePrixService.getHistoriquePrixByProduit(produitId);
        } else {
            historiquePrix = historiquePrixService.getAllHistoriquePrix();
        }
        mv.addObject("all", historiquePrix);

        return mv;
    }

    @GetMapping("/delete")
    public String deleteProduit(@RequestParam("id") Integer id) {
        try {
            produitService.deleteById(id);
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du produit : " + e.getMessage());
        }
        return "redirect:/produit/listProduit";
    }


    @PostMapping("/update")
    public String updateProduit(
            @RequestParam("id") Integer id,
            @RequestParam("nom") String nom,
            @RequestParam("prix_vente") Double prix_vente,
            @RequestParam("idCategorie") Integer idCategorie,
            @RequestParam("idParfum") Integer idParfum) {
        Produit produit = produitService.getById(id).orElseThrow();
        produit.setNom(nom);
        produit.setPrixVente(prix_vente);
        Categorie categorie = categorieService.getById(idCategorie).orElseThrow();
        produit.setCategorieByIdCategorie(categorie);
        Parfum parfum = parfumService.getById(idParfum).orElseThrow();
        produit.setParfumByIdParfum(parfum);
        produitService.save(produit);
        return "redirect:/produit/listProduit";
    }
}
