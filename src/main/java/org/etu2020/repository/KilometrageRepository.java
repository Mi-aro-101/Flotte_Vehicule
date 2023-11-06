/**
 * 
 */
package org.etu2020.repository;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import org.etu2020.model.Kilometrage;

/**
 * @author miaro
 *
 */
public interface KilometrageRepository extends CrudRepository<Kilometrage, String> {

	List<Kilometrage> findByVehiculeIdVehicule(String idVehicule);
	
	List<Kilometrage> findByDateKilometrage(LocalDate date_kilometrage);
	
	List<Kilometrage> findByDebutkm(double debutkm);
	
	List<Kilometrage> findByFinkm(double finkm);
	
}
