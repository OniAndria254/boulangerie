package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Genre;
import itu.p16.boulangerie.entity.Vendeur;
import itu.p16.boulangerie.service.GenreService;
import itu.p16.boulangerie.service.VendeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/vendeur")
public class VendeurController {
    @Autowired
    private GenreService genreService;

    @Autowired
    private VendeurService vendeurService;

    // Afficher le formulaire d'ajout d'un vendeur
    @GetMapping("/addVendeur")
    public ModelAndView showVendeurForm() {
        ModelAndView mv = new ModelAndView("layout");

        List<Genre> genres = genreService.getAllGenres();
        mv.addObject("genres", genres);
        mv.addObject("page", "vendeur/new"); // Chemin vers la vue du formulaire d'ajout
        return mv;
    }

    // Ajouter un vendeur
    @PostMapping("/add")
    public String addVendeur(
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("salaire") Double salaire,
            @RequestParam("idGenre") Integer idGenre
    ) {
        Vendeur vendeur = new Vendeur();
        Genre genre = genreService.getGenreById(idGenre);
        vendeur.setGenreByIdGenre(genre);
        vendeur.setNom(nom);
        vendeur.setPrenom(prenom);
        vendeur.setSalaire(BigDecimal.valueOf(salaire));

        vendeurService.saveVendeur(vendeur);
        return "redirect:/vendeur/listVendeur"; // Rediriger vers la liste des vendeurs
    }

    // Afficher la liste des vendeurs
    @GetMapping("/listVendeur")
    public ModelAndView showAllVendeurs() {
        ModelAndView mv = new ModelAndView("layout");
        List<Vendeur> vendeurs = vendeurService.getAllVendeurs();
        mv.addObject("all", vendeurs);
        mv.addObject("page", "vendeur/list"); // Chemin vers la vue de la liste des vendeurs
        return mv;
    }

    // Afficher le formulaire de modification d'un vendeur
    @GetMapping("/update")
    public ModelAndView showEditForm(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView("layout");
        Vendeur vendeur = vendeurService.getVendeurById(id);
        List<Genre> genres = genreService.getAllGenres();
        mv.addObject("genres", genres);
        mv.addObject("vendeur", vendeur);
        mv.addObject("page", "vendeur/update"); // Chemin vers la vue du formulaire de modification
        return mv;
    }

    // Modifier un vendeur
    @PostMapping("/update")
    public String updateVendeur(
            @RequestParam("idVendeur") Integer idVendeur,
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("salaire") Double salaire,
            @RequestParam("idGenre") Integer idGenre
    ) {
        Vendeur vendeur = vendeurService.getVendeurById(idVendeur);
        vendeur.setNom(nom);
        vendeur.setPrenom(prenom);
        vendeur.setSalaire(BigDecimal.valueOf(salaire));
        Genre g = genreService.getGenreById(idGenre);
        vendeur.setGenreByIdGenre(g);

        vendeurService.saveVendeur(vendeur);
        return "redirect:/vendeur/listVendeur"; // Rediriger vers la liste des vendeurs
    }

    // Supprimer un vendeur
    @GetMapping("/delete")
    public String deleteVendeur(@RequestParam("id") Integer id) {
        vendeurService.deleteVendeur(id);
        return "redirect:/vendeur/listVendeur"; // Rediriger vers la liste des vendeurs
    }
}