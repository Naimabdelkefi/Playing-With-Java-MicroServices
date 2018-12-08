package com.ensi.ilsi.AirlineCompany.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
public class Customer  {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "number_points")
	private int numberPts;
	@Column(name = "PassportNumber")
	private String PassportNumber;
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonManagedReference(value="customer")
	private List<Booking> bookings = new ArrayList<Booking>();*/




	public Customer( String name, String adresse, int numberPts, String passportNumber) {
		super();

		this.name = name;
		this.adresse = adresse;
		this.numberPts = numberPts;
		PassportNumber = passportNumber;
		
	}

	public String getPassportNumber() {
		return PassportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		PassportNumber = passportNumber;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNumberPts() {
		return numberPts;
	}

	public void setNumberPts(int numberPts) {
		this.numberPts = numberPts;
	}

	public Customer() {
	}

}
