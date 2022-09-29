package com.springboot.flight.ser;

import java.util.List;
import com.springboot.flight.model.Flight;

public interface FlightService {
	
	//save
	Flight saveFlight(Flight flight);
	//findAll
	List<Flight> getAllFlights();
	//find
	Flight getFlightById(long flightNumber);
	//update
	Flight updateFlight(Flight flight,long flightNumber);
	//delete
	void deleteFlight(long flightNumber);

}
