package itu.p16.boulangerie.controller;

import itu.p16.boulangerie.dto.ClientAchatDTO;
import itu.p16.boulangerie.entity.Client;
import itu.p16.boulangerie.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Afficher le formulaire d'ajout d'un client
    @GetMapping("/addClient")
    public ModelAndView showClientForm() {
        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("page", "client/new");
        return mv;
    }

    // Ajouter un client
    @PostMapping("/add")
    public String addClient(
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("date_naissance") LocalDate date_naissance
    ) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setDateNaissance(java.sql.Date.valueOf(date_naissance)); // Convertir String en Date

        clientService.save(client);
        return "redirect:/client/listClient";
    }

    // Afficher la liste des clients
    @GetMapping("/listClient")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("layout");
        List<Client> clients = clientService.getAll();
        mv.addObject("all", clients);
        mv.addObject("page", "client/list");
        return mv;
    }

    // Afficher le formulaire de modification d'un client
    @GetMapping("/update")
    public ModelAndView showEditForm(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView("layout");
        Client client = clientService.getById(id);
        mv.addObject("client", client);
        mv.addObject("page", "client/update");
        return mv;
    }

    // Modifier un client
    @PostMapping("/update")
    public String updateClient(
            @RequestParam("idClient") Integer idClient,
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("dateNaissance") String dateNaissance
    ) {
        Client client = clientService.getById(idClient);
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setDateNaissance(java.sql.Date.valueOf(dateNaissance)); // Convertir String en Date

        clientService.save(client);
        return "redirect:/client/listClient";
    }

    // Supprimer un client
    @GetMapping("/delete")
    public String deleteClient(@RequestParam("id") Integer id) {
        clientService.delete(id);
        return "redirect:/client/listClient";
    }

    @GetMapping("/clientsAvecAchats")
    public ModelAndView showClientsWithAchats(@RequestParam(required = false) LocalDate dateAchat) {
        System.out.println(dateAchat);
        ModelAndView mv = new ModelAndView("layout");
        // Appeler le service avec LocalDate
        List<ClientAchatDTO> clientsAchats = clientService.getClientsWithAchatsAndDetails(dateAchat);

        mv.addObject("all", clientsAchats);
        mv.addObject("page", "client/listAchat");
        return mv;
    }
}