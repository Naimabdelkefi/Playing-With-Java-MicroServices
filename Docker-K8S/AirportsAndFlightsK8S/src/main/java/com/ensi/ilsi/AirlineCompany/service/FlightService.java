package com.ensi.ilsi.AirlineCompany.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ensi.ilsi.AirlineCompany.entities.Booking;
import com.ensi.ilsi.AirlineCompany.entities.Flight;
import com.ensi.ilsi.AirlineCompany.repository.FlightRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@EnableDiscoveryClient
@Service
@Transactional
public class FlightService {
	  @Bean
	   @LoadBalanced
	   RestTemplate restTemplate() {
	         return new RestTemplate();
	   }

	   @Autowired
	   RestTemplate restTemplate;
	private final FlightRepo flightRepo;
	
	public FlightService(FlightRepo flightRepo) {
		super();
		this.flightRepo = flightRepo;
	}
	public List<Flight> findAll(){
		
		return this.flightRepo.findAll();
		
	}
	public Optional<Flight> findById(Long id) {
		return this.flightRepo.findById(id);
	}
	public Flight findByNumber(String number){
		return this.flightRepo.findByNumber(number);
	}
	public Flight create(Flight f) {
	 return  this.flightRepo.save(
			 new Flight(
					 f.getNumber(),
					 f.getDeparture(),
					 f.getArrival(),
					 f.getState(),
					 f.getDepartureAirport(),
					 f.getArrivalAirport()
					 ));
	}
	public void delete(Flight f) {
	this.flightRepo.delete(f);
	}
	@Transactional
	public Flight updateBookings(String Number) throws IOException {
		Flight f=this.flightRepo.findByNumber(Number);

	
		final String response = restTemplate.getForObject("http://CustumerAndBookings/booking/{Number}", String.class,Number);
		//f.getBookings().add(response.getId());
		System.out.println(response);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(response);
		for(int i =0;i<rootNode.size();i++) {
		Booking newJsonNode = mapper.treeToValue(rootNode.get(i), Booking.class);
		System.out.println(newJsonNode.getState());
		/*final Booking response = restTemplate.getForObject("http://localhost:8081/booking/{Number}",Booking.class,Number);*/
		System.out.println(newJsonNode.getCustmerPaasport());
		f.getBookings().add(newJsonNode.getCustmerPaasport());}
		return this.flightRepo.save(f);

	}
}
