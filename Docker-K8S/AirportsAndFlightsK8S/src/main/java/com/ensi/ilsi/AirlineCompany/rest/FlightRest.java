package com.ensi.ilsi.AirlineCompany.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensi.ilsi.AirlineCompany.entities.Flight;
import com.ensi.ilsi.AirlineCompany.service.FlightService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Gestion des vols")
@RestController
@RequestMapping("/flights")
public class FlightRest {
	private final FlightService flightService;

	public FlightRest(FlightService flightService) {
		super();
		this.flightService = flightService;
	}

	@ApiOperation(value = "Récupère tous les vols")
	@GetMapping
	public List<Flight> findAll() {
		return this.flightService.findAll();
	}

	@ApiOperation(value = "Récupère une vol grâce à son number")
	@GetMapping("/{number}")
	public Flight findByNumber(@PathVariable String number) {
		return this.flightService.findByNumber(number);
	}
	 @ApiOperation(value = "MAJ booking d'une vol")
	@GetMapping("/Bookings/{Number}")
	public void setbooking(@PathVariable String Number) throws IOException {
		this.flightService.updateBookings(Number);
	}
	 @ApiOperation(value = "new flight")
	@PostMapping
	public Flight create(@RequestBody Flight f) {
		return this.flightService.create(f);
	}
	 @ApiOperation(value = "delelte flight using ID")
	@DeleteMapping("/{number}")
	public void delete(@PathVariable String number) {
		Flight f = this.flightService.findByNumber(number);
		this.flightService.delete(f);
	}

}
