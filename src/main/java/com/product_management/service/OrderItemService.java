package com.product_management.service;

import com.product_management.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem addOrderItem(Integer orderId, OrderItem order_Item);

    OrderItem updateOrderItem(Integer orderItemSeqId, OrderItem order_Item);

    void deleteOrderItem(Integer orderItemSeqId);

    List<OrderItem> getItemsByOrderId(Integer orderId);
}
