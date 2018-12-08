package com.ensi.ilsi.AirlineCompany.entities;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ensi.ilsi.AirlineCompany.entities.enumeration.BookingState;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "BookingId")
	private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
	private BookingState state;
	@Column(name = "date")
	private ZonedDateTime  date;
	@Column(name = "flightnumber")
	private String flightnumber;
	@Column(name = "CustmerPaasport")
	private String CustmerPaasport;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference(value="customer")
	@JoinColumn(name = "customer")
	private Customer customer;


	public Booking(BookingState state, ZonedDateTime date, String flightnumber, String custmerPaasport) {
		super();
		this.state = state;
		this.date = date;
		this.flightnumber = flightnumber;
		this.CustmerPaasport = custmerPaasport;
	}

	public String getCustmerPaasport() {
		return CustmerPaasport;
	}

	public void setCustmerPaasport(String custmerPaasport) {
		CustmerPaasport = custmerPaasport;
	}

	public String getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}

	public Booking() {
		//JPA
	}

	public BookingState getState() {
		return state;
	}

	public void setState(BookingState state) {
		this.state = state;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}


}
