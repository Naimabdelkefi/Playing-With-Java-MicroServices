package com.ensi.ilsi.AirlineCompany.rest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensi.ilsi.AirlineCompany.entities.Flight;
import com.ensi.ilsi.AirlineCompany.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightRest {
	private final FlightService flightService;

	public FlightRest(FlightService flightService) {
		super();
		this.flightService = flightService;
	}
	@GetMapping
    public List<Flight> findAll() {
        return this.flightService.findAll();
    }
	@GetMapping("/{number}")
    public Flight findByNumber(@PathVariable String number) {
        return this.flightService.findByNumber(number);
    }
	@GetMapping("/Bookings/{Number}")
    public void setbooking (@PathVariable String Number) throws IOException {
         this.flightService.updateBookings(Number);
    }
	@PostMapping
	public Flight create(@RequestBody Flight f) {
	   return this.flightService.create(f);
	    }
	@DeleteMapping("/{number}")
	public void delete(@PathVariable String number) {
		Flight f=this.flightService.findByNumber(number);
		this.flightService.delete(f);
	}

}
