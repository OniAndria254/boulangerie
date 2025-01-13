package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Categorie;
import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.service.CategorieService;
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
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/addCategorie")
    public ModelAndView showCategorieForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "categorie/new");
        return mv;
    }

    @PostMapping("/add")
    public String addUniteMesure(
            @RequestParam("nom") String nom
    ) {
        Categorie categorie = new Categorie();
        categorie.setNom(nom);

        Categorie insere = categorieService.save(categorie);
        return "redirect:/categorie/list";
    }

    @GetMapping("/listCategorie")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("layout");
        List<Categorie> categories = categorieService.getAll();
        mv.addObject("all", categories);
        mv.addObject("page", "categorie/list");
        return mv;
    }
}
