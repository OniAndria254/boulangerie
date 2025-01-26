package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // Par exemple, trouver un genre par son nom
    Genre findByNom(String nom);
}