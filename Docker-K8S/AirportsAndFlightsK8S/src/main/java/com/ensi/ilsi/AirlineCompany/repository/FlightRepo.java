package com.ensi.ilsi.AirlineCompany.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensi.ilsi.AirlineCompany.entities.Flight;
import com.ensi.ilsi.AirlineCompany.entities.enumeration.FlightState;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
	
	ArrayList<Flight> findByState(FlightState state);
	Flight findByNumber(String number);
	
}
