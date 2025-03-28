import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

enum TicketClass {
    BUSINESS, ECONOMY, GENERAL
}

class Passenger {
    private String name;
    private TicketClass tc;
    private long bookingTime;

    public Passenger(String name, TicketClass tc) {
        this.name = name;
        this.tc = tc;
        this.bookingTime = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public TicketClass getTicketClass() {
        return tc;
    }

    public long getBookingTime() {
        return bookingTime;
    }
}

class PassengerComparator implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        int classComparison = p1.getTicketClass().compareTo(p2.getTicketClass());
        if (classComparison != 0) {
            return classComparison;
        }
        return Long.compare(p1.getBookingTime(), p2.getBookingTime());
    }
}

public class D5_Q2_TicketBookingSystem {

    private PriorityQueue<Passenger> bookingQueue;

    public D5_Q2_TicketBookingSystem() {
        this.bookingQueue = new PriorityQueue<>(new PassengerComparator());
    }

    public void bookTicket(String name, TicketClass tc) {
        Passenger passenger = new Passenger(name, tc);
        bookingQueue.add(passenger);
        System.out.println("Ticket booked: " + passenger.getName());
    }

    public void processNextPassenger() {
        if (!bookingQueue.isEmpty()) {
            Passenger nextPassenger = bookingQueue.poll();
            System.out.println("Processing passenger: " + nextPassenger);
        } else {
            System.out.println("No Passengers to process.");
        }
    }

    public void displayAllPassengers() {
        if (bookingQueue.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        System.out.println("All booked passenger: ");
        Iterator<Passenger> iterator = bookingQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        D5_Q2_TicketBookingSystem sys = new D5_Q2_TicketBookingSystem();
        sys.bookTicket("Yash", TicketClass.BUSINESS);
        sys.bookTicket("Bob", TicketClass.ECONOMY);
        sys.bookTicket("Alice", TicketClass.ECONOMY);

        sys.displayAllPassengers();

        sys.processNextPassenger();
        sys.processNextPassenger();
        sys.processNextPassenger();
    }
}
