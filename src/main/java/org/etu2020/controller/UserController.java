package org.etu2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.etu2020.repository.UtilisateurRepository;
import java.util.List;
import java.util.ArrayList;
import org.etu2020.model.Utilisateur;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UtilisateurRepository userRepo;
	
	@GetMapping("")
	public ResponseEntity<List<Utilisateur>> getAllUsers() {
		try {
			// Instantiate a list of the results type where to put all the result of findAll()
			List<Utilisateur> allusers = new ArrayList<>();
			userRepo.findAll().forEach(allusers::add);
			
			return new ResponseEntity<>(allusers, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
