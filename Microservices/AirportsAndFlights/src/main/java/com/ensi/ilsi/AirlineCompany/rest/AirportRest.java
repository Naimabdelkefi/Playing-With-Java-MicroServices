package com.ensi.ilsi.AirlineCompany.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensi.ilsi.AirlineCompany.entities.Airport;
import com.ensi.ilsi.AirlineCompany.service.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportRest {
	private final AirportService airportService;

	public AirportRest(AirportService airportService) {
		super();
		this.airportService = airportService;
	}

	@GetMapping
	public List<Airport> findAll() {
		return this.airportService.findAll();
	}
	@DeleteMapping("/{name}")
	public void delete(@PathVariable String name) {
		Airport a=this.airportService.findByName(name);
		this.airportService.delete(a);
	}
	@PostMapping
	public Airport create(@RequestBody Airport a) {
		System.out.println(a.getName());
		return this.airportService.create(a);
	}
	@GetMapping("/updateDep")
	public Airport updateDep(@RequestParam("flightNumber") String flightNumber,@RequestParam("airportName") String airpot) {
		return this.airportService.updateDepratureAirportFlight(flightNumber, airpot);
	}
	@GetMapping("/updateAriv")
	public Airport updateAriv(@RequestParam("flightNumber") String flightNumber,@RequestParam("airportName") String airpot) {
		return this.airportService.updateArrivalAirportFlight(flightNumber, airpot);
	}

}
