package com.spring.TravelBookingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TravelBooking {
	private TransportService transportService;  
	@Autowired
	public TravelBooking(@Qualifier("busservice") TransportService transportService) {
		this.transportService = transportService;
	}

	public void setTransportService(TransportService transportService) {
		this.transportService = transportService;
	}

	public void BookTravel(String source, String destination) {
		transportService.BookTicket(source, destination);
	}
}
