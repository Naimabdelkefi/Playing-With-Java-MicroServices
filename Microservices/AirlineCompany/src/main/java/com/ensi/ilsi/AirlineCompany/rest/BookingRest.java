package com.ensi.ilsi.AirlineCompany.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensi.ilsi.AirlineCompany.entities.Booking;
import com.ensi.ilsi.AirlineCompany.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingRest {
	private final BookingService bookingService;

	public BookingRest(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	@GetMapping
	public List<Booking> findAll(){
		return this.bookingService.findAll();	
	}
	@GetMapping("/{number}")
	public List<Booking> findByFlightNumber(@PathVariable String number){
		return this.bookingService.findByFlightNumber(number);
	}
	@PostMapping
	public Booking create(@RequestBody Booking b){
		return this.bookingService.create(b);
	}
}
