package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.entity.Parfum;
import itu.p16.boulangerie.service.ParfumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parfum")
public class ParfumController {
    @Autowired
    private ParfumService parfumService;

    @GetMapping("/addParfum")
    public ModelAndView showCategorieForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "parfum/new");
        return mv;
    }

    @PostMapping("/add")
    public String addUniteMesure(
            @RequestParam("nom") String nom
    ) {
        Parfum parfum = new Parfum();
        parfum.setNom(nom);

        Parfum insere = parfumService.save(parfum);
        return "redirect:/parfum/listParfum";
    }

    @GetMapping("/listParfum")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("layout");
        List<Parfum> parfums = parfumService.getAll();
        mv.addObject("all", parfums);
        mv.addObject("page", "parfum/list");
        return mv;
    }
}
