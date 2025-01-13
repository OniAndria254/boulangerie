package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.repository.UniteMesureRepository;
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
@RequestMapping("/uniteMesure")
public class UniteMesureController {

    @Autowired
    private UniteMesureService uniteMesureService;

    @GetMapping("/addUM")
    public ModelAndView showUMForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "uniteMesure/new");
        return mv;
    }

    @PostMapping("/add")
    public String addUniteMesure(
            @RequestParam("libelle") String libelle,
            @RequestParam("description") String description
    ) {
        UniteMesure uniteMesure = new UniteMesure();
        uniteMesure.setLibelle(libelle);
        uniteMesure.setDescription(description);

        UniteMesure insere = uniteMesureService.save(uniteMesure);
        return "redirect:/uniteMesure/listUM";
    }

    @GetMapping("/listUM")
    public ModelAndView showAllUM() {
        ModelAndView mv = new ModelAndView("layout");
        List<UniteMesure> uniteMesures = uniteMesureService.getAll();
        mv.addObject("all", uniteMesures);
        mv.addObject("page", "uniteMesure/list");
        return mv;
    }
}
