package com.product_management.repository;

import com.product_management.model.OrderHeader;
import com.product_management.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrder(OrderHeader order);
}
