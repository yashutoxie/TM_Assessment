package com.spring.TravelBookingSystem;

import org.springframework.stereotype.Component;

@Component("busservice")
class BusService implements TransportService {

	@Override
	public void BookTicket(String source, String destination) {

		System.out.println("Bus ticket booked from " + source + " to " + destination);

	}
}
