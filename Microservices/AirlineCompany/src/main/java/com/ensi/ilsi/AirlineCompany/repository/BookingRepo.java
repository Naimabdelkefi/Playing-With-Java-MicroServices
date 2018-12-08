package com.ensi.ilsi.AirlineCompany.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ensi.ilsi.AirlineCompany.entities.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
   
	ArrayList<Booking> findByFlightnumber(String number);
  /**  @Query(value="SELECT b FROM Booking b WHERE b.customer IN (SELECT c FROM Customer c where name=:name)")
  	ArrayList<Booking> findByCustomerName(@Param("name") String name);*/
}
