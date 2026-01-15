package com.product_management.service;

import com.product_management.model.ContactMech;
import com.product_management.model.Customer;
import com.product_management.model.OrderHeader;
import com.product_management.repository.ContactMechRepository;
import com.product_management.repository.CustomerRepository;
import com.product_management.repository.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHeaderImplementation implements OrderHeaderService{
    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ContactMechRepository contactMechRepository;

    @Override
    public OrderHeader createOrder(OrderHeader orderHeader) {

        Customer customer = customerRepository.findById(
                orderHeader.getCustomer().getCustomerId()
        ).orElseThrow(() -> new RuntimeException("Customer not found"));


        ContactMech shipping = contactMechRepository.findById(
                orderHeader.getShippingContactMech().getContactMechId()
        ).orElseThrow(() -> new RuntimeException("Shipping address not found"));


        ContactMech billing = contactMechRepository.findById(
                orderHeader.getBillingContactMech().getContactMechId()
        ).orElseThrow(() -> new RuntimeException("Billing address not found"));


        orderHeader.setCustomer(customer);
        orderHeader.setShippingContactMech(shipping);
        orderHeader.setBillingContactMech(billing);


        return orderHeaderRepository.save(orderHeader);
    }

    @Override
    public OrderHeader getOrderById(Integer orderId) {
        return orderHeaderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public OrderHeader updateOrder(Integer orderId, OrderHeader orderHeader) {
        OrderHeader existingOrder = getOrderById(orderId);


        if (orderHeader.getCustomer() != null) {
            existingOrder.setCustomer(orderHeader.getCustomer());
        }


        if (orderHeader.getShippingContactMech() != null) {
            ContactMech shipping = contactMechRepository.findById(
                            orderHeader.getShippingContactMech().getContactMechId())
                    .orElseThrow(() -> new RuntimeException("Shipping address not found"));
            existingOrder.setShippingContactMech(shipping);
        }
        return orderHeaderRepository.save(existingOrder);

    }

    @Override
    public void deleteOrder(Integer orderId) {
        OrderHeader order = getOrderById(orderId);
        orderHeaderRepository.delete(order);
    }
}
