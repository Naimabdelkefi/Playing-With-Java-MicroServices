package com.ensi.ilsi.AirlineCompany.entities;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ensi.ilsi.AirlineCompany.entities.enumeration.FlightState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@Column(name="number",unique=true)
	 private String number="";
	
	@Column(name = "departure")
	private ZonedDateTime  departure;
	
	@Column(name = "arrival")
	private ZonedDateTime  arrival;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
	private FlightState state;
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference(value="departureAirport")
    private Airport departureAirport=null;
   @ManyToOne(fetch=FetchType.LAZY)
   @JsonBackReference(value="arrivalAirport")
    private Airport arrivalAirport=null;
	@ElementCollection
	@Column(name="bookings")
   private List<String> bookings = new ArrayList<String>();

	public Flight() {
	// JPA
}

	public String getNumber() {
	return number;
}



	public ZonedDateTime  getDeparture() {
		return departure;
	}

	public void setDeparture(ZonedDateTime  departure) {
		this.departure = departure;
	}

	public ZonedDateTime  getArrival() {
		return arrival;
	}

	public void setArrival(ZonedDateTime  arrival) {
		this.arrival = arrival;
	}

	public FlightState getState() {
		return state;
	}

	public void setState(FlightState state) {
		this.state = state;
	}
	public Flight(String number, ZonedDateTime departure, ZonedDateTime arrival, FlightState state,
			Airport departureAirport, Airport arrivalAirport) {
		super();
		this.number = number;
		this.departure = departure;
		this.arrival = arrival;
		this.state = state;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}


	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}


	public Airport getArrivalAirport() {
		return arrivalAirport;
	}


	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public List<String> getBookings() {
		return bookings;
	}

	public void setBookings(List<String> bookings) {
		this.bookings = bookings;
	}

	public void setNumber(String number) {
		this.number = number;
	}




}
