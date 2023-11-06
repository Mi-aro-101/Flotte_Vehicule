package org.etu2020.repository;

import org.springframework.data.repository.CrudRepository;
import org.etu2020.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {

}