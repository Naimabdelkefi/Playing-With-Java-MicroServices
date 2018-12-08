package com.ensi.ilsi.AirlineCompany.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensi.ilsi.AirlineCompany.entities.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	ArrayList<Customer> findByName(String name);
}
