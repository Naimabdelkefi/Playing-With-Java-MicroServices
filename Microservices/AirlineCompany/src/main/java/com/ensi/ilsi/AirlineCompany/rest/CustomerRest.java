package com.ensi.ilsi.AirlineCompany.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensi.ilsi.AirlineCompany.entities.Customer;
import com.ensi.ilsi.AirlineCompany.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRest {
	private final CustomerService customerService;

	public CustomerRest(CustomerService customerService) {
		super();
		this.customerService = customerService;
	};
	@GetMapping
	public List<Customer> findAll(){
		return this.customerService.findAll();
	}
	@PostMapping
	public Customer create(@RequestBody Customer c) {
		return this.customerService.create(c);
	}
}
