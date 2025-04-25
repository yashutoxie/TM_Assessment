package com.ecommerce.service;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Item;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;
    
    @Autowired
    public OrderService(
        OrderRepository orderRepository,
        CustomerRepository customerRepository,
        ItemRepository itemRepository,
        OrderItemRepository orderItemRepository
    ) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.orderItemRepository = orderItemRepository;
    }
    
    // Create
    public Order createOrder(Long customerId) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isPresent()) {
            Order order = new Order();
            order.setCustomer(customerOpt.get());
            return orderRepository.save(order);
        }
        throw new IllegalArgumentException("Customer not found with ID: " + customerId);
    }
    
    // Add item to order
    public OrderItem addItemToOrder(Long orderId, Long itemId, int quantity) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        Optional<Item> itemOpt = itemRepository.findById(itemId);
        
        if (orderOpt.isPresent() && itemOpt.isPresent()) {
            Order order = orderOpt.get();
            Item item = itemOpt.get();
            
            OrderItem orderItem = new OrderItem(order, item, quantity);
            order.addOrderItem(orderItem);
            
            orderRepository.save(order);
            return orderItem;
        }
        throw new IllegalArgumentException("Order or Item not found");
    }
    
    // Read
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    
    // JPQL to fetch all orders placed by a specific customer
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }
    
    public List<Order> getOrdersInDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findOrdersInDateRange(startDate, endDate);
    }
    
    // Update
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
    
    // Delete
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    
    // Remove item from order
    public void removeItemFromOrder(Long orderId, Long orderItemId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        Optional<OrderItem> orderItemOpt = orderItemRepository.findById(orderItemId);
        
        if (orderOpt.isPresent() && orderItemOpt.isPresent()) {
            Order order = orderOpt.get();
            OrderItem orderItem = orderItemOpt.get();
            
            order.removeOrderItem(orderItem);
            orderRepository.save(order);
        }
    }
}