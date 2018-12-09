package com.ensi.ilsi.AirlineCompany.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ensi.ilsi.AirlineCompany.entities.Customer;
import com.ensi.ilsi.AirlineCompany.repository.CustomerRepo;

@Service
@Transactional
public class CustomerService {
	private final CustomerRepo customerRepo;

	public CustomerService(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	public List<Customer> findAll(){
		return this.customerRepo.findAll();
	}
	public Customer create(Customer c) {
		return this.customerRepo.save(c);
	}

}
