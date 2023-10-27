package org.etu2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.etu2020.repository.UsersRepository;
import java.util.List;
import java.util.ArrayList;
import org.etu2020.model.Users;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UsersRepository userRepo;
	
	@GetMapping("/")
	public ResponseEntity<List<Users>> getAllUsers() {
		try {
			// Instantiate a list of the results type where to put all the result of findAll()
			List<Users> allusers = new ArrayList<>();
			userRepo.findAll().forEach(allusers::add);
			
			return new ResponseEntity<>(allusers, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
