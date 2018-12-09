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
@Table(name = "airport")
public class Airport {


	@Id
	@Column(name = "name",unique=true)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departureAirport")
	@JsonManagedReference(value="departureAirport")
	private List<Flight> departureFilghts = new ArrayList<Flight>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalAirport")
	@JsonManagedReference(value="arrivalAirport")
	private List<Flight> arrivalFilghts = new ArrayList<Flight>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<Flight> getDepartureFilghts() {
		return departureFilghts;
	}

	public void setDepartureFilghts(List<Flight> departureFilghts) {
		this.departureFilghts = departureFilghts;
	}

	public List<Flight> getArrivalFilghts() {
		return arrivalFilghts;
	}

	public void setArrivalFilghts(List<Flight> arrivalFilghts) {
		this.arrivalFilghts = arrivalFilghts;
	}


}
