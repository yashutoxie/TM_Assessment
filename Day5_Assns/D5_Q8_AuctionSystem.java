/*
Build an online auction system where:
> Bids are stored in a PriorityQueue<Bid> based on highest bid amount.
> Use a generic class Auction<T>, where T is the type of item being auctioned.
> Implement a Comparator to prioritize bids based on the amount and bid time.
> Allow real-time bid processing, removing the highest bid using poll().
*/

import java.util.*;
class Bid {
	private String bidder;
	private double amount;
	private long timestamp;

	public Bid(String bidder, double amount) {
		this.bidder = bidder;
		this.amount = amount;
		this.timestamp = System.currentTimeMillis();
	}

	public String getBidder() {
		return bidder;
	}

	public double getAmount() {
		return amount;
	}

	public long getTimeStamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Bidder: " + bidder + ", Amount: " + amount;
	}
}


class BidComparator implements Comparator<Bid> {
	@Override
	public int compare(Bid b1, Bid b2) {
		if(Double.compare(b2.getAmount(), b1.getAmount()) == 0) {
			return Long.compare(b1.getTimeStamp(), b2.getTimeStamp());
		}
		return Double.compare(b2.getAmount(), b1.getAmount());
	}
}


class Auction<T> {
	private T item;
	private PriorityQueue<Bid> bidQueue;

	public Auction(T item) {
		this.item = item;
		this.bidQueue = new PriorityQueue<>(new BidComparator());
	}

	public void placeBid(String bidder, double amount) {
		bidQueue.add(new Bid(bidder, amount));
		System.out.println("New Bid Placed: " + bidder + " -> " + amount);
	}
	
	public void processHighestBid() {
		if(bidQueue.isEmpty()) {
			System.out.println("No Bids Available.");
			return;
		}

		Bid highestBid = bidQueue.poll();
		System.out.println("\nProcessing highest bid: " + highestBid);
	}


	public void displayBids() {
		if(bidQueue.isEmpty()) {
			System.out.println("No bids Available.");
			return;
		}
		System.out.println("\nAll Bids (Sorted by Priority):");
		for(Bid bid: bidQueue) {
			System.out.println(bid);
		}
	}
}


public class Main {

	public static void main(String[] args) {
		Auction<String> a = new Auction<>("Vintage Car");

		a.placeBid("Alice", 5000);
		a.placeBid("Anand", 5250);
		a.placeBid("Akbar", 5700);
		a.placeBid("Tata", 5080);
		a.placeBid("Kiran", 6000);

		a.displayBids();

		a.processHighestBid();
		a.processHighestBid();

		a.displayBids();
	}
}
