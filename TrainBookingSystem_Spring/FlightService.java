package com.spring.TravelBookingSystem;
import org.springframework.stereotype.Component;

@Component("flightservice")
class FlightService implements TransportService {
	@Override
    public void BookTicket(String source, String destination) {
        System.out.println("Flight ticket booked from " + source + " to " + destination);
    }
}
