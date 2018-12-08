package com.ensi.ilsi.AirlineCompany.repository;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensi.ilsi.AirlineCompany.entities.Airport;

@Repository
public interface  AirportRepo extends JpaRepository<Airport,Long> {
	Airport findByName(String name);

}
