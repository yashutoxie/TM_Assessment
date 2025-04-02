package com.spring.TravelBookingSystem;

import org.springframework.stereotype.Component;

@Component("trainservice")
class TrainService implements TransportService {
	@Override
    public void BookTicket(String source, String destination) {
        System.out.println("Train ticket booked from " + source + " to " + destination);
    }
}
