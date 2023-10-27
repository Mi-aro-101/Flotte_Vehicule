/**
 * 
 */
package org.etu2020.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.etu2020.model.Vehicule;
import java.util.List;

/**
 * @author miaro
 *
 */
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
	List<Vehicule> findAll();
}
