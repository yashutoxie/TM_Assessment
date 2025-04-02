import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static final BlockingQueue<String> orderQueue = new LinkedBlockingQueue<>();
    private static volatile boolean isRunning = true;  

    public static void main(String[] args) { 
        Thread orderProcessor = new Thread(new OrderProcessor());
        orderProcessor.start();
 
        for (int i = 1; i <= 5; i++) {
            final int customerId = i;
            new Thread(() -> placeOrder("Order from Customer " + customerId)).start();
        }
 
        try {
            Thread.sleep(5000); // Simulate system running for 5 seconds
            shutdownOrderProcessor(orderProcessor);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
 
    private static void placeOrder(String order) {
        try {
            orderQueue.put(order); // Add the order to the BlockingQueue
            System.out.println("Placed: " + order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
 
    private static void shutdownOrderProcessor(Thread orderProcessor) {
        isRunning = false; 
        orderProcessor.interrupt(); 
        System.out.println("Order processing system is shutting down...");
    }
 
    private static class OrderProcessor implements Runnable {
        @Override
        public void run() {
            while (isRunning || !orderQueue.isEmpty()) {
                try {
                    String order = orderQueue.poll();
                    if (order != null) {
                        processOrder(order);
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("OrderProcessor has stopped.");
        }

        private void processOrder(String order) throws InterruptedException {
            System.out.println("Processing: " + order);
            Thread.sleep(1000); 
        }
    }
}
// Day 8 Q2
