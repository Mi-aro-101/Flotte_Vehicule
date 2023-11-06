/**
 * 
 */
package org.etu2020.repository;

import org.springframework.data.repository.CrudRepository;

import org.etu2020.model.Marque;

/**
 * @author miaro
 *
 */
public interface MarqueRepository extends CrudRepository<Marque, String> {
	
}
