/**
 * 
 */
package org.etu2020.controller;

import org.etu2020.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

import org.etu2020.model.Vehicule;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping("/vehicule")
public class VehiculeController {
	
	@Autowired
	VehiculeRepository vehiculerepo;
	
	/**
	 * For no path value given, just redirect the application to the get all method here
	 * @return json of arrayList of all vehicule from database (including their 'marque')
	 */
	@GetMapping("")
	public ResponseEntity<List<Vehicule>> getAllVehicule(){
		try {
			// Instantiate an arrayList to stock the results of the findAll method
			List<Vehicule> allVehicule = new ArrayList<>();
			// Invoke findAll and allocate response from it to the ArrayList instanciated above
			vehiculerepo.findAll().forEach(allVehicule::add);
			
			// Return a formatted json of the results if status = 200
			return new ResponseEntity<>(allVehicule, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
