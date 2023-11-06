/**
 * 
 */
package org.etu2020.controller;

import org.etu2020.repository.MarqueRepository;
import org.etu2020.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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
	 * Retrieve all vehicule from the database
	 * @return
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
	
	/**
	 * Retrieve vehicule by Id from database
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Vehicule> getVehiculeById(@PathVariable("id") String id){
		Optional<Vehicule> vehicule = vehiculerepo.findById(id);
		
		if(vehicule.isPresent()) {
			return new ResponseEntity<>(vehicule.get(), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	/**
	 * Save to the database the entity car
	 * @param car
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Vehicule> saveVehicule(@RequestBody Vehicule car){
		try {
			Vehicule vehicule = vehiculerepo.save(car);
			
			return new ResponseEntity<>(vehicule, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * update from database the entity having the {id} as following the entity given
	 * @param id
	 * @param car
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Vehicule> updateVehicule(@PathVariable("id") String id, @RequestBody Vehicule car){
		Optional<Vehicule> _vehicule = vehiculerepo.findById(id);
		
		if(_vehicule.isPresent()) {
			Vehicule vehicule = _vehicule.get();
			vehicule.setDes_vehicule(car.getDes_vehicule());
			vehicule.setMarque(car.getMarque());
			
			vehiculerepo.save(vehicule);
			return new ResponseEntity<>(vehicule, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<HttpStatus> removeVehicule(@PathVariable("id") String id){
		try {
			vehiculerepo.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
