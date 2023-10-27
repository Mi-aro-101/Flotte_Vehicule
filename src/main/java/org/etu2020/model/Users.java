package org.etu2020.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue
	int id;
	
	@Column(name="first_name", nullable=false)
	String first_name;
	
	@Column(name="last_name", nullable=false)
	String last_name;
	
	@Column(name="city", nullable=false)
	String city;
	
	public Users(String first_name, String last_name, String city) {
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setCity(city);
	}
	
	public Users() {}
	
	public int getId() {
		return id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public void setLast_name(String last_name){
		this.last_name = last_name;
	}
	
	public void setCity(String city){
		this.city = city;
	}
}
