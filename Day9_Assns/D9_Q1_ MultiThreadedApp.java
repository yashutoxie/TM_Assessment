/*You are working on a multi-threaded application where multiple threads update a shared counter.
The counter sometimes produces incorrect results due to a race condition.
Use breakpoints in your IDE to:
oPause execution when multiple threads access the counter.
oStep through execution to identify incorrect updates.
oUse watchpoints to track changes to the counter variable.
Fix the issue using synchronization or AtomicInteger.*/

import java.util.*;
import java.util.concurrent.*;

// Flight class representing flight details
class Flight {
    private String flightNumber;
    private String destination;
    private int availableSeats;

    public Flight(String flightNumber, String destination, int seats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = seats;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }

    // Synchronized method to prevent overbooking
    public synchronized boolean bookTicket() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return flightNumber + " to " + destination + " | Seats Available: " + availableSeats;
    }
}

// Flight search task using Callable
class FlightSearchTask implements Callable<List<Flight>> {
    private String destination;
    private List<Flight> flightsDatabase;

    public FlightSearchTask(String destination, List<Flight> flightsDatabase) {
        this.destination = destination;
        this.flightsDatabase = flightsDatabase;
    }

    @Override
    public List<Flight> call() throws Exception {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flightsDatabase) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        return result;
    }
}

// Main Booking System
public class Main {
    private static List<Flight> flightsDatabase = new ArrayList<>();

    public static void main(String[] args) {
        // Sample flights
        flightsDatabase.add(new Flight("AA101", "New York", 5));
        flightsDatabase.add(new Flight("BA202", "London", 3));
        flightsDatabase.add(new Flight("CA303", "Paris", 2));

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Simulating multiple users searching and booking flights concurrently
        Future<List<Flight>> futureFlights1 = executor.submit(new FlightSearchTask("New York", flightsDatabase));
        Future<List<Flight>> futureFlights2 = executor.submit(new FlightSearchTask("London", flightsDatabase));

        try {
            List<Flight> flightsToNY = futureFlights1.get();
            List<Flight> flightsToLondon = futureFlights2.get();

            System.out.println("\nAvailable Flights to New York: " + flightsToNY);
            System.out.println("Available Flights to London: " + flightsToLondon);

            // Booking tickets concurrently
            executor.execute(() -> bookTicket("AA101"));
            executor.execute(() -> bookTicket("BA202"));
            executor.execute(() -> bookTicket("BA202"));
            executor.execute(() -> bookTicket("AA101"));
            executor.execute(() -> bookTicket("AA101"));
            executor.execute(() -> bookTicket("BA202"));
            executor.execute(() -> bookTicket("BA202"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    public static void bookTicket(String flightNumber) {
        for (Flight flight : flightsDatabase) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                synchronized (flight) {
                    if (flight.bookTicket()) {
                        System.out.println(Thread.currentThread().getName() + " booked on " + flight);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " failed to book " + flight);
                    }
                }
                return;
            }
        }
        System.out.println("Flight " + flightNumber + " not found.");
    }
}
