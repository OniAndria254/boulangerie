package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.dto.CommissionVendeurDTO;
import itu.p16.boulangerie.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CommissionController {

    @Autowired
    private CommissionService commissionService;

    @GetMapping("/commissions")
    public ModelAndView showCommissions(
            @RequestParam(required = false) LocalDate date_debut,
            @RequestParam(required = false) LocalDate date_fin
    ) {
//        System.out.println("Date de début : " + date_debut);
//        System.out.println("Date de fin : " + date_fin);

        ModelAndView mv = new ModelAndView("layout");

        // Appeler le service avec les dates
        List<CommissionVendeurDTO> commissionsVendeurs = commissionService.getCommissionsVendeursBetweenDates(date_debut, date_fin);

        // Ajouter les résultats au modèle
        mv.addObject("all", commissionsVendeurs);
        mv.addObject("page", "vendeur/commission"); // Spécifier la vue à afficher
        return mv;
    }
}