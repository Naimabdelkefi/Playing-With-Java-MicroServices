package com.ensi.ilsi.AirlineCompany.service;

import java.awt.print.Book;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ensi.ilsi.AirlineCompany.entities.Booking;
import com.ensi.ilsi.AirlineCompany.repository.BookingRepo;

@Service
@Transactional
public class BookingService {
	
	private final BookingRepo bookingRepo;

	public BookingService(BookingRepo bookingRepo) {
		super();
		this.bookingRepo = bookingRepo;
	}
	public List<Booking> findAll(){
		return this.bookingRepo.findAll();
	}
	public List<Booking> findByFlightNumber(String number){
		return this.bookingRepo.findByFlightnumber(number);
	}
	public Booking create(Booking b) {
	
		return this.bookingRepo.save(new Booking(
				b.getState(),
				b.getDate(),
				b.getFlightnumber(),
				b.getCustmerPaasport()));
	}
}
