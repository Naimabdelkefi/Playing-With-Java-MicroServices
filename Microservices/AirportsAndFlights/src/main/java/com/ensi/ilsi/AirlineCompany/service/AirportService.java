package com.ensi.ilsi.AirlineCompany.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensi.ilsi.AirlineCompany.entities.Airport;
import com.ensi.ilsi.AirlineCompany.entities.Flight;
import com.ensi.ilsi.AirlineCompany.repository.AirportRepo;
import com.ensi.ilsi.AirlineCompany.repository.FlightRepo;

@Service
@Transactional
public class AirportService {
	
	private final AirportRepo airportRepo;
	
	private final FlightRepo flightRepo;
	
	public AirportService(AirportRepo airportRepo ,FlightRepo flightRepo) {
		super();
		this.airportRepo = airportRepo;
		this.flightRepo=flightRepo;
	}

	public List<Airport> findAll(){
		return this.airportRepo.findAll();	
	}
	public Airport findByName(String name){
		return this.airportRepo.findByName(name);	
	}
	public Airport create(Airport a) {
		 return  this.airportRepo.save(a);
		}
	@Transactional
	public Airport updateDepratureAirportFlight(String flightNumber,String AirportName) {
		Airport a=this.airportRepo.findByName(AirportName);
		Flight f=this.flightRepo.findByNumber(flightNumber);
		a.getDepartureFilghts().add(f);
		return this.airportRepo.save(a);
		
	}
	@Transactional
	public Airport updateArrivalAirportFlight(String flightNumber,String AirportName) {
		Airport a=this.airportRepo.findByName(AirportName);
		Flight f=this.flightRepo.findByNumber(flightNumber);
		a.getArrivalFilghts().add(f);
		return this.airportRepo.save(a);
		
	}
	public void delete(Airport a) {
		this.airportRepo.delete(a);
		}
}
