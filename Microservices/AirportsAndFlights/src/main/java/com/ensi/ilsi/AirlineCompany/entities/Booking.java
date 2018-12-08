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


public class Booking {

	
	private String state;

	private String  date;
	
	private String flightnumber;
	private String CustmerPaasport;


	public Booking( String state, String date,String flightnumber,String CustmerPaasport) {
		super();
		this.flightnumber=flightnumber;
		this.state = state;
		this.date = date;
		this.CustmerPaasport=CustmerPaasport;
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


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}
