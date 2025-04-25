package com.ecommerce.repository;
import com.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
    List<OrderItem> findByOrderId(Long orderId);
    
    List<OrderItem> findByItemId(Long itemId);
    
    @Query("SELECT oi FROM OrderItem oi JOIN oi.order o WHERE o.customer.id = :customerId AND oi.item.id = :itemId")
    List<OrderItem> findByCustomerIdAndItemId(
        @Param("customerId") Long customerId, 
        @Param("itemId") Long itemId
    );
}