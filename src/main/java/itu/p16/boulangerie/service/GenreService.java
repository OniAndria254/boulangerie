package itu.p16.boulangerie.service;

import itu.p16.boulangerie.entity.Genre;
import itu.p16.boulangerie.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    // Récupérer tous les genres
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Récupérer un genre par son ID
    public Genre getGenreById(Integer id) {
        Optional<Genre> genre = genreRepository.findById(id);
        return genre.orElse(null); // Retourne null si le genre n'est pas trouvé
    }

    // Ajouter ou mettre à jour un genre
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    // Supprimer un genre par son ID
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }

    // Trouver un genre par son nom
    public Genre getGenreByNom(String nom) {
        return genreRepository.findByNom(nom);
    }
}