/**
 * 
 */
package org.etu2020.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="vehicule")
public class Vehicule {
	@Id
	@Column(name="id_vehicule")
	String idVehicule;
	
	@Column(name="des_vehicule")
	String desVehicule;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(nullable=false, name="id_marque")
	Marque marque;
	
	public Vehicule() {}
	
	public Vehicule(String des_vehicule, Marque maque) {
		this.setDes_vehicule(des_vehicule);
		this.setMarque(maque);
	}
	
	public String getId_vehicule() {
		return idVehicule;
	}
	
	public String getDes_vehicule() {
		return desVehicule;
	}
	
	public Marque getMarque() {
		return marque;
	}
	
	public void setId_vehicule(String id_vehicule) {
		this.idVehicule = id_vehicule;
	}
	
	public void setDes_vehicule(String des_vehicule) {
		this.desVehicule = des_vehicule;
	}
	
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
}
