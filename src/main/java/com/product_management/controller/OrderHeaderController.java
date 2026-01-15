package com.product_management.controller;

import com.product_management.model.OrderHeader;
import com.product_management.service.OrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderHeaderController {
    @Autowired
    private OrderHeaderService orderHeaderService;
    @PostMapping("/orderHeader")
    public ResponseEntity<?> saveProduct(@RequestBody OrderHeader orderHeader){

        return new ResponseEntity<>(orderHeaderService.createOrder(orderHeader), HttpStatus.CREATED);
    }
    @GetMapping("/getOrderHeader/{id}")
    public ResponseEntity<OrderHeader> getOrderById(@PathVariable Integer id){
        OrderHeader order = orderHeaderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderHeader> updateOrder(
            @PathVariable Integer orderId,
            @RequestBody OrderHeader orderHeader) {

        OrderHeader updatedOrder = orderHeaderService.updateOrder(orderId, orderHeader);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {

        orderHeaderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}
