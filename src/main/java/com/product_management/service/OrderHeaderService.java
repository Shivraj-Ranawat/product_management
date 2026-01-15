package com.product_management.service;

import com.product_management.model.OrderHeader;

public interface OrderHeaderService {
    OrderHeader createOrder(OrderHeader orderHeader);

    OrderHeader getOrderById(Integer orderId);

    OrderHeader updateOrder(Integer orderId, OrderHeader orderHeader);

    void deleteOrder(Integer orderId);
}
