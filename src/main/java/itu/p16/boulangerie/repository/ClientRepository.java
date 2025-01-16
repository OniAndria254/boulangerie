package itu.p16.boulangerie.repository;

import itu.p16.boulangerie.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}