package com.product_management.service;

import com.product_management.model.OrderHeader;
import com.product_management.model.OrderItem;
import com.product_management.model.Product;
import com.product_management.repository.OrderHeaderRepository;
import com.product_management.repository.OrderItemRepository;
import com.product_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImplementation implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public OrderItem addOrderItem(Integer orderId, OrderItem orderItem) {
        if (orderItem.getProduct() == null || orderItem.getProduct().getProduct_id() == null) {
            throw new RuntimeException("Product ID must not be null");
        }

        OrderHeader order = orderHeaderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        Product product = productRepository.findById(orderItem.getProduct().getProduct_id())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + orderItem.getProduct().getProduct_id()));

        orderItem.setOrder(order);
        orderItem.setProduct(product);
        if (orderItem.getStatus() == null) {
            orderItem.setStatus("Pending");
        }

        return orderItemRepository.save(orderItem);
    }


    @Override
    public OrderItem updateOrderItem(Integer orderItemSeqId, OrderItem orderItem) {
        OrderItem existingItem = orderItemRepository.findById(orderItemSeqId)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + orderItemSeqId));

        if (orderItem.getQuantity() != null) {
            existingItem.setQuantity(orderItem.getQuantity());
        }

        if (orderItem.getStatus() != null) {
            existingItem.setStatus(orderItem.getStatus());
        }

        return orderItemRepository.save(existingItem);
    }


    @Override
    public void deleteOrderItem(Integer orderItemSeqId) {
        if (!orderItemRepository.existsById(orderItemSeqId)) {
            throw new RuntimeException("OrderItem not found with id: " + orderItemSeqId);
        }
        orderItemRepository.deleteById(orderItemSeqId);
    }


    @Override
    public List<OrderItem> getItemsByOrderId(Integer orderId) {
        OrderHeader order = orderHeaderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        return orderItemRepository.findByOrder(order);
    }
}
