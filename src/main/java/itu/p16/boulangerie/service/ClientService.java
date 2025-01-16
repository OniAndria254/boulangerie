package itu.p16.boulangerie.service;

import itu.p16.boulangerie.dto.ClientAchatDTO;
import itu.p16.boulangerie.entity.Client;
import itu.p16.boulangerie.repository.ClientRepository;
import itu.p16.boulangerie.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VenteRepository venteRepository;

    // Sauvegarder un client
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    // Récupérer tous les clients
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    // Récupérer un client par son ID
    public Client getById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    // Supprimer un client par son ID
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }


    // Récupérer les clients avec les détails des achats, avec filtre sur la date d'achat
    // Utiliser java.time.LocalDate pour le paramètre
    public List<ClientAchatDTO> getClientsWithAchatsAndDetails(LocalDate dateAchat) {
        // Convertir LocalDate en java.sql.Date
        Date sqlDate = (dateAchat != null) ? Date.valueOf(dateAchat) : null;

//        System.out.println(sqlDate.toString());
        // Appeler le repository avec java.sql.Date
        List<Object[]> results = venteRepository.findClientsWithAchatsAndDetails(sqlDate);

        // Mapper les résultats en DTO
        return results.stream()
                .map(row -> new ClientAchatDTO(
                        (Integer) row[0], // Id_client
                        (String) row[1],  // nom
                        (String) row[2],  // prenom
                        (String) row[3],  // produit
                        (Integer) row[4], // quantite
                        ((Date) row[5]).toLocalDate() // Convertir java.sql.Date en LocalDate
                ))
                .collect(Collectors.toList());
    }
}