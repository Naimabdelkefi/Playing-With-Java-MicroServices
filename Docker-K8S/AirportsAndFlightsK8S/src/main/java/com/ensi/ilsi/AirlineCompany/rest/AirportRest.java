package com.ensi.ilsi.AirlineCompany.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensi.ilsi.AirlineCompany.entities.Airport;
import com.ensi.ilsi.AirlineCompany.service.AirportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( description="Gestion des airports.")
@RestController
@RequestMapping("/airports")
public class AirportRest {
	private final AirportService airportService;

	public AirportRest(AirportService airportService) {
		super();
		this.airportService = airportService;
	}
    @ApiOperation(value = "Récupère tous les airports")
	@GetMapping
	public List<Airport> findAll() {
		return this.airportService.findAll();
	}
    @ApiOperation(value = "Supprimer un airport grâce à son nom")
	@DeleteMapping("/{name}")
	public void delete(@PathVariable String name) {
		Airport a=this.airportService.findByName(name);
		this.airportService.delete(a);
	}
    @ApiOperation(value = "Ajouter un nouveaux airport")
	@PostMapping
	public Airport create(@RequestBody Airport a) {
		System.out.println(a.getName());
		return this.airportService.create(a);
	}
    @ApiOperation(value = "MAJ la liste des dep vol")
	@GetMapping("/updateDep")
	public Airport updateDep(@RequestParam("flightNumber") String flightNumber,@RequestParam("airportName") String airpot) {
		return this.airportService.updateDepratureAirportFlight(flightNumber, airpot);
	}
    @ApiOperation(value = "MAJ la liste des Arv vol")
	@GetMapping("/updateAriv")
	public Airport updateAriv(@RequestParam("flightNumber") String flightNumber,@RequestParam("airportName") String airpot) {
		return this.airportService.updateArrivalAirportFlight(flightNumber, airpot);
	}

}
