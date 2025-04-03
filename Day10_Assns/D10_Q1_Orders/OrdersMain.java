public class Main {
    public static void main(String[] args) {
        Order orderDAO = new Order(); 
        orderDAO.addOrder(11, "Laptop", 1299.99, "Pending"); 
        orderDAO.getOrderById(11);
        orderDAO.updateOrderStatus(101, "Shipped")
        orderDAO.deleteCanceledOrders();
    }
}
