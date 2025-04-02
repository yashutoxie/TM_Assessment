package com.spring.TravelBookingSystem;

import java.util.Scanner;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring.TravelBookingSystem")
public class TravelBookingSystemApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				TravelBookingSystemApplication.class); Scanner sc = new Scanner(System.in)) {

			TravelBooking tb = context.getBean(TravelBooking.class);
			System.out.print("Enter Travel Mode (train/flight/bus): ");
			String travelMode = sc.nextLine().toLowerCase();
			TransportService selectedService;
			switch (travelMode) {
			case "train": {
				selectedService = (TransportService) context.getBean("trainservice");
				break;
			}
			case "flight":
				selectedService = (TransportService) context.getBean("flightservice");
				break;
			default:
				selectedService = (TransportService) context.getBean("busservice");
				break;
			}
			tb.setTransportService(selectedService);
			System.out.print("Enter Source: ");
			String source = sc.nextLine().toUpperCase();
			System.out.print("Enter Destination: ");
			String destination = sc.nextLine().toUpperCase();
			tb.BookTravel(source, destination);

		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

}
