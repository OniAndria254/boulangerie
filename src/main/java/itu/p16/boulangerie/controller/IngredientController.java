package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.UniteMesure;
import itu.p16.boulangerie.service.UniteMesureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private UniteMesureService uniteMesureService;

    @GetMapping("/add")
    public ModelAndView showUMForm() {
        ModelAndView mv = new ModelAndView("layout");
        List<UniteMesure> list = uniteMesureService.getAll();
        mv.addObject("all", list);
        mv.addObject("page", "ingredient/new");
        return mv;
    }
}
