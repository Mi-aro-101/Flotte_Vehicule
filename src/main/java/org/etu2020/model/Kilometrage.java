/**
 * 
 */
package org.etu2020.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author miaro
 *
 */
@Entity
@Table(name="kilometrage")
public class Kilometrage {
	@Id
	String id_kilometrage;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(nullable=false, name="id_vehicule")
	Vehicule vehicule;
	
	@Column(name="date_kilometrage")
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate dateKilometrage;
	
	@Column(name="debutkm")
	double debutkm;
	
	@Column(name="finkm")
	double finkm;
	
	public Kilometrage() {}
	
	public Kilometrage(Vehicule vehicule, LocalDate date_kilometrage, double debutkm, double finkm) {
		this.setVehicule(vehicule);
		this.setDate_kilometrage(date_kilometrage);
		this.setDebutkm(debutkm);
		this.setFinkm(finkm);
	}
	
	public String getId_kilometrage() {
		return id_kilometrage;
	}
	
	public Vehicule getVehicule() {
		return vehicule;
	}
	
	public LocalDate getDate_kilometrage() {
		return dateKilometrage;
	}
	
	public double getDebutkm() {
		return debutkm;
	}
	
	public double getFinkm() {
		return finkm;
	}
	
	public void setId_kilometrage(String id_kilometrage) {
		this.id_kilometrage = id_kilometrage;
	}
	
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	public void setDate_kilometrage(LocalDate date_kilometrage) {
		this.dateKilometrage = date_kilometrage;
	}
	
	public void setDebutkm(double debutkm) {
		this.debutkm = debutkm;
	}
	
	public void setFinkm(double finkm) {
		this.finkm = finkm;
	}
}
