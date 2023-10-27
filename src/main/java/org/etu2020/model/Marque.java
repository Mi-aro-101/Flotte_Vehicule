/**
 * 
 */
package org.etu2020.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="marque")
public class Marque {
	@Id
	@GeneratedValue
	String id_marque;
	
	@Column(name="des_marque", nullable=false)
	String des_marque;
	
	public Marque() {}
	
	public Marque(String id_marque, String des_marque) {
		this.setId_marque(id_marque);
		this.setDes_marque(des_marque);
	}
	
	public String getId_marque() {
		return id_marque;
	}
	
	public String getDes_marque() {
		return des_marque;
	}
	
	public void setId_marque(String id_marque) {
		this.id_marque = id_marque;
	}
	
	public void setDes_marque(String des_marque) {
		this.des_marque = des_marque;
	}
	
}
