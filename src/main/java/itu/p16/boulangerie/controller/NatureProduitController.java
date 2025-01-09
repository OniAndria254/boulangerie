package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Categorie;
import itu.p16.boulangerie.entity.NatureProduit;
import itu.p16.boulangerie.service.CategorieService;
import itu.p16.boulangerie.service.NatureProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/natureProduit")
public class NatureProduitController {
    @Autowired
    private NatureProduitService natureProduitService;

    @GetMapping("/add")
    public ModelAndView showCategorieForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "natureProduit/new");
        return mv;
    }

    @PostMapping("/add")
    public String addUniteMesure(
            @RequestParam("nom") String nom
    ) {
        NatureProduit natureProduit = new NatureProduit();
        natureProduit.setNom(nom);

        NatureProduit insere = natureProduitService.save(natureProduit);
        return "redirect:/natureProduit/list";
    }

    @GetMapping("/list")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("layout");
        List<NatureProduit> natureProduits = natureProduitService.getAll();
        mv.addObject("all", natureProduits);
        mv.addObject("page", "natureProduit/list");
        return mv;
    }
}
