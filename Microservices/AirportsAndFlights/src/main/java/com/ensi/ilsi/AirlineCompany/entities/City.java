package com.ensi.ilsi.AirlineCompany.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;

	private List<Long> Airports = new ArrayList<Long>();
}
