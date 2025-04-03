import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

enum OrderStatus {
    PENDING, SHIPPED, DELIVERED
}

class Order {
    private int orderID;
    private double amount;
    private LocalDateTime orderDate;
    private OrderStatus status;

    public Order(int orderID, double amount, LocalDateTime orderDate, OrderStatus status) {
        this.orderID = orderID;
        this.amount = amount;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getOrderID() { return orderID; }
    public double getAmount() { return amount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public OrderStatus getStatus() { return status; }

    public String getFormattedOrderDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return orderDate.format(formatter);
    }

    @Override
    public String toString() {
        return "Order #" + orderID +
               " | Amount: $" + amount +
               " | Date: " + getFormattedOrderDate() +
               " | Status: " + status;
    }
}

class OrderProcessingSystem {
    private List<Order> orders;

    public OrderProcessingSystem(List<Order> orders) {
        this.orders = orders;
    }

    public double getTotalRevenueForToday() {
        LocalDateTime today = LocalDateTime.now();
        return orders.stream()
                .filter(order -> order.getOrderDate().toLocalDate().equals(today.toLocalDate()))
                .mapToDouble(Order::getAmount)
                .sum();
    }

    public List<Order> getPendingOrders() {
        return orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.PENDING)
                .sorted(Comparator.comparing(Order::getOrderDate))
                .collect(Collectors.toList());
    }

    public Optional<Order> getMostRecentDeliveredOrder() {
        return orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.DELIVERED)
                .max(Comparator.comparing(Order::getOrderDate));
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<Order> orders = Arrays.asList(
            new Order(random.nextInt(1000), random.nextDouble() * 500, LocalDateTime.now().minusHours(random.nextInt(5)), OrderStatus.PENDING),
            new Order(random.nextInt(1000), random.nextDouble() * 500, LocalDateTime.now().minusDays(random.nextInt(3)), OrderStatus.SHIPPED),
            new Order(random.nextInt(1000), random.nextDouble() * 500, LocalDateTime.now().minusHours(random.nextInt(5)), OrderStatus.PENDING),
            new Order(random.nextInt(1000), random.nextDouble() * 500, LocalDateTime.now().minusDays(random.nextInt(3)), OrderStatus.DELIVERED),
            new Order(random.nextInt(1000), random.nextDouble() * 500, LocalDateTime.now(), OrderStatus.DELIVERED),
            new Order(random.nextInt(1000), random.nextDouble() * 500, LocalDateTime.now().minusDays(random.nextInt(3)), OrderStatus.PENDING)
        );

        OrderProcessingSystem orderSystem = new OrderProcessingSystem(orders);

        System.out.println("\nTotal Revenue for Today: $" + orderSystem.getTotalRevenueForToday());

        System.out.println("\nPending Orders:");
        List<Order> pendingOrders = orderSystem.getPendingOrders();
        if (pendingOrders.isEmpty()) {
            System.out.println("No pending orders.");
        } else {
            pendingOrders.forEach(System.out::println);
        }

        System.out.println("\nMost Recent Delivered Order:");
        Optional<Order> recentDeliveredOrder = orderSystem.getMostRecentDeliveredOrder();
        System.out.println(recentDeliveredOrder.map(Order::toString).orElse("No delivered orders found."));
    }
}
