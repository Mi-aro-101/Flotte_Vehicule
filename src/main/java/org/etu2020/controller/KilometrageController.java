/**
 * 
 */
package org.etu2020.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.etu2020.model.Kilometrage;
import org.etu2020.model.Vehicule;
import org.etu2020.repository.KilometrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaro
 *
 */
@RestController
@RequestMapping("/kilometrage")
public class KilometrageController {

	@Autowired
	KilometrageRepository kilometragerepo;
	
	/**
	 * Get kilometrage by vehicule using the id of the vehicule as identifier
	 * @param id_vehicule
	 * @return
	 */
	@GetMapping("/vehicule/{id}")
	public ResponseEntity<List<Kilometrage>> getKilometrageByVehicule(@PathVariable("id") String id_vehicule){
		try {
			List<Kilometrage> kilometrages = new ArrayList<>();
			// get kilometrage where vehicule=?
			kilometragerepo.findByVehiculeIdVehicule(id_vehicule).forEach(kilometrages::add);
			
			return new ResponseEntity<>(kilometrages, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Find all Kilometrage from a given date
	 * @param date_kilometrage
	 * @return
	 */
	@GetMapping("/date")
	public ResponseEntity<List<Kilometrage>> getKilometrageByDate(@RequestParam("date")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date_kilometrage){
		try {
			List<Kilometrage> kilometrages = new ArrayList<>();
			// get kilometrage where vehicule=?
			kilometragerepo.findByDateKilometrage(date_kilometrage).forEach(kilometrages::add);
			
			return new ResponseEntity<>(kilometrages, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * get kilometrage by it's debutkm
	 * @param debutkm
	 * @return
	 */
	@GetMapping("/debutkm")
	public ResponseEntity<List<Kilometrage>> getKilometrageByDebutkm(@RequestParam("debutkm") double debutkm){
		try {
			List<Kilometrage> kilometrages = new ArrayList<>();
			// get kilometrage where debutkm=?
			kilometragerepo.findByDebutkm(debutkm).forEach(kilometrages::add);
			
			return new ResponseEntity<>(kilometrages, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * get kilometrage as it's finkm
	 * @param finkm
	 * @return
	 */
	@GetMapping("/finkm")
	public ResponseEntity<List<Kilometrage>> getKilometrageByFinkm(@RequestParam("finkm") double finkm){
		try {
			List<Kilometrage> kilometrages = new ArrayList<>();
			// get kilometrage where finkm=?
			kilometragerepo.findByFinkm(finkm).forEach(kilometrages::add);
			
			return new ResponseEntity<>(kilometrages, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Get all method to retrive all kilometrage
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<List<Kilometrage>> getAllKilometrage(){
		try {
			// Instantiate an arrayList to stock the results of the findAll method
			List<Kilometrage> allkilometrage = new ArrayList<>();
			// Invoke findAll and allocate response from it to the ArrayList instanciated above
			kilometragerepo.findAll().forEach(allkilometrage::add);
			
			// Return a formatted json of the results if status = 200
			return new ResponseEntity<>(allkilometrage, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("save")
	public ResponseEntity<Kilometrage> saveKilometrage(@RequestBody Kilometrage kilom){
		try {
			Kilometrage kilometrage = kilometragerepo.save(kilom);
			
			return new ResponseEntity<>(kilometrage, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
