package com.springboot.flight.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.flight.model.Flight;
import com.springboot.flight.ser.FlightService;


@RestController
@RequestMapping("/api/flights")
public class FlightController {
	
	private FlightService flightService;

	public FlightController(FlightService flightService) {
		super();
		this.flightService = flightService;
	}
	
	@PostMapping
	public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight){
		return new ResponseEntity<Flight> (flightService.saveFlight(flight),
				HttpStatus.OK);
		
	}
	@GetMapping
	public List<Flight> getAllFlight(){
		return flightService.getAllFlights();
	}
    @GetMapping("{flightNumber}")
	public ResponseEntity<Flight> getFlightById(@PathVariable long flightNumber){
	    return new ResponseEntity<Flight>(flightService.getFlightById(flightNumber),
	    			HttpStatus.OK);
	    	
	}
    @PutMapping("{flightNumber}")
    public ResponseEntity<Flight> updateFlight(@PathVariable("flightNumber")long flightNumber,
    		@RequestBody Flight flight){
    	return new ResponseEntity<Flight>(flightService.updateFlight(flight, flightNumber),
    			HttpStatus.OK);
    }
    @DeleteMapping("{flightNumber}")
    public ResponseEntity<String> deleteFlight(@PathVariable("flightNumber")long flightNumber){
    	
    	flightService.deleteFlight(flightNumber);
    	return new ResponseEntity<String>("Flight details deleted successfully..!",HttpStatus.OK);
    	
    }
	

}
